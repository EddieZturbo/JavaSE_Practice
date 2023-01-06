package inputstreamreadertest;

/**
 * @author EddieZhang
 * @create 2022-08-17 22:11
 */

import org.junit.Test;

import java.io.*;

/**
 * 转换流--（处理流）
 * 1.属于字符流
 * InputStreamReader;  将一个字节的输入流转换成字符的输入流;
 * OutputStreamWriter; 将一个字符的输出流转换成字节的输出流;
 * 2.作用
 * 提供字节流和字符流之间的转换
 * 3.
 * 编码: 字符数组,字符串--->字节,字节数组;
 * 解码: 字节,字节数组--->字符数组,字符串;
 * 4.字符集
 * InputStreamReader(file,"UTF-8");实现字节的输入流到字符的输入流的转换//指明字符集--取决于要读进的文件原本的字符集
 * InputStreamWriter(file,"GBK");实现字符的输出流到字节的输出流的转换//指明字符集--取决于想要写出为的字符集
 */
public class InputStreamReaderTest {

    /*
        InputStreamReader(file,"UTF-8");实现字节的输入流到字符的输入流的转换//指明字符集--取决于要读进的文件原本的字符集
     */
    @Test
    public void test() {
        InputStreamReader inputStreamReader = null;
        try {
            //实例化文件以及相应的流
            inputStreamReader = new InputStreamReader(new FileInputStream(new File("HelloEddieTest.txt")), "UTF-8");
            //InputStreamReader(file,"UTF-8");//指明字符集--取决于要读进的文件原本的字符集

            //操作数据
            char[] chars = new char[2048];
            int len;
            while ((len = inputStreamReader.read(chars)) != -1) {
                String str = new String(chars, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (inputStreamReader != null) {
                //关闭流
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    /**
     * * InputStreamReader(file,"UTF-8");实现字节的输入流到字符的输入流的转换//指明字符集--取决于要读进的文件原本的字符集
     * * InputStreamWriter(file,"GBK");实现字符的输出流到字节的输出流的转换//指明字符集--取决于想要写出为的字符集
     */
    @Test
    public void test1() {
        InputStreamReader inputStreamReader = null;//读入转换--解码
        OutputStreamWriter outputStreamWriter = null;//写出转换--编码
        try {
            //实例化文件以及相应的流
            inputStreamReader = new InputStreamReader(new FileInputStream(new File("HelloEddieTest.txt")), "UTF-8");
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File("HelloEddieTest_GBK.txt")), "GBK");
            //操作数据
            char[] chars = new char[2048];
            int len;
            while ((len = inputStreamReader.read(chars)) != -1) {
                outputStreamWriter.write(chars, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
