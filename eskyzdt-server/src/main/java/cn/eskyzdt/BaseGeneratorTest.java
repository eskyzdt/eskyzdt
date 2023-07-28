package cn.eskyzdt;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;

/**
 * 基础测试类
 *
 * @author lanjerry
 * @since 3.5.3
 */
public class BaseGeneratorTest {
    /**
     * 处于com.xxx. . 这一级的包名 todo
     */
    public static final String PACKAGE_MODULE = ".user";

    /**
     * 子级的模块名 todo
     */
    public static final String FEATURE_MODULE = ".dosth";


    /**
     * 策略配置
     */
    protected static StrategyConfig.Builder strategyConfig() {
        StrategyConfig.Builder builder = new StrategyConfig.Builder();


        // controller层
        builder.controllerBuilder().enableRestStyle()
                .enableFileOverride()
                .enableHyphenStyle();
        // service层
        builder.serviceBuilder()
                .convertServiceImplFileName(o->o + "Service")
                .enableFileOverride();

        // entity层
        builder.entityBuilder().enableChainModel()
                .enableLombok()
                .addIgnoreColumns("who_created", "who_modified", "corp_id", "create_time", "update_time", "del_status")
                .enableFileOverride();
        return builder;
    }

    /**
     * 全局配置
     */
    protected static GlobalConfig.Builder globalConfig() {
        String projectPath = System.getProperty("user.dir");
        GlobalConfig.Builder builder = new GlobalConfig.Builder().author("dongtian.zhang")
                .outputDir(projectPath + "/src/main/java")
                ;
        return builder;
    }

    /**
     * 包配置
     */
    protected static PackageConfig.Builder packageConfig() {
        PackageConfig.Builder builder = new PackageConfig.Builder();
        builder.parent("com.myy" + PACKAGE_MODULE);
        builder.controller("controller" + FEATURE_MODULE);
        builder.service("service" + FEATURE_MODULE);
        builder.serviceImpl("service.impl" + FEATURE_MODULE);
        builder.mapper("mapper" + FEATURE_MODULE);
        builder.xml("resources.mapper");
        builder.entity("mapper.po" + FEATURE_MODULE);

        return builder;
    }

    /**
     * 模板配置
     */
    protected static TemplateConfig.Builder templateConfig() {
        TemplateConfig.Builder builder = new TemplateConfig.Builder();
        builder.controller("mytemplate/controller.java.vm");
        builder.service("mytemplate/service.java.vm");
        builder.serviceImpl("mytemplate/serviceImpl.java.vm");
        builder.mapper("mytemplate/mapper.java.vm");
        builder.xml("mytemplate/mapper.xml.vm");
        builder.entity("mytemplate/entity.java.vm");
        return builder;
    }

    /**
     * 注入配置
     */
    protected static InjectionConfig.Builder injectionConfig() {
        // 测试自定义输出文件之前注入操作，该操作再执行生成代码前 debug 查看
        return new InjectionConfig.Builder().beforeOutputFile((tableInfo, objectMap) -> {
            System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size())

            ;
        })
//                .customFile(Collections.singletonMap("test.txt", "/estyaaa/controller.java.vm"))
                ;
    }
}