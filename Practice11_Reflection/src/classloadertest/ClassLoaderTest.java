package classloadertest;

/**
 @author EddieZhang
 @create 2022-08-19 19:48
 */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *  类装载器
 *  类加载器的作用：
 *  类加载的作用：将class文件字节码内容加载到内存中，并将这些静态数据转换成方
 * 法区的运行时数据结构，然后在堆中生成一个代表这个类的java.lang.Class对象，作为
 * 方法区中类数据的访问入口。
 *  类缓存：标准的JavaSE类加载器可以按要求查找类，但一旦某个类被加载到类加载器
 * 中，它将维持加载（缓存）一段时间。不过JVM垃圾回收机制可以回收这些Class对象
 *
 * 类加载器作用是用来把类(class)装载进内存的
 *
 * 引导类加载器：用C++编写的，是JVM自带的类加载器，负责Java平台核心库，用来装载核心类库。该加载器无法直接获取
 * 扩展类加载器：负责jre/lib/ext目录下的jar包或 –D java.ext.dirs 指定目录下的jar包装入工作库
 * 系统类加载器：负责java –classpath 或 –Djava.class.path所指的目录下的类与jar包装入工作 ，是最常用的加载器
 *
 * • //1.获取一个系统类加载器
 * • ClassLoader classloader = ClassLoader.getSystemClassLoader();
 * • System.out.println(classloader);
 * • //2.获取系统类加载器的父类加载器，即扩展类加载器
 * • classloader = classloader.getParent();
 * • System.out.println(classloader);
 * • //3.获取扩展类加载器的父类加载器，即引导类加载器
 * • classloader = classloader.getParent();
 * • System.out.println(classloader);
 */
public class ClassLoaderTest {
    @Test
    public void test() {
        //1.获取一个系统类加载器
        ClassLoader classloader = ClassLoader.getSystemClassLoader();
        System.out.println(classloader);//jdk.internal.loader.ClassLoaders$AppClassLoader@27c170f0

        //2.获取系统类加载器的父类加载器，即扩展类加载器
        classloader = classloader.getParent();
        System.out.println(classloader);//jdk.internal.loader.ClassLoaders$PlatformClassLoader@c818063

        //3.获取扩展类加载器的父类加载器，即引导类加载器--用来装载核心类库。该加载器无法直接获取
        classloader = classloader.getParent();
        System.out.println(classloader);//null

    }

    /*
        使用类加载器读取配置文件
     */
    @Test
    public void test1() throws Exception {
        //读取配置文件方式一:

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(new File("src\\jdbc2.properties"));//默认识别文件在当前module下
        properties.load(fileInputStream);
        String name = properties.getProperty("Name");
        String age = properties.getProperty("Age");
        String major = properties.getProperty("Major");
        System.out.println("Name: "  + name + "\tAge: "  + age + "\tMajor: " + major);
        //Name: Eddie	Age: 21	Major: Java

        //读取配置文件方式二:使用ClassLoader

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc2.properties");//默认识别文件在当前module的src下
        properties.load(resourceAsStream);
        String name1 = properties.getProperty("Name");
        String age1 = properties.getProperty("Age");
        String major1 = properties.getProperty("Major");
        System.out.println("Name: "  + name1 + "\tAge: "  + age1 + "\tMajor: " + major1);
        //Name: Eddie	Age: 21	Major: Java

    }
}
