package nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 @author EddieZhang
 @create 2023-04-13 10:56 PM
 */
public class ServerZero {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();//open a channel
        serverSocketChannel.configureBlocking(false);//choose non-block mode
        serverSocketChannel.bind(new InetSocketAddress(9956));//binding a port
        Selector selector = Selector.open();//obtain a selector

        //register channel to selector and indicate accept events
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0){
            System.out.println("New Round");
            //obtain all the  selectionKeys
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            //Iterate over each one
            while (iterator.hasNext()){
                //obtain the event
                SelectionKey selectionKey = iterator.next();
                //What type of event it is
                if(selectionKey.isAcceptable()){
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                    //read data
                    ByteBuffer bf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = socketChannel.read(bf)) > 0){
                        bf.flip();
                        System.out.println(new String(bf.array(), 0, len));
                        bf.clear();
                    }
                }
            }
            iterator.remove();
        }

    }
}
