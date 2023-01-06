package practice.test1;

/**
 @author EddieZhang
 @create 2022-08-26 20:13
 */

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 反射习题1
 */
public class Test1 {//通过反射得到类的私有属性name并且修改私有的name属性值，并调用getName()方法打印name属性值

    public static void main(String[] args) throws Exception{
//        Class<PrivateTest> privateTestClass = PrivateTest.class;//获取Class
        //通过Class可以获取对应的唯一加载类的结构 也可以通过Class.getConstructor().newInstance()获取Class实例--对应着一个运行时类

//        Field name = privateTestClass.getDeclaredField("name");
//
//        name.setAccessible(true);
//        PrivateTest privateTest = privateTestClass.getConstructor().newInstance();//获取Class实例--对应着一个运行时类
//        name.set(privateTest,"EddieZhang");
//
//        Method getName = privateTestClass.getMethod("getName");//通过Class类调用method
//        String getNameString = (String) getName.invoke(privateTest);
//        System.out.println(getNameString);
//
//        System.out.println(privateTest.getName().toString());//通过Class实例（对应着一个运行时类）直接调用method

        Class<?> aClass = Class.forName("java.io.File");//通过Class().forName("java.io.File")全类名获取相应运行时类的Class
        System.out.println(aClass);//class java.io.File
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor c1 :
                declaredConstructors) {
            System.out.println(c1);
        }
        //public java.io.File(java.lang.String)
        //public java.io.File(java.lang.String,java.lang.String)
        //public java.io.File(java.net.URI)
        //private java.io.File(java.lang.String,java.io.File)
        //private java.io.File(java.lang.String,int)
        //public java.io.File(java.io.File,java.lang.String)

        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        File newInstance = (File) declaredConstructor.newInstance("E:\\mynew.txt");
        Method createNewFile = aClass.getMethod("createNewFile");
        createNewFile.invoke(newInstance);

//        newInstance.createNewFile();


    }
}


class PrivateTest {//定义一个测试类
    private String name = "hello kitty";//私有的name属性

    public PrivateTest() {
    }

    public String getName() {//提供公共的方法getName()
        return name;
    }

    @Override
    public String toString() {
        return "PrivateTest{" +
                "name='" + name + '\'' +
                '}';
    }
}