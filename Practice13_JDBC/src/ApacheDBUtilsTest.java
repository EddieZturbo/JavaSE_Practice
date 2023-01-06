/**
 @author EddieZhang
 @create 2022-09-10 23:06
 */

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Apache的DBUtils工具类 + druid（连接池） 完成对表的crud
 */
@SuppressWarnings(value = "all")
public class ApacheDBUtilsTest {
    @Test
    public void test() {
        Connection connection = null;
        try {
            //得到连接（druid）
            connection = JDBCUtilsByDruid.getConnection();
            //使用DBUtils 类和接口
            //创建QueryRunner类--该类封装了SQL的执行，是线程安全的。可以实现 增删改查插 批处理
            QueryRunner queryRunner = new QueryRunner();
            String sql = "select id,name,sex,borndate from actor where id >= ?";
            /*
                query方法就是执行sql语句，得到resultset --- 封装到 --> ArrayList 集合中 并返回集合
                形参列表解读
                query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params)

                Connection conn:连接
                String sql:sql语句
                ResultSetHandler<T> rsh:new BeanListHandler<>(Actor.class)将resultset -> Actor对象 -> 封装到ArrayList中
                    //底层用到反射机制 获取Actor的属性 然后进行封装
                Object... params:？的赋值 是可变形参 可以根据第几个进行赋值

                底层会自动关闭resultset资源以及prepareStaement资源
             */
            List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
            for (Actor actor :
                    list) {
                System.out.println(actor);
                //Actor{id=1, name='张锦豪', sex='男', borndate=2000-12-07, phone='null'}//可以指定查询列 没有查询的列就默认返回null
                //Actor{id=2, name='欧文', sex='男', borndate=1989-02-05, phone='null'}
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源（只用关闭connection）
            JDBCUtilsByDruid.close(null, null, connection);
        }
        /*

        * 分析 queryRunner.query 方法:
        * public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws
        SQLException {
        * PreparedStatement stmt = null;//定义 PreparedStatement
        * ResultSet rs = null;//接收返回的 ResultSet
        * Object result = null;//返回 ArrayList
        *
        * try {
        * stmt = this.prepareStatement(conn, sql);//创建 PreparedStatement
        * this.fillStatement(stmt, params);//对 sql 进行 ? 赋值
        * rs = this.wrap(stmt.executeQuery());//执行 sql,返回 resultset
        * result = rsh.handle(rs);//返回的 resultset --> arrayList[result] [使用到反射，对传入 class 对象
                        处理]
        * } catch (SQLException var33) {
        * this.rethrow(var33, sql, params);
        * } finally {
        * try {
        * this.close(rs);//关闭 resultset
                                    * } finally {
        * this.close((Statement)stmt);//关闭 preparedstatement 对象
        * }
        * }
        *
        * return result;
        * }
        */
    }
}
