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

    // 注意改完之后需要清理工作空间
    /**
     * 处于com.xxx. . 这一级的包名 一般是项目名
     */
    public static final String PACKAGE_MODULE = ".chat";

    /**
     * 子级的模块名 一般是功能名
     */
    public static final String FEATURE_MODULE = ".statistics";
    public static final String FEATURE_MODULE_PATH = "/statistics";

    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .build();

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        // 策略配置(StrategyConfig)
        StrategyConfig.Builder strategyConfigBuilder = strategyConfig();
        // 配置要生成的表
        strategyConfigBuilder.addInclude("ms_appointment_statistics");
        generator.strategy(strategyConfigBuilder.build());
        // 全局配置
        generator.global(globalConfig().build());
        // 包的路径等
        generator.packageInfo(packageConfig().build());
        // 自定义配置
        generator.injection(injectionConfig().build());
        // 模板配置
        generator.template(templateConfig().build());
        generator.execute();
    }

}