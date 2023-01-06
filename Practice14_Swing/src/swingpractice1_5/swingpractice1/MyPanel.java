package swingpractice1_5.swingpractice1;

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

    //定义Boom的Vector集合 用于存放Boom  当子弹击中tank时候  就加入一个boom对象到panel中
    Vector<Boom> booms = new Vector<>();
    //定义Boom的image
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


    Vector<EnemyTank> enemyTanks = new Vector<>();//enemyTank军团
    int enemyTanksSize = 3;//定义军团规模


    public MyPanel() {
        tank = new MyTank(10, 10);//初始化MyTank

        //for循环初始化enemyTanks
        for (int i = 0; i < enemyTanksSize; i++) {
            EnemyTank enemyTank = new EnemyTank((100 + (i * 80)), 100);

            new Thread(enemyTank).start();//启动enemyTank线程

            Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY(), enemyTank.getDirection());
            enemyTank.bulletVector.add(bullet);
            new Thread(bullet).start();//启动Bullet线程

            enemyTanks.add(enemyTank);
        }
        //初始化image对象
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_3.gif"));


    }

    @Override
    public void paint(Graphics g) {//重写paint方法 g理解为画笔
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//设计panel
        //先判断我们的Tank的isLife
        if (tank != null && tank.isLife) {
            //绘制MyTank
            drawTank(tank.getX(), tank.getY(), g, tank.getDirection(), 0);
            //画出Bullet 根据bullet的情况绘制
//        if (tank.bullet != null && tank.bullet.isLive == true) {
//            g.setColor(Color.RED);
//            g.fill3DRect(tank.bullet.x, tank.bullet.y, 5, 5, false);
//        }
            //将子弹夹中的所有元素遍历出来 绘制所有的子弹
            for (int i = 0; i < tank.bulletVector.size(); i++) {
                Bullet bullet = tank.bulletVector.get(i);
                if (bullet != null && bullet.isLive == true) {
                    g.setColor(Color.RED);
                    g.fill3DRect(bullet.x, bullet.y, 5, 5, false);
                } else {//该子弹已经无效 从集合中拿掉
                    tank.bulletVector.remove(bullet);
                }

            }

        }


        //绘制enemyTanks
        for (int i = 0; i < enemyTanks.size(); i++) {
            if (enemyTanks.get(i).isLife) {//先判断enemyTank是否存活
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

            } else {
                enemyTanks.remove(enemyTanks.get(i));
            }
        }

        for (int i = 0; i < booms.size(); i++) {
            Boom boom = booms.get(i);//取出boom
            //根据boom的life值绘制boom
            if (boom.life > 6) {
                g.drawImage(image1, boom.x, boom.y, 60, 60, this);
            } else if (boom.life > 3) {
                g.drawImage(image2, boom.x, boom.y, 60, 60, this);
            } else {
                g.drawImage(image3, boom.x, boom.y, 60, 60, this);
            }
            //减少boom的life
            boom.life--;//为了boom的显示效果
            //判断boom的life是否为0 从集合中remove
            if (boom.life == 0) {
                booms.remove(boom);
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

    //编写被击中的方法
    public void hetMyTank() {
        //遍历所有的enemyTank
        for (int i = 0; i < enemyTanksSize; i++) {
            EnemyTank enemyTank = enemyTanks.get(i);//取出enemyTank
            //遍历enemyTank所有子弹
            for (int j = 0; j < enemyTank.bulletVector.size(); j++) {
                Bullet bullet = enemyTank.bulletVector.get(j);//取出enemyTank的子弹
                //让子弹和myTank进行判断 是否被子弹击中
                if (tank.isLife && bullet.isLive) {
                    hitTank(bullet, tank);
                }

            }
        }
    }


    //编写 击中EnemyTank的方法
    public void hitTank(Bullet bullet, Tank tank1) {
        //判断Bullet 是否在tank的体内
        switch (tank1.getDirection()) {//根据tank的方向判断
            case 0://敌方tank 方向向上
            case 2://敌方tank 方向向下
                if (bullet.x > tank1.getX() && bullet.x < tank1.getX() + 40 && bullet.y > tank1.getY() && bullet.y < tank1.getY() + 60) {
                    bullet.isLive = false;//将子弹的状态置成false
                    tank1.isLife = false;//将被击中的tank的状态置成false
                    //创建一个boom对象
                    Boom boom = new Boom(tank1.getX(), tank1.getY());
                    booms.add(boom);
                }
                break;
            case 1://敌方tank 方向向右
            case 3://敌方tank 方向向左
                if (bullet.x > tank1.getX() && bullet.x < tank1.getX() + 60 && bullet.y > tank1.getY() && bullet.y < tank1.getY() + 40) {
                    bullet.isLive = false;//将子弹的状态置成false
                    tank1.isLife = false;//将被击中的tank的状态置成false
                    //创建一个boom对象
                    Boom boom = new Boom(tank1.getX(), tank1.getY());
                    booms.add(boom);
                }
                break;

        }


    }

    //判断所有子弹是否击中enemyTank的方法
    public void BulletHitEnemyTank() {
        //判断所有的子弹是否击中了tank
        for (int j = 0; j < tank.bulletVector.size(); j++) {
            Bullet bullet = tank.bulletVector.get(j);
            if (bullet != null && bullet.isLive) {//如果我的Bullet还存活着
                //遍历所有的enemyTanks 查看是否被击中
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(bullet, enemyTank);
                }
            }
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
                if ((tank.getY() + 100) < 750) {
                    tank.movingDown();
                }
                this.repaint();
                break;
            case KeyEvent.VK_W:
                tank.setDirection(0);
                if (tank.getY() > 0) {
                    tank.movingUp();
                }
                this.repaint();
                break;
            case KeyEvent.VK_A:
                tank.setDirection(3);
                if (tank.getX() > 0) {
                    tank.movingLift();
                }
                this.repaint();
                break;
            case KeyEvent.VK_D:
                tank.setDirection(1);
                if ((tank.getX() + 80) < 1000) {
                    tank.movingRight();
                }
                this.repaint();
                break;


//            case KeyEvent.VK_DOWN:
//                enemyTanks.get(0).setDirection(2);
//                enemyTanks.get(0).movingDown();
//                this.repaint();
//                break;
//            case KeyEvent.VK_UP:
//                enemyTanks.get(0).setDirection(0);
//                enemyTanks.get(0).movingUp();
//                this.repaint();
//                break;
//            case KeyEvent.VK_LEFT:
//                enemyTanks.get(0).setDirection(3);
//                enemyTanks.get(0).movingLift();
//                this.repaint();
//                break;
//            case KeyEvent.VK_RIGHT:
//                enemyTanks.get(0).setDirection(1);
//                enemyTanks.get(0).movingRight();
//                this.repaint();
//                break;
        }
        //如果按键按下j件 就启动Bullet线程
        if (e.getKeyCode() == KeyEvent.VK_J && tank.isLife) {
//            if (tank.bulletVector.isEmpty() || !tank.bullet.isLive) {//如果我们的bullet为null就去创建一个bullet 或者 bullet的life为false
//            tank.shootBullet();
//            }
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
            BulletHitEnemyTank();//判断所有子弹是否之中enemyTank的方法
            hetMyTank();//判断是否我们的Tank被击中
            this.repaint();

        }

    }
}



