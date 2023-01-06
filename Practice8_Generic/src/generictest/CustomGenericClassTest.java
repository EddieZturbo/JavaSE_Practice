package generictest;

/**
 * @author EddieZhang
 * @create 2022-08-16 16:33
 */

import java.util.ArrayList;

/**
 * 自定义泛型类，接口，方法
 * 自定义泛型类，接口--
 * 1.泛型的声明
 * interface List<T> 和 class GenTest<K,V>
 *     泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如：<E1,E2,E3>
 * 其中，T,K,V不代表值，而是表示类型。这里使用任意字母都可以。常用T表示，是Type的缩写。
 * 使用<T>类可以定义变量/一般方法/构造器
 *      泛型类的构造器如下：public GenericClass(){}。
 *                      错误的：public GenericClass<E>(){}
 * 静态方法中不能使用类的泛型
 * 异常类不能声明为泛型类
 *
 * 2.泛型的实例化：
 * 一定要在类名后面指定类型参数的值（类型）。如：
 * List<String> strList = new ArrayList<String>();
 * Iterator<Customer> iterator = customers.iterator();
 *  T只能是类，不能用基本数据类型填充。但可以使用包装类填充
 *  把一个集合中的内容限制为一个特定的数据类型，这就是generics背后的核心思想
 *
 * 泛型不同的引用不能相互赋值
 * ArrayList<String> list1 = new ArrayList<String>()
 * ArrayList<Integer> list2 = new ArrayList<String>()
 *      不能进行 list1 = list2;
 */

/*
泛型方法：
 方法，也可以被泛型化，不管此时定义在其中的类是不是泛型类。在泛型方法中可以定义泛型参数，此时，参数的类型就是传入数据的类型。
 泛型方法的格式：
[访问权限] <泛型> 返回类型 方法名([泛型标识 参数名称]) 抛出的异常
public class DAO <T>{//不管此时定义在其中的类是不是泛型类
    //方法中定义的泛型参数与泛型类的参数毫无关系
    public <E> E get(int id, E e) {//在泛型方法中可以定义泛型参数
        E result = null;
        return result;
    }
}
 泛型方法在调用时;指明泛型参数的类型;
 泛型方法可以声明成static的，原因是泛型参数是在调用泛型方法时确定的并非在实例化类时确定的
 */

/**
 * 测试泛型方法
 */
class test{
    public static void main(String[] args) {
        CustomGenericClassTest<String> customGenericClassTest = new CustomGenericClassTest<String>();
        String[] strings = new String[]{"zjh","21","Java"};
        ArrayList<String> strings1 = customGenericClassTest.getList(strings);//泛型方法在调用时，指明泛型类型;
        Integer[] integers = new Integer[]{1,5,3,58,546,12};
        ArrayList<Integer> integers1 = customGenericClassTest.getList(integers);//泛型方法在调用时，指明泛型类型;
    }
}
public class CustomGenericClassTest <T>{
    private String name;
    private int age;
    private T define;

    public CustomGenericClassTest() {
    }

    public CustomGenericClassTest(String name, int age, T define) {
        this.name = name;
        this.age = age;
        this.define = define;
    }
    //泛型方法:
    public <E> ArrayList<E> getList(E[] lists){
        ArrayList<E> list = new ArrayList<>();
        for (E list1 :
                lists) {
            list.add(list1);
        }
        return list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public T getDefine() {
        return define;
    }

    public void setDefine(T define) {
        this.define = define;
    }

    @Override
    public String toString() {
        return "CustomGenericClassTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", define=" + define +
                '}';
    }
}
