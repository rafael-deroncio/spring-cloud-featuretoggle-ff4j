package com.company.featuretoggle.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfiguration {

    @Value("${spring.datasource.url}")
    private String _url;

    @Value("${spring.datasource.username}")
    private String _username;

    @Value("${spring.datasource.password}")
    private String _password;

    @Value("${spring.datasource.driver-class-name}")
    private String _driver;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(_url);
        dataSource.setUsername(_username);
        dataSource.setPassword(_password);
        dataSource.setDriverClassName(_driver);
        return dataSource;
    }

}
