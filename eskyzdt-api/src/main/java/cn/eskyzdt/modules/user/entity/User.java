package cn.eskyzdt.modules.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 8545996863226528791L;
    private int id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String dupq;
    @JsonFormat(pattern = "yyyy-MM")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyyMM")
    private LocalDateTime createTime;
}
