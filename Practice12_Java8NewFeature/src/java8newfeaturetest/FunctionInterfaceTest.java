package java8newfeaturetest;

/**
 @author EddieZhang
 @create 2022-08-21 15:17
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置的四大核心函数式接口
 *      消费型接口--consumer<T>---------void(T t)
 *      供给型接口--Supplier<T>---------T get()
 *      函数型接口--Function<T,R>-------R apply(T t)
 *      判定型接口--Predicate<T>--------boolean test(T t)
 */
public class FunctionInterfaceTest {
    /**
     * 消费型接口--consumer<T>---------void(T t)
     */
    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("今天买书花了" + aDouble);
                //今天买书花了500.0
            }
        });
        System.out.println("--------------------------Lambda表达式写法--------------------------");
        happyTime(1499,money -> System.out.println("今日消费" + money));
        //今日消费1499.0

    }
    public void happyTime(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }
    /**
     * 判定型接口--Predicate<T>--------boolean test(T t)
     */
    @Test
    public void test2(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("北京");
        arrayList.add("东京");
        arrayList.add("天津");
        arrayList.add("普京");
        arrayList.add("南京");
        ArrayList<String> arrayList1 = filterString(arrayList, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(arrayList1);
        System.out.println("--------------------------Lambda表达式写法--------------------------");
        List<String> stringArrayList = Arrays.asList("中国","美国","英国","日本","德国");
        ArrayList<String> arrayList2 = filterString(stringArrayList, s -> s.contains("中"));
        System.out.println(arrayList2);
    }
    //传入一个集合 根据某种规则经行筛选 Predicate接口的实现类中的方法体声明筛选规则
    public ArrayList<String> filterString(List<String> stringList, Predicate<String> predicate){
        ArrayList<String> arrayList = new ArrayList<>();
        for (String arrayListData :
                stringList) {
            if (predicate.test(arrayListData)) {
                arrayList.add(arrayListData);
            }
        }
        return arrayList;


    }
}
