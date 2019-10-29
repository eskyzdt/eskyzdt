package cn.eskyzdt.modules.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDto implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date createTime;
}
