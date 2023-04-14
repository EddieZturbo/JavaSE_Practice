package nio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 @author EddieZhang
 @create 2023-04-14 3:23 PM
 */
public class GroupChatClientZero {
    //define property
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9556;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    //constructor method initial
    public GroupChatClientZero(){
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
            socketChannel.configureBlocking(false);
            selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_READ);

            username = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println("Client\t" + username + "\tready");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * sent msg to server method
     * @param msg data
     */
    public void sentMessage(String msg){
        msg = username + "\t talk: \t" + msg;
        try {
            socketChannel.write(ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Receive information from the server
     */
    public void readInfo(){
        try {
            int readableChannels = selector.select();
            if(readableChannels > 0){
                //get all the selectionKeys
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                //iterate all each selectionKey
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isReadable()){
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        //prepare a buffer
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        socketChannel.read(byteBuffer);
                        String receiveMsg = new String(byteBuffer.array());
                        System.out.println(username + "\treceive msg from server: " + receiveMsg.trim());
                    }
                }
                iterator.remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GroupChatClientZero groupChatClientZero = new GroupChatClientZero();
        //start one thread to receive msg from server (Once / 3s)
        new Thread(() -> {
            while (true){
                groupChatClientZero.readInfo();//receive msg from server
                try {
                    TimeUnit.SECONDS.sleep(3);//sleep 3s
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //send msg to server
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String msg = scanner.nextLine();
            groupChatClientZero.sentMessage(msg.trim());
        }
    }
}
