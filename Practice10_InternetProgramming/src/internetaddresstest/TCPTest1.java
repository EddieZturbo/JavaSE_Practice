package internetaddresstest;

/**
 @author EddieZhang
 @create 2022-08-18 22:08
 */

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 *  *  For instance 2:
 *  *      客户端发送文件给服务端，服务端将文件保存在本地;
 */
public class TCPTest1 {

    /*
        客户端
            //1.实例化Socket指明服务器端的IP和端口
            //2.实例化流
            //3.数据处理
            //4.关闭资源
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream socketOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 2022);//1.实例化Socket指明服务器端的IP和端口
            socketOutputStream = socket.getOutputStream();//2.实例化流
            fileInputStream = new FileInputStream(new File("1 wbNftKjM0CGqzH-7AnHrYQ6.jpeg"));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {//3.数据处理
                socketOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {//4.关闭资源
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socketOutputStream != null) {
                try {
                    socketOutputStream.close();
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

    /*
        服务器端
            //1.实例化ServerSocket指明端口
            //2.通过调用accept()方法表明接收来自客户端的socket
            //3.实例化流
            //4.数据操作
            //5.资源关闭
     */
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            serverSocket = new ServerSocket(2022);//1.实例化ServerSocket指明端口

            accept = serverSocket.accept();//2.通过调用accept()方法表明接收来自客户端的socket
            inputStream = accept.getInputStream();//3.实例化流
            fileOutputStream = new FileOutputStream(new File("1 wbNftKjM0CGqzH-7AnHrYQ7.jpeg"));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {//4.数据操作
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {//5.资源关闭
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
}
