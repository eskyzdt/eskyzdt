package cn.eskyzdt;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;

import java.util.ArrayList;

import static cn.eskyzdt.MySQLGeneratorTest.FEATURE_MODULE;
import static cn.eskyzdt.MySQLGeneratorTest.FEATURE_MODULE_PATH;
import static cn.eskyzdt.MySQLGeneratorTest.PACKAGE_MODULE;

/**
 * 基础测试类
 *
 * @author lanjerry
 * @since 3.5.3
 */
public class BaseGeneratorTest {

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
                .convertServiceImplFileName(o -> o + "Service")
                .enableFileOverride();

        // mapper层
        builder.mapperBuilder().enableBaseColumnList()
                .enableFileOverride();

        // entity层
        builder.entityBuilder().enableChainModel()
                .enableLombok()
                .addIgnoreColumns("id", "who_created", "who_modified", "corp_id", "create_time", "update_time", "del_status")
                .enableFileOverride();
        return builder;
    }

    /**
     * 全局配置
     */
    protected static GlobalConfig.Builder globalConfig() {
        String projectPath = System.getProperty("user.dir");
        GlobalConfig.Builder builder = new GlobalConfig.Builder().author("dongtian.zhang")
                .outputDir(projectPath + "/src/main/java");
        return builder;
    }

    /**
     * 包配置
     */
    protected static PackageConfig.Builder packageConfig() {
        PackageConfig.Builder builder = new PackageConfig.Builder();
        builder.parent("com.myy" + PACKAGE_MODULE);
        builder.controller("controller" + FEATURE_MODULE);
        // service层改为repository层
        builder.service("repository" + FEATURE_MODULE);
        builder.serviceImpl("service" + FEATURE_MODULE);
        builder.mapper("mapper" + FEATURE_MODULE);
        builder.xml("resources.mapper");
        builder.entity("mapper" + FEATURE_MODULE);

        return builder;
    }

    /**
     * 模板配置
     */
    protected static TemplateConfig.Builder templateConfig() {
        TemplateConfig.Builder builder = new TemplateConfig.Builder();
        builder.controller("mytemplate/controller.java.vm");
        builder.service("mytemplate/repository.java.vm");
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
        CustomFile fileOne = new CustomFile.Builder().fileName("/custom/req" +FEATURE_MODULE_PATH +"/req.java").templatePath("mytemplate/reqvo.java.vm").build();
        CustomFile fileTwo = new CustomFile.Builder().fileName("/custom/res"+FEATURE_MODULE_PATH +"/res.java").templatePath("mytemplate/resvo.java.vm").build();
        CustomFile fileThree = new CustomFile.Builder().fileName("/custom/res"+FEATURE_MODULE_PATH +"/converter.java").templatePath("mytemplate/converter.java.vm").build();
        ArrayList<CustomFile> customFiles = new ArrayList<>();
        customFiles.add(fileOne);
        customFiles.add(fileTwo);
        customFiles.add(fileThree);

        InjectionConfig.Builder builder = new InjectionConfig.Builder()
                .customFile(customFiles)
                .beforeOutputFile((tableInfo, objectMap) -> {
                    String entityName = tableInfo.getEntityName();
                    System.out.println("tableInfo: " + entityName + " objectMap: " + objectMap.size());
                })
                .fileOverride()
                ;

        return builder;
    }
}