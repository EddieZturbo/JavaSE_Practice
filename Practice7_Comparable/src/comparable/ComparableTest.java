package comparable;

/**
 * @author EddieZhang
 * @create 2022-08-14 21:42
 */

import java.util.Arrays;

/**
 * 自然排序：java.lang.Comparable
 * Comparable 的典型实现：(默认都是从小到大排列的)
 * String：按照字符串中字符的Unicode值进行比较
 * Character：按照字符的Unicode值来进行比较
 * 数值类型对应的包装类以及BigInteger、BigDecimal：按照它们对应的数值
 * 大小进行比较
 * Boolean：true 对应的包装类实例大于 false 对应的包装类实例
 * Date、Time等：后面的日期时间比前面的日期时间大
 *
 *  实现 Comparable 的类必须实现 compareTo(Object obj) 方法，两个对象即通过 compareTo(Object obj) 方法的返回值来比较大小。
 * 如果当前对象this大于形参对象obj，则返回正整数，如果当前对象this小于形参对象obj，则返回负整数，如果当前对象this等于形参对象obj，则返回零
 */
public class ComparableTest {


    public static void main(String[] args) {
        Person1[] person1s = new Person1[6];//创建Person1[]数组存储Person1类对象 动态初始化数组
        //给数组赋值
        person1s[0] = new Person1("张锦豪",21,"Java");
        person1s[1] = new Person1("詹姆斯",37,"Basketball");
        person1s[2] = new Person1("欧文",32,"Basketball");
        person1s[3] = new Person1("库里",34,"Basketball");
        person1s[4] = new Person1("杜兰特",34,"Basketball");
        person1s[5] = new Person1("哈登",34,"Basketball");
//        Arrays.sort(Object obj)方法给Person1[]数组进行排序
        Arrays.sort(person1s);
        //输出数组
        System.out.println(Arrays.toString(person1s));

        //foreach遍历数组
        for (Person1 person2 :
                person1s) {
            System.out.println(person2);
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

}

/**
 * 自定义类实现Comparable接口 可进行排序比大小
 * 1.implements Comparable接口
 * 2.@Override--Comparable接口中的compareTo(Object o)方法
 * 3.在compareTo(Object o)方法体中定义如何进行排序
 */
class Person1 implements Comparable {
    private String name;
    private int age;
    private String major;

    public Person1() {
    }

    public Person1(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    //按照年龄比较Person1类的大小
    @Override
    public int compareTo(Object o) {
        if (o instanceof Person1) {
            Person1 otherPerson1 = (Person1) o;
            return Integer.compare(this.age,otherPerson1.age);//推荐方式
//            if (this.age > otherPerson1.age) {
//                return 1;
//            } else if (this.age < otherPerson1.age) {
//                return -1;
//            } else {
////                return 0;
//                return this.getMajor().compareTo(otherPerson1.getMajor());//
//            }
        }
        throw new RuntimeException("输入的数据类型不一致！！");
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}