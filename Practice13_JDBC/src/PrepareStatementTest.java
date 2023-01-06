/**
 @author EddieZhang
 @create 2022-09-08 19:04
 */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * PrepareStatement
 * 解决Statement**存在sql注入风险**的方法：使用PrepareStatement（从Statement扩展而来）取代Statement
 */
public class PrepareStatementTest {
    @Test
    public void test() throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要查询的姓名:");
        String readName = scanner.nextLine();
        System.out.print("请输入要查询的姓别:");
        String readGender = scanner.nextLine();
        //通过Properties对象load相关的配置文件信息（根据需求可以编辑配置文件）
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("src\\mysql.properties")));
        //使用getProperty()方法得到配置文件中的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //1.注册驱动
        Class.forName(driver);
        //2.取得连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //3.sql语句
        PreparedStatement preparedStatement = connection.prepareStatement("select * from order2 where name = ? and gender = ?");//其中？是占位符
        //调用set xxx(第几个占位符)方法 给占位符设置值
        preparedStatement.setString(1,readName);
        preparedStatement.setString(2,readGender);

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String gender = resultSet.getString(3);
            System.out.println(id + "\t" + name + "\t" + gender);
        }
        //4.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
        scanner.close();
    }
}
