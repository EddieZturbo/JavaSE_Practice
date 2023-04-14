package nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 @author EddieZhang
 @create 2023-04-14 3:22 PM
 */
public class GroupChatServerZero {
    //define property
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final int PORT = 9556;

    //constructor initial
    public GroupChatServerZero() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(PORT));

            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //listening method
    public void listening() {
        System.out.println("listening ready");
        try {
            while (selector.select() > 0) {
                System.out.println("begin handle event");
                //iterate all the events
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    //obtain one of the events
                    SelectionKey selectionKey = iterator.next();
                    //judge what is the event?
                    if (selectionKey.isAcceptable()) {
                        //Gets the channel of the currently connected client
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        System.out.println(socketChannel.getRemoteAddress() + "\t" + "online");
                        //register this channel to selector
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        //handle reading...
                        readData(selectionKey);
                    }
                }
                iterator.remove();//completed remove current event
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * reading data method
     * @param selectionKey current event
     */
    public void readData(SelectionKey selectionKey) {
        SocketChannel channel = null;
        try {
            //get current channel
            channel= (SocketChannel) selectionKey.channel();
            //create a buffer and indicate capacity
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //reading
            int read = channel.read(byteBuffer);
            if(read > 0){
                //buffer‘s byte[] transfer to String
                String msg = new String(byteBuffer.array());
                System.out.println("from client data : " + msg.trim());

                //sent data to else client except current client
                sentDataToOtherClient(msg,channel);
            }

        } catch (IOException e) {
            e.printStackTrace();
            try {
                System.out.println(channel.getRemoteAddress() + "\t" + "down");
                selectionKey.cancel();//cancel register
                channel.close();//close channel
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * sent data to else client except current client
     * @param msg data
     * @param currentChannel current client channel
     */
    public void sentDataToOtherClient(String msg, SocketChannel currentChannel) throws IOException {
        System.out.println(Thread.currentThread().getName() + "\t server transfer the data to other client");
        //iterate all the socketChannels and except current channel
        for(SelectionKey key : selector.keys()){
            //获取socketChannel
            Channel channel = key.channel();
            //judge whether isn't current channel
            if(channel instanceof SocketChannel && channel != currentChannel){
                SocketChannel destSocketChannel = (SocketChannel) channel;
                //write msg to destination
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8));
                destSocketChannel.write(byteBuffer);
            }
        }
    }

    public static void main(String[] args) {
        GroupChatServerZero groupChatServerZero = new GroupChatServerZero();
        groupChatServerZero.listening();
    }
}
