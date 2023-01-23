package MapPractice;

/**
 * @author EddieZhang
 * @create 2022-08-15 20:33
 */

import org.junit.Test;

import java.util.*;

/**
 * HashMap
 * HashMap是 Map 接口使用频率最高的实现类
 * 允许使用null键和null值，与HashSet一样，不保证映射的顺序。
 * 所有的key构成的集合是Set:无序的、不可重复的。所以，key所在的类要重写：equals()和hashCode()
 * 所有的value构成的集合是Collection:无序的、可以重复的。所以，value所在的类要重写：equals()
 * 一个key-value构成一个entry
 * 所有的entry构成的集合是Set:无序的、不可重复的
 * HashMap 判断两个 key 相等的标准是：两个 key 通过 equals() 方法返回 true，hashCode 值也相等。
 * HashMap 判断两个 value相等的标准是：两个 value 通过 equals() 方法返回 true
 *
 * HashMap源码中的重要常量
 * DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 * MAXIMUM_CAPACITY ： HashMap的最大支持容量，2^30
 * DEFAULT_LOAD_FACTOR：HashMap的默认加载因子
 * TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树
 * UNTREEIFY_THRESHOLD：Bucket中红黑树存储的Node小于该默认值，转化为链表
 * MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量。（当桶中Node的数量大到需要变红黑树时，
 * 若hash表容量小于MIN_TREEIFY_CAPACITY时，此时应执行resize扩容操作这个MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的4倍。）
 * table：存储元素的数组，总是2的n次幂
 * entrySet：存储具体元素的集
 * size：HashMap中存储的键值对的数量
 * modCount：HashMap扩容和结构改变的次数。
 * threshold：扩容的临界值，=容量*填充因子
 * loadFactor：填充因子
 */
public class HashMapTest {
    @Test
    public void test1() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key2", 22);
        map.put("key3", 3);
        map.put("key4", 4);
//        map.put();
        //遍历key--使用上泛型
        Set<String> keySet = map.keySet();
        Iterator<String> iterator1 = keySet.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        //遍历value--使用上泛型
        Collection<Integer> valueCollection = map.values();
        Iterator<Integer> iterator2 = valueCollection.iterator();
        for (Integer values : valueCollection) {
            System.out.println(values);
        }
        //遍历entry--使用上泛型☆嵌套泛型
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> stringIntegerEntry = entryIterator.next();
            String key = stringIntegerEntry.getKey();
            Integer value = stringIntegerEntry.getValue();
            System.out.println(key + "-->" + value);
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("foreach遍历map");
        for (Map.Entry<String, Integer> entry : map.entrySet()
        ) {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println();
        for (String keys : map.keySet()) {
            System.out.println(keys);
        }
        System.out.println();
        for (Integer values :
                map.values()) {
            System.out.println(values);
        }


    }


}
