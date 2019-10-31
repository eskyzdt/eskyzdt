package cn.eskyzdt.modules.user.service;

import cn.eskyzdt.modules.user.dao.UserDao;
import cn.eskyzdt.modules.user.entity.User;
import cn.eskyzdt.modules.user.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional  //这里要加事务的注解
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findById(Integer id) {
        System.out.println("USerServicerun");
        return userDao.findById(id);
    }

    @Override
    public UserDto findUser(UserDto userDto) {
        return userDao.findUser(userDto);
    }

    @Override
    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public boolean insertUser(UserDto user) {
        return userDao.insertUserDto(user);
    }

    @Override
    public boolean batchInsertUser(List<User> userList) {
        return userDao.batchInsertUser(userList);
    }

    @Override
    public List<User> queryUser(Map<String, Object> params) {
        return userDao.queryUser(params);
    }

}
