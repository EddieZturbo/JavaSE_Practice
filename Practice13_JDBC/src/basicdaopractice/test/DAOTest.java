package basicdaopractice.test;

/**
 @author EddieZhang
 @create 2022-09-11 21:43
 */

import basicdaopractice.dao.ActorDAO;
import basicdaopractice.dao.GoodsDAO;
import basicdaopractice.dao.StudentDAO;
import basicdaopractice.domain.Actor;
import basicdaopractice.domain.Goods;
import basicdaopractice.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * 对ActorDAO的相关测试
 */
public class DAOTest {
    @Test
    public void test(){
        ActorDAO actorDAO = new ActorDAO();
        //查询多行
        List<Actor> actorDAOS = actorDAO.queryMultiply("select * from actor where id >= ?", Actor.class, 1);
        for (Actor actor :
                actorDAOS) {
            System.out.println(actor);
        }
        //查询单行
        Actor actor = actorDAO.querySingleRow("select * from actor where id = ?", Actor.class, 2);
        System.out.println(actor);
        //查询单行单列
        Object o = actorDAO.queryObject("select name from actor where id = ?", 2);
        System.out.println(o);

        //执行dml操作
        int i = actorDAO.update("insert into actor values (null,?,?,?,?)", "James", "男", "1986-08-09", "12233335555");
        if(i > 0){
            System.out.println("sql语句执行成功");

        }


    }
    @Test
    public void test1(){
        GoodsDAO goodsDAO = new GoodsDAO();
        int i = goodsDAO.create("create table goods (id int,name varchar(100),price double)character set utf8 collate utf8_bin engine innodb");
        int i1 = goodsDAO.update("insert into goods values (?,'华为手机',2000),(?,'苹果手机',3000),(?,'小米手机',2000),(?,'vivo手机',null),(?,'三星手机',2300),(?,'海尔手机',1800),(?,'IBM',5000),(?,'格力手机',null),(?,'格力手机',null)",10,20,30,40,50,60,70,80,80);
        if(i > 0){
            System.out.println("sql语句执行成功");
        }
        List<Goods> goodsList = goodsDAO.queryMultiply("select * from goods where id >= ?", Goods.class, 10);
        for (Goods goods :
                goodsList) {
            System.out.println(goods);
        }
    }
    @Test
    public void test2(){
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.queryMultiply("select * from student where id >= ?", Student.class, 0);
        for (Student students :
                studentList) {
            System.out.println(students);
        }
    }
}
