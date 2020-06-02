package cn.eskyzdt.modules.transaction.service;

import cn.eskyzdt.modules.user.entity.User;
import cn.eskyzdt.modules.user.service.UserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExceptionOneImpl implements ExceptionOne  {

    @Resource
    private UserService userService;

    @Override
    // nested：内部的事务不影响外部
    // @Transactional(propagation = Propagation.NESTED)
    // 如果什么都不加,默认是required,内外都是一个事务
    @Transactional(rollbackFor = RuntimeException.class)
    /**
     * 在有事务的情况下@Async注解是没用的,程序会依然顺序执行
     */
    @Async
    public String exception() {
        List<User> user1 = userService.findUserList("out");
        System.out.println("查到的用户为:" + user1 );
        if(CollectionUtils.isEmpty(user1) || user1.size()!=1){
            System.out.println("----------------------");
        }
        System.out.println("异常线程开始睡觉");
        String name = Thread.currentThread().getName();
        System.out.println("异常线程名" + name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异常线程睡觉结束");
        User user = new User();
        user.setUsername("nest");
        userService.insertUser(user);
        int a = 1/0;
        return String.valueOf(a);
    }

}
