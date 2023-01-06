package objectstreamtest;

import org.junit.Test;

import java.io.*;

/**
 * @author EddieZhang
 * @create 2022-08-18 15:13
 * 对象流--处理流
 *  ObjectInputStream和ObjectOutputStream
 *  用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来
 *  序列化：用ObjectOutputStream类保存基本类型数据或对象的机制
 *  反序列化：用ObjectInputStream类读取基本类型数据或对象的机制
 *  ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 * 对象的序列化机制
 * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从
 * 而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传
 * 输到另一个网络节点。//当其它程序获取了这种二进制流，就可以恢复成原
 * 来的Java对象
 * 序列化的好处在于可将任何实现了Serializable接口的对象转化为字节数据，
 * 使其在保存和传输时可被还原
 * 序列化是 RMI（Remote Method Invoke – 远程方法调用）过程的参数和返
 * 回值都必须实现的机制，而 RMI 是 JavaEE 的基础。因此序列化机制是
 * JavaEE 平台的基础
 * 如果需要让某个对象支持序列化机制，则必须让对象所属的类及其属性是可
 * 序列化的，为了让某个类是可序列化的，该类必须实现如下两个接口之一。
 * 否则，会抛出NotSerializableException异常
 * Serializable
 * Externalizable
 * <p>
 * 凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量：
 * private static final long serialVersionUID;
 * serialVersionUID用来表明类的不同版本间的兼容性。简言之，其目的是以序列化对象
 * 进行版本控制，有关各版本反序列化时是否兼容。
 * 如果类没有显示定义这个静态常量，它的值是Java运行时环境根据类的内部细节自
 * 动生成的。若类的实例变量做了修改，serialVersionUID 可能发生变化。故建议，
 * 显式声明。
 *  简单来说，Java的序列化机制是通过在运行时判断类的serialVersionUID来验
 * 证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的
 * serialVersionUID与本地相应实体类的serialVersionUID进行比较，如果相同
 * 就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异
 * 常。(InvalidCastException)
 */


/** 使用对象流序列化对象
 *  若某个类实现了 Serializable 接口，该类的对象就是可序列化的：
 * 创建一个 ObjectOutputStream
 * 调用 ObjectOutputStream 对象的 writeObject(对象) 方法输出可序列化对象
 * 注意写出一次，操作flush()一次
 * 反序列化
 * 创建一个 ObjectInputStream
 * 调用 readObject() 方法读取流中的对象
 * 强调：如果某个类的属性不是基本数据类型或 String 类型，而是另一个
 * 引用类型，那么这个引用类型必须是可序列化的，否则拥有该类型的
 * Field 的类也不能序列化
 */
public class ObjectStreamTest {

    /*  Serialization（序列化）:
            将内存中Java对象或基本类型数据保存到磁盘或者通过网络传输出去--将内存中的数据持久化
            使用ObjectOutputStream实现
        步骤:
            1.File的实例化----------造文件
            2.选择相应的流并实例化----造流
            3.数据的操作------------操作数据
            4.资源的关闭------------关闭流
     */
    @Test
    public void test() {
        ObjectOutputStream objectOutputStream = null;
        try {
            //1.File的实例化----------造文件--2.选择相应的流并实例化----造流
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("ObjectData.dat")));

            //3.数据的操作------------操作数据
            objectOutputStream.writeObject(new String("A book that interested you most!!"));
            objectOutputStream.flush();
            objectOutputStream.writeObject(new Person("Eddie", 21, "Java", true, new Student("Irving", 1001, 95)));
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //4.资源的关闭------------关闭流
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }


    /* Externalization（反序列化）
            从磁盘或网络中读取基本类型数据或对象保存到Java程序内存中
            用ObjectInputStream来实现
       步骤:
            1.File的实例化----------造文件
            2.选择相应的流并实例化----造流
            3.数据的操作------------操作数据
            4.资源的关闭------------关闭流
     */
    @Test
    public void test1() {
        ObjectInputStream objectInputStream = null;
        try {
            //1.File的实例化----------造文件--2.选择相应的流并实例化----造流
            objectInputStream = new ObjectInputStream(new FileInputStream(new File("ObjectData.dat")));

            //3.数据的操作------------操作数据
            Object readObject = objectInputStream.readObject();
            String string = (String) readObject;
            Person person = (Person) objectInputStream.readObject();

            System.out.println(string);
            System.out.println(person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectInputStream != null) {
                //4.资源的关闭------------关闭流
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
