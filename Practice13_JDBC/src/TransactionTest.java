/**
 @author EddieZhang
 @create 2022-09-09 16:12
 */

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Transaction事物
 * JDBC对事物进行编程：
 * 默认情况下，数据库连接处于自动提交模式（auto commit mode）即每个sql语句一旦被执行便被提交到数据库。
 * 一旦命令被提交，就无法进行回滚（rollback）操作。使用事物时，需要：**connection.setAutoCommit(false)**
 */
public class TransactionTest {
    @Test
    public void test() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        try {
            connection = JDBCUtils.getConnection();//通过JDBCUtils取得连接
            connection.setAutoCommit(false);//setAutoCommit(false)
            //sql语句
            preparedStatement = connection.prepareStatement("update account set balance = balance - 100 where name = '张锦豪'");
            preparedStatement = connection.prepareStatement("update account set balance = balance + 100 where name = '欧文'");
            int executeUpdate = preparedStatement.executeUpdate();
            if (executeUpdate > 0) {//
                System.out.println("sql语句执行成功~~");
            }

                connection.commit();//提交事物（事物一旦提交 就不能在进行回滚操作）

        } catch (SQLException e) {//如果在执行过程中发生了异常 就进行回滚
            try {
                connection.rollback();//回滚操作
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {//释放资源
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (preparedStatement1 != null) {
                try {
                    preparedStatement1.close();
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
