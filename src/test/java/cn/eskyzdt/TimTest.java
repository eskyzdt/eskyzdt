package cn.eskyzdt;

import cn.eskyzdt.modules.dao.UserDao;
import cn.eskyzdt.modules.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void Test01(){
        User byId = userDao.findById(1);
        System.out.println(byId);
    }


}
