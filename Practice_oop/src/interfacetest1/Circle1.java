package interfacetest1;

/**
 * @author shkstart
 * @create 2022-08-01 9:30
 */
public class Circle1 {
    //设计类的属性
    private Double redius;
    //设计类的constructor方法

    public Circle1() {
    }

    public Circle1(double redius) {
        this.redius = redius;
    }
    //设计类的方法

    public Double getRedius() {
        return redius;
    }

    public void setRedius(Double redius) {
        this.redius = redius;
    }
}
