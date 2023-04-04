package bio_and_threadPool.server;

import bio_and_threadPool.threadPool.MyThreadPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 @author EddieZhang
 @create 2023-04-04 9:50 PM
 */
public class MultiServer1 {
    public static void main(String[] args) throws Exception {
        MyThreadPool myThreadPool = new MyThreadPool(5, 8, 2);
        ServerSocket serverSocket = new ServerSocket(9988);
        while (true) {
            Socket accept = serverSocket.accept();
            System.out.println("等待客户端传输消息");
            myThreadPool.executeThreadWithPool(() -> {
                try {
                    InputStream inputStream = accept.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String msg;
                    while ((msg = bufferedReader.readLine()) != null) {
                        System.out.println("客户端" + Thread.currentThread().getName() + "说:\t" + msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
