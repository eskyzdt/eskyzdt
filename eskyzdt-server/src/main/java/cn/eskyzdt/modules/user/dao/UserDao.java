package cn.eskyzdt.modules.user.dao;


import cn.eskyzdt.modules.pic.entity.Pic;
import cn.eskyzdt.modules.user.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

   User findById(@Param("id") Integer id);

   Pic findById2(@Param("id") Integer id);
}
