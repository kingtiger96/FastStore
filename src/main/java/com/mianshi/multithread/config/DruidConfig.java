package com.mianshi.multithread.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import javax.sql.DataSource;


@Configuration
public class DruidConfig {
    private Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    @Value("${spring.datasource.mysql.jdbc-url}")
    private String dbUrl;

    @Value("${spring.datasource.mysql.userName}")
    private String username;

    @Value("${spring.datasource.mysql.password}")
    private String password;
    @Value("${spring.datasource.mysql.driver-class-name}")
    private String driverClassName;



    @Bean
    @Primary
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(this.username);
        datasource.setPassword(this.password);
        datasource.setDriverClassName(this.driverClassName);

        return datasource;
    }
}
