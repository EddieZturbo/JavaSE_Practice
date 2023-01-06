package collectionpractice;

import java.util.*;

/**
 * @author EddieZhang
 * @create 2022-08-13 16:05
 */
public class CollectionTestTest {


    /**
     * 1、添加
     *  add(Object obj)
     *  addAll(Collection coll)
     * 向Collection接口的实现类的对象中添加自定义的数据obj时 要求obj所在类对equals方法进行重写
     */
    @org.junit.Test
    public void methodTest1() {
        Collection coll = new ArrayList();//new接口的实现类 动态数组ArraysList
        //add(Object obj)
        coll.add("Eddie");
        coll.add("zjh");
        coll.add(123);
        coll.add('Z');
        System.out.println(coll);
        Collection coll1 = new ArrayList();
        //addAll(Collection coll)
        coll1.addAll(coll);
        coll1.add("詹姆斯");
        coll1.add("欧文");
        coll1.add("库里");
        coll1.add("杜兰特");
        System.out.println(coll1);
    }

    /**
     * 2、获取有效元素的个数
     *  int size()
     */
    @org.junit.Test
    public void methodTest2() {
        Collection coll = new ArrayList();//new接口的实现类 动态数组ArraysList
        //add(Object obj)
        coll.add("Eddie");
        coll.add("zjh");
        coll.add(123);
        coll.add('Z');
        System.out.println(coll);
        // int size()
        System.out.println(coll.size());
        Collection coll1 = new ArrayList();
        //addAll(Collection coll)
        coll1.addAll(coll);
        coll1.add("詹姆斯");
        coll1.add("欧文");
        coll1.add("库里");
        coll1.add("杜兰特");
        System.out.println(coll1);
        // int size()
        System.out.println(coll1.size());
    }

    /**
     * 3、清空集合
     *  void clear()
     */
    @org.junit.Test
    public void methodTest3() {
        Collection coll = new ArrayList();//new接口的实现类 动态数组ArraysList
        //add(Object obj)
        coll.add("Eddie");
        coll.add("zjh");
        coll.add(123);
        coll.add('Z');
        System.out.println(coll);
        //void clear()
        coll.clear();
        System.out.println(coll);

    }


    /**
     * 4、是否是空集合
     *  boolean isEmpty()
     */
    @org.junit.Test
    public void methodTest4() {
        Collection coll = new ArrayList();//new接口的实现类 动态数组ArraysList
        //add(Object obj)
        coll.add("Eddie");
        coll.add("zjh");
        coll.add(123);
        coll.add('Z');
        //boolean isEmpty()
        System.out.println(coll.isEmpty());
        System.out.println(coll);
        //void clear()
        coll.clear();
        //boolean isEmpty()
        System.out.println(coll.isEmpty());
        System.out.println(coll);

    }


    /**
     * 5、是否包含某个元素
     *  boolean contains(Object obj)：是通过元素的equals方法来判断是否
     * 是同一个对象
     *  boolean containsAll(Collection c)：也是调用元素的equals方法来比
     * 较的。拿两个集合的元素挨个比较。
     * 自定义的类 调contains（）方法 要重写equals方法
     */
    @org.junit.Test
    public void methodTest5() {
        Collection coll = new ArrayList();//new接口的实现类 动态数组ArraysList
        //add(Object obj)
        coll.add("Eddie");
        coll.add("zjh");
        coll.add(123);
        coll.add('Z');
        System.out.println(coll);
        Collection coll1 = Arrays.asList("詹姆斯", "欧文", "库里", "杜兰特");
        //addAll(Collection coll)
//        coll1.addAll(coll);
//        coll1.add("詹姆斯");
//        coll1.add("欧文");
//        coll1.add("库里");
//        coll1.add("杜兰特");
        System.out.println(coll1);

        System.out.println("---------------------------------------------");
        //boolean contains(Object obj)：是通过元素的equals方法来判断是否
        boolean contains = coll1.contains("欧文");
        System.out.println(contains);

        //boolean containsAll(Collection c)：也是调用元素的equals方法来比较的。拿两个集合的元素挨个比较。
        boolean containsAll = coll1.containsAll(coll);
        System.out.println(containsAll);
    }


    /**
     * 6、删除
     *  boolean remove(Object obj) ：通过元素的equals方法判断是否是
     * 要删除的那个元素。只会删除找到的第一个元素
     *  boolean removeAll(Collection coll)：取当前集合的差集
     */
    @org.junit.Test
    public void methodTest6() {
        Collection coll = new ArrayList();//new接口的实现类 动态数组ArraysList
        //add(Object obj)
        coll.add("Eddie");
        coll.add("zjh");
        coll.add(123);
        coll.add('Z');
        System.out.println(coll);
        Collection coll1 = new ArrayList();
        //addAll(Collection coll)
        coll1.addAll(coll);
        coll1.add("詹姆斯");
        coll1.add("欧文");
        coll1.add("库里");
        coll1.add("杜兰特");
        System.out.println(coll1);

        System.out.println("---------------------------------------------");
        //boolean remove(Object obj) ：通过元素的equals方法判断是否是要删除的那个元素。只会删除找到的第一个元素
        boolean remove = coll.remove('Z');
        System.out.println(remove);
        System.out.println(coll);
        //boolean removeAll(Collection coll)：取当前集合的差集
        boolean removeAll = coll1.removeAll(coll);
        System.out.println(removeAll);
        System.out.println(coll1);

    }


    /**
     * 7、取两个集合的交集
     *  boolean retainAll(Collection c)：把交集的结果存在当前集合中，不
     * 影响c
     */
    @org.junit.Test
    public void methodTest7() {
        Collection coll = new ArrayList();//new接口的实现类 动态数组ArraysList
        //add(Object obj)
        coll.add("Eddie");
        coll.add("zjh");
        coll.add(123);
        coll.add('Z');
        System.out.println(coll);
        Collection coll1 = new ArrayList();
        //addAll(Collection coll)
        coll1.addAll(coll);
        coll1.add("詹姆斯");
        coll1.add("欧文");
        coll1.add("库里");
        coll1.add("杜兰特");
        System.out.println(coll1);

        System.out.println("---------------------------------------------");
        //boolean retainAll(Collection c)：把交集的结果存在当前集合中，不影响c
        System.out.println(coll1.retainAll(coll));
        System.out.println(coll1);
    }

    /**
     * 8、集合是否相等
     *  boolean equals(Object obj)
     */
    @org.junit.Test
    public void methodTest8() {
        Collection coll = new ArrayList();//new接口的实现类 动态数组ArraysList
        //add(Object obj)
        coll.add("Eddie");
        coll.add("zjh");
        coll.add(123);
        coll.add('Z');
        System.out.println(coll);
        Collection coll1 = new ArrayList();
        //addAll(Collection coll)
        coll1.addAll(coll);
        coll1.add("詹姆斯");
        coll1.add("欧文");
        coll1.add("库里");
        coll1.add("杜兰特");
        System.out.println(coll1);
        Collection coll2 = Arrays.asList("Eddie", "zjh", 123, 'Z');
        System.out.println(coll2);

        System.out.println("---------------------------------------------");
        //boolean equals(Object obj)
        System.out.println(coll1.equals(coll));//false

        System.out.println(coll.equals(coll2));//true
    }


    /**
     * 10、获取集合对象的哈希值
     *  hashCode()
     */
    @org.junit.Test
    public void methodTest9() {
        Collection coll = new ArrayList();//new接口的实现类 动态数组ArraysList
        //add(Object obj)
        coll.add("Eddie");
        coll.add("zjh");
        coll.add(123);
        coll.add('Z');
        System.out.println(coll);
        Collection coll1 = new ArrayList();
        //addAll(Collection coll)
        coll1.addAll(coll);
        coll1.add("詹姆斯");
        coll1.add("欧文");
        coll1.add("库里");
        coll1.add("杜兰特");
        System.out.println(coll1);
        Collection coll2 = Arrays.asList("Eddie", "zjh", 123, 'Z');
        System.out.println(coll2);

        System.out.println("---------------------------------------------");
        //hashCode()
        System.out.println(coll.hashCode());
        System.out.println(coll1.hashCode());
        System.out.println(coll2.hashCode());
    }

    /**
     * 9、转成对象数组
     *  Object[] toArray()
     */
    @org.junit.Test
    public void methodTest10() {
        Collection coll = new ArrayList();//new接口的实现类 动态数组ArraysList
        //add(Object obj)
        coll.add("Eddie");
        coll.add("zjh");
        coll.add(123);
        coll.add('Z');
        System.out.println(coll);
        Collection coll1 = new ArrayList();
        //addAll(Collection coll)
        coll1.addAll(coll);
        coll1.add("詹姆斯");
        coll1.add("欧文");
        coll1.add("库里");
        coll1.add("杜兰特");
        System.out.println(coll1);
        Collection coll2 = Arrays.asList("Eddie", "zjh", 123, 'Z');
        System.out.println(coll2);

        System.out.println("---------------------------------------------");
        //Object[] toArray() ArrayList集合 转成Object[]数组
        Object[] objects = coll.toArray();
        Object[] objects1 = coll1.toArray();
        Object[] objects2 = coll2.toArray();
        System.out.println(objects);
        System.out.println(objects1);
        System.out.println(objects2);

        System.out.println(Arrays.toString(objects));
        System.out.println(Arrays.toString(objects1));
        System.out.println(Arrays.toString(objects2));

        System.out.println("---------------------------------------------");
        //ArrayList asList() Object[]数组 转成ArrayList集合
        List<Object> objectList = Arrays.asList(objects);
        List<Object> objectList1 = Arrays.asList(objects1);
        List<Object> objectList2 = Arrays.asList(objects2);
        System.out.println(objectList);
        System.out.println(objectList1);
        System.out.println(objectList2);

        System.out.println("---------------------------------------------");
        //ArrayList asList() Object[]数组 转成ArrayList集合
        List<Integer> integers = Arrays.asList(new Integer[]{1, 2});//在new基本数据类型数组的时候注意写成包装类
        System.out.println(integers);
        System.out.println(integers.size());
        //
        List<Integer> integers1 = Arrays.asList(1, 2);//或者直接填写基本数据类型
        System.out.println(integers1);
        System.out.println(integers1.size());
    }

    /**
     * 11、遍历
     *  iterator()：返回迭代器对象，用于集合遍历
     * <p>
     * iterator.hasNext()//判断下面还有没有元素
     * iterator.next()//指针下移 然后将下移到的位置的元素值返回
     */
    @org.junit.Test
    public void methodTest11() {
        Collection coll = new ArrayList();//new接口的实现类 动态数组ArraysList
        //add(Object obj)
        coll.add("Eddie");
        coll.add("zjh");
        coll.add(123);
        coll.add('Z');
        System.out.println(coll);
        Collection coll1 = new ArrayList();
        //addAll(Collection coll)
        coll1.addAll(coll);
        coll1.add("詹姆斯");
        coll1.add("欧文");
        coll1.add("库里");
        coll1.add("杜兰特");
        System.out.println(coll1);
        Collection coll2 = Arrays.asList("Eddie", "zjh", 123, 'Z');
        System.out.println(coll2);

        System.out.println("---------------------------------------------");
        //iterator()：返回迭代器对象，用于集合遍历
        Iterator iterator = coll1.iterator();
        System.out.println(iterator);
        //
        while (iterator.hasNext()) {//iterator.hasNext()//判断下面还有没有元素
            System.out.println(iterator.next());//iterator.next()//指针下移 然后将下移到的位置的元素值返回
        }

        System.out.println("---------------------------------------------");
        //remove()
        Iterator iterator1 = coll1.iterator();
        while(iterator1.hasNext()){
            Object next = iterator1.next();
            if(next.equals(123)){
                iterator1.remove();
            }

        }
        iterator1 = coll1.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());

        }


    }

}