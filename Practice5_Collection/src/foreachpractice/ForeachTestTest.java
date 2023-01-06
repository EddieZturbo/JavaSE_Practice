package foreachpractice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author EddieZhang
 * @create 2022-08-13 18:41
 */

/**
 * Foreach()增强for循环
 * for(Object object : collection){//集合
 * <p>
 * }
 * for(集合中元素的类型 遍历后自定义元素的名 : 要遍历的集合名){
 * <p>
 * }
 * for(int array1 : arraysInt){//数组
 * <p>
 * }
 * for(数组的类型 遍历后自定义元素的名 : 要遍历的数组名){
 * <p>
 * }
 * <p>
 * 用于遍历集合和数组
 */
public class ForeachTestTest {
    /**
     * 集合
     * 使用Foreach循环
     */
    @Test
    public void test1() {
        Collection coll = new ArrayList();//new接口的实现类 动态数组ArraysList
        //add(Object obj)
        coll.add("Eddie");
        coll.add("zjh");
        coll.add(123);
        coll.add('Z');
        Collection coll1 = new ArrayList();
        //addAll(Collection coll)
        coll1.addAll(coll);
        coll1.add("詹姆斯");
        coll1.add("欧文");
        coll1.add("库里");
        coll1.add("杜兰特");

        //使用Foreach
        for (Object o :
                coll) {
            System.out.println(o);
        }
        System.out.println("-------------------------------------");
        for (Object o1 :
                coll1) {
            System.out.println(o1);
        }


    }


    /**
     * 数组
     * 使用Foreach循环
     */
    @Test
    public void test2() {
        int[] arrayInt1 = new int[]{1, 2, 33, 5, 22, 5, 2, 555, 6, 656, 5, 23, 321};
        for (int array1 :
                arrayInt1) {
            System.out.println(array1);
        }
    }


    @Test
    public void test3() {
        String[] str = new String[5];
        for (String myStr : str) {//foreach循环给到一个新的数组
            myStr = "atguigu";
            System.out.println(myStr);
            //atguigu
            //atguigu
            //atguigu
            //atguigu
            //atguigu
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
            //null
            //null
            //null
            //null
            //null
        }
    }
}