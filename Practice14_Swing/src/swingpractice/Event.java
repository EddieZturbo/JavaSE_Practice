package swingpractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Java事件监听机制
 * ”委派事件模型“
 *
 */

/**
 @author EddieZhang
 @create 2022-09-14 13:05
 */
public class Event extends JFrame{//窗体
    //创建面板属性
    MyPanel2 myPanel2 = null;

    //创建构造器 初始化面板 窗体
    public Event(){
        myPanel2 = new MyPanel2();
        this.add(myPanel2);//将面板add于窗体中
        this.setSize(300,400);//设计窗体的size
        this.addKeyListener(myPanel2);//窗体可以监听在myPanel2中的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设计窗体为点击close即为exit程序
        this.setVisible(true);//设计窗体的可见性
    }
    public static void main(String[] args) {
        Event event = new Event();
    }
}
class MyPanel2 extends JPanel implements KeyListener {//面板--继承监听事件 实现事件

    //初始化小球的位置坐标变量
    private int x = 10;
    private int y = 10;
    @Override
    public void paint(Graphics g) {//重写绘制方法 g理解为画笔
        super.paint(g);
        g.fillOval(x,y,20,20);//绘制一个位置于(10,10)的直径为20的黑色填充小球
    }

    //监听有字符时 该方法被触发
    @Override
    public void keyTyped(KeyEvent e) {


    }

    //当监听到有按键 被按压时 该方法被触发
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_DOWN:
                y++;
                this.repaint();
                break;
            case KeyEvent.VK_UP:
                y--;
                this.repaint();
                break;
            case KeyEvent.VK_LEFT:
                x--;
                this.repaint();
                break;
            case KeyEvent.VK_RIGHT:
                x++;
                this.repaint();
                break;
        }

    }

    //当监听到有按键 被释放（松开） 该方法被触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
