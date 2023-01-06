package otherstreamusetest;

/**
 * @author EddieZhang
 * @create 2022-08-17 23:33
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 其他流的使用
 * 1.标准的输入/输出流
 * 2.打印流
 * 3.数据流
 */
public class OtherStreamTest1 {

    /* 1.标准的输入/输出流
            1.1 输入输出设备;
                System.in:标准的输入流,默认从键盘输入;
                System.out:标准的输出流,默认从控制台输出;
            1.2 重定向;对默认设备进行改变
                System类的setIn(InputStream is)&setOut(OutputStream ps)方法重新指定输入和输出的流

     */

    /**test;
     从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序
     方式一:Scanner;调用next()返回字符串
     方式二:使用System.in;System.in--> InputStreamReader(转换流)--->BufferedReader的readLine();（字节到字符需要转换）
     *
     * @param args
     */
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;//InputStreamReader(转换流)--->BufferedReader的readLine()
        try {
            InputStreamReader reader = new InputStreamReader(System.in);//使用System.in;System.in--> InputStreamReader(转换流)
            bufferedReader = new BufferedReader(reader);

            while (true) {
                System.out.println("请输入字符串:");
                String data1 = bufferedReader.readLine();
                if ("e".equalsIgnoreCase(data1) || "exit".equalsIgnoreCase(data1)) {
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data1.toUpperCase();
                System.out.println(upperCase);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }
}
