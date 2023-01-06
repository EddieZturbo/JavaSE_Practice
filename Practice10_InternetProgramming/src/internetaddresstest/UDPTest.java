package internetaddresstest;

/**
 @author EddieZhang
 @create 2022-08-19 0:00
 */

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 *  UDP网络通信
 *       流 程：
 * 1. DatagramSocket与DatagramPacket
 * 2. 建立发送端，接收端
 * 3. 建立数据包
 * 4. 调用Socket的发送、接收方法
 * 5. 关闭Socket
 *  发送端与接收端是两个独立的运行程序
 */
public class UDPTest {
    /*
        发送端
     */
    @Test
    public void sent() throws IOException {

        //建立发送端--实例化DatagramSocket
        DatagramSocket datagramSocket = new DatagramSocket();
        String strData = new String("你好我现在向你发射导弹！请务必接收！！");
        byte[] strDataBytes = strData.getBytes();
        //建立发送的数据包--将要发送的数据放入相应的构造器中--指明要发送到的IP和接口
        DatagramPacket datagramPacket = new DatagramPacket(strDataBytes,strDataBytes.length, InetAddress.getLocalHost(),8899);
        //调用Socket的send()方法发送数据包
        datagramSocket.send(datagramPacket);
        //关闭Socket
        datagramSocket.close();
    }

    /*
        接收端
     */
    @Test
    public void receive() throws IOException {
        //建立接收端--实例化DatagramSocket指明端口
        DatagramSocket datagramSocket = new DatagramSocket(8899);
        //建立接收的数据包--指明接收的容器和方式
        byte[] bytes = new byte[1000];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length);
        //调用Socket的receive()方法接收数据包
        datagramSocket.receive(datagramPacket);
        //对接收到的数据进行操作
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        //关闭Socket
        datagramSocket.close();


    }
}
