package swingpractice;

import javax.swing.*;
import java.awt.*;

/**
 @author EddieZhang
 @create 2022-09-14 11:13
 */
public class DrawTank extends JFrame {//继承JFrame类 窗口
    private MyPanel1 myPanel1;//在窗体中定义画板属性
    //在构造器中new画板
    public DrawTank(){
        myPanel1 = new MyPanel1();
        //将画板放入窗口
        this.add(myPanel1);
        //窗口设计
        this.setSize(400,300);//窗体大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设计点击按钮及表示exit程序
        this.setVisible(true);//设置窗口可视化
    }

    public static void main(String[] args) {
        DrawTank drawTank = new DrawTank();
    }

}
class MyPanel1 extends JPanel {//创建一个Panel类 继承于JPanel 画板
    //重写paint方法

    @Override
    public void paint(Graphics g) {//其中的g即理解为画笔
        super.paint(g);
        g.drawRect(100,10,100,200);
        //在线框中勾勒tank的每个结构件 并按照准确的坐标位置组合在一起
        g.setColor(Color.darkGray);
        g.fillRect(100,10,25,200);//轮子件
        g.fillRect(175,10,25,200);//轮子件
        g.fillRect(125,30,50,150);//tank中间部分舱体件
        g.fillRect(145,10,10,25);//tank炮管件
        g.setColor(Color.GRAY);
        g.fillOval(125,85,50,50);//tank顶部圆形件

    }
}
