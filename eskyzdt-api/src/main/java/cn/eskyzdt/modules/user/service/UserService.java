package cn.eskyzdt.modules.user.service;

import cn.eskyzdt.modules.user.entity.User;
import cn.eskyzdt.modules.user.entity.UserDto;

import java.util.List;
import java.util.Map;

public interface UserService {

    User findById(Integer id);

    UserDto findUser(UserDto userDto);

    boolean insertUser (User user);

    boolean batchInsertUser (List<User> userList);

    List<User> queryUser(Map<String, Object> params);
}
