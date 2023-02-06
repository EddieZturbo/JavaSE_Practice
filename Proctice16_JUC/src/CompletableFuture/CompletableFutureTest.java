package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 @author EddieZhang
 @create 2023-02-04 10:22 PM
 */
public class CompletableFutureTest {

    public static ExecutorService threadPool = Executors.newFixedThreadPool(20);//指定线程池
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            int num = 10 / 0;//模拟出现异常
            return "Hello ";
        }, threadPool);
        supplyAsync.whenComplete((result,exception)->{//当异步任务完成后
            System.out.println("上一步异步执行的结果是:" + result + "\t" + "上异步出现的异常是" + exception);
            //上一步异步执行的结果是:null	上异步出现的异常是java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
        }).exceptionally(throwable -> {//若异步任务完成时出现了异常
            System.out.println("出现的异常是" + throwable);
            //出现的异常是java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
            return "如果出现异常的话 这里返回一个默认值";
        }).thenAccept((result)->{
            System.out.println(result);//如果出现异常的话 这里返回一个默认值
        });

        threadPool.shutdown();
        while (!threadPool.isTerminated()){}//循环等待指导线程池关闭完成
        System.out.println("Finished all threads");
    }

}
