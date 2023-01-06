package developmentteamproject3practice1.domain1;

/**
 * @author shkstart
 * @create 2022-08-06 10:37
 */
public class Employee1 {
    private int id1;//表示员工的id
    private String name1;//表示员工姓名
    private int age1;//表示年龄
    private double salary1;//薪资

    public Employee1() {
    }

    public Employee1(int id1, String name1, int age1, double salary1) {
        this.id1 = id1;
        this.name1 = name1;
        this.age1 = age1;
        this.salary1 = salary1;
    }

    public int getId() {
        return id1;
    }

    public void setId(int id) {
        this.id1 = id;
    }

    public String getName() {
        return name1;
    }

    public void setName(String name) {
        this.name1 = name;
    }

    public int getAge() {
        return age1;
    }

    public void setAge(int age) {
        this.age1 = age;
    }

    public double getSalary() {
        return salary1;
    }

    public void setSalary(double salary) {
        this.salary1 = salary;
    }

    public String getDetail1(){
        return id1 + "\t" + name1 + "\t" + age1 + "\t" + salary1;
    }

    @Override
    public String toString() {
        return getDetail1();
    }
}
