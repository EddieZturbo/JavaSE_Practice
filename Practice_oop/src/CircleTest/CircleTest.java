package CircleTest;

/**
 * @author shkstart
 * @create 2022-07-29 16:58
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle1 c1 = new Circle1();
        Circle1 c2 = new Circle1();
        Circle1 c3 = new Circle1(9.9);
        Circle1 c4 = new Circle1(15.5);
        c1.setRadius(8.8);
        c2.setRadius(9.8);
        System.out.println("现在有" + Circle1.getTotal() + "个圆" + "\t圆：" + c1.getId() + "的半径为：" + c1.getRadius() + ",\t面积为："+ c1.findArea());
        System.out.println("现在有" + Circle1.getTotal() + "个圆" + "\t圆：" + c2.getId() + "的半径为：" + c2.getRadius() + ",\t面积为："+ c2.findArea());
        System.out.println("现在有" + Circle1.getTotal() + "个圆" + "\t圆：" + c3.getId() + "的半径为：" + c3.getRadius() + ",\t面积为："+ c3.findArea());
        System.out.println("现在有" + Circle1.getTotal() + "个圆" + "\t圆：" + c4.getId() + "的半径为：" + c4.getRadius() + ",\t面积为："+ c4.findArea());
        System.out.println(System.getProperty("file.encoding"));
    }

}
//创建类 设计类的成员
class Circle1{
    //设计类的属性
    private int id;//每个圆自己的编号
    private double radius;//圆的半径

    private static int total;//圆的个数
    private static int init = 1001;//每个圆的号码 从1001开始++
    //设计类的constructor方法
    public Circle1(){
        id = init++;
        total++;
    }
    public Circle1(double radius){
        this();//一定要写首行
//        id = init++;
//        total++;
        this.radius = radius;
    }


    //设计类的方法
    public double findArea(){
        return Math.PI * radius * radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }
}