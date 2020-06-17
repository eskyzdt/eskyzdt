package cn.eskyzdt.modules.user.service;

import cn.eskyzdt.modules.user.dao.UserDao;
import cn.eskyzdt.modules.user.entity.User;
import cn.eskyzdt.modules.user.entity.UserDto;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional  //这里要加事务的注解
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(Integer id) {
        System.out.println("USerServicerun");
        User byId = userDao.findById(id);
        R r = R.ok(byId);
        return byId;
    }

    @Override
    public R findByIdR(Integer id) {
        System.out.println("USerServicerun");
        UserDto byId = userDao.findById2(id);
        R r = R.ok(byId);
        return r;
    }

    @Override
    public UserDto findById2(Integer id) {
        System.out.println("USerServicerun");
        UserDto byId2 = userDao.findById2(id);
        return byId2;
    }

    @Override
    public UserDto findUser(UserDto userDto) {
        return userDao.findUser(userDto);
    }

    @Override
    public List<User> findUserList(String userName) {
        return userDao.findUserList(userName);
    }

    @Override
    @Transactional
    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    @Transactional
    public boolean insertUserDup(User user) {
        return userDao.insertUserDup(user);
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
