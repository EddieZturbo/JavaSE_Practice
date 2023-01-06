package swingpractice1;

/**定义一个tank类
 @author EddieZhang
 @create 2022-09-14 11:54
 */
public class Tank {
    private int x;//坦克的x坐标
    private int y;//坦克的y坐标

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
}
