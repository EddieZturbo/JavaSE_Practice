package abstractclasstest;

/**
 * @author shkstart
 * @create 2022-07-31 12:15
 */
public class AbstractClassTest1 {
    public static void main(String[] args) {
        Employee e1 = new Manager("张锦豪",20001207,50000,25000);
        //父类的引用 指向子类的对象 多态性
        e1.work();
        Employee e2 = new CommonEmployee("张锦豪",20001207,15000);
        //父类的引用 指向子类的对象 多态性
        e2.work();
    }
}



//创建abstract类
abstract class Employee{
    //设计类的属性
    private String name;
    private int id;
    private double salary;

    //设计类的constructor方法
    public Employee() {
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    //设计类的方法
    public abstract void work();


}

//创建abstract类的子类
class Manager extends Employee{
    //设计类的属性
    private double bonus;

    //设计类的constructor方法

    public Manager() {
    }

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }
    //设计类的方法

    @Override
    public void work() {
        System.out.println("提高公司的运行效率");
    }
}
//创建abstract子类
class CommonEmployee extends Employee{
    //设计类的属性


    //设计类的constructor方法

    public CommonEmployee() {
    }

    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }
    //设计类的方法


    @Override
    public void work() {
        System.out.println("撸起袖子加油干");
    }
}
