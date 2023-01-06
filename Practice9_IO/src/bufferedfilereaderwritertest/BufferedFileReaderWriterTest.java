package bufferedfilereaderwritertest;

import org.junit.Test;

import java.io.*;
/**
 * @author EddieZhang
 * @create 2022-08-17 18:45
 */
/**
 *                                                 * Stream的体系结构 *
 * 抽象基类              节点流（文本流）                                   缓冲流(处理流的一种--提高读写效率)--flush()刷新方法    ...处理流--（”套接“在已有流的流）--flush()刷新方法
 * InputStream          FileInputStream                                 BufferedInputStream
 *                                      (read(byte[] buffer))                               read(byte[] buffer)
 * OutputStream         FileOutputStream                                BufferedOutputStream
 *                                      (write(byte[] buffer,0,lend))                       (write(byte[] buffer,0,lend))
 * Writer               FileWriter                                      BufferedWriter
 *                                      (read(char[] cbuf))                                 (read(char[] cbuf)/readLine())
 * Reader               FileReader                                      BufferedReader
 *                                      (write(char[] cbuf,0,lend))                         (write(char[] cbuf,0,lend))
 */
/*
    字节流--处理非文本文件（.jpg/.mp3/.mp4/.avi/.doc/.ppt/.excel/......）
    字符流--处理文本文件（.txt/.java/.c/.cpp/......）
 */

/**缓冲流（处理流的一种--加快读写速度）
 *          提高流的读写速度
 *          原理:
 *          内部提供了一个缓冲区
 *          源码中:private static int DEFAULT_BUFFER_SIZE = 8192;
 *
 *      操作流程
 * 1.实例化File类对象指明要操作的文本文件----造文件
 * 2.指明具体的流 实例化流----------------造流
 *      2.1 造节点流
 *      2.2 造缓冲流（处理流）--将节点流放入缓冲流的构造器中
 *      造流顺序--（先造内层后造外层）
 * 3.进行数据的读入/写出等操作-----------操作数据
 * 4.资源的关闭----------------------关闭资源
 *      关闭顺序的要求--（先关外层后关内层）
 *      关闭外层流的同时内层流自动会进行关闭--可以省略内层流的关闭
 */


public class BufferedFileReaderWriterTest {

    /*缓冲流（处理流的一种--加快读写速度）
    以下操作实现非文本类的读写操作
     */
    @Test
    public void test() {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //File类的实例化造文件
            File file = new File("1 wbNftKjM0CGqzH-7AnHrYQ1.jpeg");
            File file1 = new File("1 wbNftKjM0CGqzH-7AnHrYQ2.jpeg");
            //缓冲流的实例化
            //内层流节点流的实例化
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            //外层流缓冲流的实例化--将节点流的实例化对象放进缓冲流的构造器形参列表中
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //对数据进行操作
            byte[] bytes = new byte[10];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                //读入时每次按照lend个byte进行；写出时每次按照lend个byte进行
                bufferedOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流（关闭外层流即可）
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    /*缓冲流（处理流的一种--加快读写速度）
        以下操作实现文本类的读写操作
    */

    @Test
    public void test2() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //实例化文件以及相应的流
            bufferedReader = new BufferedReader(new FileReader(new File("HelloEddieZhang2.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("HelloEddieZhang3.txt")));
            //数据操作
            //方式一
            char[] chars = new char[5];
            int lend;
            while ((lend = bufferedReader.read(chars)) != -1) {
                bufferedWriter.write(chars, 0, lend);
            }
            /*方式二
            String data1;
            while((data1 = bufferedReader.readLine()) != null){//readLine()按行读进数据
                bufferedWriter.write(data1);//不包含换行符 需要自己添加换行操作-newLine()
                bufferedWriter.newLine();
            }
             */
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
