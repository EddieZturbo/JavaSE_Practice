package comparator;

/**
 * @author EddieZhang
 * @create 2022-08-14 21:42
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 定制排序：java.util.Comparator
 *  当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
 * 或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
 * 那么可以考虑使用 Comparator 的对象来排序，强行对多个对象进行整体排序的比较
 *  重写compare(Object o1,Object o2)方法，比较o1和o2的大小：如果方法返
 * 回正整数，则表示o1大于o2；如果返回0，表示相等；返回负整数，表示
 * o1小于o2。
 *  可以将 Comparator 传递给 sort 方法（如 Collections.sort 或 Arrays.sort），
 * 从而允许在排序顺序上实现精确控制。
 *  还可以使用 Comparator 来控制某些数据结构（如有序 set或有序映射）的
 * 顺序，或者为那些没有自然顺序的对象 collection 提供排序。
 */
public class ComparatorTest {


    public static void main(String[] args) {
        Person2[] person2s = new Person2[6];//创建Person1[]数组存储Person1类对象 动态初始化数组
        //给数组赋值
        person2s[0] = new Person2("张锦豪", 21, "Java");
        person2s[1] = new Person2("詹姆斯", 37, "Basketball");
        person2s[2] = new Person2("欧文", 32, "Basketball");
        person2s[3] = new Person2("库里", 34, "Basketball");
        person2s[4] = new Person2("杜兰特", 34, "Basketball");
        person2s[5] = new Person2("哈登", 34, "Basketball");
//        定制排序：java.util.Comparator
        Arrays.sort(person2s, new Comparator<Person2>() {
            @Override
            public int compare(Person2 o1, Person2 o2) {
                if (o1 instanceof Person2 && o2 instanceof Person2) {
                    Person2 person1 = (Person2) o1;
                    Person2 person2 = (Person2) o2;
                    //按照年龄从大到小排序 年龄相同时按照name排序
                    if (person1.getAge() == person2.getAge()) {
                        return person1.getName().compareTo(person2.getName());
                    } else {
                        return -Integer.compare(person1.getAge(), person2.getAge());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致！！");
            }

        });
        System.out.println(Arrays.toString(person2s));

        System.out.println("------------------------------------------------------");
        for (Person2 person2 :
                person2s) {
            System.out.println(person2);
//            Person1 {name='詹姆斯', age=37, major='Basketball'}
//            Person1{name='哈登', age=34, major='Basketball'}
//            Person1{name='库里', age=34, major='Basketball'}
//            Person1{name='杜兰特', age=34, major='Basketball'}
//            Person1{name='欧文', age=32, major='Basketball'}
//            Person1{name='张锦豪', age=21, major='Java'}
        }


    }

}

/**
 * 自定义类实现Comparable接口 可进行排序比大小
 * 1.implements Comparable接口
 * 2.@Override--Comparable接口中的compareTo(Object o)方法
 * 3.在compareTo(Object o)方法体中定义如何进行排序
 */
class Person2 {
    private String name1;
    private int age1;
    private String major1;

    public Person2() {
    }

    public Person2(String name, int age, String major) {
        this.name1 = name;
        this.age1 = age;
        this.major1 = major;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name1 + '\'' +
                ", age=" + age1 +
                ", major='" + major1 + '\'' +
                '}';
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

    public String getMajor() {
        return major1;
    }

    public void setMajor(String major) {
        this.major1 = major;
    }
}