package com.eskyzdt.modules.service;

import com.eskyzdt.modules.dao.UserDao;
import com.eskyzdt.modules.entity.User;
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
