package cn.eskyzdt.modules.filter;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 方法1: 使用 @Configuration 或@Component
 * spring会扫描到注解
 * 并以首字母小写的方式注入过滤器
 * 因为它实现了Filter
 *
 *  * 这里使用extends OncePerRequestFilter也可以
 *  * OncePerRequestFilter也是实现Filter的
 *  例 public class TestFilter extends OncePerRequestFilter
 *
  */

/**
 * 方法2: 使用@WebFilter注解
 * 这个注解在SpringMvc中可以直接用,springmvc会自动扫描到
 * 但是到了springBoot中,需要配合
 * @See @ServletComponentScan 使用
 * 需要注意的是 @ServletComponentScan 只支持使用内置的tomcat容器时才生效
 * 下面是说明
 * 它支持扫描 WebServlet WebListener WebFilter三个注解,如果使用@ServletComponentScan
 * 那么注解无效
 *
 *
 *  * Enables scanning for Servlet components ({@link WebFilter filters}, {@link WebServlet
 *  * servlets}, and {@see WebListener listeners}). Scanning is only performed when using an
 *  * embedded web server.
 *  * <p>
 *  * Typically, one of {@code value}, {@code basePackages}, or {@code basePackageClasses}
 *  * should be specified to control the packages to be scanned for components. In their
 *  * absence, scanning will be performed from the package of the class with the annotation.
 *  *
 *  * @author Andy Wilkinson
 *  * @since 1.3.0
 *  * @see WebServlet
 *  * @see WebFilter
 *  * @see WebListener
 *
 *
 * 附: springboot启动时提示
 * 2020-12-17 11:11:47.176  INFO 2324 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1358 ms
 * 2020-12-17 11:11:47.358  INFO 2324 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Servlet dispatcherServlet mapped to [/]
 * 2020-12-17 11:11:47.361  INFO 2324 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
 * 2020-12-17 11:11:47.362  INFO 2324 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
 * 2020-12-17 11:11:47.362  INFO 2324 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
 * 2020-12-17 11:11:47.362  INFO 2324 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
 * 2020-12-17 11:11:47.362  INFO 2324 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'testFilter' to: [/*]
 *
 *
 */

/**
 * 一般使用时指定下面三个参数即可
 * @WebInitParam可以初始化字段
 * @WebFilter(filterName = "AuthorizeFilter",
 * 		urlPatterns = "/*",
 * 		initParams = {@WebInitParam(name = "a", value = "sssssss")})
 *
 * 注意这里的urlPatterns = "/*", 只能用/*,不能用/**,使用/**会报错
 * Suspicious url pattern: "/**"
 * 可疑的路径,并不会影响启动,但是并不会拦截请求了,相当于失效
 * 对于urlPatterns,只要带了/**,都不生效
 *
 */
@WebFilter(filterName = "TestFilter",urlPatterns = "/*",
    // 注意这里是使用config.getInitParameter(“test”);获得InitParam的value的字符串。然后再存入,所以需要getset方法,否则是存不进去的啊傻子QAQ
    initParams = {@WebInitParam(name = "test",value = "true")}

)
/**
 * 这个是指定过滤器的优先级
 */
@Order(value = 2111)
public class TestFilter extends OncePerRequestFilter {

    private boolean test;

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("33333");
        System.out.println(test);
    }

}
