package swingpractice1_4.swingpractice1;

/**
 @author EddieZhang
 @create 2022-09-15 10:16
 */
public class Boom {
    int x,y;//Boom的坐标
    int life = 9;//Boom的生命值
    boolean isLive = true;//存活状态

    public Boom(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //减少生命值的方法
    public void lifeDown(){
        if (life > 0){
            life--;
        }else {
            isLive = false;
        }
    }
}
