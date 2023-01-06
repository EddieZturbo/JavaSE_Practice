package swingpractice1_3.swingpractice1;

import java.util.Vector;

/**
 @author EddieZhang
 @create 2022-09-14 16:52
 */
public class EnemyTank extends Tank {
    //创建vector集合 存放每个tank的Bullet
    Vector<Bullet> bulletVector = new Vector<>();

    //生命状态
    boolean isLive = true;

    public Vector<Bullet> getBulletVector() {
        return bulletVector;
    }

    public void setBulletVector(Vector<Bullet> bulletVector) {
        this.bulletVector = bulletVector;
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }

}
