/**
 @author EddieZhang
 @create 2022-09-07 21:46
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
 * JDBC--连接Mysql中的db02库
 */
public class JavaConnectMysqlTest {

@Test
public void test() {
        Connection connection = null;
        Statement statement = null;

        try {
                //前置工作--》将jar包复制粘贴到IDEA所用的项目下，放置jar包的目录可以是自己新建的，也可以和项目同在一个目录下。然后再：右键选择添加到add as Library下:
                //通过Properties对象获取配置文件信息（配置文件自己创建可根据实际情况经行编辑）
                Properties properties = new Properties();
                properties.load(new FileInputStream("src\\mysql.properties"));
                //获取相关的值
                String user = properties.getProperty("user");
                String password = properties.getProperty("password");
                String url = properties.getProperty("url");
                String driver = properties.getProperty("driver");
                //1.注册驱动
                Class.forName(driver);//Class.forName("com.mysql.cj.jdbc.Driver");
                //2.获得连接
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("推荐连接方式" + connection);
                //3.操作sql语句
                //定义要执行的sql语句
                String sql = "insert into actor values (null,'张锦豪','男','2000-12-07','13556859181')";
                //获取执行sql语句的对象 Statement
                statement = connection.createStatement();
                //执行sql语句
                int executeUpdate = statement.executeUpdate(sql);
                //返回的是处理结果
                if(executeUpdate > 0){
                        System.out.println("执行sql语句成功");

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
