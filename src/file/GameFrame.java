package file;

import file.minion.Boss;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class GameFrame extends JFrame {

    // 窗口
    private final static int Wid = 800;
    private final static int Hei = 600;

    private LinkedList<GameObject> objList = new LinkedList<>();
    private LinkedList<GameObject> bossList = new LinkedList<>();

    public LinkedList<GameObject> getBossList() {
        return bossList;
    }

    public void setBossList(LinkedList<GameObject> bossList) {
        this.bossList = bossList;
    }

    // 玩家
    Champion player = new Champion(this);

    // boss
    Boss boss = new Boss(this);

    // 背景
    Background background = new Background(this);

    // 双缓冲
    private Image offScreenImage = null;


    public void launch() {
        setSize(Wid , Hei);
        setLocationRelativeTo(null);

        // 关闭
        setDefaultCloseOperation(3);
        // 调整大小
        setResizable(true);
        // 可见
        setVisible(true);

        setTitle("西游");

        this.addKeyListener(new GameFrame.KeyMonitor());

        // 添加游戏元素
        objList.add(background);
        objList.add(player);

        boss.createMinion(this, bossList);

        while (true) {
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                //
                System.out.println("重绘出错");
            }
        }
    }

    // 绘制方法 , 绘制背景和英雄等
    public void paint(Graphics g) {

        // 创建一个空白的图片
        if (offScreenImage == null) {
            offScreenImage = this.createImage(Wid, Hei);
        }
        // 把元素都绘制到这个空白图片上
        Graphics gImage = offScreenImage.getGraphics();

        for (int i = 0; i < objList.size(); i++) {
            // 这里打印下面两个元素
            //        background.paintSelf(gImage);
            //        player.paintSelf(gImage);
            objList.get(i).paintSelf(gImage);
        }

        boss.paintSelf(gImage);

        // x,y 代表图片左上角相对于窗口左上角的位置
        // 说明player.getX() - Wid / 2 是图片需要调整的距离(即英雄所在位置减去 窗口中心点坐标)
        g.drawImage(offScreenImage,  - player.getX() + Wid / 2, - player.getY() + Hei / 2, null);
    }





    // 键盘事件
    class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            player.KeyPressed(e);


            // 测试
//            int key = e.getKeyCode();
//            System.out.println(key);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.KeyReleased(e);

        }
    }













    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.launch();



    }





}
