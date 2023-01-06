package internetaddresstest;

/**
 @author EddieZhang
 @create 2022-08-18 20:18
 */

/**
 * 网络编程中有两个主要的问题：
 * 如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 *       通信双方地址
 *  IP
 *  端口号
 * 找到主机后如何可靠高效地进行数据传输
 *       一定的规则（即：网络通信协议。有两套参考模型）
 *  OSI参考模型：模型过于理想化，未能在因特网上进行广泛推广
 *  TCP/IP参考模型(或TCP/IP协议)：事实上的国际标准
 *
 *
 */

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 *       通信双方地址
 *  IP
 *           IP 地址：InetAddress
 * 唯一的标识 Internet 上的计算机（通信实体）
 * 本地回环地址(hostAddress)：127.0.0.1 主机名(hostName)：localhost
 *          IP地址分类方式1：
 *          IPV4 和 IPV6
 * IPV4：4个字节组成，4个0-255。大概42亿，30亿都在北美，亚洲4亿。2011年初已
 * 经用尽。以点分十进制表示，如192.168.0.1
 * IPV6：128位（16个字节），写成8个无符号整数，每个整数用四个十六进制位表示，
 * 数之间用冒号（：）分开，如：3ffe:3201:1401:1280:c8ff:fe4d:db39:1984
 *          IP地址分类方式2：
 *          公网地址(万维网使用)和私有地址(局域网使用)。192.168.
 * 开头的就是私有址址，范围即为192.168.0.0--192.168.255.255，专门为组织机
 * 构内部使用
 * 特点：不易记忆
 *  端口号
 *           端口号标识正在计算机上运行的进程（程序）
 *  不同的进程有不同的端口号
 *  被规定为一个 16 位的整数 0~65535。
 *  端口分类：
 *  公认端口：0~1023。被预先定义的服务通信占用（如：HTTP占用端口
 * 80，FTP占用端口21，Telnet占用端口23）
 *  注册端口：1024~49151。分配给用户进程或应用程序。（如：Tomcat占
 * 用端口8080，MySQL占用端口3306，Oracle占用端口1521等）。
 *  动态/私有端口：49152~65535。
 * 端口号与IP地址的组合得出一个网络套接字：Socket
 *
 */

public class InternetAddressTest {
        public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.10.08");//IP
            System.out.println(inetAddress);
            InetAddress inetAddress1 = InetAddress.getByName("www.youtube.com");//域名
            System.out.println(inetAddress1);
            InetAddress inetAddress2 = InetAddress.getByName("127.0.0.1");//本机
            System.out.println(inetAddress2);
            InetAddress localHost = InetAddress.getLocalHost();//本机
            System.out.println(localHost);
            //localHost.getHostName()
            String hostName = localHost.getHostName();
            System.out.println(hostName);
            //localHost.getHostAddress()
            String hostAddress = localHost.getHostAddress();
            System.out.println(hostAddress);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        InetAddress类
     */
    @Test
    public void test() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        System.out.println(inetAddress);
        // /127.0.0.1
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        //LAPTOP-EFT0K1UP/192.168.199.1
        String hostAddress = localHost.getHostAddress();
        String hostName = localHost.getHostName();
        System.out.println("主机名:" + hostName + "\t主机地址:" + hostAddress);
        //主机名:LAPTOP-EFT0K1UP	主机地址:192.168.199.1
    }
}

