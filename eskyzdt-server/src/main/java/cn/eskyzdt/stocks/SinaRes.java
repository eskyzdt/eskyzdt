package cn.eskyzdt.stocks;

import lombok.Data;

import java.io.Serializable;

@Data
public class SinaRes implements Serializable {

    private static final long serialVersionUID = 5015569882835208286L;

    private String day;

    private String open;

    private String high;

    private String low;

    private String close;

    private String volume;

    private String ma_price5;

    private String maVolume5;

    @Override
    public String toString() {
        return
                "endTime='" + day.replace(StocksController.now, "") + '\'' +
                        ", open='" + open + '\'' +
                        ", low='" + low + '\'' +
                        ", high='" + high + '\'' +
                        ", close='" + close;
    }

}
