package cn.eskyzdt.modules.transaction.controller;

import cn.eskyzdt.modules.transaction.service.ExceptionOne;
import cn.eskyzdt.modules.user.entity.User;
import cn.eskyzdt.modules.user.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ExceptionOneController {

    @Resource
    private ExceptionOne exceptionOne;

    @Resource
    private UserService userService;

    @RequestMapping("/exe")
    /**
     * 非运行时异常是RuntimeException以外的异常，类型上都属于Exception类及其子类。
     * 如IOException、SQLException等以及用户自定义的Exception异常。
     * 对于这种异常，JAVA编译器强制要求我们必需对出现的这些异常进行catch并处理，否则程序就不能编译通过
     */

    /**
     * 1 让checked例外也回滚：在整个方法前加上 @Transactional(rollbackFor=Exception.class)
     *
     * 2 让unchecked例外不回滚： @Transactional(notRollbackFor=RunTimeException.class)
     *
     * 3 不需要事务管理的(只查询的)方法：@Transactional(propagation=Propagation.NOT_SUPPORTED)
     */
    @Transactional(rollbackFor = Exception.class)
    public void exceptionOneCon() {
        try {
            User user = new User();
            user.setUsername("out11");
            userService.insertUser(user);
            String name = Thread.currentThread().getName();
            System.out.println("主线程名" + name);

            try {
                exceptionOne.exception();
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            System.out.println("主线程睡10s");
            Thread.sleep(10000);
            System.out.println("主线程结束");
        } catch (Exception e) {
            /** 如果不加下面这一行,返回值会返回spring自动回滚的信息
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
             返回的结果:
           Wed Feb 19 18:48:40 CST 2020
             There was an unexpected error (type=Internal Server Error, status=500).
             Transaction rolled back because it has been marked as rollback-only
             **/
            System.out.println("e.toString" + e.toString());
            System.out.println("e.getCause" + e.getCause());
            System.out.println("===================================");
            e.printStackTrace();
            System.out.println("=========================");
            System.out.println("e.getMessage()" + e.getMessage());
            // 手动回滚,页面不会报错
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println("exe");
        }
    }

}