package MapPractice;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author EddieZhang
 * @create 2022-08-15 21:57
 */

/**
 * Properties
 * Properties 类是 Hashtable 的子类，该对象用于处理属性文件
 *  * 由于属性文件里的 key、value 都是字符串类型，所以 Properties 里的 key和 value 都是字符串类型
 *  * 存取数据时，建议使用setProperty(String key,String value)方法和getProperty(String key)方法
 */
public class PropertiesTestTest {

    @Test
    public void test1() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        properties.load(fileInputStream);//加载Stream对应的文件
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println("name = " + name + "\tpassword = " + password);
        //name = Edie	password = zjh20001207
    }
}