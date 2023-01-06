package java8newfeaturetest;

/**
 @author EddieZhang
 @create 2022-08-21 12:09
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**     Java8新特性
 * Lambda 表达式
 * Lambda 是一个匿名函数，我们可以把 Lambda 表达式理解为是一段可以传递的代码（将代码像数据一样进行传递）。使用它可以写出更简洁、
 * 更灵活的代码。作为一种更紧凑的代码风格，使Java的语言表达能力得到了提升
 * Lambda 表达式：在Java 8 语言中引入的一种新的语法元素和操作符。
 * 这个操作符为 “->” ， 该操作符被称为 Lambda 操作符或箭头操作符。
 * 它将 Lambda 分为两个部分：
 * 左侧：指定了 Lambda 表达式需要的参数列表
 * 右侧：指定了 Lambda 体，是抽象方法的实现逻辑，也即Lambda 表达式要执行的功能
 * For instance:(o1,o2) -> Integer.compare(o1,o2)
 * Lambda表达式语法格式的6种情况（总结）
 *      ->左侧:Lambda形参列表的数据类型可以省略(类型推断),当只有一个参数时 () 可以省略
 *      ->右侧:Lambda体应该由一对{}包裹;如果只有一条执行语句(可能是return语句)可以省略{}以及return关键字;
 *
 * Lambda表达式的本质:作为(函数式接口)接口的实例
 *      其中:接口要求只有一个抽象方法的(函数式接口--只有一个抽象方法
 * 当需要创建一个函数式接口的匿名实现类时即可选择使用Lambda表达式来实现
 */
public class LambdaTest {
    //Lambda表达式举例
    @Test
    public void test(){
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("EddieZhang");
            }
        };
        runnable1.run();//EddieZhang
        System.out.println("---------------------------------------使用lambda表达式后---------------------------------------");
        Runnable runnable2 = () -> {
            System.out.println("Irving");
        };
        runnable2.run();//Irving

    }

    /**
     * 语法格式一：无参，无返回值
     */
    @Test
    public void test1(){
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {//无参，无返回值
                System.out.println("EddieZhang");
            }
        };
        runnable1.run();//EddieZhang
        System.out.println("---------------------------------------使用lambda表达式后---------------------------------------");
        Runnable runnable2 = () -> {
            System.out.println("Irving");
        };////无参，无返回值
        runnable2.run();//Irving

    }
    /**
     * 语法格式一：无参，有返回值
     */
    @Test
    public void test2(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Hello Eddie!!");
        //Hello Eddie!!
        System.out.println("---------------------------------------使用lambda表达式后---------------------------------------");
        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };
        consumer.accept("Hello Irving!!");
        //Hello Irving!!
    }
    /**
     * 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
     */
    @Test
    public void test3(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Hello Eddie!!");
        //Hello Eddie!!
        System.out.println("---------------------------------------使用lambda表达式后---------------------------------------");
        Consumer<String> consumer1 = (s) -> {//类型推断
            System.out.println(s);
        };
        consumer.accept("Hello Irving!!");
        //Hello Irving!!
    }
    /**
     * 语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
     */
    @Test
    public void test4(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Hello Eddie!!");
        //Hello Eddie!!
        System.out.println("---------------------------------------使用lambda表达式后---------------------------------------");
        Consumer<String> consumer1 = s -> {//类型推断//若只需要一个参数时，参数的小括号可以省略
            System.out.println(s);
        };
        consumer.accept("Hello Irving!!");
        //Hello Irving!!
    }
    /**
     * 语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
     */
    @Test
    public void test5(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(15, 65));
        //15
        //65
        //-1
        System.out.println("---------------------------------------使用lambda表达式后---------------------------------------");
        Comparator<Integer> comparator1 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);

        };
        System.out.println(comparator1.compare(56, -46));
        //56
        //-46
        //1
    }
    /**
     * 语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
     */
    @Test
    public void test6(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(15, 65));
        //-1
        System.out.println("---------------------------------------使用lambda表达式后---------------------------------------");
        Comparator<Integer> comparator1 = (o1,o2) ->  o1.compareTo(o2);//当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
        System.out.println(comparator1.compare(56, -46));
        //1
    }

}
