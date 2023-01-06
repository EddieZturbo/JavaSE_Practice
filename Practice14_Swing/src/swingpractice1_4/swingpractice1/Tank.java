package swingpractice1_4.swingpractice1;

/**定义一个tank类
 @author EddieZhang
 @create 2022-09-14 11:54
 */
public class Tank {
    private int x;//坦克的x坐标
    private int y;//坦克的y坐标

    private int direction = 0;//tank方向 初始向上
    private int speed = 8;//tank移动的速度

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tank() {
    }
    //移动的方法
    public void movingUp(){
        y-=speed;
    }
    public void movingDown(){
        y+=speed;
    }
    public void movingRight(){
        x+=speed;
    }
    public void movingLift(){
        x-=speed;
    }
}
