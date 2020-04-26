package com.example.oraclemergedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Value("${com.manish.dbUrl}")
    private String dbUrl;
    @Value("${com.manish.userName}")
    private String userName;
    @Value("${com.manish.password}")
    private String password;
    @Value("${com.manish.driver-class-name}")
    private String driverClassName;

    @Primary
    @Bean(name = "datasource")
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(dbUrl);
        driverManagerDataSource.setUsername(userName);
        driverManagerDataSource.setPassword(password);
        driverManagerDataSource.setDriverClassName(driverClassName);

        return  driverManagerDataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
