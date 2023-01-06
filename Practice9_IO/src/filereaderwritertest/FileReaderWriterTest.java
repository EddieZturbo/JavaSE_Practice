package filereaderwritertest;

import org.junit.Test;

import java.io.*;

/**
 * @author EddieZhang
 * @create 2022-08-17 14:37
 * <p>
 * Java IO原理
 *  I/O是Input/Output的缩写， I/O技术是非常实用的技术，用于处理设备之间的数据传输。如读/写文件，网络通讯等。
 *  Java程序中，对于数据的输入/输出操作以“流(stream)” 的方式进行。
 *  java.io包下提供了各种“流”类和接口，用以获取不同种类的数据，并通过标准的方法输入或输出数据
 * <p>
 * 输入input：读取外部数据（磁盘、光盘等存储设备的数据）到程序（内存）中
 * 输出output：将程序（内存）数据输出到磁盘、光盘等存储设备中
 * <p>
 * Stream(流)的分类
 * 按照流向-----------输入流/输出流
 * 按照操作数据单位----字节流/字符流  (字符流处理文本/字节流处理音视频图像等非文本)
 * 按照流的角色-------节点流/处理流
 */

/**
 *                                                 * Stream的体系结构 *
 * 抽象基类              节点流（文本流）                                   缓冲流(处理流的一种--提高读写效率)                     ...处理流--（”套接“在已有流的流）
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

/**
 *      操作流程
 * 1.实例化File类对象指明要操作的文本文件----造文件
 * 2.指明具体的流 实例化流----------------造流
 * 3.进行数据的读入/写出等操作-----------操作数据
 * 4.资源的关闭----------------------关闭资源
 */
public class FileReaderWriterTest {

    /**字符流--文本文件
     * 将指定文档文件读入到程序中,并输出到控制台
     * 1.read()逐个读取文本文件中的数据返回读入的一个字符 当读取到末尾时候返回-1表示读取完毕
     * 2.异常处理 为了保证流的资源一定可以执行到close()关闭流操作 要使用try-catch-finally处理异常
     * 3.读入的文件一定要存在，否则会报异常FileNotFoundException。
     */
    @Test
    public void test() {
        //通过调用File类的构造器进行实例化并调用方法在指定位置创建文本文件
        FileReader fileReader = null;
        try {
            File file = new File("HelloEddie.txt");
            System.out.println(file.exists());
            file.createNewFile();


            //实例化File类对象指明要操作的文本文件
            File file1 = new File("HelloEddie.txt");
            //指明具体的流
            fileReader = new FileReader(file1);
            //进行数据的读入
            int readFile1 = fileReader.read();//空参构造器;逐个读取文本文件中的数据当读取到末尾时候返回-1表示读取完毕
            while (readFile1 != -1) {
                System.out.print((char) readFile1);
                readFile1 = fileReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //关闭流(资源的关闭)


    }


    /*
    将指定文档文件读入到程序中,并输出到控制台
       1.read(CharBuffer)CharBuffer参数的构造器；将字符读入数组。如果已到达流的末尾，则返回 -1。否则返回本次读取的字符数
     * 2.异常处理 为了保证流的资源一定可以执行到close()关闭流操作 要使用try-catch-finally处理异常
     * 3.读入的文件一定要存在，否则会报异常FileNotFoundException
     */
    @Test
    public void test1() {
        FileReader fileReader1 = null;
        try {
            //1.File类的实例化
            File file1 = new File("HelloEddie.txt");
            //2.选择流 实例化流
            fileReader1 = new FileReader(file1);
            //3.读入/写出数据的操作
            char[] cbuf = new char[5];//定义一个CharBuffer数组
            //CharBuffer参数的构造器；将字符读入数组。如果已到达流的末尾，则返回 -1。否则返回本次读取的字符数
            int read = fileReader1.read(cbuf);
            while (read != -1) {//read--没次读取的字符数
                //方式一：转成String数组直接遍历输出--注意循环遍历的length
                String str = new String(cbuf, 0, read);//read--没次读取的字符数
                System.out.print(str);
                //方式二：for循环遍历输出--注意循环遍历的length
//                for (int i = 0; i < read; i++) {
//                    System.out.print(cbuf[i]);
//                }
                read = fileReader1.read(cbuf);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //4.资源的关闭
            try {
                if (fileReader1 != null) {
                    fileReader1.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /*
    从内存中写出数据到磁盘文件里
    1.File类的实例化 提供File类的对象 指明要写出到的文件
    2.选择流 实例化流（用于写出的流）磁盘中可以不存在File类的对象文件
            如果原本磁盘中不存在File的对象，自动创建文件
            如果原本磁盘中已经存在File的对象
                    取决于进行写出操作时调用的构造器;
                    fileWriter.write(file)默认==(file,（append）false)表示不追加
                    不在已有的文件中追加写入，而是覆盖已有的文件
                    fileWriter.write(file,true)==(file,（append）true)表示追加
                    在已有的文件中直接进行追加写入
    3.写出的操作
    4.资源的关闭
     */
    @Test
    public void test2() {
        FileWriter fileWriter = null;
        try {
            //File类的实例化 提供File类的对象 指明要写出到的文件
            File file = new File("HelloEddieZhang.txt");
            //选择流 实例化流（用于写出的流）
            fileWriter = new FileWriter(file);
            //写出的操作
            fileWriter.write("My name is EddieZhang.\t");
            fileWriter.write("I am proficient in Java Programming!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        //资源的关闭
    }


    /**
     * 将指定文档文件读入到程序中--从内存中写出数据到磁盘文件里（相当于复制一份文件）
     */
    @Test
    public void test3() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //File类的实例化
            File fileRead = new File("HelloEddieZhang.txt");//读入的File实例化--文件要求在磁盘中真实存在
            File fileWrite = new File("HelloEddieZhang2.txt");//写出的File实例化--文件可以不存在--会进行创建
            //选择流 实例化流
            fileReader = new FileReader(fileRead);
            fileWriter = new FileWriter(fileWrite);
            //操作数据（读入/写出）
            char[] cbuf = new char[5];
            int len;
            while ((len = fileReader.read(cbuf)) != -1) {
                //读入时每次按照lend个char进行;写出时每次按照lend个char写出
                fileWriter.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //资源的关闭
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**字节流--音视频图片等非文本文件
     * 操作流程
     * 1.File类进行实例化
     * 2.选择流 实例化流
     * 3.对数据进行操作（读入/写出等）
     * 4.资源的关闭
     */
    @Test
    public void test4() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //File类的实例化
            File fileRead = new File("1 wbNftKjM0CGqzH-7AnHrYQ.jpeg");//读入的File实例化--磁盘中要真实存在
            File fileWrite = new File("1 wbNftKjM0CGqzH-7AnHrYQ1.jpeg");//写出的File实例化--磁盘中可以不存在此File
            //选择流 实例化流
            fileInputStream = new FileInputStream(fileRead);
            fileOutputStream = new FileOutputStream(fileWrite);
            //对数据进行读入/写出的操作
            byte[] bytes = new byte[5];
            int lend;
            while ((lend = fileInputStream.read(bytes)) != -1) {
                //读入时候每次按照lend个byte进行，写出时每次按照lend个byte进行
                fileOutputStream.write(bytes, 0, lend);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //资源的关闭
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    /*
    /**字节流--音视频图片等非文本文件
     * 操作流程
     * 1.File类进行实例化
     * 2.选择流 实例化流
     * 3.对数据进行操作（读入/写出等）
     * 4.资源的关闭
     */
    //图片的加密--使用异或 ^ 运算
    @Test
    public void test5() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //实例化file以及相应的流
            fileInputStream = new FileInputStream(new File("1 wbNftKjM0CGqzH-7AnHrYQ2.jpeg"));
            fileOutputStream = new FileOutputStream(new File("1 wbNftKjM0CGqzH-7AnHrYQ2secret.jpeg"));
            //操作数据
            byte[] bData = new byte[10];
            int len;
            while ((len = fileInputStream.read(bData)) != -1) {
                for (int i = 0; i < len; i++) {
                    bData[i] = (byte) (bData[i] ^ 5);//byte型 ^ int型 接收结果是byte型 要经行(byte)强制转换
                }
                //加密:读入数据后进行 ^ 异或位运算进行 然后再进行写出
                fileOutputStream.write(bData, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    /*
    /**字节流--音视频图片等非文本文件
     * 操作流程
     * 1.File类进行实例化
     * 2.选择流 实例化流
     * 3.对数据进行操作（读入/写出等）
     * 4.资源的关闭
     */
    //图片的解密--使用异或 ^ 运算
    @Test
    public void test6() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //实例化file以及相应的流
            fileInputStream = new FileInputStream(new File("1 wbNftKjM0CGqzH-7AnHrYQ2secret.jpeg"));
            fileOutputStream = new FileOutputStream(new File("1 wbNftKjM0CGqzH-7AnHrYQ3.jpeg"));
            //操作数据
            byte[] bData = new byte[10];
            int len;
            while ((len = fileInputStream.read(bData)) != -1) {
                for (int i = 0; i < len; i++) {
                    bData[i] = (byte) (bData[i] ^ 5);//byte型 ^ int型 接收结果是byte型 要经行(byte)强制转换
                }
                //解密:读入加密数据后再次进行相同的 ^ 异或位运算 然后再进行写出（m ^ n ^ n == m）
                fileOutputStream.write(bData, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
