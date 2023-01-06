package internetaddresstest;

/**
 @author EddieZhang
 @create 2022-08-28 9:08
 */

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接
 */
public class TCPTestPractice {
    /*
        服务器端
        1.启动服务器
            1.1服务器启动 8990 端口
        2.服务器监听客户机连接
        3.实例化流--进行数据操作
        4.关闭资源

     */
    @Test
    public void service() {
        ServerSocket serverSocket = null;//服务器启动 8990 端口
        Socket accept = null;//服务器监听客户机连接
        InputStream inputStream = null;//实例化流
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;//实例化流
        try {
            serverSocket = new ServerSocket(8990);
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            File file = new File("1 wbNftKjM0CGqzH-7AnHrYQ8.jpeg");
            fileOutputStream = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {//对数据进行写入
                fileOutputStream.write(bytes, 0, len);//读出操作
            }
            //给客户端传输反馈信息
            outputStream = accept.getOutputStream();
            outputStream.write("服务端收到~~".getBytes());//要反馈的信息bytes
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //资源关闭
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            if (inputStream != null) {

                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (accept != null) {

                try {
                    accept.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (serverSocket != null) {

                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /*
        客户端
        1.实例化Socket指明服务器的IP和端口
        2.实例化流--进行数据操作
        3.关闭资源
     */
    @Test
    public void client() {
        Socket socket = null;//实例化Socket指明服务器的IP和端口
        OutputStream outputStream = null;//实例化流
        FileInputStream fileInputStream = null;//将数据通过写入流读入
        InputStream inputStream = null;//实例化流
        ByteArrayOutputStream byteArrayOutputStream = null;//将收到的bytes数据写出
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8990);
            outputStream = socket.getOutputStream();
            File file = new File("1 wbNftKjM0CGqzH-7AnHrYQ6.jpeg");//从指定路径获取数据
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {//对数据进行读入
                outputStream.write(bytes, 0, len);//写出操作
            }

            socket.shutdownOutput();

            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes1 = new byte[1024];
            int len1;
            while ((len1 = inputStream.read(bytes1)) != -1) {//对数据进行读入
                byteArrayOutputStream.write(bytes1, 0, len1);//写出操作
            }
            System.out.println(byteArrayOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            if (inputStream != null) {
                try {
                    inputStream.close();
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
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
