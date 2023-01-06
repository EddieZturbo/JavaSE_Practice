/**
 @author EddieZhang
 @create 2022-09-08 11:04
 */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 结果集 ResultSet
 *
 */
public class ResultSetTest {
    @Test
    public void test() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;//查询select语句调用executeQuery()方法会返回一个结果集ResultSet
        try {
            //连接到Mysql中的db01库中
            //根据获取配置文件信息的方法连接
            //通过Properties对象load配置文件信息（配置文件可以根据实际需求编写）
            Properties properties = new Properties();//new一个Properties对象
            properties.load(new FileInputStream(new File("src\\mysql.properties")));
            //对象调用getProperty（）方法获取相关值
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
            resultSet = statement.executeQuery("select id,name,address from test1");
            //想要获取ResultSet需要用到while循环
            while(resultSet.next()){//ResultSet对象中有next方法（读取每一行的列 如果遇到null行则返回false）一行接着下一行的读取
                int id = resultSet.getInt(1);//获取第某一列的值 要确定返回值类型
                String name = resultSet.getString(2);//获取第某一列的值 要确定返回值类型
                String address = resultSet.getString(3);//获取第某一列的值 要确定返回值类型
                System.out.println(id + "\t" + name + "\t" + address);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        //4.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
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
