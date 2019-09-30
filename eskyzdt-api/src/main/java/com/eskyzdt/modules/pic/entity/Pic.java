package com.eskyzdt.modules.pic.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Pic {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date createTime;
}
