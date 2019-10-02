package cn.eskyzdt.modules.user.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date createTime;
}
