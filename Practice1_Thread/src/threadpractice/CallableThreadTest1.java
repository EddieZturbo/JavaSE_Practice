package threadpractice;

/**
 @author EddieZhang
 @create 2022-08-21 22:53
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程方式三
 * JDK5.0后
 *  实现Callable接口
 *  1.实现Callable接口
 *  2.实现Callable接口中的抽象call()方法--方法支持返回值且可抛出异常支持泛型的返回值
 *  3.创建线程类的对象
 *  4.创建一个FutureTask对象将线程类的对象作为参数传入构造器中--FutureTask对象可以调用get（）方法获取call（）方法的返回值
 *  5.创建一个Thread类的对象将FutureTask对象作为参数传入构造器中
 *      //创建多个线程
 * //需要创建FutureTask对象将线程类的对象作为参数传入构造器中--再创建多个Thread类的对象将FutureTask对象作为参数传入构造器中
 *         FutureTask futureTask1 = new FutureTask(myThread6);//创建多个线程--创建多个FutureTask对象将线程类的对象作为参数传入构造器中
 *         Thread thread1 = new Thread(futureTask1);//创建多个线程--创建多个Thread类的对象将FutureTask对象作为参数传入构造器中
 *         thread1.setName("线程二");
 *         thread1.start();
 *
 *  相较于Runnable接口而言
 *  实现Callable接口的功能更加强大
 *  1.call（）方法有返回值
 *  2.可以抛出异常
 *  3.支持泛型的返回值
 *  4.需要借助FutureTask类来获取返回值
 *          Future接口
 *          可以对具体Runnable、Callable任务的执行结果进行取消、查询是否完成、获取结果等。
 *          FutureTask是Future接口的唯一的实现类
 *          FutureTask 同时实现了Runnable, Future接口。它既可以作为
 *          Runnable被线程执行，又可以作为Future得到Callable的返回值
 */
class MyThread6 implements Callable {//1.实现Callable接口
    @Override
    public Object call() throws Exception {//2.实现Callable接口中的抽象run()方法--方法支持返回值且可抛出异常支持泛型的返回值--处理异常
        int sum = 0;
        for(int i = 0;i <= 100;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;
    }
}
public class CallableThreadTest1 {
    public static void main(String[] args) {
        MyThread6 myThread6 = new MyThread6();//3.创建线程类的对象
        FutureTask futureTask = new FutureTask(myThread6);//创建一个FutureTask对象将线程类的对象作为参数传入构造器中
        Thread thread = new Thread(futureTask);//创建一个Thread类的对象将FutureTask对象作为参数传入构造器中
        thread.setName("线程一");
        thread.start();
        FutureTask futureTask1 = new FutureTask(myThread6);//创建多个线程--创建多个FutureTask对象将线程类的对象作为参数传入构造器中
        Thread thread1 = new Thread(futureTask1);//创建多个线程--创建多个Thread类的对象将FutureTask对象作为参数传入构造器中
        thread1.setName("线程二");
        thread1.start();
        Object o = null;
        try {
            o = futureTask.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ":" + o);

    }
}
