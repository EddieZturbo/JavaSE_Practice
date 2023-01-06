package collectionpractice;

import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author EddieZhang
 * @create 2022-08-13 23:02
 */
public class CollectionListTestTest {

    /**
     * List中的常用方法
     * List除了从Collection集合继承的方法外，List 集合里添加了一些根据索引来
     * 操作集合元素的方法
     * ArrayList、★主要实现类 线程不安全的 效率较高 底层使用Object[]存储
     * 常用方法 着重放在：
     * 增 :void add(Object obj)
     * 删 :Object remove(int index):移除指定index位置的元素，并返回此元素
     * 删 :boolean remove(Object obj):移除指定元素，并返回此元素
     * 改 :Object set(int index, Object ele):设置指定index位置的元素为ele
     * 查 :Object get(int index):获取指定index位置的元素
     * 插 :void add(int index, Object ele):在index位置插入ele元素
     * 长度 :int size()
     * 遍历 :1.iterator迭代器
     *      2.foreach(增强for循环)
     *      3.普通的循环
     *      4.遍历public void forEach(Consumer<? super E> action)--default方法
     */
    @Test
    public void test1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add("zjh");
        arrayList.add('Z');
        arrayList.add("张锦豪");
        arrayList.add(123);
        System.out.println(arrayList);

        System.out.println("-------------------------------------------------");
        //void add(int index, Object ele):在index位置插入ele元素
        arrayList.add(1,"欧文");
        System.out.println(arrayList);

        System.out.println("-------------------------------------------------");
        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List<? extends Serializable> serializables1 = Arrays.asList(123, "zjh", "张锦豪", 'O');
        arrayList.addAll(serializables1);
        System.out.println(arrayList);
        System.out.println(arrayList.size());

        System.out.println("-------------------------------------------------");
        //Object get(int index):获取指定index位置的元素
        System.out.println(arrayList.get(0));


        System.out.println("-------------------------------------------------");
        //int indexOf(Object obj):返回obj在集合中首次出现的位置
        System.out.println("在集合中首次出现的位置: " + arrayList.indexOf("zjh"));

        System.out.println("-------------------------------------------------");
        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        System.out.println("在当前集合中末次出现的位置: " + arrayList.lastIndexOf("zjh"));

        System.out.println("-------------------------------------------------");
        //Object remove(int index):移除指定index位置的元素，并返回此元素
        System.out.println(arrayList.remove(0));
        System.out.println(arrayList);

        System.out.println("-------------------------------------------------");
        //boolean remove(Object obj):移除指定元素，并返回此元素
        arrayList.remove("zjh");
        System.out.println(arrayList);

        System.out.println("-------------------------------------------------");
        //Object set(int index, Object ele):设置指定index位置的元素为ele
        arrayList.set(0,"凯里欧文");
        System.out.println(arrayList);

        System.out.println("-------------------------------------------------");
        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合 前闭后开[ fromIndex , toIndex )
        System.out.println(arrayList.subList(2, 5));

        System.out.println("-------------------------------------------------");
        //遍历--Iterator迭代器方式
        Iterator iterator = arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        System.out.println("-------------------------------------------------");
        //遍历--foreach(增强for循环)方式
        for (Object obj1 :
                arrayList) {
            System.out.println(obj1);
        }
        System.out.println("-------------------------------------------------");
        //遍历--普通for循环方式
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("-------------------------------------------------");
        //遍历public void forEach(Consumer<? super E> action)--default方法
        arrayList.forEach(System.out::println);

    }
}