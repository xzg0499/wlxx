package com.xzg.wlxx.generator;

import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

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
     * 可选配置
     */


    /**
     * 全局配置
     */

    private String packageName = "wlxx";
    private String tableNames = "t_user";



    /**
     * 全局配置
     */
    private String outputDir = "F:\\generator";
    private String fileOverride = "false";
    private Boolean disableOpenDir = true;
    private String author = "xzgang0499";
    private Boolean enableKolin = false;
    private String enableSwagger = "false";
    private String dateType = "";
    private String commentDate = "yyyy-MM-dd";

    /**
     * 包配置
     */
    private String parent = "com.xzg";
    private String moduleName = "wlxx";
    private String entity = "entity";
    private String service = "service";
    private String serviceImpl = "service.impl";
    private String mapper = "mapper";
    private String mapperXml = "mapper.xml";
    private String other = "";
    private Map<OutputFile,String> pathInfo = new HashMap<>();

    /**
     * 模板配置
     */
    private Boolean disable = false;

    /**
     * 策略
     */
    private Boolean enableCapitalMode = false;
    private Boolean enableSkipView = false;
    private Boolean disableSqlFiler = true;
    private Boolean enableSchema = false;


    /**
     * 实体策略
     */
    private INameConvert nameConvert;
    private String superClass = "com.xzg.wlxx.common.pojo.entity.BaseEntity";
    private Boolean disableSerialVersionUID = true;
    private Boolean enableColumnContant = false;
    private Boolean enableChainModel = false;
    private Boolean enableLombok = false;
    private Boolean enableRemoveIsPrefix = false;
    private Boolean enableTableFieldAnnotation = false;
    private Boolean enableActiveRecord = false;
    private String versionColumnName = "";
    private String versionPropertyName = "";
    private String logicDeleteColumnName = "";
    private String logicDeletePropertyName = "";
    private String disableOutputDir;
    private String enableKotlin;

    public String getDisableOutputDir() {
        return disableOutputDir;
    }

    public void setDisableOutputDir(final String disableOutputDir) {
        this.disableOutputDir = disableOutputDir;
    }

    public String getEnableKotlin() {
        return enableKotlin;
    }

    public void setEnableKotlin(final String enableKotlin) {
        this.enableKotlin = enableKotlin;
    }
}
