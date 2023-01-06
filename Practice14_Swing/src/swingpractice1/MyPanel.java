package swingpractice1;

import javax.swing.*;
import java.awt.*;

/**
 @author EddieZhang
 @create 2022-09-14 11:58
 */
public class MyPanel extends JPanel {//绘制panel
    Tank tank = null;//定义tank属性

    public MyPanel() {
        tank = new Tank(100,100);//初始化MyTank
    }

    @Override
    public void paint(Graphics g) {//从写paint方法 g理解为画笔
        super.paint(g);
        g.fillRect(0,0,1000,750);//设计panel
        drawTank(tank.getX(), tank.getY(), g,0,0);
    }
    /*
     * @Description 绘制tank的方法
     * @Author EddieZhang
     * @Date 2022/9/14 12:11
     * @Param [x, y, g, direct, type]（x,y）tank的坐标 g 画笔 direction 方向 type tank类型
     * @Return void
     * @Since version-1.0
     */
    public void drawTank(int x,int y,Graphics g,int direction,int type){
        //根据tank的阵营绘制不同的颜色
        switch (type){
            case 0://我们的tank
                g.setColor(Color.cyan);
                break;
            case 1://对方的呃tank
                g.setColor(Color.yellow);
                break;
        }
        switch (direction){
            case 0://向上的方向
                g.fill3DRect(x,y,10,60,false);//左轮
                g.fill3DRect(x + 30,y,10,60,false);//右轮
                g.fill3DRect(x + 10,y + 10,20,40,false);//盖子
                g.fillOval(x + 10,y + 20,20,20);//圆盖子
                g.drawLine(x + 20,y + 30,x + 20,y);
                break;
            default:
                System.out.println("未处理");
        }

    }
}
