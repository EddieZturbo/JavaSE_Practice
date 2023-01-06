package threadpractice;

/**
 * @author EddieZhang
 * @create 2022-08-15 10:35
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * JDK5.0 新增线程创建方式
 * 实现Callable接口
 * 1.实现Callable接口
 * 2.@override--Callable中的call（）方法 执行的操作声明在方法体中
 * 3.new一个实现了Callable接口的对象
 * 4.new一个FutureTask类的对象，将实现了Callable接口的对象放入构造器中
 * 5.new一个Thread类的对象，FutureTask类的对象放入构造器中 通过Thread类的对象调用start（）方法 启动线程
 * .需要查看返回值可使用FutureTask类的对象调用get（）方法 同时处理异常
 *
 *  与使用Runnable相比， Callable功能更强大些
 *  相比run()方法，可以有返回值
 *  方法可以抛出异常
 *  支持泛型的返回值
 *  需要借助FutureTask类，比如获取返回结果
 *
 * Future接口
 *  可以对具体Runnable、Callable任务的执行结果进行取消、查询是否完成、获取结果等。
 *  FutrueTask是Futrue接口的唯一的实现类
 *  FutureTask 同时实现了Runnable, Future接口。它既可以作为
 * Runnable被线程执行，又可以作为Future得到Callable的返回值
 */
class CallableThread1 implements Callable {//实现Callable接口

    @Override
    public Object call() throws Exception {//@override--Callable中的call（）方法 执行的操作声明在方法体中
        int sum = 0;
        for (int i = 0;i < 100 ;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " " + i);
                sum += i;
            }
        }
        return sum;//可以有返回值
    }
}

public class CallableThreadTest {
    public static void main(String[] args) {
        CallableThread1 callableThread1 = new CallableThread1();//new一个实现了Callable接口的对象
        FutureTask futureTask1 = new FutureTask(callableThread1);//new一个FutureTask类的对象，将实现了Callable接口的对象放入构造器中
        Thread thread1 = new Thread(futureTask1);//new一个Thread类的对象，FutureTask类的对象放入构造器中
        thread1.start();//通过Thread类的对象调用start（）方法 启动线程

        //需要查看返回值可使用FutureTask类的对象调用get（）方法 同时处理异常
        try {
            Object numberSum = futureTask1.get();
            System.out.println(Thread.currentThread().getName() + "  遍历100内所有的偶数和为: " + numberSum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
//输出如下
//Thread-0 0
//......
//Thread-0 98
//main  遍历100内所有的偶数和为: 2450
