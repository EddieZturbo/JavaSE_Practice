package collectionexercise;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author EddieZhang
 * @create 2022-08-16 8:37
 */
public class CollectionExerciseTestTest {


    /**
     * 请把学生名与考试分数录入到集合中，并按分数显示前三名成绩学员的名字
     */
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(new Students("张锦豪",99,1001));
        list.add(new Students("欧文",89,1002));
        list.add(new Students("詹姆斯",95,1003));
        list.add(new Students("库里",90,1004));
        list.add(new Students("杜兰特",90,1005));
        list.add(new Students("东七七",88,1006));
        list.add(new Students("哈登",83,1007));
        list.add(new Students("保罗",87,1008));
        list.add(new Students("莱昂纳德",93,1009));
        list.add(new Students("布克",91,1010));
        list.add(new Students("塔图姆",85,1011));
        Collections.sort(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Students && o2 instanceof Students){
                    Students students1 = (Students)o1;
                    Students students2 = (Students)o2;
                    return -Integer.compare(students1.getScore(),students2.getScore());

                }
                throw new RuntimeException("输入的数据类型不一致!");
            }
        });
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

    }

    /**
     *
     */
    @Test
    public void test2() throws IOException {
        Properties properties1 = new Properties();
        FileInputStream fileInputStream1 = new FileInputStream("jdbc1.properties");
        properties1.load(fileInputStream1);
        System.out.println(properties1.size());
        System.out.println(properties1);
        Map mapProperties1 = (Map)properties1;
        Set keySet = mapProperties1.keySet();
        System.out.println("一共有: " + keySet.size() + " 个姓氏");
        System.out.println("其中姓氏为张的出现了: " + Collections.frequency(keySet, "张") + " 次");

    }
}