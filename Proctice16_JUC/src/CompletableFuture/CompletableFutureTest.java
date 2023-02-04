package CompletableFuture;

import java.util.concurrent.*;

/**
 @author EddieZhang
 @create 2023-02-04 10:22 PM
 */
public class CompletableFutureTest {

    public static ExecutorService pool = Executors.newFixedThreadPool(20);
    public static void main(String[] args) {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("这里是实现runnable接口启动的异步线程:" + Thread.currentThread().getName());
        }, pool);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("这里是实现runnable接口启动的异步线程:" + Thread.currentThread().getName());
        }, pool);
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            System.out.println("这里是实现runnable接口启动的异步线程:" + Thread.currentThread().getName());
        }, pool);
        CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> {
            System.out.println("这里是实现runnable接口启动的异步线程:" + Thread.currentThread().getName());
        }, pool);
        CompletableFuture<Void> future5 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这里是实现runnable接口启动的异步线程:" + Thread.currentThread().getName());
        }, pool);
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2, future3, future4, future5);
        try {
            allOf.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("这里是main线程");
        pool.shutdown();
    }

}
