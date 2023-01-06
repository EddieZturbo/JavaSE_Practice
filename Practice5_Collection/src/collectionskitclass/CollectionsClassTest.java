package collectionskitclass;

import org.junit.Test;

import java.util.*;

/**
 * @author EddieZhang
 * @create 2022-08-15 22:22
 */

/**
 * Collections常用方法
 * 排序操作：（均为static方法）
 *  * reverse(List)：反转 List 中元素的顺序
 *  * shuffle(List)：对 List 集合元素进行随机排序
 *  * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 *  * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 *  * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 * 查找、替换
 * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
 * Object min(Collection)
 * Object min(Collection，Comparator)
 * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 * void copy(List dest,List src)：将src中的内容复制到dest中
 * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值
 *
 * Collections常用方法：同步控制
 * Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题
 */
public class  CollectionsClassTest {

    /**
     * 排序操作：（均为static方法）
     *  *  * reverse(List)：反转 List 中元素的顺序
     *  *  * shuffle(List)：对 List 集合元素进行随机排序
     *  *  * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
     *  *  * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
     *  *  * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
     */
    @Test
    public void test1() {
        List arrayList = new ArrayList();
        arrayList.add("Eddie");
        arrayList.add("James");
        arrayList.add("Irving");
        arrayList.add("Curry");
        arrayList.add("Durant");
        System.out.println(arrayList);
        //[Eddie, James, Irving, Curry, Durant]
        System.out.println("----------------------------------------------------------------------------------------");
        //reverse(List)：反转 List 中元素的顺序
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        //[Durant, Curry, Irving, James, Eddie]
        System.out.println("----------------------------------------------------------------------------------------");
        //shuffle(List)：对 List 集合元素进行随机排序
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
        //[Curry, Eddie, James, Durant, Irving]
        System.out.println("----------------------------------------------------------------------------------------");
        //sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
        Collections.sort(arrayList);
        System.out.println(arrayList);
        //[Curry, Durant, Eddie, Irving, James]
        System.out.println("----------------------------------------------------------------------------------------");
        //sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
        Collections.sort(arrayList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);//根据name降序排序
                }
                throw new RuntimeException("输入的数据类型不一致！");
            }
        });
        System.out.println(arrayList);
        //[James, Irving, Eddie, Durant, Curry]
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("BeforeSwap" + arrayList);
        //BeforeSwap[James, Irving, Eddie, Durant, Curry]

        //swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
        Collections.swap(arrayList,0,4);
        System.out.println("AfterSwap" + arrayList);
        //AfterSwap[Curry, Irving, Eddie, Durant, James]
    }

    /**
     * 查找、替换
     *  * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
     *  * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
     *  * Object min(Collection)
     *  * Object min(Collection，Comparator)
     *  * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
     *  * void copy(List dest,List src)：将src中的内容复制到dest中
     *  * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List对象的所有旧值
     */
    @Test
    public void test2(){
        List arrayList = new ArrayList();
        arrayList.add("Eddie");
        arrayList.add("James");
        arrayList.add("Irving");
        arrayList.add("Curry");
        arrayList.add("Durant");
        System.out.println(arrayList);
        //[Eddie, James, Irving, Curry, Durant]
        //按照升序排序
        Collections.sort(arrayList);
        System.out.println(arrayList);
        //[Curry, Durant, Eddie, Irving, James]
        System.out.println("----------------------------------------------------------------------------------------");
        //Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
        Comparable max = Collections.max(arrayList);
        System.out.println(max);
        //James
        System.out.println("----------------------------------------------------------------------------------------");
        //Object min(Collection)：根据元素的自然顺序，返回给定集合中的最小元素
        Comparable min = Collections.min(arrayList);
        System.out.println(min);
        //Curry
        System.out.println("----------------------------------------------------------------------------------------");
        //Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最小元素--（max略同）
        Object min1 = Collections.min(arrayList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);//根据name降序排序
                }
                throw new RuntimeException("输入的数据类型不一致！");
            }
        });
        System.out.println(min1);
        //定制排序后的 min-->James--定制排序前的 max-->System.out.println(max);//James
        System.out.println("----------------------------------------------------------------------------------------");
        //int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        int eddieFrequency = Collections.frequency(arrayList, "Eddie");
        System.out.println(eddieFrequency);
        //1
        System.out.println("----------------------------------------------------------------------------------------");
        //void copy(List dest,List src)：将src中的内容复制到dest中
//      Collections.copy(arrayList1,arrayList);throw new IndexOutOfBoundsException("Source does not fit in dest");

        //正确写法
        List arrayList1 = Arrays.asList(new Object[arrayList.size()]);
        int size = arrayList1.size();//arrayList.size()
        System.out.println(size);//5
        System.out.println(arrayList1);
        //[null, null, null, null, null]
        Collections.copy(arrayList1,arrayList);
        System.out.println(arrayList1);
        //[Curry, Durant, Eddie, Irving, James]
        System.out.println("----------------------------------------------------------------------------------------");
        //boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List对象的所有旧值



    }

    /*
    Collections常用方法：同步控制
 * Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题
    Collections.synchronizedCollection()
    Collections.synchronizedList()
    Collections.synchronizedMap()
    Collections.synchronizedSet()
     */
    @Test
    public void test3(){
        List arrayList = new ArrayList();
        arrayList.add("Eddie");
        arrayList.add("James");
        arrayList.add("Irving");
        arrayList.add("Curry");
        arrayList.add("Durant");
        List list1 = Collections.synchronizedList(arrayList);
        //返回的list1即为线程安全的List集合
    }
}