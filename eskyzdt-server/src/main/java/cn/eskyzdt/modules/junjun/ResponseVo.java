package cn.eskyzdt.modules.junjun;

public class ResponseVo {

    private String code;
    private String bigType;
    private String midType;
    private String smallType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBigType() {
        return bigType;
    }

    public void setBigType(String bigType) {
        this.bigType = bigType;
    }

    public String getMidType() {
        return midType;
    }

    public void setMidType(String midType) {
        this.midType = midType;
    }

    public String getSmallType() {
        return smallType;
    }

    public void setSmallType(String smallType) {
        this.smallType = smallType;
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "code='" + code + '\'' +
                ", bigType='" + bigType + '\'' +
                ", midType='" + midType + '\'' +
                ", smallType='" + smallType + '\'' +
                '}';
    }
}
