package cn.eskyzdt.modules.user.dao;


import cn.eskyzdt.modules.pic.entity.Pic;
import cn.eskyzdt.modules.user.entity.User;
import cn.eskyzdt.modules.user.entity.UserDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

   //这里的dao层用了别名,所以这里有红线
   User findById(@Param("id") Integer id);

   UserDto findById2(@Param("id") Integer id);

   boolean insertUser(User user);

   boolean batchInsertUser(List<User> userList);

   List<User> queryUser(Map<String, Object> params);

    UserDto findUser(UserDto userDto);

   boolean insertUserDto(UserDto user);

    List<User> findUserList(@Param("username") String userName);

    boolean insertUserDup(User user);
}
