package swingpractice1_3.swingpractice1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 @author EddieZhang
 @create 2022-09-14 11:58
 */
//为了让子弹不停的移动 重绘 需要将MyPanel实现Runnable接口
public class MyPanel extends JPanel implements KeyListener, Runnable {//绘制panel
    MyTank tank = null;//定义tank属性


    Vector<EnemyTank> enemyTanks = new Vector<>();//enemyTank军团
    int enemyTanksSize = 3;//定义军团规模


    public MyPanel() {
        tank = new MyTank(10, 10);//初始化MyTank
        //for循环初始化enemyTanks
        for (int i = 0; i < enemyTanksSize; i++) {
            EnemyTank enemyTank = new EnemyTank((100 + (i * 80)), 100);

            Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY(), enemyTank.getDirection());
            enemyTank.bulletVector.add(bullet);
            new Thread(bullet).start();


            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {//重写paint方法 g理解为画笔
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//设计panel
        //绘制MyTank
        drawTank(tank.getX(), tank.getY(), g, tank.getDirection(), 0);

        //画出Bullet 根据bullet的情况绘制
        if (tank.bullet != null && tank.bullet.isLive == true) {
            g.setColor(Color.RED);
            g.fill3DRect(tank.bullet.x, tank.bullet.y, 5, 5, false);
        }


        //绘制enemyTanks
        for (int i = 0; i < enemyTanks.size(); i++) {
            if (enemyTanks.get(i).isLive) {//先判断enemyTank是否存活
                drawTank(enemyTanks.get(i).getX(), enemyTanks.get(i).getY(), g, enemyTanks.get(i).getDirection(), 1);
                //绘制enemyTanks的Bullets
                for (int j = 0; j < enemyTanks.get(i).bulletVector.size(); j++) {
                    Bullet bullet = enemyTanks.get(i).bulletVector.get(j);
                    if (bullet.isLive == true) {
                        g.setColor(Color.yellow);
                        g.fill3DRect(bullet.x, bullet.y, 5, 5, false);
                    } else {
                        enemyTanks.get(i).bulletVector.remove(j);
                    }

                }

            }else {
                enemyTanks.remove(enemyTanks.get(i));
            }
        }


    }

    /*
     * @Description 绘制tank的方法
     * @Author EddieZhang
     * @Date 2022/9/14 12:11
     * @Param [x, y, g, direct, type]（x,y）tank的坐标 g 画笔 direction 方向 type tank类型
     * @Return void
     * @Since version-1.0
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        //根据tank的阵营绘制不同的颜色
        switch (type) {
            case 0://我们的tank
                g.setColor(Color.cyan);
                break;
            case 1://对方的呃tank
                g.setColor(Color.yellow);
                break;
        }
        //根据不同的方向绘制不同的tank（0向上，1向右，2向下，3向左）
        switch (direction) {
            case 0://向上的方向
                g.fill3DRect(x, y, 10, 60, false);//左轮
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//盖子
                g.fillOval(x + 10, y + 20, 20, 20);//圆盖子
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1://向右方向
                g.fill3DRect(x, y, 60, 10, false);//左轮
                g.fill3DRect(x, y + 30, 60, 10, false);//右轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//盖子
                g.fillOval(x + 20, y + 10, 20, 20);//圆盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
            default:
                System.out.println("未处理");
        }

    }

    //编写 击中tank的方法
    public static void hitTank(Bullet bullet, EnemyTank enemyTank) {
        //判断Bullet 是否在tank的体内
        switch (enemyTank.getDirection()) {//根据tank的方向判断
            case 0://敌方tank 方向向上
            case 2://敌方tank 方向向下
                if (bullet.x > enemyTank.getX() && bullet.x < enemyTank.getX() + 40 && bullet.y > enemyTank.getY() && bullet.y < enemyTank.getY() + 60) {
                    bullet.isLive = false;//将子弹的状态置成false
                    enemyTank.isLive = false;//将被击中的tank的状态置成false
                }
                break;
            case 1://敌方tank 方向向右
            case 3://敌方tank 方向向左
                if (bullet.x > enemyTank.getX() && bullet.x < enemyTank.getX() + 60 && bullet.y > enemyTank.getY() && bullet.y < enemyTank.getY() + 40) {
                    bullet.isLive = false;//将子弹的状态置成false
                    enemyTank.isLive = false;//将被击中的tank的状态置成false
                }
                break;

        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_S:
                tank.setDirection(2);
                tank.movingDown();
                this.repaint();
                break;
            case KeyEvent.VK_W:
                tank.setDirection(0);
                tank.movingUp();
                this.repaint();
                break;
            case KeyEvent.VK_A:
                tank.setDirection(3);
                tank.movingLift();
                this.repaint();
                break;
            case KeyEvent.VK_D:
                tank.setDirection(1);
                tank.movingRight();
                this.repaint();
                break;


            case KeyEvent.VK_DOWN:
                enemyTanks.get(0).setDirection(2);
                enemyTanks.get(0).movingDown();
                this.repaint();
                break;
            case KeyEvent.VK_UP:
                enemyTanks.get(0).setDirection(0);
                enemyTanks.get(0).movingUp();
                this.repaint();
                break;
            case KeyEvent.VK_LEFT:
                enemyTanks.get(0).setDirection(3);
                enemyTanks.get(0).movingLift();
                this.repaint();
                break;
            case KeyEvent.VK_RIGHT:
                enemyTanks.get(0).setDirection(1);
                enemyTanks.get(0).movingRight();
                this.repaint();
                break;
        }
        //如果按键按下j件 就启动Bullet线程
        if (e.getKeyCode() == KeyEvent.VK_J) {
            tank.shootBullet();
            this.repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔100mm重绘
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断是否击中了tank
            if (tank.bullet != null && tank.bullet.isLive) {//如果我的Bullet还存活着
                //遍历所有的enemyTanks 查看是否被击中
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(tank.bullet, enemyTank);
                }
            }
            this.repaint();

        }

    }
}



