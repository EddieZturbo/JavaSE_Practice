package newinstancetest;

/**
 @author EddieZhang
 @create 2022-08-19 20:53
 */

import org.junit.Test;
import reflectiontest.Person;

import java.lang.reflect.InvocationTargetException;

/**
 * 创建类的对象：
 * 调用Class对象的newInstance()方法（jdk1.9及之后版本弃用）
 * 调用Class对象的getDeclaredConstructor().newInstance()☆
 *  要 求： 1）类必须有一个无参数的构造器。
 *          2）类的构造器的访问权限需要足够
 */

/**
 * 在JavaBean中要求提供public空参构造器
 * 原因:
 *      1.便于通过反射，创建运行时类的对象
 *      2.便于子类继承此运行时类时；默认调用super()时，确保父类有次构造器
 */
public class NewInstanceTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        /*
            创建运行时类的对象：调用Class对象的newInstance()方法
                newInstance()方法内部调用了运行时类的空参构造器
         */
        Person instance = personClass.newInstance();
        System.out.println(instance);
        //Person{name='null', age=0, major='null', isMale=false}
    }


    /*
        .getDeclaredConstructor().newInstance()☆
     */
    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Person newInstance = Person.class.getDeclaredConstructor().newInstance();
        System.out.println(newInstance);
        //Person{name='null', age=0, major='null', isMale=false}

    }
}
