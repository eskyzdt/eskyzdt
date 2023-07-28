package cn.eskyzdt.modules.user.service;

import cn.eskyzdt.modules.user.entity.User;
import cn.eskyzdt.modules.user.entity.UserDto;

import java.util.List;
import java.util.Map;

public interface UserService<R> {


    void threadTest();

    User findById(Integer id);

    UserDto findById2(Integer id);

    public R findByIdR(Integer id);

    UserDto findUser(UserDto userDto);

    List<User> findUserList(String username);

    boolean insertUser (User user);

    boolean insertUserDup (User user);

    boolean insertUser (UserDto user);

    boolean batchInsertUser (List<User> userList);

    List<User> queryUser(Map<String, Object> params);
}
