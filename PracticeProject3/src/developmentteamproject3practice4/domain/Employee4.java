package developmentteamproject3practice4.domain;

/**
 @author EddieZhang
 @create 2022-08-25 9:02
 */
public class Employee4 {
    private int id4;
    private String name4;
    private int age4;
    private double salary4;

    @Override
    public String toString() {
        return detail4();
    }
    public String detail4(){
        return id4 + "\t" + name4 + "\t" + age4 + "\t" + salary4;
    }

    public int getId4() {
        return id4;
    }

    public void setId4(int id4) {
        this.id4 = id4;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public int getAge4() {
        return age4;
    }

    public void setAge4(int age4) {
        this.age4 = age4;
    }

    public double getSalary4() {
        return salary4;
    }

    public void setSalary4(double salary4) {
        this.salary4 = salary4;
    }

    public Employee4(int id4, String name4, int age4, double salary4) {
        this.id4 = id4;
        this.name4 = name4;
        this.age4 = age4;
        this.salary4 = salary4;
    }

    public Employee4() {
    }
}
