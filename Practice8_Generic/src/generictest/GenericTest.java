package generictest;

/**
 * @author EddieZhang
 * @create 2022-08-16 15:08
 */

/**
 *  泛型<Generic>--jdk5.0新增
 *
 *  集合接口或集合类都修改为带泛型的结构
 *  在实例化集合类是可以指明泛型的类型
 *  指明泛型类型后在集合类或接口中凡是定义类或接口时，内部结构（方法，属性，构造器等...）使用到类的泛型的位置，都指定为实例化时相同的泛型类型
 *  泛型的类型必须是类;不能为基本数据类型(可转换成包装类后使用)
 *  如果实例化时候没有指明泛型类型;默认类型为java.long.Object类型
 *  静态方法中不能使用类的泛型
 *  异常类不能声明为泛型类
 *
 * 1. 解决元素存储的安全性问题，好比商品、药品标签，不会弄错。
 * 2. 解决获取数据元素时，需要类型强制转换的问题，好比不用每回拿商品、药品都要辨别
 * Java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生ClassCastException异常。同时，代码更加简洁、健壮
 *
 **在集合中没有泛型时;任何类型都可以添加到集合中：类型不安全
 *     读取出来的对象需要强转：繁琐可能有ClassCastException
 *
 **在集合中有泛型时;在编译时就会进行数据类型检查;只有指定类型才可以添加到集合中：类型安全
 *     读取出来的对象不需要强转：便捷
 *     使用泛型的主要优点是能够在编译时而不是在运行时检测错误
 *     经验：泛型要使用一路都用。要不用，一路都不要用
 *     jdk1.7，泛型的简化操作：ArrayList<Fruit> list = new ArrayList<>();--类型推断
 *
 **泛型在继承方面的体现:
 * List<Object> list1 = new List;
 * List<String> list2 = new List;
 *      list1 = list2(不允许);//此时的list1和list2不具有子父类关系;
 *
 *
 */
public class GenericTest {
    public static void main(String[] args) {
        //在对泛型类进行实例化时使用指明泛型类型
        CustomGenericClassTest<String> customGenericClassTest = new CustomGenericClassTest<String>("Eddie",21,"String-Type");
        //相应的方法统一会使用指明的泛型类型
        customGenericClassTest.setDefine("String-Type");
    }
}
