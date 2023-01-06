package developmentteamproject3practice3.domain;

/**
 * @author EddieZhang
 * @create 2022-08-11 11:27
 */
public class Employee3 {
    private int id3;//表示员工在公司的id
    private String name3;//表示员工的姓名
    private int age3;//表示年龄
    private double salary3;//工资

    public Employee3() {
    }

    public Employee3(int id3, String name3, int age3, double salary3) {
        this.id3 = id3;
        this.name3 = name3;
        this.age3 = age3;
        this.salary3 = salary3;
    }

    public int getId3() {
        return id3;
    }

    public void setId3(int id3) {
        this.id3 = id3;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public int getAge3() {
        return age3;
    }

    public void setAge3(int age3) {
        this.age3 = age3;
    }

    public double getSalary3() {
        return salary3;
    }

    public void setSalary3(double salary3) {
        this.salary3 = salary3;
    }
    public String detail3(){
        return id3 + "\t" + name3 + "\t" + age3 + "\t" + salary3;
    }

    @Override
    public String toString() {
        return detail3();
    }
}
