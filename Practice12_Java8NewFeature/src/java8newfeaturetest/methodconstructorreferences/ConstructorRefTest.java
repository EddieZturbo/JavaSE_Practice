package java8newfeaturetest.methodconstructorreferences;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 * 格式:ClassName::new
 * 与函数式接口相结合，自动与函数式接口中的方法兼容。
 * 可以把构造器引用赋值给定义的方法;
 * 要求:构造器参数列表要与接口中抽象方法的参数列表一致！且方法的返回值即为构造器对应类的对象
 *
 * 二、数组引用
 * 格式:type[]::new
 * 可以把数组看作一个特殊的类;写法与构造器引用一致.
 *
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的T get()
    @Test
    public void test1() {
        //常规写法
        Supplier<Employee> supplier = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        //Lambda表达式写法
        Supplier<Employee> supplier1 = () -> new Employee();
        System.out.println(supplier1.get());
        System.out.println("-----------------------------");

        //构造器引用写法
        Supplier<Employee> supplier2 = Employee::new;
        System.out.println(supplier2.get());

    }

    //Function中的R apply(T t)
    @Test
    public void test2() {
        //常规写法
        Function<Integer,Employee> function = new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer integer) {
                return new Employee(integer);
            }
        };
        Employee employee1 = function.apply(1002);
        System.out.println(employee1);
        System.out.println("-----------------------------");
        //Lambda表达式写法
        Function<Integer,Employee> function1 = id -> new Employee(id);
        Employee employee = function1.apply(1001);
        System.out.println(employee);
        System.out.println("-------------------------------------");
        //构造器引用写法
        Function<Integer,Employee> function2 = Employee::new;
        Employee employee2 = function2.apply(1003);
        System.out.println(employee2);


    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3() {
        //常规写法
        BiFunction<Integer,String,Employee> biFunction = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer integer, String s) {
                return new Employee(integer,s);
            }
        };
        Employee employee = biFunction.apply(1001, "Eddie");
        System.out.println(employee);
        System.out.println("-------------------------");
        //Lambda表达式写法
        BiFunction<Integer,String,Employee> biFunction1 = (id,name) -> new Employee(id,name);
        Employee employee1 = biFunction1.apply(1002, "James");
        System.out.println(employee1);
        System.out.println("-----------------------------");
        //构造器引用写法
        BiFunction<Integer,String,Employee> biFunction2 = Employee::new;
        Employee employee2 = biFunction2.apply(1003, "Irving");
        System.out.println(employee2);


    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4() {
        //常规写法
        Function<Integer,String[]> function = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer];
            }
        };
        String[] strings = function.apply(10);
        System.out.println("数组的长度为:" + strings.length);
        System.out.println(Arrays.toString(strings));
        System.out.println("----------------------------");
        //Lambda表达式写法
        Function<Integer,String[]> function1 = integer -> new String[integer];
        String[] strings1 = function1.apply(20);
        System.out.println("数组的长度为:" + strings1.length);
        System.out.println(Arrays.toString(strings1));
        System.out.println("------------------------------");
        //构造器引用写法
        Function<Integer,String[]> function2 = String[]::new;
        String[] strings2 = function2.apply(30);
        System.out.println("数组的长度为:" + strings2.length);
        System.out.println(Arrays.toString(strings2));


    }
}
