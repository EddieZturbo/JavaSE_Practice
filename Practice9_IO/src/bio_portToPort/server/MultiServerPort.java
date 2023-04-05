package bio_portToPort.server;

import bio_portToPort.threadPool.MyThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 @author EddieZhang
 @create 2023-04-05 12:00 AM
 */
public class MultiServerPort {
    private static ArrayList<Socket> list = new ArrayList<>();//集合中维护所有在线的client

    public static void main(String[] args) throws IOException {
        MyThreadPool threadPool = new MyThreadPool(5,8,2);
        ServerSocket serverSocket = new ServerSocket(9555);
        while(true){
            Socket accept = serverSocket.accept();//接收客户端的连接  阻塞方法
            System.out.println("收到了客户端的连接");
            list.add(accept);
            threadPool.executeThreadWithPool(() -> {
                try {
                    InputStream inputStream = accept.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String msg ;
                    while((msg = bufferedReader.readLine()) != null){
                        System.out.println("接收到了客户端" + Thread.currentThread().getName() + "的消息:\t" + msg);
                        sentMessageToClients(msg);//向在线的客户端发送接收到的消息
                    }
                } catch (IOException e) {
                    //出现异常则表明当前连接socket下线 将从list中移除
                    list.remove(accept);
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 服务端将客户端收到的消息返送给所有在线的客户端
     * @param msg
     */
    private static void sentMessageToClients(String msg) throws IOException {
        for (Socket socket : list) {
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.println(msg);
            printStream.flush();
        }
    }
}
