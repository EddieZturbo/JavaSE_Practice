package collectionpractice;

/**
 * @author EddieZhang
 * @create 2022-08-14 10:26
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Set接口 没有额外的定义新的方法，使用的都是Collection中声明的方法
 * 向Set中添加的数据，其所在的类一定要重写hashCode()方法 & equals()方法
 * 重写hashCode()方法 & equals()方法尽可能保持一致性;相等的对象必须具有相等的散列码
 * * 无序性：不等于随机性 存储的数据在底层数组中并非按照数组的索引顺序添加的 是根据数据的hash值决定的没有索引
 * * 不可重复性：保证添加的元素按照equals方法判断时，不能返回true 即：相同的元素只能添加一个
 * HashSet:★主要实现类 线程不安全 可以存储null值
 */
public class CollectionSetTestTest {


    /**
     * 在List内去除重复数字值，要求尽量简单
     */
    @Test
    public void test1() {
        //根据Set集合的不可重复性来解决这个问题
        ArrayList arrayList = new ArrayList();
        arrayList.add(4);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(2);

        HashSet hashSet = new HashSet();
        hashSet.addAll(arrayList);
        System.out.println(hashSet);//[1, 2, 4]
    }
    @Test
    public void test2(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        p1.type = "CC";
        set.remove(p1);
        System.out.println(set);
        //[Person{number=1002, type='BB'}, Person{number=1001, type='CC'}]
        set.add(new Person(1001,"CC"));
        System.out.println(set);
        //[Person{number=1002, type='BB'}, Person{number=1001, type='CC'}, Person{number=1001, type='CC'}]
        set.add(new Person(1001,"AA"));
        System.out.println(set);
        //[Person{number=1002, type='BB'}, Person{number=1001, type='CC'}, Person{number=1001, type='CC'}, Person{number=1001, type='AA'}]
    }
}