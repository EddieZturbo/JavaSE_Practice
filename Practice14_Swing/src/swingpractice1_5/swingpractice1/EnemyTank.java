package swingpractice1_5.swingpractice1;

import java.util.Vector;

/**
 @author EddieZhang
 @create 2022-09-14 16:52
 */
public class EnemyTank extends Tank implements Runnable {
    //创建vector集合 存放每个tank的Bullet
    Vector<Bullet> bulletVector = new Vector<>();

    //生命状态

    public Vector<Bullet> getBulletVector() {
        return bulletVector;
    }

    public void setBulletVector(Vector<Bullet> bulletVector) {
        this.bulletVector = bulletVector;
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }


    @Override
    public void run() {
        while (true) {
            if(this.isLife && bulletVector.size() < 3){//如果enemyTank存活在 而且没有子弹了 就给它创建一颗子弹add入弹夹中
                Bullet bullet = null;
                //根据enemyTank的方向
                switch (getDirection()){
                    case 0:
                        bullet = new Bullet(getX() + 10, getY(),0);
                        break;
                    case 1:
                        bullet = new Bullet(getX() + 60, getY() + 20,1);
                        break;
                    case 2:
                        bullet = new Bullet(getX() + 20, getY() + 60,2);
                        break;
                    case 3:
                        bullet = new Bullet(getX(), getY() + 20,4);
                        break;
                }
                bulletVector.add(bullet);
                new Thread(bullet).start();
            }




            //根据tank方法来继续移动
            switch (getDirection()) {
                case 0:
                    for (int i = 0; i < 10; i++) {
                        if (getY() > 0) {
                            movingUp();//保持一个方向移动多一点
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 10; i++) {
                        if ((getX() + 80) < 1000) {
                            movingRight();//保持一个方向移动多一点
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 10; i++) {
                        if ((getY() + 100) < 750)
                            movingDown();//保持一个方向移动多一点
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 10; i++) {
                        if (getX() > 0) {
                            movingLift();//保持一个方向移动多一点
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

            }
            //随机改变tank方向
            setDirection((int)(Math.random() * 4));//[0,3]的随机数
            //考虑线程结束条件
            if (!this.isLife) {
                break;
            }
        }
    }
}
