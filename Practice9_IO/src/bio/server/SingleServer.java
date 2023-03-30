package bio.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 @author EddieZhang
 @create 2023-03-30 9:49 PM
 */
public class SingleServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9955);//获取ServerSocket[服务端的socket连接套接字]指定服务端的端口
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();//获取一个接收流 服务端准备接收client端的数据
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg = bufferedReader.readLine()) != null){
                System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
