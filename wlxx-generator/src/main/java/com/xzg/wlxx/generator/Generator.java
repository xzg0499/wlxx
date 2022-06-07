package com.xzg.wlxx.generator;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xzgan
 * @date 2022/6/1
 * @since jdk1.8
 */
public class Generator {

    public static void main(String[] args) throws IOException {
        saveConfig();
    }

    public static void loadConfig() throws IOException {
        String dir = System.getProperty("user.dir")+"\\generator\\";
        File file = new File(dir+"config.json");

        JSON json = JSONUtil.readJSON(file, StandardCharsets.UTF_8);

        DataSourceConfig dataSourceConfig = null;



        System.out.println(json.toString());

    }

    public static void saveConfig() throws IOException {
        String url = "jdbc:mysql://localhost:3306/db_system?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "xiao";
        String dir = System.getProperty("user.dir")+"\\generator\\";

        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder(url,username,password).build();


        File file = new File(dir+"config.json");
        if(!file.exists()) {
            file.createNewFile();
        }
        JSONConfig config = new JSONConfig();
        config.setIgnoreNullValue(false);
        FileUtil.writeString(JSONUtil.toJsonStr(dataSourceConfig,config).toString(),file,StandardCharsets.UTF_8);
        System.out.println(JSONUtil.toJsonStr(dataSourceConfig));

    }

    public static void fastExecute(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/db_system?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true"
                        ,"root","xiao")
                // 全局配置
                .globalConfig((scanner, builder) ->{
                    builder.author("xzgang0499").fileOverride()
                            .disableOpenDir()
                            .outputDir(System.getProperty("user.dir")+"\\generator");
                    System.out.println(JSONUtil.toJsonStr(builder.build()));
                })
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent("com.xzg.wlxx"))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude("t_dict")
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok().addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        ).build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .execute();
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
