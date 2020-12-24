package cn.eskyzdt.modules.time;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MyTimeVo implements Serializable {

    private LocalDateTime createTime;


}
