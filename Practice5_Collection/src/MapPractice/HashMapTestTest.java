package MapPractice;

import org.junit.Test;

import java.util.*;

/**
 * @author EddieZhang
 * @create 2022-08-15 20:34
 */

/**
 * Map接口：常用方法
 *  添加、删除、修改操作：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 */
public class HashMapTestTest {

    // 添加、删除、修改操作：
    // *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
    // *  void putAll(Map m):将m中的所有key-value对存放到当前map中
    // *  Object remove(Object key)：移除指定key的key-value对，并返回value
    // *  void clear()：清空当前map中的所有数据
    @Test
    public void test1() {
        //Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
        Map map = new HashMap();
        map.put("张锦豪", 21);
        map.put("欧文", 32);
        map.put("詹姆斯", 37);
        map.put("杜兰特", 34);
        map.put("库里", 34);
        System.out.println(map);
        //{詹姆斯=37, 张锦豪=21, 库里=34, 杜兰特=34, 欧文=32}
        System.out.println("-------------------------------------------------------------------------------------");
        //void putAll(Map m):将m中的所有key-value对存放到当前map中
        Map map1 = new HashMap();
        map1.put("哈登", 33);
        map1.put("东七七", 23);
        map1.putAll(map);
        System.out.println(map1);
        //{詹姆斯=37, 东七七=23, 张锦豪=21, 库里=34, 哈登=33, 杜兰特=34, 欧文=32}
        System.out.println("-------------------------------------------------------------------------------------");
        //Object remove(Object key)：移除指定key的key-value对，并返回value
        Object removeValue = map1.remove("哈登");
        System.out.println(removeValue);
        //33
        System.out.println(map1);
        //{詹姆斯=37, 东七七=23, 张锦豪=21, 库里=34, 杜兰特=34, 欧文=32}
        System.out.println("-------------------------------------------------------------------------------------");
        //void clear()：清空当前map中的所有数据 不等于map = null 只是清空key-value数据 map还在
        map.clear();
        System.out.println(map);
        //{}
        System.out.println(map.size());
        //0
    }

    // 元素查询的操作：
    // *  Object get(Object key)：获取指定key对应的value
    // *  boolean containsKey(Object key)：是否包含指定的key
    // *  boolean containsValue(Object value)：是否包含指定的value
    // *  int size()：返回map中key-value对的个数
    // *  boolean isEmpty()：判断当前map是否为空
    // *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
    @Test
    public void test2() {
        //Object get(Object key)：获取指定key对应的value
        Map map = new HashMap();
        map.put("张锦豪", 21);
        map.put("欧文", 32);
        map.put("詹姆斯", 37);
        map.put("杜兰特", 34);
        map.put("库里", 34);
        System.out.println(map);
        //{詹姆斯=37, 张锦豪=21, 库里=34, 杜兰特=34, 欧文=32}
        System.out.println(map.get("欧文"));
        //32
        System.out.println(map.get("哈登"));
        //null
        System.out.println("-------------------------------------------------------------------------------------");
        //boolean containsKey(Object key)：是否包含指定的key
        System.out.println(map.containsKey("杜兰特"));
        //true
        System.out.println(map.containsKey("哈登"));
        //false
        System.out.println("-------------------------------------------------------------------------------------");
        //int size()：返回map中key-value对的个数
        System.out.println(map.size());
        //5
        System.out.println("-------------------------------------------------------------------------------------");
        //boolean isEmpty()：判断当前map是否为空
        System.out.println(map.isEmpty());
        //false
        System.out.println("-------------------------------------------------------------------------------------");
        //boolean equals(Object obj)：判断当前map和参数对象obj是否相等
        System.out.println(map.equals(map));
        //true
        Map map2 = new HashMap();
        map2.put("哈登", 33);
        map2.put("东七七", 23);
        map2.putAll(map);
        System.out.println(map2);
        //{詹姆斯=37, 东七七=23, 张锦豪=21, 库里=34, 哈登=33, 杜兰特=34, 欧文=32}
        System.out.println(map.equals(map2));
        //false
    }

    // 元视图操作的方法：
    //通过以下方法可以获得Set/Collection的集合-->使用iterator迭代器遍历集合
    // *  Set keySet()：返回所有key构成的Set集合
    // *  Collection values()：返回所有value构成的Collection集合
    // *  Set entrySet()：返回所有key-value对构成的Set集合
    @Test
    public void test3() {
        //Set keySet()：返回所有key构成的Set集合
        Map map = new HashMap();
        map.put("张锦豪", 21);
        map.put("欧文", 32);
        map.put("詹姆斯", 37);
        map.put("杜兰特", 34);
        map.put("库里", 34);
        System.out.println(map);
        //{詹姆斯=37, 张锦豪=21, 库里=34, 杜兰特=34, 欧文=32}
        Set keySet = map.keySet();
        System.out.println(keySet);
        //[詹姆斯, 张锦豪, 库里, 杜兰特, 欧文]
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //詹姆斯
        //张锦豪
        //库里
        //杜兰特
        //欧文
        System.out.println("-------------------------------------------------------------------------------------");
        //Collection values()：返回所有value构成的Collection集合
        Collection values = map.values();
        System.out.println(values);
        //[37, 21, 34, 34, 32]
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        //37
        //21
        //34
        //34
        //32
        System.out.println("-------------------------------------------------------------------------------------");
        //Set entrySet()：返回所有key-value对构成的Set集合
        Set entrySet = map.entrySet();
        System.out.println(entrySet);
        //[詹姆斯=37, 张锦豪=21, 库里=34, 杜兰特=34, 欧文=32]
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        //詹姆斯=37
        //张锦豪=21
        //库里=34
        //杜兰特=34
        //欧文=32
        //-------------------------------------------------------------------------------------------------------------
        //使用foreach循环遍历集合
        for (Object setEntry :
                entrySet) {
            System.out.println(setEntry);
            Map.Entry entry = (Map.Entry) setEntry;//entrySet()：返回所有key-value对构成的Set集合的元素
                                                    // 都为Map.Entry类型--可以强制转换
            //Entry中定义了getKey()&getValue()方法
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
        //詹姆斯=37
        //张锦豪=21
        //库里=34
        //杜兰特=34
        //欧文=32
    }
}