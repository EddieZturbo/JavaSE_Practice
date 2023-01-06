package objectstreamtest;

import org.junit.Test;

import java.io.*;

/**
 @author EddieZhang
 @create 2022-08-29 11:05
 */

/**
 * 序列化：将内存中的数据持久化到磁盘中或者通过网络传输出去--将内存中的数据持久化
 *             使用ObjectOutputStream实现
 * 对象流--处理流
 *  *  ObjectInputStream和ObjectOutputStream
 *
 */
public class ObjectStreamTestPractice1 {
    /*
        序列化--将内存中的数据持久化到磁盘中或者通过网络传输出去--将内存中的数据持久化
            使用ObjectOutputStream实现
     */
    @Test
    public void test() {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("ObjectData1.dat")));
            objectOutputStream.writeObject(new String("My name is EddieZhang~~"));
            objectOutputStream.flush();
            objectOutputStream.writeObject(new Person("Irving",33,"Basketball",true,new Student("Eddie",1001,99)));
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }



    }
    /*
       反序列化--序列化的逆过程
     */
    @Test
    public void test1() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(new File("ObjectData1.dat")));

            Object object = objectInputStream.readObject();
            String str1 = (String) object;
            Object object1 = objectInputStream.readObject();
            Person person1 = (Person) object1;

            System.out.println(str1);
            System.out.println(person1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }


}
