package cn.eskyzdt;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

import static cn.eskyzdt.BaseGeneratorTest.globalConfig;
import static cn.eskyzdt.BaseGeneratorTest.strategyConfig;

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

            .build();

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(strategyConfig().build());
        generator.global(globalConfig().build());
        generator.packageInfo(packageConfig().build());
//        generator.injection(injectionConfig().build());
        generator.template(templateConfig().build());
        generator.execute();
    }

}