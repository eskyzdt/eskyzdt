package cn.eskyzdt.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;


/**
 *  * 如果继承WebMvcConfigurationSupport会导致一些mvc的配置类用@Bean的方式注入进去后不生效
 *  实现WebMvcConfigurer则不影响
 */

/**
 *  * 这里不需要用WebMvcConfigurerAdapter,已经过时了
 *  * 这里不需要用WebMvcConfigurerAdapter是WebMvcConfigurer的子类实现
 *  * 可以直接实现WebMvcConfigurer
 *

 *
 *  因为
 * {@link WebMvcConfigurer} has default methods (made
 * possible by a Java 8 baseline) and can be implemented directly without the
 * need for this adapter
 *
 * WebMvcConfigurerAdapter 是一个实现了WebMvcConfigurer 接口的抽象类，
 * 并提供了全部方法的空实现，我们可以在其子类中覆盖这些方法，
 * 以实现我们自己的配置，如视图解析器，拦截器和跨域支持等…，
 * 由于Java的版本更新，在Java 8中，可以使用default关键词为接口添加默认的方法，
 * Spring在升级的过程中也同步支持了Java 8中这一新特性。
 * 我们可以通过实现WebMvcConfigure接口中的方法来配置Web应用程序，
 * 而不需要让WebMvcConfigurerAdapter这个中间商 赚差价。
 *
 * 我们除了消除中间商从WebMvcConfigurer中获得配置Web应用程序的途径外，
 * 还可以直接从WebMvcConfigurationSupport这个配置“供应商“的手中获取配置途径。
 * WebMvcConfigurationSupport是一个提供了以Java编程方式来配置Web应用程序的配置主类，
 * 所以我们可以从这个配置供应商的手中获取Web应用程序的配置方式。方法很简单，
 * 只需要继承此类并重写对应的方法即可。
 *
 * 继承WebMvcConfigurationSupport
 * @see WebMvcConfig
 */
@Configuration
public class WebConfiguration  implements WebMvcConfigurer{

   @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                //添加资源目录
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/webapp/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //添加主页,如果用了themlef模板引擎,则index.html要放在templates中,现在没用,所以不用放
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        WebMvcConfigurer.super.addViewControllers(registry);
    }
}
