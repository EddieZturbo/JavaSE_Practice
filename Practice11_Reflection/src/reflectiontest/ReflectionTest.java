package reflectiontest;

/**
 @author EddieZhang
 @create 2022-08-19 17:00
 */

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Reflection反射
 *      Reflection（反射）是被视为动态语言的关键，反射机制允许程序在执行期
 *      借助于Reflection API取得任何类的内部信息，并能直接操作任意对象的内部属性及方法
 *      加载完类之后，在堆内存的方法区中就产生了一个Class类型的对象（一个类只有一个Class对象），这个对象就包含了完整的类的结构信息。
 *      我们可以通过这个对象看到类的结构。这个对象就像一面镜子，透过这个镜子看到类的结构，所以，我们形象的称之为：反射
 *      反射的特征:动态性
 *
 */
public class ReflectionTest {
    /*
        使用Reflection前;常规操作
     */
    @Test
    public void test(){
        //创建类的对象
        reflectiontest.Person person = new reflectiontest.Person("张锦豪",21,"Java",true);
        //通过类的对象调用类的相关结构
        person.setName("EddieZhang");
        person.showInformation();
        //Name: EddieZhangAge: 21Major: JavaIs Male: true
        System.out.println(person.toString());
        //Person{name='EddieZhang', age=21, major='Java', isMale=true}

        //无法通过类的对象对类内部为private的结构进行调用
    }

    /*
        使用Reflection;

            可以调用(运行时)类中的private结构
     */
    @Test
    public void test1() throws Exception{
        Class<reflectiontest.Person> personClass = reflectiontest.Person.class;

        Constructor<reflectiontest.Person> constructor = personClass.getConstructor(String.class,int.class,String.class,boolean.class);
        reflectiontest.Person newInstance = constructor.newInstance("张锦豪", 21,"Java", true);
        System.out.println(newInstance.toString());
        //Person{name='张锦豪', age=21, major='Java', isMale=true}
        newInstance.setName("EddieZhang");
        System.out.println(newInstance.toString());
        //Person{name='EddieZhang', age=21, major='Java', isMale=true}


        System.out.println("----------------------------------通过反射调用private结构-----------------------------------");
        //通过反射可以调用类中的private结构

        //调用私有构造器
        Constructor<reflectiontest.Person> declaredConstructor = personClass.getDeclaredConstructor(String.class, int.class, boolean.class);
        declaredConstructor.setAccessible(true);//setAccessible(true)//setAccessible作用是启动和禁用访问安全检查的开关
        reflectiontest.Person person = declaredConstructor.newInstance("Eddie", 21, true);
        System.out.println(person.toString());
        //Person{name='Eddie', age=21, major='null', isMale=true}

        //调用私有的方法
        Method showPrivateInformation = personClass.getDeclaredMethod("showPrivateInformation");
        showPrivateInformation.setAccessible(true);//setAccessible(true)
        Object invoke = showPrivateInformation.invoke(person);//invoke()
        //Name: EddieAge: 21Is Male: true

        //调用私有属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person,"EddieZhang");
        System.out.println(person);
        //Person{name='EddieZhang', age=21, major='null', isMale=true}
    }
}
