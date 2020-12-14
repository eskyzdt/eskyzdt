package cn.eskyzdt.modules.junjun;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {

    private String code;

    private String type;

    private List<Result> children;

    public List<Result> getChildren() {
        return children;
    }

    public void setChildren(List<Result> children) {
        this.children = children;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code + '\"' +
                ", \"type\":\"" + type + '\"' +
                ",\"children\":" + children +
                '}';
    }
}