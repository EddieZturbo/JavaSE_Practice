package datetimepractice;

/**
 * @author EddieZhang
 * @create 2022-08-12 14:32
 */


import java.util.Arrays;
import java.util.Comparator;

/**
 * 自定义person类 如何实现自然排序（按照名字从小到大排序）
 */
class Person1 implements Comparable{
    private int age;
    private String name;

    public Person1() {
    }

    public Person1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof Person1) {
            Person1 person1 = (Person1) o;
            int compare = this.name.compareTo(person1.name);//从前到后 implements Comparable 重写compareTo方法自定义比较
            return compare;
        }
        throw new RuntimeException("数据类型不一致");
    }
}

public class DateTimeTest1 {
    public static void main(String[] args) {
        Person1[] person1s = new Person1[7];
        person1s[0] = new Person1(21, "Eddie Hu");
        person1s[1] = new Person1(22, "Eddie Zhang");
        person1s[2] = new Person1(22, "Eddie Huang");
        person1s[3] = new Person1(23, "Eddie Cheng");
        person1s[4] = new Person1(19, "Eddie Liu");
        person1s[5] = new Person1(25, "Eddie Wang");
        person1s[6] = new Person1(18, "Eddie Li");
//        Arrays.sort(person1s);
//        System.out.println(Arrays.toString(person1s));

        Arrays.sort(person1s, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person1 && o2 instanceof Person1){
                    Person1 person1 = (Person1)o1;
                    Person1 person2 = (Person1)o2;
                    int compareTo = -person1.compareTo(person2);//从后到前 new Comparator()临时比较一次
                    return compareTo;
                }
                throw new RuntimeException("数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(person1s));





    }


}
