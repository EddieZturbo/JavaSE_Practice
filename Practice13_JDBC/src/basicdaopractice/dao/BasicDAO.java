package basicdaopractice.dao;

/**
 @author EddieZhang
 @create 2022-09-11 21:16
 */

import basicdaopractice.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 开发BasicDAO 是其他DAO的父类
 *
 */
public class BasicDAO<T> {//泛型指定具体的类型
    private QueryRunner queryRunner = new QueryRunner();

    public int create(String sql) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            return queryRunner.update(connection, sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //开发通用的呃dml方法
    public int update(String sql, Object... parameters) {//形参列表传入sql语句 以及相关的参数
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            int i = queryRunner.update(connection, sql, parameters);
            return i;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //select返回多个对象（多行）针对 任意表
    public List<T> queryMultiply(String sql, Class<T> tClass, Object... parameters) {//形参列表传入sql语句 一个类 的Class对象 以及相关的参数
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> tList = queryRunner.query(connection, sql, new BeanListHandler<T>(tClass), parameters);
            return tList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }

    }

    //select返回单个（单行）针对 任意表
    public T querySingleRow(String sql, Class<T> tClass, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            T t = queryRunner.query(connection, sql, new BeanHandler<T>(tClass), parameters);
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }

    }

    //select返回单个（单行单列）Object 针对 任意表
    public Object queryObject(String sql, Object... parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            T t = queryRunner.query(connection, sql, new ScalarHandler<T>(), parameters);
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }

    }

}
