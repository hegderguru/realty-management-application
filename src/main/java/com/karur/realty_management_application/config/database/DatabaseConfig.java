package com.karur.realty_management_application.config.database;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfig {

    @Configuration
    @EnableJpaRepositories(
            basePackages = "com.karur.realty_management_application.repository",
            entityManagerFactoryRef = "assetContainerEntityManagerFactory",
            transactionManagerRef = "assetPlatformTransactionManager"
    )
    public static class AssetDatabaseConfig{

    }
}
