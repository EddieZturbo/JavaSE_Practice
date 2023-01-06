package generictest.exercise;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * @author EddieZhang
 * @create 2022-08-16 19:59
 */
/*
定义一个测试类：
创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象
 */
public class DAOTest {
    @Test
    public void test(){
        //public void save(String id,T entity)：
        User user = new User(1001,21,"张锦豪");
        User user1 = new User(1002,33,"欧文");
        User user2 = new User(1003,37,"詹姆斯");
        User user3 = new User(1004,34,"杜兰特");
        User user4 = new User(1005,34,"库里");
        User user5 = new User(1006,33,"哈登");
        DAO<User> userDAO = new DAO<User>();
        userDAO.save("01",user);
        userDAO.save("02",user1);
        userDAO.save("03",user2);
        userDAO.save("04",user3);
        userDAO.save("05",user4);
        System.out.println("-----------------------------------------------------------");
        //public T get(String id)：
        System.out.println(userDAO.get("01"));//User{id=1001, age=21, name='张锦豪'}
        System.out.println("-----------------------------------------------------------");
        //public void update(String id,T entity)：
        userDAO.update("01",user5);
        System.out.println(userDAO.get("01"));//User{id=1006, age=33, name='哈登'}
        System.out.println("-----------------------------------------------------------");
        //public List<T> list()：
        List<User> userList = userDAO.list();
        Iterator<User> userIterator1 = userList.iterator();
        while (userIterator1.hasNext()) {
            System.out.println(userIterator1.next());
        }
        //User{id=1006, age=33, name='哈登'}
        //User{id=1002, age=33, name='欧文'}
        //User{id=1003, age=37, name='詹姆斯'}
        //User{id=1004, age=34, name='杜兰特'}
        //User{id=1005, age=34, name='库里'}
        System.out.println("-----------------------------------------------------------");
        //public void delete(String id)：
        userDAO.delete("01");
        //遍历输出操作一
        List<User> users = userDAO.list();
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            System.out.println(userIterator.next());
        }
        //User{id=1002, age=33, name='欧文'}
        //User{id=1003, age=37, name='詹姆斯'}
        //User{id=1004, age=34, name='杜兰特'}
        //User{id=1005, age=34, name='库里'}
        System.out.println("-----------------------------------------------------------");
        //遍历输出操作二
        for (User userList1 :
                users) {
            System.out.println(userList1);
        }
        //User{id=1002, age=33, name='欧文'}
        //User{id=1003, age=37, name='詹姆斯'}
        //User{id=1004, age=34, name='杜兰特'}
        //User{id=1005, age=34, name='库里'}
        System.out.println("-----------------------------------------------------------");
        //遍历输出操作三
        users.forEach(System.out::println);
        //User{id=1002, age=33, name='欧文'}
        //User{id=1003, age=37, name='詹姆斯'}
        //User{id=1004, age=34, name='杜兰特'}
        //User{id=1005, age=34, name='库里'}

    }
}
