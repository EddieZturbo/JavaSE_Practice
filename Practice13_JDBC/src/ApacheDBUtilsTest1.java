/**
 @author EddieZhang
 @create 2022-09-11 20:05
 */

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Apache的DBUtils工具类 + druid（连接池） 完成对表的crud
 */
public class ApacheDBUtilsTest1 {
    @Test
    public void test(){
        Connection connection = null;//取得连接 使用JDBCUtilsByDruid
        try {
            connection = JDBCUtilsByDruid.getConnection();
            //使用DBUtils 接口和类
            QueryRunner queryRunner = new QueryRunner();
            String sql = new String("select * from actor where id = ?");
            List<Actor> query = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 2);
            for (Actor actor :
                    query) {
                System.out.println(actor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        JDBCUtilsByDruid.close(null,null,connection);//释放资源 使用JDBCUtilsByDruid
        }


    }
    /**
     * 使用Apache-DBUtils + Druid 完成 返回的结果是单行记录 （单个对象）
     */
    @Test
    public void test1(){
        Connection connection = null;
        try {
            //得到连接
            connection = JDBCUtilsByDruid.getConnection();
            //使用DBUtils 接口和类
            QueryRunner queryRunner = new QueryRunner();
            String sql = new String("select * from actor where id = ?");
            Actor query = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);//返回的结果是单行记录 （单个对象）使用形参列表中使用的Handler 为new BeanHandler<>(Actor.class)
            System.out.println(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        JDBCUtilsByDruid.close(null,null,connection);//释放资源
        }

    }
    /**
     * 使用Apache-DBUtils + Druid 完成 返回的结果是单行单列的 返回的就是Object对象
     */
    @Test
    public void test2(){
        Connection connection = null;//取得连接
        try {
            connection = JDBCUtilsByDruid.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String sql = new String("select name from actor where id = ?");
            Object query = queryRunner.query(connection, sql, new ScalarHandler<>(), 2);//回的结果是单行单列的 返回的就是Object对象 使用形参列表中使用的Handler 为new ScalarHandler<>()
            System.out.println(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        JDBCUtilsByDruid.close(null,null,connection);
        }


    }

    /**
     * 使用Apache-DBUtils + Druid 完成DML操作 update delete insert into
     */
    @Test
    public void test4(){
        Connection connection = null;
        try {
            //取得连接
            connection = JDBCUtilsByDruid.getConnection();
            //使用DBUtils的接口和类 执行sql语句
            QueryRunner queryRunner = new QueryRunner();
//            String sql = new String("update actor set name = ? where id = ?");
//            String sql1 = new String("insert into actor values (null,?,?,?,?)");
            String sql2 = new String("delete from actor where name = ?");

            //执行dml的queryRunner.update()
            //返回的结果是受影响的行数
//            int affectedRows = queryRunner.update(connection, sql, "Eddie", 1);
//            int affectedRows1 = queryRunner.update(connection, sql, "Irving", 2);
            int i = queryRunner.update(connection,sql2,"James");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        JDBCUtilsByDruid.close(null,null,connection);
        }


    }
}
