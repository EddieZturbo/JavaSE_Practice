package collectionexercise;

import java.util.*;

/**
 * @author EddieZhang
 * @create 2022-08-16 8:24
 */
public class CollectionExerciseTest {
    public static void main(String[] args) {
//        /**
//         * 1.请从键盘随机输入10个整数保存到List中，并按倒序、从大到小的顺序显示出来
//         */
//        Scanner scanner = new Scanner(System.in);
//        List list = new ArrayList();
//        for (int i = 0;;i++){
//            System.out.print("请输入整数(输入-1结束输入):");
//            int nextInt = scanner.nextInt();
//            if(nextInt == -1){
//                break;
//            }
//            list.add(nextInt);
//        }
//        Collections.sort(list, new Comparator<Object>() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                if(o1 instanceof Integer && o2 instanceof Integer){
//                    Integer integer1 = (Integer) o1;
//                    Integer integer2 = (Integer) o2;
//                    return -Integer.compare(integer1,integer2);
//                }
//                throw new RuntimeException("输入的数据类型不一致！");
//            }
//        });
//        List subList = list.subList(0, 3);
//        subList.forEach(System.out::println);
//        scanner.close();


        System.out.println("-----------------------------------------------------------------------------------------");
        /**
         * 请把学生名与考试分数录入到集合中，并按分数显示前三名成绩学员的名字
         */
        ArrayList arrayList = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生的姓名成绩等信息(输入-1结束录入):");
        for(int i = 0;i < 10;i++){
            System.out.print("Number:");int number = scanner.nextInt();
            if(number == -1){
                break;
            }
            System.out.print("(" + number + ") " + "Name:");String name = scanner.next();
            System.out.print("(" + name + ") " + "Score:");int score = scanner.nextInt();
            Students students = new Students(name,score,number);
            arrayList.add(students);
        }
        Collections.sort(arrayList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Students && o2 instanceof Students){
                    Students students1 = (Students) o1;
                    Students students2 = (Students) o2;
                    return -Integer.compare(students1.getScore(),students2.getScore());//按照成绩从高到底排序
                }
                throw new RuntimeException("输入的数据类型不一致！！");
            }
        });
        List subList = arrayList.subList(0, 3);
        subList.forEach(System.out::println);


        scanner.close();
    }
    public void test(){


    }
}
