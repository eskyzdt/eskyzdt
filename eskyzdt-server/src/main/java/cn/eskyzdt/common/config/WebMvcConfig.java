package cn.eskyzdt.common.config;


import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;


/**
 * 消息转换器的目标是：
 *
 *
 *     HTTP输入请求格式向Java对象的转换；
 *
 *
 *     Java对象向HTTP输出请求的转换。
 *
 *
 *
 * 有的消息转换器只支持多个数据类型，有的只支持多个输出格式，还有的两者兼备。
 *
 *
 * 例如：MappingJackson2HttpMessageConverter可以将Java对象转换为application/json，而ProtobufHttpMessageConverter仅支持com.google.protobuf.Message类型的输入，但是可以输出application/json、application/xml、text/plain和application/x-protobuf这么多格式。
 *
 *
 * 实践
 *
 *
 * 在项目中有三种办法配置消息转换器，主要是从可定制性和易用度两个方面进行衡量。
 *
 *
 *     在WebConfiguration类中加入@Bean定义
 *
 *
 *
 * @Bean
 * public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
 *     return new ByteArrayHttpMessageConverter();
 * }
 *
 *
 *
 *     重写（override）configureMessageConverters方法，扩展现有的消息转换器链表；
 *
 *
 *
 * @Override
 * public
 * void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
 *     converters.add(new ByteArrayHttpMessageConverter());
 * }
 *
 *
 *
 *     更多的控制，可以重写extendMessageConverters方法，首先清空转换器列表，再加入自定义的转换器。
 *
 *
 *
 * @Override
 * public
 * void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
 *     converters.clear();
 *     converters.add(new ByteArrayHttpMessageConverter());
 * }
 *
 *
 *
 * 分析
 *
 *
 * Spring Boot提供了多种方法完成同样的任务，选择哪个取决于我们更侧重便捷性还是更侧重可定制性。
 *
 *
 * 上述提到的三种方法各有什么不同呢？
 *
 *
 * 通过@Bean定义HttpMessageConverter是向项目中添加消息转换器最简便的办法，这类似于之前提到的添加Servlet Filters。如果Spring扫描到HttpMessageConverter类型的bean，就会将它自动添加到调用链中。推荐让项目中的WebConfiguration继承自WebMvcConfigurerAdapter。
 *
 *
 * 通过重写configureMessageConverters方法添加自定义的转换器很方便，但有一个弱点：如果项目中存在多个WebMvcConfigurers的实例（我们自己定义的，或者Spring Boot默认提供的），不能确保重写后的configureMessageConverters方法按照固定顺序执行。
 *
 *
 * 如果需要更精细的控制：清除其他消息转换器或者清楚重复的转换器，可以通过重写extendMessageConverters完成，仍然有这种可能：别的WebMvcConfigurer实例也可以重写这个方法，但是这种几率非常小。
 *
 *
 * Spring Boot 1.x系列
 *
 *     Spring Boot的自动配置、Command-line-Runner 了解Spring Boot的自动配置 Spring Boot的@PropertySource注解在整合Redis中的使用
 *
 *
 * 本号（javaadu）专注于后端技术、JVM问题排查和优化、Java面试题、个人成长和自我管理等主题，为读者提供一线开发者的工作和成长经验，期待你能在这里有所收获。
 */
//@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("*")
				.allowCredentials(true)
				.allowedOrigins("*");
		super.addCorsMappings(registry);
	}

	@Override
	protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new Resolver());
		super.addArgumentResolvers(argumentResolvers);
	}

}
