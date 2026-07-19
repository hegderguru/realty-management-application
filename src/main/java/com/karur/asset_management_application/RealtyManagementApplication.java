package com.karur.asset_management_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RealtyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealtyManagementApplication.class, args);
	}

}
