package bio.client;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 @author EddieZhang
 @create 2023-03-30 9:48 PM
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9966);//客户端创建一个Socket套接字 指定要连接的服务端的IP和端口
            OutputStream outputStream = socket.getOutputStream();//获取打印流流 准备向服务端进行传输数据
            PrintStream printWriter = new PrintStream(outputStream);
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.print("Please talk anymore:");
                String msg = scanner.nextLine();
                printWriter.println(msg);
                printWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
