package wildcardtest;

/**
 * @author EddieZhang
 * @create 2022-08-16 18:11
 */

import java.util.ArrayList;
import java.util.List;

/**
 * wildcard(通配符):--?
 * 1.使用类型通配符：？
 * 比如：List<?> ，Map<?,?>
 * List<?>是List<String>、List<Object>等各种泛型List的父类。
 * 2.读取List<?>的对象list中的元素时，永远是安全的，因为不管list的真实类型是什么，它包含的都是Object。
 * 3.写入list中的元素时，不行。因为我们不知道c的元素类型，我们不能向其中添加对象。
 *  唯一的例外是null，它是所有类型的成员
 *
 * 通配符的使用:
 * 泛型在继承方面的体现:
 *  * List<Object> list1 = new List;
 *  * List<String> list2 = new List;
 *  *      list1 = list2(不允许);//此时的list1和list2不具有子父类关系;
 *
 *      List<?> list3 = new List;--//List<?>是List<String>、List<Object>等各种泛型List的父类
 *      list3 = list1;
 *      list3 = list2;
 *
 * 有限制条件的通配符的使用:
 *      ? extends Father----写入(不允许)--------------读取为至少Father
 *          --(-∞,Father]
 *      ? super Father-----写入(允许)-- 小于Father的--只能读取为Object
 *          --[Father,+∞)
 *
 */
public class WildcardTest {
    public static void main(String[] args) {
    List<Object> objectList = new ArrayList<>();
    List<String> stringList = new ArrayList<>();

//        objectList = stringList;//(不允许);//此时的list1和list2不具有子父类关系;

    List<?> lists = null;//List<?>是List<String>、List<Object>等各种泛型List的父类

    stringList.add("zz");
    stringList.add("jj");
    stringList.add("hh");
    stringList.add("nn");

        lists = stringList;

        //写入(不允许)
        lists.add(null);
//        lists.add("zjh");//不能自己添加数据
        //写入list中的元素时，不行。因为我们不知道c的元素类型，我们不能向其中添加对象。
        // 唯一的例外是null，它是所有类型的成员

        //读取(允许)
        Object o = lists.get(0);//读取List<?>的对象list中的元素时，永远是安全的，因为不管list的真实类型是什么，它包含的都是Object。
        System.out.println(o);
//---------------------------------------------------------------------------------------------------------------------
//        有限制条件的通配符的使用:
//        ? extends Father
//                          --(-∞,Father]
//       ? super Father
//                          --[Father,+∞)

        List<Father> list3 = null;
        List<Son> list4 = null;
        List<Object> list5 = null;

        List<? extends Father> lists1 = null;
//        ? extends Father
//                          --(-∞,Father]
        lists1 = list3;
        lists1 = list4;
//        lists1 = list5;//不允许-- 原因 :> Father

        List<? super Father> lists2 = null;
//        ? super Father
//                          --[Father,+∞)
        lists2 = list3;
        lists2 = list5;
//        lists2 = list4;//不允许-- 原因 :< Father

        //写入(允许)-- 小于Father的
//        ? super Father
//                          --[Father,+∞)


//---------------------------------------------------------------------------------------------------------------------
        System.out.println("-------------------------------------------------------------------------------------");
        WildcardTest wildcardTest = new WildcardTest();
        List<String> getlist = wildcardTest.getlist(new String[]{"zjh", "Irving", "james"});////泛型方法在调用时，指明泛型类型;
    }

    /**
     * 泛型方法
     * @param es
     * @return
     * @param <E>
     */
    public<E> List<E> getlist(E[] es){
        List<E> eList = new ArrayList<>();
        for (E lists :
                es) {
            eList.add(lists);
        }
        return eList;
    }

}
