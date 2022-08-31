package file.minion;

import file.GameFrame;
import file.GameObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Boss extends Minion{

    public Boss(GameFrame gameFrame) {
        super(gameFrame);
        setImg("src/file/minion/1.png");

    }

    @Override
    public void move() {
        if (getX() < 2000) {
            setX(getX() + getSpd());
            setY(getY() + getSpd());
        }
    }

    @Override
    public void createMinion(GameFrame gameFrame, List<GameObject> list) {
        if (isNextMinion()) {
            Boss boss = new Boss(gameFrame);
            LinkedList<GameObject> bossList = gameFrame.getBossList();
            bossList.add(boss);
            bossList.add(boss);
            bossList.add(boss);
            bossList.add(boss);
            gameFrame.setBossList(bossList);
            new NextMinion().run();

        }
    }
}
