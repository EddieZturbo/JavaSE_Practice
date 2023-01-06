package practice2;

/**
 @author EddieZhang
 @create 2022-09-11 11:34
 */
public class Practice2_2 {
    public static void main(String[] args) {
        Worker worker = new Worker("Eddie",350,15);
        System.out.println("worker的salary为:" + worker.showSalary() + "$");
        Manager manager = new Manager("Boss",1500,15);
        System.out.println("boss的salary为:" + manager.showSalary() + "$");
    }
}
class Employee{
    String name;//姓名
    double daySalary;//日工资
    double jobDays;//工作天数

    public double showSalary(){
        return daySalary * jobDays;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", daySalary=" + daySalary +
                ", jobDays=" + jobDays +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaySalary() {
        return daySalary;
    }

    public void setDaySalary(double daySalary) {
        this.daySalary = daySalary;
    }

    public double getJobDays() {
        return jobDays;
    }

    public void setJobDays(double jobDays) {
        this.jobDays = jobDays;
    }

    public Employee(String name, double daySalary, double jobDays) {
        this.name = name;
        this.daySalary = daySalary;
        this.jobDays = jobDays;
    }

    public Employee() {
    }
}
class Worker extends Employee{
    double grade = 1.0;//员工的等级

    public Worker() {
    }

    public Worker(String name, double daySalary, double jobDays) {
        super(name, daySalary, jobDays);
        this.grade = grade;
    }

    public Worker(double grade) {
        this.grade = grade;
    }

    @Override
    public double showSalary() {
        return super.showSalary() * grade;
    }
}
class Manager extends Employee{
    double grade = 1.2;//员工的等级
    double bonus = 1000;//奖金

    public Manager() {
    }

    public Manager(String name, double daySalary, double jobDays) {
        super(name, daySalary, jobDays);
        this.grade = grade;
    }

    public Manager(double grade) {
        this.grade = grade;
    }

    @Override
    public double showSalary() {
        return super.showSalary() * grade + bonus;
    }
}
