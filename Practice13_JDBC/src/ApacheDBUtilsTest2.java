/**
 @author EddieZhang
 @create 2022-09-21 0:01
 */

import basicdaopractice.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 使用Apache的DBUtils + Druid连接池
 */
public class ApacheDBUtilsTest2 {
    @Test
    public void test() {
        Connection connection = null;
        try {
            //使用Druid取得数据库的连接
            connection = JDBCUtilsByDruid.getConnection();
            //使用DBUtils的实现类QueryRunner实现查询
            QueryRunner queryRunner = new QueryRunner();
            //多行查询
            List<Actor> actorList = queryRunner.query(connection, "select * from actor where id >= ?", new BeanListHandler<>(Actor.class), 1);
            for (Actor actors :
                    actorList) {
                System.out.println(actors);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭连接
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
    @Test
    public void test1(){
        Connection connection = null;
        try {
            //使用Druid取得连接
            connection = JDBCUtilsByDruid.getConnection();
            //使用DBUtils的实现类QueryRunner实现update操作
            QueryRunner queryRunner = new QueryRunner();
            queryRunner.update(connection,"insert into actor values (null,'Curry','男','1989-05-06','12344446666')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        //关闭连接
        JDBCUtilsByDruid.close(null,null,connection);
        }
    }
}
