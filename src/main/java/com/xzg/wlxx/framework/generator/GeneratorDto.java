package com.xzg.wlxx.framework.generator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 肖志刚
 * @Date: 2020/7/5 0:30
 */
@Data
@Log4j2
public class GeneratorDto {
    @Setter@Getter
    private String datasourceName = "wlxx";
    @Setter@Getter
    private String packageParentName = "com.xzg";
    @Setter@Getter
    private String packageModuleName = "wlxx";
    @Setter@Getter
    private String[] tableNames;
    @Setter@Getter
    private String jdbcUrl;
    @Setter@Getter
    private String driverClassName;
    @Setter@Getter
    private String username;
    @Setter@Getter
    private String password;
    public void initDatasourceConfig(DatasourceList datasourceList){
        Map<String,String> datasource = new HashMap<>();
        try {
            datasource = (Map<String, String>) datasourceList.getClass().getMethod("get"+this.datasourceName.replaceAll("^.",this.datasourceName.substring(0,1).toUpperCase())).invoke(datasourceList);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            log.error("找不到"+this.datasourceName+"数据源");
        }
        this.jdbcUrl=datasource.get("jdbc-url");
        this.driverClassName=datasource.get("driver-class-name");
        this.username=datasource.get("username");
        this.password=datasource.get("password");
    }
}
