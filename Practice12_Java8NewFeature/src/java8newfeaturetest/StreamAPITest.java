package java8newfeaturetest;

/**
 @author EddieZhang
 @create 2022-08-24 14:27
 */

import java8newfeaturetest.methodconstructorreferences.Employee;
import java8newfeaturetest.methodconstructorreferences.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream:
 * 是数据渠道;用于操作数据源（集合，数组等）所生产的元素序列
 * Stream和Collection集合的区别:Collection是一种静态的内存数据结构，而Stream是有关计算的。前者主要面向内存，储存在内存中。后者主要面向CPU，通过CPU实现计算。
 * ”集合将讲的是数据,Stream讲的是计算“
 * 1.Stream自己不会储存元素
 * 2.Stream不会改变源对象。相反，会返回一个持有结果的新Stream。
 * 3.Stream操作是延迟执行的，这意味着他们会等到需要结果的时候才执行
 *      ①创建Stream（创建Stream--一个数据源（如：集合，数组）获取一个Stream）（数据源）-->
 *      ②中间操作（filter过滤，map映射，...对数据源进行处理的操作）-->
 *      ③ 终止操作(终端操作)（一旦执行终止操作，就执行中间的操作链。产生结果后，不再会被使用）
 *
 * Stream的创建方式
 * 1.通过集合
 * 2.通过数组
 * 3.通过Stream的of()
 * 4.创建无限流
 *      可以使用静态方法 Stream.iterate() 和 Stream.generate()
 *
 * Stream的中间操作--
 *      多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理！而在终止操作时一次性全部处理，称为“惰性求值”
 * 1.筛选与切片
 *      filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
 *      distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
 *      limit(long maxSize) 截断流，使其元素不超过给定数量
 *      skip(long n)跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
 * 2.映射
 * 3.排序
 *
 */
public class StreamAPITest {
    /*
        创建Stream
            Stream的创建方式
            1.通过集合
                Java8 中的 Collection 接口被扩展，提供了两个获取流的方法
                    default Stream<E> stream() : 返回一个顺序流
                    default Stream<E> parallelStream() : 返回一个并行流
            2.通过数组
                Java8 中的 Arrays 的静态方法 stream() 可以获取数组流：重载形式，能够处理对应基本类型的数组
                    static <T> Stream<T> stream(T[] array): 返回一个流
            3.通过Stream的of()
                可以调用Stream类静态方法 of(), 通过显示值创建一个流。它可以接收任意数量的参数
                    public static<T> Stream<T> of(T... values) : 返回一个流
            4.创建无限流--帮助我们来创造数据
                可以使用静态方法 Stream.iterate() 和 Stream.generate(), 创建无限流
                    迭代:public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
                    生成:public static<T> Stream<T> generate(Supplier<T> s)
     */
    @Test
    public void test(){
        //1.通过集合
        List<Employee> employeeList = EmployeeData.getEmployees();
            //default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> employeeStream = employeeList.stream();
            //default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream = employeeList.parallelStream();
        //2.通过数组
        int[] numberArray = new int[]{1,2,5,6,8,-5,4,5,33,546,3};
        String[] stringsArray = new String[]{"Eddie","James","Irving","Curry","Durant"};
        double[] longsArray = new double[]{12.5,56.4,553.5,66.5,54654.5};
            //static <T> Stream<T> stream(T[] array): 返回一个流;重载形式，能够处理对应基本类型的数组：
        IntStream intStream = Arrays.stream(numberArray);
        Stream<String> stringStream = Arrays.stream(stringsArray);
        DoubleStream doubleStream = Arrays.stream(longsArray);
        //3.通过Stream的of()
            //public static<T> Stream<T> of(T... values) : 返回一个流
        Stream<Integer> integerStream = Stream.of(1,5,3,5,1,2,5,8,4,54,56,5);
        Stream<String> stringStream1 = Stream.of("Eddie", "Irving", "James", "Curry", "Durant");
        //4.创建无限流
            //迭代:public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
            Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);//遍历前十个偶数
            //迭代条件----------------------------迭代限制----------------终止操作
            //生成:public static<T> Stream<T> generate(Supplier<T> s)
            Stream.generate(Math::random).limit(10).forEach(System.out::println);//随机生成10个数
            //生成条件----------------------------迭代限制----------------终止操作


    }

    /*
        Stream的中间操作
            1.筛选与切片
            2.映射
            3.排序
     */
    @Test
    public void test1(){
        //1.筛选与切片
        List<Employee> employees = EmployeeData.getEmployees();
        System.out.println("------------------------------------映射-------------------------------");
            //filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
        employees.stream().filter(employee -> employee.getSalary() > 7000).forEach(System.out::println);
        //创建流--------------中间操作（filter筛选）------------------------------终止操作
            //Employee{id=1002, name='马云', age=12, salary=9876.12}
            //Employee{id=1004, name='雷军', age=26, salary=7657.37}
            //Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}
        System.out.println("-------------------------------------------------------------");
            //limit(long maxSize) 截断流，使其元素不超过给定数量
         employees.stream().limit(3).forEach(System.out::println);//--注意以上Stream已经执行终止操作；不可再次使用；而需要新造一个Stream。
        //创建流-------中间操作（limit(long maxSize) 截断流）---终止操作
            //Employee{id=1001, name='马化腾', age=34, salary=6000.38}
            //Employee{id=1002, name='马云', age=12, salary=9876.12}
            //Employee{id=1003, name='刘强东', age=33, salary=3000.82}
        System.out.println("--------------------------------------------------------------");
            //skip(long n)跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        employees.stream().skip(3).forEach(System.out::println);
        //创建流--------中间操作（skip(long n)跳过元素）---终止操作
            //Employee{id=1004, name='雷军', age=26, salary=7657.37}
            //Employee{id=1005, name='李彦宏', age=65, salary=5555.32}
            //Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}
            //Employee{id=1007, name='任正非', age=26, salary=4333.32}
            //Employee{id=1008, name='扎克伯格', age=35, salary=2500.32}
        System.out.println("--------------------------------------------------------------");
            //distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        employees.add(new Employee(1010,"张锦豪",21,16000));//向集合中添加几个相同的数据
        employees.add(new Employee(1010,"张锦豪",21,16000));
        employees.add(new Employee(1010,"张锦豪",21,16000));
        employees.add(new Employee(1010,"张锦豪",21,16000));
        employees.add(new Employee(1010,"张锦豪",21,16000));
        employees.stream().distinct().forEach(System.out::println);
        //创建流--------中间操作（distinct() 筛选）---终止操作
        //Employee{id=1001, name='马化腾', age=34, salary=6000.38}
        //Employee{id=1002, name='马云', age=12, salary=9876.12}
        //Employee{id=1003, name='刘强东', age=33, salary=3000.82}
        //Employee{id=1004, name='雷军', age=26, salary=7657.37}
        //Employee{id=1005, name='李彦宏', age=65, salary=5555.32}
        //Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}
        //Employee{id=1007, name='任正非', age=26, salary=4333.32}
        //Employee{id=1008, name='扎克伯格', age=35, salary=2500.32}
        //Employee{id=1010, name='张锦豪', age=21, salary=16000.0}
        System.out.println("------------------------------------映射-------------------------------");
        //2.映射
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("google");
        stringList.add("amazon");
        stringList.add("microsoft");
            //map(Function f)接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
        stringList.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        //创建流---------------中间操作（map(Function f)接收一个函数作为参数）-----------终止操作
        //APPLE
        //GOOGLE
        //AMAZON
        //MICROSOFT
        System.out.println("----------------------------------------------------------------------");
        //practice获取员工name长度大于三的员工数据
        List<Employee> employeeList = EmployeeData.getEmployees();//创建集合将员工数据储存进集合中
        Stream<String> namesStream = employeeList.stream().map(employee -> employee.getName());//创建员工数据流-->使用中间操作映射map（）方法获取员工的姓名Steam
        Stream<String> stream = namesStream.filter(names -> names.length() > 3);//使用中间操作filter()筛选出名字长度大于三的员工姓名
        stream.forEach(System.out::println);//终止操作
        //比尔盖茨
        //扎克伯格
        System.out.println("---------------------------------------------------------------------");
            //flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流--集合中含集合的优先使用
                    //类似于addAll(arrayList)将添加的集合所有元素打散添加于一个集合中--区别于add(arrayList)将加入的集合按照一个元素进行添加
        List arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        List arrayList1 = new ArrayList();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList.add(arrayList1);
        System.out.println(arrayList);//[1, 2, 3, [1, 2, 3]]//将加入的集合看作一个元素进行添加
        arrayList.addAll(arrayList1);
        System.out.println(arrayList);//[1, 2, 3, [1, 2, 3], 1, 2, 3]//将添加的集合所有元素打散添加于一个集合中
        System.out.println("---------------------------------------------------------------");
        //将字符串中的多个字符构成的集合转换为对应的Stream的实例
        Stream<Character> characterStream = stringList.stream().flatMap(StreamAPITest::fromStringToStream);//方法引用--类::静态方法名
        characterStream.forEach(System.out::println);

        System.out.println("------------------------------------排序-------------------------------");
        //3.排序
        List<Integer> integerList = new ArrayList<>();
        integerList.add(56);
        integerList.add(5);
        integerList.add(-68);
        integerList.add(546);
        integerList.add(-648);
        integerList.add(-35);
        integerList.add(0);
        integerList.add(354);

        List<Employee> employeeList1 = EmployeeData.getEmployees();
        Stream<Employee> employeeStream = employeeList1.stream();
        //sorted() 产生一个新流，其中按自然顺序排序
        integerList.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
        employeeStream.sorted((e1,e2) -> {//Lambda表达式写法
            int compare = Integer.compare(e1.getAge(), e2.getAge());
            if(compare != 0){
                return compare;
            }else{
                return -Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out::println);//按照年龄进行升序排序--若年龄相等按照工资进行降序排序

//        employeeStream.sorted(new Comparator<Employee>() {--标准写法
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                int compare = Integer.compare(o1.getAge(), o2.getAge());
//                if(compare != 0){
//                    return compare;
//                }else{
//                    return -Double.compare(o1.getSalary(),o2.getSalary());
//                }
//            }
//        }).forEach(System.out::println);//按照年龄进行升序排序--若年龄相等按照工资进行降序排序




    }
    /*
        //将字符串中的多个字符构成的集合转换为对应的Stream的实例
     */
    public static Stream<Character> fromStringToStream(String str1){
        List<Character> characterList = new ArrayList<>();
        for (Character charList :
                str1.toCharArray()) {
            characterList.add(charList);
        }

        return characterList.stream();
    }

    /*
        Stream的终止操作
            1.匹配与查找
            2.归约
            3.收集
     */
    @Test
    public void test2(){
        List<Employee> employeeList = EmployeeData.getEmployees();
        //1.匹配与查找
        //匹配
        System.out.println("---------------------------------匹配---------------------------------------------");
            //allMatch(Predicate p) 检查是否匹配所有元素
        System.out.println(employeeList.stream().allMatch(employee -> employee.getAge() > 18));//检查所有员工的年龄是否都大于18
        //false
        System.out.println(employeeList.stream().allMatch(employee -> employee.getSalary() > 2000));//检查所有员工的工资是否都大于5000
        //true
        System.out.println("------------------------------------------------------------------------------");
            //noneMatch(Predicate p) 检查是否没有匹配所有元素
        System.out.println(employeeList.stream().noneMatch(employee -> employee.getName().startsWith("雷")));//检查所有员工中是否没有一个姓雷的
        //false
        System.out.println("------------------------------------------------------------------------------");
            //anyMatch(Predicate p) 检查是否至少匹配一个元素
        System.out.println(employeeList.stream().anyMatch(employee -> employee.getName().startsWith("马")));//检查所有员工中是否至少有一个姓马的
        //true

        //查找
        System.out.println("---------------------------------查找---------------------------------------------");
            //findFirst() 返回第一个元素
        System.out.println(employeeList.stream().findFirst());//查找所有员工中第一个员工的信息
        //Optional[Employee{id=1001, name='马化腾', age=34, salary=6000.38}]
            //findAny() 返回当前流中的任意元素
        System.out.println(employeeList.stream().findAny());//其中stream()为串行流（顺序流）--通常随机返回第一个
        //Optional[Employee{id=1001, name='马化腾', age=34, salary=6000.38}]
        System.out.println(employeeList.parallelStream().findAny());//其中parallelStream()为平行流--通常不按照顺序随机返回
        //Optional[Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}]

        //元素总数
        System.out.println("---------------------------------元素总数---------------------------------------------");
            //count() 返回流中元素总数
        System.out.println(employeeList.stream().count());
        //8
            //count() 返回流中工资大于5000的元素个数
        //5
        System.out.println(employeeList.stream().filter(employee -> employee.getSalary() > 5000).count());


        //最大值
        System.out.println("---------------------------------最大值---------------------------------------------");
            //max(Comparator c) 返回流中最大值
        Stream<Double> doubleStream = employeeList.stream().map(employee -> employee.getSalary());//获取员工的工资流
        System.out.println(doubleStream.max((s1, s2) -> Double.compare(s1, s2)));//max()获取最大的工资金额
        //Optional[9876.12]

        //最小值
        System.out.println("---------------------------------最小值---------------------------------------------");
            //min(Comparator c) 返回流中最小值
        System.out.println(employeeList.stream().min((p1, p2) -> Double.compare(p1.getSalary(), p2.getSalary())));//按照员工的salary进行升序排序 min()返回最小值
        //Optional[Employee{id=1008, name='扎克伯格', age=35, salary=2500.32}]

        //内部迭代
        System.out.println("---------------------------------内部迭代---------------------------------------------");
            //forEach(Consumer c)内部迭代Stream API 使用内部迭代——它帮你把迭代做了--使用 Collection 接口需要用户去做迭代，称为外部迭代。
        employeeList.stream().forEach(System.out::println);//遍历流
        //Employee{id=1001, name='马化腾', age=34, salary=6000.38}
        //Employee{id=1002, name='马云', age=12, salary=9876.12}
        //Employee{id=1003, name='刘强东', age=33, salary=3000.82}
        //Employee{id=1004, name='雷军', age=26, salary=7657.37}
        //Employee{id=1005, name='李彦宏', age=65, salary=5555.32}
        //Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}
        //Employee{id=1007, name='任正非', age=26, salary=4333.32}
        //Employee{id=1008, name='扎克伯格', age=35, salary=2500.32}

        //2.归约
        System.out.println("---------------------------------归约---------------------------------------------");
            //reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        Stream<Double> doubleStream1 = employeeList.stream().map(employee -> employee.getSalary());//map()映射出所有员工的工资流
        System.out.println(doubleStream1.reduce(Double::sum));//reduce(初始值,操作数据)将流中的合结合起来得到一个总和
//        System.out.println(doubleStream1.reduce((d1, d2) -> d1 + d2));//手动写的
        //48424.08
            //reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(integerList.stream().reduce(0, Integer::sum));//遍历自然数1-10的和
        //55

        //3.收集
        //collect(Collector c)将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        //Collectors 实用类提供了很多静态方法，可以方便地创建常见收集器实例
//        toList List<T> 把流中元素收集到List
//        List<Employee> emps= list.stream().collect(Collectors.toList());
//        toSet Set<T> 把流中元素收集到Set
//        java.util.Set<Employee> emps= list.stream().collect(Collectors.toSet());
//        toCollection Collection<T> 把流中元素收集到创建的集合
//        java.util.Collection<Employee> emps =list.stream().collect(Collectors.toCollection(ArrayList::new));

        System.out.println("---------------------------------收集---------------------------------------------");
        List<Employee> collect = employeeList.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());//将工资大于6000的员工收集于List中
        collect.forEach(System.out::println);
        //Employee{id=1001, name='马化腾', age=34, salary=6000.38}
        //Employee{id=1002, name='马云', age=12, salary=9876.12}
        //Employee{id=1004, name='雷军', age=26, salary=7657.37}
        //Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}


    }
}
