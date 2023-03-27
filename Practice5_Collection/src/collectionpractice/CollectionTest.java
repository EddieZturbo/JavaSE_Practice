package collectionpractice;

/**
 * @author EddieZhang
 * @create 2022-08-13 16:03
 */

import java.util.ArrayList;

/**
 * Collection接口
 *  Collection接口：单列数据，定义了存取一组对象的方法的集合
 *  向Collection接口的实现类的对象中添加自定义的数据obj时 要求obj所在类对equals方法进行重写
 *
 *  * List：元素有序、可重复的集合
 *  * Set：元素无序、不可重复的集合--存放在Set容器中的对象，
 *                               对应的类一定要重写equals()和hashCode(Object obj)方法，以实现对象相等规则
 *
 *      ------List★
 *              ------ArrayList★---------------主要实现类 线程不安全的 效率较高 底层使用Object[]存储
 *
 *                          ------LinkedList----对于频繁的插入和删除操作-效率较高 底层使用双向链表存储
 *
 *              ------Vector--------------------古老实现类 -- since：jdk1.0 线程安全效率较低 底层使用Object[]存储
 *
 *      ------Set
 *              ------HashSet☆------------------主要实现类 线程不安全 可以存储null值 底层使用数组+链表储存
 *
 *                          ------LinkedHashSet--根据元素的 hashCode 值来决定元素的存储位置，但它同时使用双向链表维护元素的次序，
 *                                               这使得元素看起来是以插入顺序保存的 不允许集合元素重复
 *                                               LinkedHashSet插入性能略低于 HashSet，但在迭代访问 Set 里的全部元素时有很好的性能
 *
 *              ------TreeSet--------------------TreeSet 是 SortedSet 接口的实现类，TreeSet 可以确保集合元素处于排序状态。
 *                                               TreeSet底层使用红黑树结构存储数据
 *                                               TreeSet 两种排序方法：自然排序和定制排序。默认情况下，TreeSet 采用自然排序
 *                                                TreeSet和后面要讲的TreeMap采用红黑树的存储结构
 *                                                特点：有序，查询速度比List快
 *
 */
public class CollectionTest {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        integers.add(11);

    }

}
