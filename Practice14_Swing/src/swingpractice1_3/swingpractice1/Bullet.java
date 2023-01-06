package swingpractice1_3.swingpractice1;

/**
 @author EddieZhang
 @create 2022-09-14 23:04
 */

/**
 * 子弹线程
 */
public class Bullet implements Runnable{
    int x;//Bullet的x坐标
    int y;//Bullet的y坐标
    int direction;//Bullet的方法
    int speed = 4;//Bullet移动的speed

    boolean isLive = true;//子弹的存活状态

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Bullet() {
    }

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        while(true){//Bullet不停的移动 直至遇到边缘或者遇到tank
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direction){//根据方向判断Bullet移动的方法
                case 0://向上
                    y-=speed;
                    break;
                case 1://向// 右
                    x+=speed;
                    break;
                case 2://向下
                    y+=speed;
                    break;
                case 3://向左
                    x-=speed;
                    break;
            }
            if(!(x>= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)){//当Bullet不在面板内 即触及边界是 就让Bullet结束 同时当Bullet集中tank时也要结束
               isLive = false;
               break;
            }
            System.out.println("Bullet的坐标" + this.x + "\t" + this.y);
        }

    }
}
