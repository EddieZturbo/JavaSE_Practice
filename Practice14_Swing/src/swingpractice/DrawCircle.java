package swingpractice;

/**
 @author EddieZhang
 @create 2022-09-14 9:08
 */

import javax.swing.*;
import java.awt.*;

/**
 * 演示在面板上画出圆
 * 1.定义一个面板--定义一个MyPanel继承与JPanel类
 */
public class DrawCircle extends JFrame{//继承JFrame 窗口
    public static void main(String[] args) {
        DrawCircle drawCircle = new DrawCircle();
    }
    //定义一个面板
    private MyPanel myPanel = null;
    public DrawCircle(){//在构造器中初始化面板
        myPanel = new MyPanel();
        //把面板放入窗口
        this.add(myPanel);
        //设置窗体大小
        this.setSize(900,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//当点击窗口的close时 程序就退出
        this.setVisible(true);//设置是否可视化
    }
}
class MyPanel extends JPanel{//继承于JPanel类 面板

    @Override
    public void paint(Graphics g) {//绘图方法--Graphics g理解为画笔 MyPanel理解成画板
        super.paint(g);
//        g.drawOval(10,10,100,100);//调用方法 绘制一个圆
        //演示绘制不同的图形.. //画直线 drawLine(int x1,int y1,int x2,int y2)
//        g.drawLine(10,10,200,10);
        //画矩形边框 drawRect(int x, int y, int width, int height)
//        g.drawRect(10,10,100,100);
        //画椭圆边框 drawOval(int x, int y, int width, int height)
//        g.drawOval(10,10,150,180);
        //填充矩形 fillRect(int x, int y, int width, int height)
//        g.fillRect(100,100,100,100);
        //设置画笔的颜色
//        g.setColor(Color.PINK);
        //填充椭圆 fillOval(int x, int y, int width, int height)
//        g.fillOval(100,100,150,180);
        //画图片 drawImage(Image img, int x, int y, ..)
        //1. 获取图片资源, /bg.png 表示在该项目的根目录去获取 bg.png 图片资源
        // Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
        // g.drawImage(image, 10, 10, 175, 221, this);
//        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/1 wbNftKjM0CGqzH-7AnHrYQ.jpeg"));
//        g.drawImage(image,10,10,875,546,this);
        //画字符串 drawString(String str, int x, int y)//写字
        //给画笔设置颜色和字体
        //设置画笔的字体 setFont(Font font)
        //设置画笔的颜色 setColor(Color c)
//        Font font = new Font(Font.SANS_SERIF,Font.ITALIC,140);
//        g.setFont(font);
//        g.setColor(Color.cyan);
//        g.drawString("Hello World!",55,140);//此时设置的（x,y）坐标是字体的左下角
    }
}
