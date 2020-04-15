package cn.eskyzdt.modules.designmodule.simplefactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer implements Product {

    private String CPU;

    private String memory;

    private String display;

    @Override
    public Product make() {
        return new Computer("i7", "16G", "17cun");
    }
}
