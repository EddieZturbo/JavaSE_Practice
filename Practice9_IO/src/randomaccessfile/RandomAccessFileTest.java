package randomaccessfile;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * @author EddieZhang
 * @create 2022-08-18 16:59
 */
/**
 * RandomAccessFile(随机存取文件流)--即可作为输入流也可作为输出流
 *      如果RandomAccessFile作为输出流--写出到的文件如果不存在 则会进行创建--如果已经存在 则会对原有文件的*内容*进行覆盖-默认从头覆盖
 *                                                                              void seek(long pos)：将文件记录指针定位到 pos 位置
 *  * RandomAccessFile 声明在java.io包下，但直接继承于java.lang.Object类。
 *  * 并且它实现了DataInput、DataOutput这两个接口，也就意味着这个类既可以读也可以写。
 *  * RandomAccessFile 类支持 “随机访问” 的方式，程序可以直接跳到文件的任意地方来读、写文件
 *  * 支持只访问文件的部分内容
 *  * 可以向已存在的文件后追加内容
 *  * RandomAccessFile 对象包含一个记录指针，用以标示当前读写处的位置。
 *  * RandomAccessFile 类对象可以自由移动记录指针：
 *  * long getFilePointer()：获取文件记录指针的当前位置
 *  * void seek(long pos)：将文件记录指针定位到 pos 位置
 *  * 可以向已存在的文件后追加内容
 */

/** RandomAccessFile(随机存取文件流)
 * 构造器
 * public RandomAccessFile(File file, String mode)
 * public RandomAccessFile(String name, String mode)
 * 创建 RandomAccessFile 类实例需要指定一个 mode 参数，该参数指定 RandomAccessFile 的访问模式：
 * r: 以只读方式打开
 * rw：打开以便读取和写入
 * rwd:打开以便读取和写入；同步文件内容的更新
 * rws:打开以便读取和写入；同步文件内容和元数据的更新
 *  如果模式为只读r。则不会创建文件，而是会去读取一个已经存在的文件，
 * 如果读取的文件不存在则会出现异常。 如果模式为rw读写。如果文件不存在
 * 则会去创建文件，如果存在则不会创建
 */
public class RandomAccessFileTest {

    /*  RandomAccessFile(随机存取文件流)
            1.造文件以及相应的流
            2.操作数据
            3.关闭流
     */
    @Test
    public void test() {
        RandomAccessFile randomAccessFileRead = null;
        RandomAccessFile randomAccessFileWrite = null;
        try {
            randomAccessFileRead = new RandomAccessFile(new File("1 wbNftKjM0CGqzH-7AnHrYQ3.jpeg"), "r");
            randomAccessFileWrite = new RandomAccessFile(new File("1 wbNftKjM0CGqzH-7AnHrYQ4.jpeg"), "rw");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = randomAccessFileRead.read(bytes)) != -1) {
                randomAccessFileWrite.write(bytes, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (randomAccessFileRead != null) {
                try {
                    randomAccessFileRead.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (randomAccessFileWrite != null) {
                try {
                    randomAccessFileWrite.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Test
    public void test1() {
        RandomAccessFile randomAccessFileWrite = null;
        try {
            randomAccessFileWrite = new RandomAccessFile(new File("HelloEddie.txt"), "rw");
            //进行一个写入（此时指定文件已经存在在）

            randomAccessFileWrite.seek(randomAccessFileWrite.length());//seek()方法指明覆盖时开始的指针位置
            randomAccessFileWrite.write("&James&Curry&Durant".getBytes());
            //写入操作--对于不存在的文件会直接进行创建
            //已经存在的文件会进行内容的覆盖--默认从索引位置为0开始覆盖
            //seek()方法可指明覆盖时开始的指针位置
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (randomAccessFileWrite != null) {
                try {
                    randomAccessFileWrite.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    /*
        实现插入的效果
     */
    @Test
    public void test2() {
        RandomAccessFile randomAccessFileRead = null;
        RandomAccessFile randomAccessFileWrite = null;
        try {
            randomAccessFileRead = new RandomAccessFile(new File("HelloEddie.txt"), "r");
            randomAccessFileWrite = new RandomAccessFile(new File("HelloEddie.txt"), "rw");


            StringBuilder stringBuilder = new StringBuilder((int)new File("HelloEddie.txt").length());
            //创建StringBuilder数组用来储存指定要插入位置后的数据--指定数组容量为文件原本length避免后续频繁扩容
            randomAccessFileRead.seek(5);
            byte[] bytes = new byte[10];
            int len;
            while ((len = randomAccessFileRead.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes,0,len));
                //读得从指定要插入位置后的数据
            }
            randomAccessFileWrite.seek(5);
            randomAccessFileWrite.write("Java&InformationTechnology&".getBytes());
            randomAccessFileWrite.write(stringBuilder.toString().getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (randomAccessFileRead != null) {
                try {
                    randomAccessFileRead.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (randomAccessFileWrite != null) {
                try {
                    randomAccessFileWrite.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
