package MapPractice;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author EddieZhang
 * @create 2022-08-15 21:30
 */

/**
 * Map实现类--TreeMap
 * 向TreeMap中添加key-value，要求key必须要由同一个类创建的对象
 * 因为要按照key进行排序
 * TreeMap 的 Key 的排序：
 *  * 自然排序：TreeMap 的所有的 Key 必须实现 Comparable 接口，而且所有的 Key 应该是同一个类的对象，否则将会抛出 ClasssCastException
 *  * 定制排序：创建 TreeMap 时，传入一个 Comparator 对象，该对象负责对TreeMap 中的所有 key 进行排序。此时不需要 Map 的 Key 实现Comparable 接口
 *  *  TreeMap判断两个key相等的标准：两个key通过compareTo()方法或者compare()方法返回0
 */
public class TreeMapTestTest {

    @Test
    public void test1() {
        Student student = new Student("Eddie",21);
        Student student1 = new Student("Irving",32);
        Student student2 = new Student("James",37);
        Student student3 = new Student("Curry",34);
        Student student4 = new Student("Durant",34);
        //自然排序
        Map map = new TreeMap();
        map.put(student1,"Java");
        map.put(student,"Basketball");
        map.put(student2,"Basketball");
        map.put(student3,"Basketball");
        map.put(student4,"Basketball");
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //Student{name='Curry', age=34}=Basketball
        //Student{name='Durant', age=34}=Basketball
        //Student{name='Eddie', age=21}=Basketball
        //Student{name='Irving', age=32}=Java
        //Student{name='James', age=37}=Basketball
        System.out.println("----------------------------------------------------------------------------------------");
        //定制排序
        Map map1 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Student && o2 instanceof Student){
                    Student student5 = (Student)o1;
                    Student student6 = (Student)o2;
                    return Integer.compare(student5.getAge(),student6.getAge());
                }
                throw new RuntimeException("输入的数据类型不一致!");
            }
        });
        map1.putAll(map);
        Set entrySet1 = map1.entrySet();
        Iterator iterator1 = entrySet1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        //Student{name='Eddie', age=21}=Basketball
        //Student{name='Irving', age=32}=Java
        //Student{name='Curry', age=34}=Basketball
        //Student{name='James', age=37}=Basketball

    }
}