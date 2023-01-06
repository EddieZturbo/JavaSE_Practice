package collectionpractice;

/**
 * @author EddieZhang
 * @create 2022-08-14 10:15
 * <p>
 * * Collection接口：单列数据，定义了存取一组对象的方法的集合
 * * List：元素有序、可重复的集合
 * * Set：元素无序、不可重复的集合
 * <p>
 * * Collection接口：单列数据，定义了存取一组对象的方法的集合
 * * List：元素有序、可重复的集合
 * * Set：元素无序、不可重复的集合
 */

/**
 *  * Collection接口：单列数据，定义了存取一组对象的方法的集合
 *  * List：元素有序、可重复的集合
 *  * Set：元素无序、不可重复的集合
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * * Set接口 没有额外的定义新的方法，使用的都是Collection中声明的方法
 * 无序性：没有索引
 * 不可重复性：
 * JDK API中Set接口的实现类常用的有：
 * HashSet:★主要实现类 线程不安全 可以存储null值
 ---* LinkedHashSet:作为HashSet的子类；遍历其数据时可以按照添加的顺序遍历
 * TreeSet:可以按照添加的对象指定属性进行排序
 */
public class CollectionSetTest {
    public static void main(String[] args) {
        MyDate myDate = new MyDate(2000, 12, 07);
        MyDate myDate1 = new MyDate(1990, 06, 12);
        MyDate myDate2 = new MyDate(1986, 04, 15);
        MyDate myDate3 = new MyDate(1988, 06, 23);
        MyDate myDate4 = new MyDate(1988, 11, 26);
        Employee employee = new Employee("Eddie", 21, myDate);
        Employee employee1 = new Employee("Irving", 33, myDate1);
        Employee employee2 = new Employee("James", 37, myDate2);
        Employee employee3 = new Employee("Curry", 34, myDate3);
        Employee employee4 = new Employee("Durant", 34, myDate4);

        TreeSet treeSet = new TreeSet();
        treeSet.add(employee);
        treeSet.add(employee1);
        treeSet.add(employee2);
        treeSet.add(employee3);
        treeSet.add(employee4);
//        遍历输出
//        for (Object treeSet1 :
//                treeSet) {
//            System.out.println(treeSet1);
//        }
//        treeSet.forEach(System.out::println);
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        System.out.println("------------------------------------------------------------------------");
        //2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序
        TreeSet treeSet1 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee emp1 = (Employee) o1;
                    Employee emp2 = (Employee) o2;
                    MyDate myDate1 = emp1.getBirthday();
                    MyDate myDate2 = emp2.getBirthday();
                    //new Comparator() 对年月日进行比较
//                    int myDate1Year = myDate1.getYear();
//                    int myDate2Year = myDate2.getYear();
//                    int minusYear = myDate1Year - myDate2Year;
//                    if (minusYear != 0) {//先判断年是否一样 不一样就对年进行比较 一样就继续对月进行比较
//                        return minusYear;
//                    } else {
//                        int myDate1Month = myDate1.getMonth();
//                        int myDate2Month = myDate2.getMonth();
//                        int minusMonth = myDate1Month - myDate2Month;
//                        if (minusMonth != 0) {//对月进行比较 一样就继续对月进行比较 不一样就对日进行比较
//                            return minusMonth;
//                        } else {//对日进行比较
//                            return myDate1.getDay() - myDate2.getDay();
//                        }
//                    }
                    //直接调用类中重写的compareTo（）方法
                    return myDate1.compareTo(myDate2);

                }
                throw new RuntimeException("输入的数据类型不一致!!");
            }
        });
        treeSet1.add(employee);
        treeSet1.add(employee1);
        treeSet1.add(employee2);
        treeSet1.add(employee3);
        treeSet1.add(employee4);
        //遍历并输出
        treeSet1.forEach(System.out::println);
    }

}


/**
 * 1). 使 Employee 实现 Comparable 接口，并按 name 排序
 *
 */
//定义一个MyDate类
class MyDate implements Comparable {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MyDate) {
            MyDate myDate = (MyDate) o;
            int myDate1Year = this.getYear();
            int myDate2Year = myDate.getYear();
            int minusYear = myDate1Year - myDate2Year;
            if (minusYear != 0) {//先判断年是否一样 不一样就对年进行比较 一样就继续对月进行比较
                return minusYear;
            } else {
                int myDate1Month = this.getMonth();
                int myDate2Month = myDate.getMonth();
                int minusMonth = myDate1Month - myDate2Month;
                if (minusMonth != 0) {//对月进行比较 一样就继续对月进行比较 不一样就对日进行比较
                    return minusMonth;
                } else {//对日进行比较
                    return this.getDay() - myDate.getDay();
                }
            }

        }
        throw new RuntimeException("输入的数据类型不一致!!");
    }
}

//1. 定义一个 Employee 类。
class Employee implements Comparable {
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }


    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            Employee employee = (Employee) o;
            return this.getName().compareTo(employee.getName());
        }
        throw new RuntimeException("输入的数据类型不匹配!!");
    }
}

