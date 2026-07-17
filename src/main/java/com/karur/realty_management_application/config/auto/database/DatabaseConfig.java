package com.karur.realty_management_application.config.auto.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Slf4j
@Component
public class DatabaseConfig {

    @Autowired
    private DatabaseProperties databaseProperties;

    @Autowired
    private ConfigurableListableBeanFactory configurableListableBeanFactory;

    private Map<String, DataSource> datasources = new HashMap<>();
    private Map<String, NamedParameterJdbcTemplate> namedParameterJdbcTemplates = new HashMap<>();
    private Map<String, EntityManagerFactory> entityManagerFactories = new HashMap<>();
    private Map<String, PlatformTransactionManager> platformTransactionManagers = new HashMap<>();

    @PostConstruct
    public void setup() {
        datasources();
        namedParameterJdbcTemplates(datasources);
        entityManagerFactories(datasources);
        platformTransactionManagers(entityManagerFactories);
    }

    private void datasources() {
        databaseProperties.getPostgres()
                .forEach((key, config) -> {
                    HikariConfig hikariConfig = new HikariConfig();
                    hikariConfig.setJdbcUrl(config.getJdbcUrl());
                    hikariConfig.setUsername(config.getUsername());
                    hikariConfig.setPassword(config.getPassword());
                    hikariConfig.setDriverClassName(config.getDriverClassName());
                    hikariConfig.setSchema(config.getSchema());
                    datasources.put(config.getPackageNames().getDatasource(), new HikariDataSource(hikariConfig));
                });
        datasources.forEach((key, dataSource) -> configurableListableBeanFactory.registerSingleton(key, dataSource));
    }

    private void namedParameterJdbcTemplates(Map<String, DataSource> datasources) {
        databaseProperties.getPostgres().forEach((key, config) -> {
            DataSource dataSource = datasources.get(config.getPackageNames().getDatasource());
            namedParameterJdbcTemplates.put(config.getPackageNames().getNamedParameterJdbcTemplate(), new NamedParameterJdbcTemplate(dataSource));
        });
        namedParameterJdbcTemplates.forEach((key, namedParameterJdbcTemplate) -> configurableListableBeanFactory.registerSingleton(key, namedParameterJdbcTemplate));
    }

    public void entityManagerFactories(Map<String, DataSource> datasources) {
        databaseProperties.getPostgres().forEach((key, config) -> {
            DataSource dataSource = datasources.get(config.getPackageNames().getDatasource());
            Properties properties = new Properties();
            properties.put("hibernate.dialect", config.getJpa().getProperties().getHibernate().getDialect());
            LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
            managerFactoryBean.setDataSource(dataSource);
            managerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
            managerFactoryBean.setJpaProperties(properties);
            managerFactoryBean.setPackagesToScan(config.getPackageNames().getEntity());
            managerFactoryBean.setPersistenceUnitName(key);
            managerFactoryBean.afterPropertiesSet();
            entityManagerFactories.put(config.getPackageNames().getContainerEntityManagerFactory(), managerFactoryBean.getObject());
        });
        entityManagerFactories.forEach((key, entityManagerFactory) -> configurableListableBeanFactory.registerSingleton(key, entityManagerFactory));
    }

    public void platformTransactionManagers(Map<String, EntityManagerFactory> entityManagerFactories) {
        databaseProperties.getPostgres().forEach((key, config) -> {
            EntityManagerFactory entityManagerFactory = entityManagerFactories.get(config.getPackageNames().getContainerEntityManagerFactory());
            platformTransactionManagers.put(config.getPackageNames().getPlatformTransactionManager(), new JpaTransactionManager(entityManagerFactory));
        });
        platformTransactionManagers.forEach((key, platformTransactionManager) -> configurableListableBeanFactory.registerSingleton(key, platformTransactionManager));
    }
}
