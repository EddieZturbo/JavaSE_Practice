package collectionpractice;

/**
 @author EddieZhang
 @create 2022-08-29 18:43
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;


public class CollectionListTestTestPractice1 {
    /*
        创建一个书籍类放入ArraysList集合中 按照价格进行升序排序
     */
    @Test
    public void test1(){
        ArrayList<MyBook> bookList = new ArrayList<>();
        bookList.add(new MyBook("Java编程思想","IT",75.5));
        bookList.add(new MyBook("Java核心技术卷I","IT",98.5));
        bookList.add(new MyBook("Java从入门到精通","IT",45.5));
        bookList.add(new MyBook("计算机网络","IT",65.4));
        bookList.add(new MyBook("操作系统","IT",86.5));
        bubbleSort(bookList);
        Iterator<MyBook> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
    //冒泡排序按照价格进行升序排序
    public static void bubbleSort(ArrayList arrayList){
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = 0; j < arrayList.size() - 1 - i; j++) {
                MyBook o = (MyBook) arrayList.get(j);
                MyBook o1 = (MyBook) arrayList.get(j + 1);
                if(o.getBookPrice() > o1.getBookPrice()){
                    arrayList.set(j,o1);
                    arrayList.set(j + 1,o);
                }
            }
        }
    }
    /*
        ArrayList底层源码debug
        底层使用Object[]数组
     */
    @Test
    public void arrayListTest(){
        ArrayList arrayList = new ArrayList();//JDK8之后在new对象时并没有提供基本空间--
        // 在进行第一个add元素时候 初始化空间长度为10 在1-10的过程中每次都会判断是否要超出10 未超出直接添加元素在相应的位置上
        // 一旦进行第11个元素的add时候就在原有的空间长度上进行1.5倍的扩容
        //超过原本1.5倍扩容后的长度继续进行1.5倍扩容
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);

        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        arrayList.add(16);

    }
    /*
        Vector底层源码debug
        底层使用Object[]数组
     */
    @Test
    public void vectorTest(){
        Vector vector = new Vector();////在new对象时提供基本空间--初始化空间长度为10
        //public Vector() {
        //  this(initialCapacity 10);
        //}
        // 在1-10的过程中每次都会判断是否要超出10 未超出直接添加元素在相应的位置上
        // 一旦进行第11个元素的add时候就在原有的空间长度上进行2.0倍的扩容
        //超过原本2.0倍扩容后的长度继续进行2.0倍扩容
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);
        vector.add(7);
        vector.add(8);
        vector.add(9);
        vector.add(10);
        //minGrowth = 1
        //prefGrowth = 10
        //prefLength = 20
        vector.add(11);
        vector.add(12);
        vector.add(13);
        vector.add(14);
        vector.add(15);
        vector.add(16);
        vector.add(17);
        vector.add(18);
        vector.add(19);
        vector.add(20);

        //minGrowth = 1
        //prefGrowth = 20
        //prefLength = 40
        vector.add(21);
    }
    /*
        linkedList底层源码debug
     */
    @Test
    public void linkedListTest(){
        LinkedList linkedList = new LinkedList();
        //new对象的时候调用空参构造器
        //public LinkedList() {
        //}
        //调用add()方法添加元素
//        public boolean add(E e) {
//            linkLast(e);
//            return true;
//        }
        linkedList.add(1);//添加第一个元素时first和last都指向唯一的元素 元素的prev和next都为null 给第一个元素的位置赋值1
        //last = {LinkedList$Node@1156}
            // prev = null
            // next = null
            // item = {Integer@1155} 1
        //first = {LinkedList$Node@1156}
            // prev = null
            // next = null
            // item = {Integer@1155} 1
        linkedList.add(2);//添加第二个元素时 last指向后添加的第二个元素 新添加的元素的prev为前一个元素（即早于他添加的元素）next为null 给第二个元素赋值2
                                        //first指向第一个元素 第一个元素的prev为null next为新添加的元素
//        this = {LinkedList$Node@1148}
//        prev = {LinkedList$Node@1145}
//        item = {Integer@1144} 1
//        next = null
//        prev = null
//        element = {Integer@1142} 2
//        value = 2
//        next = null
//        this.next = null
//        this.prev = null

        //e = {Integer@1142} 2
        // value = 2
        //l = {LinkedList$Node@1145}
        // item = {Integer@1144} 1
        // next = {LinkedList$Node@1148}
        // prev = null
        //newNode = {LinkedList$Node@1148}
        // item = {Integer@1142} 2
        // next = null
        // prev = {LinkedList$Node@1145}
        //modCount = 1
        //l.next = {LinkedList$Node@1148}
        // item = {Integer@1142} 2
        // next = null
        // prev = {LinkedList$Node@1145}
        //size = 1

        linkedList.remove(0);//删除指定元素 指定删除的元素的prev&next为null 元素的值置空为null （等待GC处理）同时若指定删除元素有前后元素那么前后元素的prev&next置空并且相互指向
//        this = {LinkedList@1139}  size = 2
//        x = {LinkedList$Node@1149}
//        item = {Integer@1142} 1
//        next = null
//        prev = null
//        element = {Integer@1142} 1
//        value = 1
//        next = {LinkedList$Node@1150}
//        item = {Integer@1143} 2
//        next = null
//        prev = null
//        prev = null
//        modCount = 2
//        size = 2
//        x.item = {Integer@1142} 1
//        value = 1
//        x.next = null


    }
}
