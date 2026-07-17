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

    private Map<String, DataSource> datasources;
    private Map<String, NamedParameterJdbcTemplate> namedParameterJdbcTemplates;
    private Map<String, EntityManagerFactory> entityManagerFactories;
    private Map<String, PlatformTransactionManager> platformTransactionManagers;

    @PostConstruct
    public void setup() {
        datasources = datasources();
        namedParameterJdbcTemplates = namedParameterJdbcTemplates(datasources);
        entityManagerFactories = entityManagerFactories(datasources);
        platformTransactionManagers = platformTransactionManagers(entityManagerFactories);
    }

    private Map<String, DataSource> datasources() {
        Map<String, DataSource> dataSources = new HashMap<>();
        databaseProperties.getPostgres()
                .forEach((key, config) -> {
                    HikariConfig hikariConfig = new HikariConfig();
                    hikariConfig.setJdbcUrl(config.getJdbcUrl());
                    hikariConfig.setUsername(config.getUsername());
                    hikariConfig.setPassword(config.getPassword());
                    hikariConfig.setDriverClassName(config.getDriverClassName());
                    hikariConfig.setSchema(config.getSchema());
                    applyDefault(hikariConfig, config.getHikari());
                    datasources.put(config.getPackageNames().getDatasource(), new HikariDataSource(hikariConfig));
                });
        datasources.forEach((key, dataSource) -> configurableListableBeanFactory.registerSingleton(key, dataSource));
        return datasources;
    }

    private void applyDefault(HikariConfig hikariConfig, DatabaseProperties.HikariProperties hikari) {
        hikariConfig.setConnectionTimeout(hikariConfig.getConnectionTimeout());
        hikariConfig.setIdleTimeout(hikariConfig.getIdleTimeout());
        hikariConfig.setMaxLifetime(hikariConfig.getMaxLifetime());
        hikariConfig.setMinimumIdle(hikariConfig.getMinimumIdle());
        hikariConfig.setLeakDetectionThreshold(hikariConfig.getLeakDetectionThreshold());
        hikariConfig.setMaximumPoolSize(hikariConfig.getMaximumPoolSize());
        hikariConfig.setConnectionTestQuery(hikariConfig.getConnectionTestQuery());
    }

    private Map<String, NamedParameterJdbcTemplate> namedParameterJdbcTemplates(Map<String, DataSource> datasources) {
        Map<String, NamedParameterJdbcTemplate> namedParameterJdbcTemplates = new HashMap<>();
        databaseProperties.getPostgres().forEach((key, config) -> {
            DataSource dataSource = datasources.get(config.getPackageNames().getDatasource());
            namedParameterJdbcTemplates.put(config.getPackageNames().getNamedParameterJdbcTemplate(), new NamedParameterJdbcTemplate(dataSource));
        });
        namedParameterJdbcTemplates.forEach((key, namedParameterJdbcTemplate) -> configurableListableBeanFactory.registerSingleton(key, namedParameterJdbcTemplate));
        return namedParameterJdbcTemplates;
    }

    public Map<String, EntityManagerFactory> entityManagerFactories(Map<String, DataSource> datasources) {
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
        return entityManagerFactories;
    }

    public Map<String, PlatformTransactionManager> platformTransactionManagers(Map<String, EntityManagerFactory> entityManagerFactories) {
        Map<String, PlatformTransactionManager> platformTransactionManagers = new HashMap<>();
        databaseProperties.getPostgres().forEach((key, config) -> {
            EntityManagerFactory entityManagerFactory = entityManagerFactories.get(config.getPackageNames().getPlatformTransactionManager());
            platformTransactionManagers.put(config.getPackageNames().getPlatformTransactionManager(), new JpaTransactionManager(entityManagerFactory));
        });
        platformTransactionManagers.forEach((key, platformTransactionManager) -> configurableListableBeanFactory.registerSingleton(key, platformTransactionManager));
        return platformTransactionManagers;
    }
}
