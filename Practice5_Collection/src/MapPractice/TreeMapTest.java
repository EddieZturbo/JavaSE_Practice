package MapPractice;

/**
 * @author EddieZhang
 * @create 2022-08-15 21:28
 */

/**
 * Map实现类--TreeMap
 * TreeMap存储 Key-Value 对时，需要根据 key-value 对进行排序。TreeMap 可以保证所有的 Key-Value 对处于有序状态
 * TreeSet底层使用红黑树结构存储数据
 * TreeMap 的 Key 的排序：
 * 自然排序：TreeMap 的所有的 Key 必须实现 Comparable 接口，而且所有的 Key 应该是同一个类的对象，否则将会抛出 ClasssCastException
 * 定制排序：创建 TreeMap 时，传入一个 Comparator 对象，该对象负责对TreeMap 中的所有 key 进行排序。此时不需要 Map 的 Key 实现Comparable 接口
 *  TreeMap判断两个key相等的标准：两个key通过compareTo()方法或者compare()方法返回0
 */
public class TreeMapTest {
    public void test(){

    }
}
