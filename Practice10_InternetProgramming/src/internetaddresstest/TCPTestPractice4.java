package internetaddresstest;

/**
 @author EddieZhang
 @create 2022-08-31 23:36
 */

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  * 实现TCP的网络编程
 *  * 从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接
 */
public class TCPTestPractice4 {
    /*
        服务端
     */
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(8335);
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            File file = new File("1 wbNftKjM0CGqzH-7AnHrYQ12.jpeg");
            fileOutputStream = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int len;
            while((len = inputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
            outputStream = accept.getOutputStream();
            outputStream.write("服务端收到~~".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
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
     */
    @Test
    public void client() {
        Socket socket = null;
        FileInputStream fileInputStream = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(),8335);
            File file = new File("1 wbNftKjM0CGqzH-7AnHrYQ11.jpeg");
            fileInputStream = new FileInputStream(file);
            outputStream = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            int len;
            while((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
            socket.shutdownOutput();
            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes1 = new byte[1024];
            int len1;
            while((len1 = inputStream.read(bytes1)) != -1){
                byteArrayOutputStream.write(bytes1,0,len1);
            }
            System.out.println(byteArrayOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
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
            if (outputStream != null) {
                try {
                    outputStream.close();
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
