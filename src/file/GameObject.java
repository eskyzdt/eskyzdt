package file;

import lombok.Data;

import java.awt.*;

/**
 * 游戏元素父类
 */
@Data
public abstract class GameObject {

    private int x;
    private int y;

    // 图片
    Image img;

    // 游戏界面
    GameFrame gameFrame;

    public GameObject() {
        // this.gameFrame = gameFrame;
        // 使用了空的构造函数;
        System.out.println("警告!!!!使用了空的构造函数");
    }

    public GameObject(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public GameObject(GameFrame gameFrame, int x, int y){
        this.gameFrame = gameFrame;
        this.x = x;
        this.y = y;
    }

    // 获取元素矩形
    public abstract Rectangle getRec();

    public abstract void paintSelf(Graphics g);

    public void setImg(String img) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
    }

}
