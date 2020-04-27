package cn.eskyzdt.modules.designmodule.componentpattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Composite extends Component {

    public Composite(String name) {
        super(name);
    }

    private List<Component> list = new LinkedList<>();

    public boolean add(Component component) {
        try {
            this.list.add(component);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean remove(Component component) {
        try {
            this.list.remove(component);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("-");
        }
        System.out.println(name);
        for (Component component : list) {
            component.display(depth + 1);
        }
    }
}
