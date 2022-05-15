package com.xzg.wlxx.system;

import cn.hutool.setting.SettingUtil;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * @author xzgan
 * @datetime 2022/5/15 16:29
 * @package com.xzg.wlxx.system
 */
public class Generator {
    public static void main(String[] args) throws IOException {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/db_system?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true"
                        , "root"
                        , "xiao")
                // 全局配置
                .globalConfig((scanner, builder) ->
                        builder
                                .author("xzg")
                                .enableSwagger()
                )
                // 包配置
                .packageConfig((scanner, builder) ->
                        builder
                                .parent("com.xzg.wlxx.system")
                                .build()
                )
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()

                        .entityBuilder().enableLombok().addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        ).enableLombok().enableTableFieldAnnotation().build()

                        .mapperBuilder().enableBaseColumnList().build()
                )
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
