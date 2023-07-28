package cn.eskyzdt;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

/**
 * MySQL 代码生成
 *
 * @author lanjerry
 * @since 3.5.3
 */
public class MySQLGeneratorTest extends BaseGeneratorTest {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://127.0.0.1:3306/mybatis-plus", "root", "123456")
            .build();

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        // 策略配置(StrategyConfig)
        StrategyConfig.Builder strategyConfigBuilder = strategyConfig();
        // 配置要生成的表
        strategyConfigBuilder.addInclude("cure_tooth_exam_follow");
        generator.strategy(strategyConfigBuilder.build());
        // 全局配置
        generator.global(globalConfig().build());
        // 包的路径等
        generator.packageInfo(packageConfig().build());
        //  enerator.injection(injectionConfig().build());
        // 模板配置
        generator.template(templateConfig().build());
        generator.execute();
    }

}