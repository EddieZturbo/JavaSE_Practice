/**
 @author EddieZhang
 @create 2022-09-08 9:57
 */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC--连接到mysql中的db01库中
 */
public class JavaConnectMysqlTest4 {
    @Test
    public void test() {
        Connection connection = null;
        Statement statement = null;
        try {
            //通过Properties对象Load配置信息（配置信息可以根据实际情况自行编辑）
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File("src\\mysql.properties")));
            //获取配置文件信息内容
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driver");
            //1.注册驱动--可以省略 建议写上
            Class.forName(driver);
            //2.取得连接
            connection = DriverManager.getConnection(url, user, password);
            //3.sql语句
            //3.1取得执行sql语句的对象
            statement = connection.createStatement();
            //3.2编写sql语句--执行sql语句
            int i = statement.executeUpdate("create table order2 (id int primary key auto_increment,`name` varchar(10) not null default '',`gender` enum ('男','女'))");
            int i1 = statement.executeUpdate("insert into order2 values (null,'EddieZhang','男'),(null,'Irving','男'),(null,'James','男')");
            if(i > 0){
                System.out.println("创建库指令完成~~");
            }
            if(i1 > 0){
                System.out.println("插入数据指令完成~~");
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
