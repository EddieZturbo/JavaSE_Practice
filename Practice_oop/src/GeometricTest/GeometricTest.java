package GeometricTest;

/**
 * @author shkstart
 * @create 2022-07-28 16:58
 */
public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest t1 = new GeometricTest();
        Circle c1 = new Circle(5,"透明",88.8);
        MyRectangle m1 = new MyRectangle(4,5,"透明",88.8);
        System.out.println("两个集合图形的面积是否一样：" + t1.equalsArea(c1,m1));
        System.out.println("--------------------------------------------");
        System.out.println("三角形的面积为：" + t1.displayGeometricObject(c1));
        System.out.println("--------------------------------------------");
        System.out.println("矩形的面积为：" + t1.displayGeometricObject(m1));



//        boolean b1 = t1.equalsArea(new Circle(5,"透明",88.8),new MyRectangle(4,5,"透明",88.8));
//        System.out.println(b1);
//        System.out.println("---------------------------------------------------------------------------------");
//
//        String s1 = t1.displayGeometricObject(new Circle(5,"透明",88.8));
//        System.out.println(s1);
//        String s2 = t1.displayGeometricObject(new MyRectangle(4,5,"透明",88.8));
//        System.out.println(s2);


    }
    public GeometricTest(){

    }
    public boolean equalsArea(GemetricObject o1,GemetricObject o2){
        return o1.findArea() == o2.findArea();

        }
    public String displayGeometricObject(GemetricObject o3){
    return "面积为：" + o3.findArea() + "平方厘米";
    }





    }















//创建类 设计类的成员
class GemetricObject{
    //设计类的属性
    protected String color;
    protected double weight;

    //设计类的constructor方法
    public GemetricObject(){

    }
    protected GemetricObject(String color,double weight){
    this.color = color;
    this.weight = weight;
    }

    //设计类的方法

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double findArea(){
        return 0.0;
    }
}
//创建类 设计类的成员
class Circle extends GemetricObject{
    //创建类的属性
    private double radius;

    //设计类的constructor方法
    public Circle(double radius,String color,double weight){
        super();
        this.radius = radius;
        super.color = color;
        super.weight = weight;
    }

    //设计类的方法

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double findArea(){
        return this.radius * this.radius * Math.PI;
    }
}
//创建类 设计类的成员
class MyRectangle extends GemetricObject{
    //创建类的属性
    private double width;
    private double height;

    //设计类的constructor方法
    public MyRectangle(double width,double height,String color,double weight){
        super();
        this.width = width;
        this.height = height;
        super.color = color;
        super.weight = weight;
    }

    //设计类的方法

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double findArea(){
        return this.width * this.height;
    }
}



