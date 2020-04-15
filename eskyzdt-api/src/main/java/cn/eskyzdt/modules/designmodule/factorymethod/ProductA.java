package cn.eskyzdt.modules.designmodule.factorymethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductA implements Product{

    private String name;

    private int count;

}
