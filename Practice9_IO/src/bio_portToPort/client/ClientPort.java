package bio_portToPort.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 @author EddieZhang
 @create 2023-04-05 12:00 AM
 */
public class ClientPort {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 9555);
        /**
         * 准备一个线程接收服务端传来的消息
         */
        new Thread(() -> {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg;
                while ((msg = bufferedReader.readLine()) != null){
                    System.out.println("接收到了服务端发来的消息:\t" + msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        while (true) {
            System.out.print("Talk anymore:");
            String msg = scanner.nextLine();
            printStream.println(msg);
            printStream.flush();
        }
    }
}
