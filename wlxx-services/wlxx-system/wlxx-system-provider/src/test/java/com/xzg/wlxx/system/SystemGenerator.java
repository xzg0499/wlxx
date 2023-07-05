package com.xzg.wlxx.system;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xzgan
 * @since 2022/8/18
 */
public class SystemGenerator {

    @Test
    public void generator() {
        //FastAutoGenerator.create("jdbc:mysql://localhost:3306/db_system?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true"
        //                , "root", "xiao")
        //        .globalConfig(builder -> {
        //            builder.author("baomidou") // 设置作者
        //                    .enableSwagger() // 开启 swagger 模式
        //                    .disableOpenDir()
        //                    .fileOverride() // 覆盖已生成文件
        //                    .outputDir("E:\\Project\\wlxx\\wlxx-services\\wlxx-system\\wlxx-system-client\\src\\main\\java"); // 指定输出目录
        //        })
        //        .packageConfig(builder -> {
        //            builder.parent("com.xzg.wlxx.system.client") // 设置父包名
        //                    .moduleName("") // 设置父包模块名
        //                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://")); // 设置mapperXml生成路径
        //        })
        //        .templateConfig(builder -> {
        //            //禁用生产 controller、service、mapper层
        //            builder.controller(null)
        //                    .service(null)
        //                    .serviceImpl(null)
        //                    .mapper(null)
        //                    .mapperXml(null);
        //        })
        //        .strategyConfig(builder -> {
        //            builder.addInclude("t_dict") // 设置需要生成的表名
        //                    .addTablePrefix("t_", "c_")// 设置过滤表前缀
        //                    .entityBuilder()
        //                    .superClass(BasePo.class)
        //                    .enableTableFieldAnnotation()
        //                    .enableLombok()
        //            ;
        //        })
        //        .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
        //        .execute();

        // TODO gradle test console无法调用Scanner方法
        // FastAutoGenerator.create("jdbc:mysql://localhost:3306/db_system?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true"
        //                 ,"root","xiao")
        //         // 全局配置
        //         .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称？")).fileOverride())
        //         // 包配置
        //         .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？")))
        //         // 策略配置
        //         .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
        //                 .controllerBuilder().enableRestStyle().enableHyphenStyle()
        //                 .entityBuilder().enableLombok().addTableFills(
        //                         new Column("create_time", FieldFill.INSERT)
        //                 ).build())
        //         /*
        //             模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
        //            .templateEngine(new BeetlTemplateEngine())
        //            .templateEngine(new FreemarkerTemplateEngine())
        //          */
        //         .templateEngine(new FreemarkerTemplateEngine())
        //         .execute();


    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
