package bio.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 @author EddieZhang
 @create 2023-03-30 10:09 PM
 */
public class MultiServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9966);
            while (true) {
                new Thread(() -> {
                    try {
                        Socket socket = serverSocket.accept();//循环创建socket 相当于每个客户端的请求对应的服务端这里都对应新建一个线程进行处理
                        InputStream inputStream = socket.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        String msg;
                        while ((msg = bufferedReader.readLine()) != null) {
                            System.out.println(Thread.currentThread().getName() + ":\t" + msg);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
