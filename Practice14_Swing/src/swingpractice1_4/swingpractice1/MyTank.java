package swingpractice1_4.swingpractice1;

/**
 @author EddieZhang
 @create 2022-09-14 11:57
 */
public class MyTank extends Tank {
    //创建一个Bullet对象 表示一个Bullet（线程）
    Bullet bullet = null;

    public MyTank() {

    }


    public MyTank(int x, int y) {
        super(x, y);
        super.setDirection(2);
    }

    //定义一个shootBullet方法 根据tank的坐标 以及tank的方向 创建Bullet（线程）
    public void shootBullet(){
        switch (getDirection()){
            case 0://tank方向向上
                bullet = new Bullet(getX() + 20,getY(),0);
                break;
            case 1://tank方向向右
                bullet = new Bullet(getX() + 60,getY() + 20,1);
                break;
            case 2://tank方向向下
                bullet = new Bullet(getX() + 20,getY() + 60,2);
                break;
            case 3://tank方向向左
                bullet = new Bullet(getX(),getY() + 20,3);
                break;
        }
        //启动Bullet线程
        new Thread(bullet).start();

    }
}
