package otherstreamusetest;

/**
 * @author EddieZhang
 * @create 2022-08-18 0:12
 */

import java.io.*;

/**
 * 其他流的使用
 * 1.标准的输入/输出流
 * 2.打印流
 * 3.数据流
 */
public class OtherStreamTest3 {
    /*  3.数据流
            3.1:
            数据流有两个类：(用于读取和写出基本数据类型、String类的数据）
             DataInputStream 和 DataOutputStream
             分别“套接”在 InputStream 和 OutputStream 子类的流上
     */
    public static void main(String[] args) {
        //将内存中的字符串,基本数据类型的变量写出到文件中
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File("Practice9_IO\\HelloEddieData1.txt")));
            //如果使用单元测试，文件相对路径为当前module--如果使用main()测试，文件相对路径为当前工程

            dataOutputStream.writeUTF("EddieZhang");
            dataOutputStream.flush();//刷新操作--将内存中的文件写出到文件中
            dataOutputStream.writeInt(21);
            dataOutputStream.flush();
            dataOutputStream.writeBoolean(true);
            dataOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        //将文件中的数据读入到内存的变量中--读入的顺序要求要与写出的顺序相同

        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(new File("Practice9_IO\\HelloEddieData1.txt")));

            String readUTF = dataInputStream.readUTF();
            int readInt = dataInputStream.readInt();
            boolean readBoolean = dataInputStream.readBoolean();
            System.out.println("Name: " + readUTF);
            System.out.println("Age: : " + readInt);
            System.out.println("IsMale : " + readBoolean);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
