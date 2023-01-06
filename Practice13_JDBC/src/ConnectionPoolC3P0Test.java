/**
 @author EddieZhang
 @create 2022-09-10 19:46
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * C3P0
 */
@SuppressWarnings(value = "all")//抑制警告
public class ConnectionPoolC3P0Test {
    /*
        方式一：
        在程序中指定相关参数
     */
    @Test
    public void C3P0Test() throws IOException, PropertyVetoException, SQLException {
        //创建一个数据源对象ComboPooledDataSource
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        //通过配置文件获取相关连接信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //给数据源配置相关参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始化连接数以及最大连接数
        comboPooledDataSource.setInitialPoolSize(10);//设置初始化连接数
        comboPooledDataSource.setMaxPoolSize(50);//最大连接数

        //测试与数据库进行5000次连接
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();//getConnection()方法实现了DataSource接口
            connection.close();//关闭连接
        }
        long end = System.currentTimeMillis();
        System.out.println("本次运行用时:" + (end - start) + "毫秒");
    }

    /*
        方式二 通过配置文件
     */
    @Test
    public void C3P0Test1() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("DataSource");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
        Connection connection = comboPooledDataSource.getConnection();
        connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("本次运行共计用时:" + (end - start) + "毫秒");
        //本次运行共计用时:772毫秒
    }
}
