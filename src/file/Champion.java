package file;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 英雄
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Champion extends GameObject {

    // 玩家速度
    private int spd = 10;

    // 移动
    public boolean up,down,left,right;

    // 移动图集
    public static String[] imgs = new String[8];
    // 第几张图片
    int moveCount = 1;

    static {
        for (int i = 0; i < 8; i++) {
            imgs[i] = "src/file/mv/" + (i + 1)  + ".png";
        }
    }

    // 初始位置
    public Champion(GameFrame gameFrame) {
        super(gameFrame);
        setImg(Constants.HERO_PNG);
        setX(500);
        setY(500);
    }

    public Champion(GameFrame gameFrame, int x, int y) {
        super(gameFrame, x, y);
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(getX(), getY(), 0, 0);
    }


    // 画自己
    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(getImg(), getX(), getY(), null);

        //
        g.setColor(Color.GREEN);
        g.fillOval(getX()+20, getY() + 30, 10, 10);

        g.drawRect(getX(), getY(), 50, 110);

        move();
    }

    public void KeyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_D:
                right = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
        }

    }

    public void KeyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_D:
                right = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
        }
    }

    // 英雄移动
    public void move() {
        // 测试当前位置
      //  System.out.println("当前的x: " + getX() + "当前的Y" + getY());
        if (up) {
            setY(getY() - getSpd());
        }
        if (left) {
            setX(getX() - getSpd());
        }
        if (right) {
            setX(getX() + getSpd());
        }
        if (down) {
            setY(getY() + getSpd());
        }
        if (right||left||up||down) {
            setImg(imgs[++moveCount%8]);
        } else {
            setImg(Constants.HERO_PNG);
        }


    }

}
