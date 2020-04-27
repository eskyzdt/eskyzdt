package cn.eskyzdt.modules.designmodule.componentpattern;

public class ComponentTest {

    public static void main(String[] args) {
        Composite root = new Composite("主干");
        root.add(new Leaf("主干叶子一"));
        root.add(new Leaf("主干叶子二"));

        Composite branch01 = new Composite("分支一");
        branch01.add(new Leaf("分支一叶子一"));
        branch01.add(new Leaf("分支一叶子二"));

        Composite branch02 = new Composite("分支二");
        branch02.add(new Leaf("分支二叶子一"));
        branch02.add(new Leaf("分支二叶子二"));

        root.add(branch01);
        branch01.add(branch02);

        root.display(1);

    }
}
