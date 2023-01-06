/**
 @author EddieZhang
 @create 2022-09-08 22:09
 */

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试创建的JDBCUtils工具类
 */
public class JDBCUtilsTest {
    /*
        测试dml语句
     */
    @Test
    public void test(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //使用工具类JDBCUtils直接取得连接
            connection = JDBCUtils.getConnection();
            //sql语句
            preparedStatement = connection.prepareStatement("delete from order2 where id = ?");
            preparedStatement.setString(1,"1");
            int executeUpdate = preparedStatement.executeUpdate();
            if(executeUpdate > 0){
                System.out.println("sql语句执行成功~~");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        //使用工具类JDBCUtils释放资源
        JDBCUtils.closerResource(connection,preparedStatement,null);
        }

    }
    /*
        测试select语句指令
     */
    @Test
    public void test1(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //使用工具类JDBCUtils直接取得连接
            connection = JDBCUtils.getConnection();
            //sql语句
            preparedStatement = connection.prepareStatement("select * from order2 where id between ? and ?");
            preparedStatement.setInt(1,2);
            preparedStatement.setInt(2,4);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                System.out.println(id + "\t" + name + "\t" + gender);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        ////使用工具类JDBCUtils释放资源
        JDBCUtils.closerResource(connection,preparedStatement,resultSet);
        }

    }
}
