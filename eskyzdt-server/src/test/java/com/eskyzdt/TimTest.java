package com.eskyzdt;

import com.eskyzdt.modules.dao.UserDao;
import com.eskyzdt.modules.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TimTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void Test01(){
        User byId = userDao.findById(1);
        System.out.println(byId);
        log.error("userDao");
    }


}
