/**
 @author EddieZhang
 @create 2022-09-08 21:52
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBCUtils
 * 在JDBC操作中，获取连接 和 释放资源 是频繁使用到的。可以将其封装至JDBC连接的工具类JDBC Utils中
 */
public class JDBCUtils {
    //定义static的属性
    static String user;
    static String password;
    static String driver;
    static String url;

    //在静态代码块中初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File("src\\mysql.properties")));
            //获取配置文件的值并赋值给属性
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //返回一个Connection连接
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //资源释放的方法
    /*
     需要考虑到释放的资源 Connection connection, Statement statement, ResultSet resultSet
     */
    public static void closerResource(Connection connection, Statement statement, ResultSet resultSet){
        //判断是否为空 不为空时close()
        try {
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
