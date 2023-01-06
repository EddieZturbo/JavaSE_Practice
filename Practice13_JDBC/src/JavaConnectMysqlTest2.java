/**
 @author EddieZhang
 @create 2022-09-07 23:34
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
 * JDBC--连接Mysql中的db01库
 */
public class JavaConnectMysqlTest2 {
    @Test
    public void test() {
        Connection connection = null;
        Statement statement = null;
        try {
            //通过Properties对象获取配置信息（配置信息自己可以根据实际情况进行编辑）
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            //获取相关的值
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            //1.注册驱动
            Class.forName(driver);
            //2.取得连接
            connection = DriverManager.getConnection(url, user, password);
            //3.sql操作
            //获取执行sql语句的对象
            statement = connection.createStatement();
            statement.executeUpdate("create table `student_jdbc` (id int primary key auto_increment,`name` varchar(10) not null default '',`age` tinyint not null default 0)");
            statement.executeUpdate("insert into student_jdbc values (null,'Eddie',21),(null,'Irving',33),(null,'James',37),(null,'Curry',34)");
            statement.executeUpdate("update student_jdbc set name = 'EddieZhang' where id = 1");
            statement.executeUpdate("delete from student_jdbc where name = 'EddieZhang'");
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
