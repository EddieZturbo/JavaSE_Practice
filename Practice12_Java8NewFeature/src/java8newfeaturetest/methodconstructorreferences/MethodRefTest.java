package java8newfeaturetest.methodconstructorreferences;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 */
public class MethodRefTest {

    // 情况一：对象 :: 实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1() {
        //Lambda表达式写法
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("EddieZhang--Java");//EddieZhang--Java
        //方法引用写法--对象::实例方法名
        PrintStream printStream = System.out;
        Consumer<String> consumer1 = printStream::println;//--PrintStream中的void println(T t)
        consumer.accept("Irving--Basketball");//Irving--Basketball
    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2() {
        //Lambda表达式写法
        Employee employee = new Employee(1001, "Eddie", 21, 16000);
        Supplier<Object> stringSupplier = () -> employee.getSalary();
        System.out.println(stringSupplier.get());//Eddie
        //方法引用写法--对象::实例方法名
        Supplier<Object> objectSupplier = employee::getId;
        System.out.println(objectSupplier.get());//1001


    }

    // 情况二：类 :: 静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3() {
        //Lambda表达式写法
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator.compare(25, -65));//1
        //方法引用写法--类 :: 静态方法
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(15, -68));//1
    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4() {
        //Lambda表达式写法
        Function<Double, Long> function = d1 -> Math.round(d1);
        System.out.println(function.apply(15.6));//16
        //方法引用写法--类 :: 静态方法
        Function<Double, Long> function1 = Math::round;
        System.out.println(function1.apply(19.5));//20

    }

    // 情况三：类 :: 实例方法
    // Comparator中的int comapre(T t1,T t2)
    // String中的int t1.compareTo(t2)
    @Test
    public void test5() {
        //Lambda表达式写法
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator.compare("abc", "abb"));//1
        //方法引用写法--类 :: 实例方法
        Comparator<String> comparator1 = String::compareTo;
        System.out.println(comparator1.compare("abc", "cbd"));//-2
    }

    //BiPredicate中的boolean test(T t1, T t2);
    //String中的boolean t1.equals(t2)
    @Test
    public void test6() {
        //Lambda表达式写法
        BiPredicate<String, String> biPredicate = (str1, str2) -> str1.equals(str2);
        System.out.println(biPredicate.test("EddieZhang", "EddieZhang"));//true
        //方法引用写法--类 :: 实例方法
        BiPredicate<String, String> biPredicate1 = String::equals;
        System.out.println(biPredicate1.test("Irving", "Irving8"));//false
    }

    // Function中的R apply(T t)
    // Employee中的String getName();
    @Test
    public void test7() {
        Employee employee = new Employee(1001, "EddieZhang", 21, 17500);
        //Lambda写法
        Function<Employee, String> function = s -> employee.getName();
        System.out.println(function.apply(employee));//EddieZhang
        //方法引用写法
        Function<Employee, String> function1 = Employee::getName;
        System.out.println(function1.apply(employee));//EddieZhang


    }

}
