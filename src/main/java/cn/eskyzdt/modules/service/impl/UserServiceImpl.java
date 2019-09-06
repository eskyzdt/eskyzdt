package cn.eskyzdt.modules.service.impl;

import cn.eskyzdt.modules.service.UserService;
import cn.eskyzdt.modules.dao.UserDao;
import cn.eskyzdt.modules.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional  //这里要加事务的注解
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findById(Integer id) {
        System.out.println("USerServicerun");
        return userDao.findById(id);
    }

}
