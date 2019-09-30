package com.eskyzdt.modules.user.dao;


import com.eskyzdt.modules.pic.entity.Pic;
import com.eskyzdt.modules.user.entity.User;
import com.sun.corba.se.impl.interceptors.PICurrent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

   User findById(@Param("id") Integer id);

   Pic findById2(@Param("id") Integer id);
}
