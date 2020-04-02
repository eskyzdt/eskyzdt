package cn.eskyzdt.modules.validate;

import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ValidateEntity {

    @NotNull
    private String Name;

    @Future
    private LocalDateTime tomorrow;

}
