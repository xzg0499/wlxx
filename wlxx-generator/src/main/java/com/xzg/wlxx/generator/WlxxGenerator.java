package com.xzg.wlxx.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xzgang0499
 * @date 2022-01-15
 * @since jdk1.8
 */
public class WlxxGenerator {
    public static GeneratorConfig generatorConfig = new GeneratorConfig();

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        new WlxxGenerator().generator();
    }

    public void init() throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel( new FlatDarkLaf());

        JFrame frame = new JFrame("Generator");
        GeneratorGui gui = new GeneratorGui();
        frame.setContentPane(gui.$$$getRootComponent$$$());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void generator(){
        FastAutoGenerator.create(generatorConfig.getJdbcUrl(), generatorConfig.getUsername(), generatorConfig.getPassword())
                .globalConfig(builder -> {
                    builder.author(generatorConfig.getAuthor()) // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(generatorConfig.getOutputDir()); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(generatorConfig.getDriverClassName()) // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, generatorConfig.getOutputDir())); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(generatorConfig.getTableNames()) // 设置需要生成的表名
                            .addTablePrefix("t_", "c_") // 设置过滤表前缀
                            .entityBuilder().enableLombok();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
