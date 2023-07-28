package cn.eskyzdt;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;

import java.util.Collections;

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
        builder.controller("controller");

        return builder;
    }

    /**
     * 模板配置
     */
    protected static TemplateConfig.Builder templateConfig() {
        TemplateConfig.Builder builder = new TemplateConfig.Builder();
        builder.controller("estyaaa/controller.java.vm");
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