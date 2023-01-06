/**
 @author EddieZhang
 @create 2022-09-07 23:51
 */

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC--连接至Mysql中的db01库
 */
public class JavaConnectMysqlTest3 {
    @Test
    public void test() {
        Connection connection = null;
        Statement statement = null;
        try {
            //通过properties对获取配置文件信息（配置文件可根据实际需求进行编辑）
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            //读取到配置文件的值
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            //1.注册驱动
            Class.forName(driver);
            //2.取得连接
            connection = DriverManager.getConnection(url, user, password);
            //3.sql语句
            //获取执行sql语句的对象
            statement = connection.createStatement();
            //传入要执行的sql语句
            int executeUpdate = statement.executeUpdate("drop table order2");//返回的值是rows（变更的行数）
            if(executeUpdate > 0){
                System.out.println("执行sql语句成功~~");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        //4.释放资源
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
