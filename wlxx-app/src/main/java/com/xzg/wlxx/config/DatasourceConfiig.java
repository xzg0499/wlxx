package com.xzg.wlxx.config;

/**
 * 注入多数据源，并且必须要有一个Primary级别的主数据源
 * @Author: 肖志刚
 * @Date: 2020/7/6 19:47
 */

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DatasourceConfiig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari.wlxx")
    @Primary
    public DataSource wlxxDatasource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari.user")
    public DataSource userDatasource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari.framework")
    public DataSource frameworkDatasource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

}
