package file.minion;

import file.GameFrame;
import file.GameObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public abstract class Minion extends GameObject {

    // 小兵速度
    private int spd = 10;

    private boolean nextMinion = true;

    private boolean nextLine = true;

    public Minion() {
    }

    public Minion(GameFrame gameFrame) {
        super(gameFrame);
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(getX() - 16, getY() - 16, 45, 45);
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(getImg(), getX() - 16, getY() - 16, null);
        g.setColor(Color.RED);
        g.fillOval(getX(), getY(), 10, 10);
        // 画框框
        g.drawRect(getX() - 16, getY() - 16, 45, 45);

        // 小兵移动
        move();
    }

    public abstract void move();

    class NextMinion implements Runnable {
        @Override
        public void run() {
            nextMinion = false;
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            nextMinion = true;
            System.out.println("线程运行了1次");
        }
    }

    public abstract void createMinion(GameFrame gameFrame, List<GameObject> list);

}
