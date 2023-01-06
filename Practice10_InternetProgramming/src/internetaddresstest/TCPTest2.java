package internetaddresstest;

/**
 @author EddieZhang
 @create 2022-08-18 22:56
 */

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * /**
 *  * 实现TCP的网络编程
 *  *  *  For instance 3:
 *  *  *      从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接
 *  */
public class TCPTest2 {

    /*
        客户端
            //1.实例化Socket指明服务器的IP和端口
            //2.实例化流
            //3.数据操作
            //4.接收服务器的信息
            //5.关闭资源
     */
    @Test
    public void clint() throws IOException {
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
                socketOutputStream.write(bytes, 0, len);
            }
            socket.shutdownOutput();//停止写出
            //4.接收服务器的信息
            InputStream inputStream = socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes1 = new byte[10];
            int len1;
            while ((len1 = inputStream.read(bytes1)) != -1){
                byteArrayOutputStream.write(bytes1,0,len1);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {//5.关闭资源
            fileInputStream.close();
            socketOutputStream.close();
            socket.close();
        }
    }

    /*
        服务器端
            //1.实例化ServerSocket指明端口
            //2.调用accept()方法表明接收来自客户端的socket
            //3.实例化流
            //4.数据操作
            //5.给客户端传输信息
            //6.资源关闭
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
            //read()方法是阻塞的方法 要求客户端要明确得到socket.shutdownOutput();//停止写出的指示;才会结束
            //5.给客户端传输信息
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("好的,收到！".getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {//6.资源关闭
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



