/**
 @author EddieZhang
 @create 2022-09-10 21:03
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Druid
 */
public class ConnectionPoolDruidTest {
    @Test
    public void DruidTest() throws Exception {
        //使用Properties对象load相关配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("src\\druid.properties")));
        //使用DruidDataSourceFactory去createDataSource得到DataSource获取Druid的连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //使用DataSource得到连接
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("本次运行用时共" + (end - start) + "毫秒");


    }

    /**
     * 使用JDBCUtilsByDruid
     */
    @Test
    public void ConnectionPoolDruidTest() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = JDBCUtilsByDruid.getConnection();//运行类型class com.alibaba.druid.pool.DruidPooledConnection
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("本次运行共计用时:" + (end - start) + "毫秒");
    }
}
