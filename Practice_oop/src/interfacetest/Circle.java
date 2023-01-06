package interfacetest;

/**
 * @author shkstart
 * @create 2022-08-01 9:30
 */
public class Circle {
    //设计类的属性
    private double redius;
    //设计类的constructor方法

    public Circle() {
    }

    public Circle(double redius) {
        this.redius = redius;
    }
    //设计类的方法

    public double getRedius() {
        return redius;
    }

    public void setRedius(double redius) {
        this.redius = redius;
    }
}
