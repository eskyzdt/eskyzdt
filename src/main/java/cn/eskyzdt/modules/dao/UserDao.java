package cn.eskyzdt.modules.dao;


import cn.eskyzdt.modules.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface UserDao {

   User findById(@Param("id") Integer id);
}
