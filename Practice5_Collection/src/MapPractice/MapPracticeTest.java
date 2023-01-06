package MapPractice;

/**
 * @author EddieZhang
 * @create 2022-08-15 15:26
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 双列数据，保存具有映射关系“key-value对”的集合
 *  Map与Collection并列存在。用于保存具有映射关系的数据:key-value
 *  Map 中的 key 和 value 都可以是任何引用类型的数据
 *  Map 中的 key 用Set来存放，不允许重复，即同一个 Map 对象所对应的类，须重写hashCode()和equals()方法
 *  常用String类作为Map的“键”
 *  key 和 value 之间存在单向一对一关系，即通过指定的 key 总能找到唯一的、确定的 value
 *  Map接口的常用实现类：HashMap、TreeMap、LinkedHashMap和Properties。其中，HashMap是 Map 接口使用频率最高的实现类
 *
 * Map接口---------------------------------双列数据，保存具有映射关系“key-value对”的集合
 *
 *      ----HashMap★---------------------线程不安全效率较高 可存储null的key/value 主要实现类
 *                                        底层储存（jdk7.0及之前）--数组+链表；
 *                                               （jdk8.0开始 ）--数组+链表+红黑树；
 *
 *              ----LinkedHashMap☆-------在遍历map元素时，可以按照添加的顺序遍历
 *                                        由于在原有的HashMap底层结构基础上，添加了一对 "指针" 指向前一个和后一个
 *                                        对于频繁的遍历操作，效率高于HashMap
 *
 *      ----TreeMap☆---------------------按照添加的key-value对进行排序，实现排序遍历 考虑的是key的自然排序/定制排序
 *                                        底层使用的红黑树的储存结构
 *
 *      ----Hashtable 古老的实现类----------线程安全效率较低 不可存储null的key/value
 *
 *              ----Properties☆----------常用来处理配置文件；key&value都是String类型
 *
 * Map结构的理解
 * Map中的key：------是无序的，不可重复的；使用Set储存所有的key------------->key所在的类要求要@override--equals（）& hashCode（）【 HashMap为例 】
 * Map中的value：----是无序的，可重复的；使用Collection储存所有的value----->value所在的类要求要@override--hashCode（）
 * 一个键值对（key-value）构成了一个Entry对象；key&value相当于Entry的两个属性
 * map中的Entry-----是无序的，不可重复的；使用Set储存所有的Entry
 *
 ***********************************************************************************************************************
 * HashMap底层实现原理：
 * jdk7.0为例：
 * HashMap hashMap1 = new HashMap();
 * 在实例化以后；底层创建了长度为16的一维数组 Entry[] table；
 * ...可能已经执行过一次或多次的put...
 * hashMap1.put(key1,value1);
 * 首先，调用key1所在类的hashCode()计算key1的哈希值；此哈希值经过某种算法计算以后，得到在Entry[]数组中的存放位置；
 * 如果在此位置上的数据为空，此时的key1-value1添加成功 ----情况一
 *                      如果此位置上的数据不为空（意味着此位置上存在一个或多个数据【以链表的形式存在】），----同位置上多个的数据以链表的形式储存
 *                      比较key1和已存在的一个或多个数据的哈希值；
 *                      如果key1的哈希值与已存在的一个或多个数据的哈希值都不相同，此时的key1-value1添加成功 ----情况二
 *                      如果key1的哈希值与已存在的某一个数据(key2,value2)的哈希值相同，继续比较；调用key1所在类的equals(key2),
 *                                                                                   如果equals(key2)结果返回false；
 *                                                                                   此时key1-value1添加成功 ----情况三
 *                                                                                   如果equals(key2)结果返回true；
 *                                                                                   使用value1替换value2。
 * 在不断添加的过程中会涉及到扩容的问题：
 * 默认的扩容方式--要超出 “临界值” 时候--扩容为原来容量的2倍；并将原有的数据copy过来。
 * ---------------------------------------------------------------------------------------------------------------------
 * jdk8.0相较于jdk7.0在底层实现方面的新特性
 * 1.在实例化时：HashMap hashMap1 = new HashMap();底层并没有直接创建长度为16的数组;
 * 2.底层数组为Node[]数组 而非jdk7.0中的Entry[];
 * 3.首次调用put()方法时底层创建长度为16的Node[]数组;
 * 4.jdk8.0中的底层结构为:数组+链表+红黑树;     jdk7.0中的底层结果为:数组+链表;
 *      当数组的某一个索引位置上以链表的形式储存的数据个数 > 8 同时当前数组的长度 > 64 ;
 *      此时此索引位置上的所有数据转成 红黑树 的储存结构;(遍历快速,方便查找)
 ************************************************************************************************************************
 * LinkedHashMap底层实现原理(了解)
 * 底层使用 Entry[] 数组
 * 在遍历map元素时，可以按照添加的顺序遍历由于在原有的HashMap底层结构基础上，添加了记录添加元素的先后顺序的操作--对于频繁的遍历操作，效率高于HashMap
 * 在源码中:
 *  static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;---------------------------//此操作记录添加元素的先后顺序！！
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 */
public class MapPracticeTest {
    /*
        HashMap底层原理debug
        底层使用Node数组+链表+红黑树
     */
    @Test
    public void hashMapTest(){
//        HashMap hashMap = new HashMap();
//        hashMap.put("Eddie",99);
//        hashMap.put("Irving",95);
//        hashMap.put("James",98);
//        hashMap.put("Curry",94);
//        hashMap.put("Durant",93);
//        hashMap.put("Eddie1",99);
//        System.out.println(hashMap);

        Node[] table = new Node[16];//Map的底层是使用Node[]数组  +链表+红黑树
        Node node = new Node();
        node.item = "Eddie";
        Node node1 = new Node();
        node1.item = "Irving";
        table[0] = node;
        node.next = node1;
        Node node2 = new Node();
        node2.item = "James";
        table[1] = node2;

    }
    class Node{
        Object item;
        Node next;

        public Node(Object item, Node next) {
            this.item = item;
            this.next = next;
        }

        public Node() {
        }
    }
    /*
        HashMap底层实现原理：
        jdk8.0相较于jdk7.0在底层实现方面的新特性
     * 1.在实例化时：HashMap hashMap1 = new HashMap();底层并没有直接创建长度为16的数组;
     * 2.底层数组为Node[]数组 而非jdk7.0中的Entry[];
     * 3.首次调用put()方法时底层创建长度为16的Node[]数组;
     * 4.jdk8.0中的底层结构为:数组+链表+红黑树;     jdk7.0中的底层结果为:数组+链表;
 *      当数组的某一个索引位置上以链表的形式储存的数据个数 > 8 同时当前数组的长度 > 64 ;
 *      此时此索引位置上的所有数据转成 红黑树 的储存结构;(遍历快速,方便查找)
     */
    @Test
    public void MapTest(){
        String str1 = "Eddie";
        String str2 = "Irving";

        Map map = new HashMap();
        map.put(str1,1001);
        map.put(str1,1001);
        map.put(str2,1002);

    }
}
