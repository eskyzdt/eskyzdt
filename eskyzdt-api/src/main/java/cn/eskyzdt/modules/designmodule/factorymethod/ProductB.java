package cn.eskyzdt.modules.designmodule.factorymethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductB implements Product{

    private String name;

    private long length;

    private long width;


}
