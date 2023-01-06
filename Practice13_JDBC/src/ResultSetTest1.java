/**
 @author EddieZhang
 @create 2022-09-08 18:35
 */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 结果集 ResultSet
 */
public class ResultSetTest1 {
    @Test
    public void test() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //连接到Mysql中的db01库
            //通过Properties对象load相关的配置文件信息（可以根据实际需求编辑配置文件）
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File("src\\mysql.properties")));
            //getProperty()获取配置文件中的值
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            //1.注册驱动
            Class.forName(driver);
            //2.取得连接
            connection = DriverManager.getConnection(url, user, password);
            //3.sql语句
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from order2");
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                String gender = resultSet.getString(3);
                System.out.println(id + "\t" + name + "\t" + gender);
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
