package employeesalarytest;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2022-07-31 15:37
 */
public class EmployeeSalaryTest {
}

//创建类 设计类的成员
abstract class Employee {
    //设计类的属性
    private String name;
    private int number;
    private MyDate birthday;

    //设计类的constructor方法


    public Employee() {
    }

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    //设计类的方法
    public abstract double earnings();

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public String information() {
        return "姓名:" + getName() + "\t工号:" + getNumber() + "\t生日:" + getBirthday().toDate();
    }
}

//创建类 设计类的成员
class MyDate {
    //设计类的属性
    private int year;
    private int month;
    private int day;

    //设计类的constructor方法


    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    //设计类的方法
    public String toDate() {
        return "" + getYear() + "年" + getMonth() + "月" + getDay() + "日";
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}


// 创建类 设计类的成员
class SalariedEmployee extends Employee {
    //设计类的属性
    private double monthlySalary;

    //设计类的constructor方法

    public SalariedEmployee() {
    }

    public SalariedEmployee(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public SalariedEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }
    //设计类的方法

    public double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public double earnings() {
//        if(getBirthday().equals(toString())){
//
//        }
        return monthlySalary;
    }

    @Override
    public String information() {
        return "SalariedEmployee[" + super.information() + "]";
    }
}


// 创建类 设计类的成员
class HourlyEmployee extends Employee {
    //设计类的属性
    private double hour;
    private double wage;
    //设计类的constructor方法


    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, int number, MyDate birthday, double hour, double wage) {
        super(name, number, birthday);
        this.hour = hour;
        this.wage = wage;
    }

    public HourlyEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }
    //设计类的方法

    @Override
    public double earnings() {
        return hour * wage;
    }

    public double getHour() {
        return hour;
    }

    public double getWage() {
        return wage;
    }

    @Override
    public String information() {
        return "HourlyEmployee[" + super.information() + "]";
    }
}


// 创建类 设计类的成员
class PayrollSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入当月的月份:");
        int readMonth = scan.nextInt();
        Employee[] employees = new Employee[4];
        employees[0] = new SalariedEmployee("张锦豪", 1001, new MyDate(2000, 12, 07),15000);
        employees[1] = new SalariedEmployee("欧文", 1002, new MyDate(1990, 7, 07),1100000);
        employees[2] = new SalariedEmployee("詹姆斯", 1003, new MyDate(1986, 5, 07),1500000);
        employees[3] = new HourlyEmployee("张锦豪",2001,new MyDate(2000,1,07),8,26);
        System.out.println(employees[0].information() + "\t工资:" + employees[0].earnings() + "$");
        System.out.println(employees[1].information() + "\t工资:" + employees[1].earnings() + "$");
        System.out.println(employees[2].information() + "\t工资:" + employees[2].earnings() + "$");
        System.out.println(employees[3].information() + "\t工资:" + employees[3].earnings() + "$");
        System.out.println("------------------------------------------------------------------------------");
        for(int i = 0;i < employees.length;i++){
            if(readMonth == employees[i].getBirthday().getMonth()){
                System.out.println(employees[i].information() + "\t工资:" + (employees[i].earnings() + 100) + "$" + "\t生日快乐！！呀  " + employees[i].getName() + "\t今天要犒劳下自己哦！！本月工资加了100块的哦！！");
            }else{
            System.out.println(employees[i].information() + "\t工资:" + employees[i].earnings() + "$");

            }
        }



    }


    //设计类的属性
//    public Employee[]employees = new Employee[100];//创建Employee[]对象数组 存放员工
//    //设计类的constructor方法
//
//    public PayrollSystem(Employee[] employees) {
//        for(int i = 0;i < employees.length;i++){
//        employees[i] = new HourlyEmployee();employees[i] = new SalariedEmployee();
//
//
//        }
//    }
//
//
//    //设计类的方法
//
//    /**
//     * 输出所有员工的信息
//     */
//    public void info(){
//        Employee[] employees1 = new Employee[employees.length];
//        for(int i = 0;i < employees1.length;i++){
//            employees1[i] = employees[i];
//            System.out.println("姓名" + employees1[i].getName() + "工号" + employees1[i].getNumber() +  "生日" + employees1[i].getBirthday());
//        }
//    }
//    /**
//     *
//     */

}









