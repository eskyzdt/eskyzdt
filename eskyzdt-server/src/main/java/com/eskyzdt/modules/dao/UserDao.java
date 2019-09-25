package com.eskyzdt.modules.dao;


import com.eskyzdt.modules.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

   User findById(@Param("id") Integer id);
}
