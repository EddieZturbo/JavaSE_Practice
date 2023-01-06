package swingpractice1_5.swingpractice1;

import javax.swing.*;

/**
 @author EddieZhang
 @create 2022-09-14 12:01
 */
public class MyFrame extends JFrame {//定义窗口

    private MyPanel myPanel = null;//定义MyPanel属性
    //构造器中初始化panel
    public MyFrame(){
        myPanel = new MyPanel();
        new Thread(myPanel).start();//启动重新绘制MyPanel的线程

        this.add(myPanel);//将panel添加至本窗口中
        this.setSize(1000,750);//窗体size
        this.addKeyListener(myPanel);//向窗体添加myPanel的监听
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置点击close即为exit程序
        this.setVisible(true);//设置窗口可见
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
