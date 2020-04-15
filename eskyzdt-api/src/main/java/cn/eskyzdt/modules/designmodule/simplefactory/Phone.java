package cn.eskyzdt.modules.designmodule.simplefactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone implements Product{

    private String CPU;

    private String memory;

    @Override
    public Phone make() {
        return new Phone("arm", "512MB");
    }
}
