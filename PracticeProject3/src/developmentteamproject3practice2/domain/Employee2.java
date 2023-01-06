package developmentteamproject3practice2.domain;

/**
 * @author shkstart
 * @create 2022-08-08 10:46
 */
public class Employee2 {
    private int id2;
    private String name2;
    private int age2;
    private double salary2;

    public Employee2() {
    }

    public Employee2(int id2, String name2, int age2, double salary2) {
        this.id2 = id2;
        this.name2 = name2;
        this.age2 = age2;
        this.salary2 = salary2;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getAge2() {
        return age2;
    }

    public void setAge2(int age2) {
        this.age2 = age2;
    }

    public double getSalary2() {
        return salary2;
    }

    public void setSalary2(double salary2) {
        this.salary2 = salary2;
    }

    public String detail2(){
        return id2 + "\t" + name2 + "\t" + age2 + "\t" + salary2;
    }

    @Override
    public String toString() {
        return detail2();
    }
}
