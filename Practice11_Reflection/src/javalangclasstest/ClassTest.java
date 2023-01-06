package javalangclasstest;

/**
 @author EddieZhang
 @create 2022-08-19 16:59
 */

import org.junit.Test;

/** package java.lang;
 *      Class类
 *          反射的”源头“
 *      加载过程:
 *          程序经过java.c命令后;会生成一个或多个的字节码文件(.class)
 *              --接着使用java.exe命令;对字节码文件进行解释运行;相当于将某个字节码文件加载到内存中。--（类的加载）--只会加载一次
 *              加载到内存中的类叫做运行时类;此运行时类就作为Class的一个实例
 *              Class的实例对应着一个运行时类（唯一存在）
 *              加载到内存中的运行时类会缓存一段时间--在此期间我们可以通过不同的方式获取Class的运行时类
 *          加载完类之后，在堆内存的方法区中就产生了一个Class类型的对象（一个类只有一个Class对象），这个对象就包含了完整的类的结构信息。
 *  *      我们可以通过这个对象看到类的结构。这个对象就像一面镜子，透过这个镜子看到类的结构，所以，我们形象的称之为：反射
 *  *      反射的特征:动态性
 *
 *  万物皆对象--加载完的类(运行时类)也是Class的对象
 */
public class ClassTest {
    /*  获取Class的实例
            Class的实例对应着一个运行时类（唯一存在）
               加载到内存中的运行时类会缓存一段时间--在此期间我们可以通过不同的方式获取Class的运行时类
            1.调用运行时类的属性.class--Class<Person> class1 = Person.class;
            2.通过运行时类的对象.getClass()--Class<? extends Person> personClass1 = person.getClass();
            3.调用Class的静态方法:forName(String classPath)★
            4.使用类的加载器 ClassLoader（了解）
     */
    @Test
    public void test() throws ClassNotFoundException {
        //1.调用运行时类的属性.class--Class<Person> class1 = Person.Class;
        Class<Person1> personClass = Person1.class;
        System.out.println(personClass);
        //class reflectiontest.Person

        //2.通过运行时类的对象.getClass()--Class<? extends Person> personClass1 = person.getClass();
        Person1 person = new Person1();
        Class<? extends Person1> personClass1 = person.getClass();
        System.out.println(personClass1);
        //class reflectiontest.Person

        //3.调用Class的静态方法:forName(String classPath)★
        Class<?> forName = Class.forName("reflectiontest.Person1");
        System.out.println(forName);
        //class reflectiontest.Person

        //4.使用类的加载器 ClassLoader（了解）
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("reflectiontest.Person1");
        System.out.println(loadClass);
        //class reflectiontest.Person

        System.out.println(personClass == personClass1);//true
        System.out.println(personClass1 == forName);//true
        System.out.println(forName == loadClass);//true

    }
    /*
        对于某个类的Class对象，在内存中只会有一份;缘由是类只加载一次
     */
    @Test
    public void test1() throws Exception{
        //调用Class的静态方法:forName(String classPath)★
        Class<?> aClass = Class.forName("javalangclasstest.Person1");//参数为全类名
        System.out.println(aClass.hashCode());
        //同一个类进行第二次加载test
        Class<?> aClass1 = Class.forName("javalangclasstest.Person1");//参数为全类名
        System.out.println(aClass1.hashCode());
        //209813603
        //209813603
        //结果显示内存中只存在唯一一份某个类的Class对象;


    }
}
