import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 @author EddieZhang
 @create 2022-09-10 21:18
 */
@SuppressWarnings(value = "all")
public class JDBCUtilsByDruid {
    private static DataSource ds;

    //在静态代码块中完成ds的初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("src\\druid.properties")));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    //getConnection的方法
    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //关闭连接--仅仅是把连接放回到连接池中   而不是真正的 断掉连接
    public static void close(ResultSet resultSet, Statement statement,Connection connection){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
