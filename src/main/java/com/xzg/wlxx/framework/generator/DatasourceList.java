package com.xzg.wlxx.framework.generator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 读取项目数据源配置，仅支持hikai多数据源配置
 * @Author: 肖志刚
 * @Date: 2020/7/7 20:39
 */
@Data
@Component
@ConfigurationProperties("spring.datasource.hikari")
public class DatasourceList {
//    单个配置获取
//    @Getter
//    @Value("${spring.datasource.hikari.wlxx.jdbc-url}")
//    private String wlxxJdbcUrl;
//    @Getter
//    @Value("${spring.datasource.hikari.wlxx.driver-class-name}")
//    private String wlxxDriverClassName;
//    @Getter
//    @Value("${spring.datasource.hikari.wlxx.username}")
//    private String wlxxUserName;
//    @Getter
//    @Value("${spring.datasource.hikari.wlxx.password}")
//    private String wlxxPassword;
//    @Getter
//    @Value("${spring.datasource.hikari.auth}")
//    private Object auth;
//    批量获取配置，每新增一个数据源，按照顺序在此处新增一个map，用于接收配置信息
    @Getter@Setter
    private Map<String,String> wlxx;
    @Getter@Setter
    private Map<String,String> auth;
}
