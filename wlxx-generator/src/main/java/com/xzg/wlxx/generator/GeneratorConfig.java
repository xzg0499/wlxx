package com.xzg.wlxx.generator;

import lombok.Data;

/**
 * @author xzgang0499
 * @date 2022-01-15
 * @since jdk1.8
 */

@Data
public class GeneratorConfig {
    /**
     * 数据库配置
     */
    private String host = "localhost";
    private String port = "3306";
    private String schema = "db_user";
    private String jdbc = "?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private String jdbcUrl = String.format("jdbc:mysql://%s:%s/%s%s",
            host,port,schema,jdbc);
    private String username = "root";
    private String password = "xiao";
    private String driverClassName = "com.mysql.cj.jdbc.Driver";

    /**
     * 表配置
     */
    private String author = "xzgang0499";
    private String packageName = "wlxx";
    private String tableNames = "t_user";

    /**
     * 全局配置
     */
    private String outputDir = "F:\\generator";
//    private String outputDir = System.getProperty("user.dir");
}
