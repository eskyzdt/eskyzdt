package cn.eskyzdt.modules.transaction.service;

import cn.eskyzdt.modules.user.entity.User;
import cn.eskyzdt.modules.user.service.UserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@EnableAsync
public class ExceptionOneImpl{

    @Resource
    private UserService userService;

    // nested：内部的事务不影响外部
    // @Transactional(propagation = Propagation.NESTED)
    // 如果什么都不加,默认是required,内外都是一个事务
    @Transactional(rollbackFor = RuntimeException.class)
    /**
     * 在有异步的情况下@Transactional注解是没用的
     */
    @Async
    public String exception() throws InterruptedException {

        System.out.println("异步子线程睡15s----------------------");
        Thread.sleep(15);
        System.out.println("异步子线程开始----------------------");
        System.out.println(this.getClass());
        List<User> user1 = userService.findUserList("fuck2");
        // 这里无论异步不异步, 都可以查到上一级插入的用户, 区别在于非异步的情况下由于transactional生效, 事务回滚, 虽然查到了但是数据库没有值
        System.out.println("查到的用户为:" + user1 );
        System.out.println("异步线程开始睡觉");
        String name = Thread.currentThread().getName();
        System.out.println("异步线程名" + name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步线程睡觉结束");
        User user = new User();
        user.setUsername("nest");
        userService.insertUser(user);
        System.out.println("异步线程报错");
        int a = 1/0;
        return String.valueOf(a);
    }

}
