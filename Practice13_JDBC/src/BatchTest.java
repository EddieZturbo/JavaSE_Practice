/**
 @author EddieZhang
 @create 2022-09-09 16:55
 */

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * batch
 * 批量处理
 */
public class BatchTest {
    /*
     * @Description 未使用batch批处理进行测试
     * @Author EddieZhang
     * @Date 2022/9/9 17:05
     * @Since version-1.0
     */
    @Test
    public void noBatchTest() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        long start = System.currentTimeMillis();
        String str = "insert into admin values (null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(str);
        int i1 = 0;
        for(int i  = 0;i < 10000;i++){
            preparedStatement.setString(1,"Eddie" + i);
            preparedStatement.setString(2,"password" + i);
            i1 = preparedStatement.executeUpdate();
        }
        if(i1 > 0){
            System.out.println("sql执行成功~~");
        }

        long end = System.currentTimeMillis();

        System.out.println("本次执行用时 " + (end - start) + "秒~~");
        preparedStatement.close();
        connection.close();


    }
    
    /*
     * @Description 使用batch批处理进行测试
     * @Author EddieZhang
     * @Date 2022/9/9 17:06
     * @Since version-1.0
     */
    @Test
    public void BatchTest() throws Exception{
        Connection connection = JDBCUtils.getConnection();
        long start = System.currentTimeMillis();
        String str = "insert into admin values (null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(str);

        for(int i  = 0;i < 100000;i++){
            preparedStatement.setString(1,"Eddie" + i);
            preparedStatement.setString(2,"password" + i);
            preparedStatement.addBatch();//将执行语句添加至Batch
            if((i + 1) % 1000 == 0){//当执行的sql语句达到1000条时就批量执行一次
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();//执行完之后要清空
            }
        }


        long end = System.currentTimeMillis();

        System.out.println("本次执行用时 " + (end - start) + "秒~~");
        preparedStatement.close();
        connection.close();
    }
    /*
     * @Description 使用batch批处理进行测试
     * @Author EddieZhang
     * @Date 2022/9/9 17:06
     * @Since version-1.0
     */
    @Test
    public void BatchTest1() throws Exception{
        //使用JDBCUtils取得和数据库的连接
        Connection connection = JDBCUtils.getConnection();
        long start = System.currentTimeMillis();
        //获得PrepareStatement执行sql语句的对象
        PreparedStatement preparedStatement = connection.prepareStatement("insert into admin values (null,?,?)");
        for (int i = 0; i < 100000; i++) {//使用循环 给preparedStatement的？赋值
            preparedStatement.setString(1,"Eddie" + i);
            preparedStatement.setString(2,"Irving" + i);
            preparedStatement.addBatch();//将preparedStatement的批量执行语句添加至Batch中
            /*
                将sql语句放入批处理包中 源码分析--批量处理会减少我们发送 sql 语句的网络开销，而且减少编译次数，因此效率提高
                      ①创建一个Arraylist elementData=>Object[]
                      ②elementData=>Object[]（初始容量为10）存放preparedStatement预处理的sql语句
                      ③elementData=>Object[]（初始容量为10）满后就进行1.5倍扩容
                      ④当添加到指定的值后就进行executeBatch
             */
            if((1 + i)%1000 == 0){//设置批量添加的形式--每1000天执行语句进行一次批量处理
                preparedStatement.executeBatch();//进行批量执行处理
                preparedStatement.clearBatch();//执行完后要清空Batch
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("本次执行共计用时" + (end - start) + "毫秒");
        preparedStatement.close();
        connection.close();

    }
}



