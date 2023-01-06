package internetaddresstest;

/**
 @author EddieZhang
 @create 2022-08-18 21:10
 */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 *  For instance 1:
 *      客户端发送信息给服务端，服务端将数据显示在控制台;
 */
public class TCPTest {
    /*  服务器端
            //1.实例化ServerSocket指明自己的端口
            //2.调用accept()方法表明接收来自客户端的socket
            //3.实例化流
            //4.操作数据
            //5.关闭资源

     */
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream socketInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            serverSocket = new ServerSocket(8899);//1.实例化ServerSocket指明自己的端口
            socket = serverSocket.accept();//2.调用accept()方法表明接收来自客户端的socket
            socketInputStream = socket.getInputStream();//3.实例化流

            byteArrayOutputStream = new ByteArrayOutputStream();//4.操作数据 ByteArrayOutputStream()接收客户端数据
            byte[] bytes = new byte[5];
            int len;
            while ((len = socketInputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {//5.关闭资源
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socketInputStream != null) {
                try {
                    socketInputStream.close();
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
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    /*  客户端
            //1.实例化Socket指明服务器的IP和端口
            //2.实例化流
            //3.操作数据
            //4.关闭资源
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream socketOutputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 8899);//1.实例化Socket指明服务器的IP和端口

            socketOutputStream = socket.getOutputStream();//2.实例化流
            socketOutputStream.write("你好我是客户端".getBytes());//3.操作数据
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {//4.关闭资源
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

}
