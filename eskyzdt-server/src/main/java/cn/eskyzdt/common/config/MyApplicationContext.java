package cn.eskyzdt.common.config;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * spring扫描到Configuration注解时会自动生成一个开头字母小写的一个bean
 */
@Configuration
public class MyApplicationContext implements ApplicationContextAware {



  private ApplicationContext context;

  /**
   * 对于实现了ApplicationContextAware接口的这个类
   * 会自动执行setApplicationContext方法
   * 这样就能获取ApplicationContext了
   *
   * @param applicationContext
   * @throws BeansException
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }

}
