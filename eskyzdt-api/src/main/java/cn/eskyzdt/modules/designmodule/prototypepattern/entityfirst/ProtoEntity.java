package cn.eskyzdt.modules.designmodule.prototypepattern.entityfirst;

public class ProtoEntity implements ProtoInterface {
    String property;

    @Override
    public String toString() {
        return "ProtoEntity{" +
                "property='" + property + '\'' +
                '}';
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public ProtoEntity() {
    }

    public ProtoEntity(String property) {
        this.property = property;
    }

    @Override
    public ProtoEntity clone() {
        try {
            ProtoEntity clone = (ProtoEntity) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }


}
