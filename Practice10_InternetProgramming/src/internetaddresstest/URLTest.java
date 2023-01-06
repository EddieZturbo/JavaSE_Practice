package internetaddresstest;

/**
 @author EddieZhang
 @create 2022-08-19 8:53
 */

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/** URL网络编程
 *  1.URL统一支援定位符;对应着互联网的某一资源地址
 *  2.格式:
 *      http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123
 *      <传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
 *          #片段名：即锚点，例如看小说，直接定位到章节
 *          参数列表格式：参数名=参数值&参数名=参数值....
 *
 *
 *
 */
public class URLTest {
    @Test
    public void test(){
        try {
            URL url = new URL("https://www.bilibili.com/video/BV1Qb411g7cz?p=627&spm_id_from=pageDriver&vd_source=714abe81613c048c13e8afe87725981a");
//        public String getProtocol( ) 获取该URL的协议名
        System.out.println(url.getProtocol());
//        public String getHost( ) 获取该URL的主机名
            System.out.println(url.getHost());
//        public String getPort( ) 获取该URL的端口号
            System.out.println(url.getPort());
//        public String getPath( ) 获取该URL的文件路径
            System.out.println(url.getPath());
//        public String getFile( ) 获取该URL的文件名
            System.out.println(url.getFile());
//        public String getQuery( ) 获取该URL的查询名
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
