package file;

import java.awt.*;

/**
 * 游戏背景
 */
public class Background extends GameObject{

    // 构造函数
    public Background(GameFrame gameFrame) {
        super(gameFrame);
    }

    public Background(GameFrame gameFrame, int x, int y) {
        super(gameFrame, x, y);
    }

    @Override
    public Rectangle getRec() {
        return null;
    }

    Image bg = Toolkit.getDefaultToolkit().getImage("src/file/1.png");

    public void paintSelf(Graphics graphics) {
        graphics.drawImage(bg,0, 0, null);
    }

}
