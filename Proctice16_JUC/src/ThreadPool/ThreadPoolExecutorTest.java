package ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 @author EddieZhang
 @create 2023-02-05 12:36 AM
 */
public class ThreadPoolExecutorTest {
    private static final int CORE_POOL_SIZE = 5;//核心线程数
    private static final int MAX_POOL_SIZE = 10;//线程池中最大线程数
    private static final int QUEUE_CAPACITY = 100;//阻塞队列的最大容量
    private static final Long KEEP_ALIVE_TIME = 1L;//线程池中非核心空闲线程的存活时间
    public static void main(String[] args) {
        /**
         * (
         *  int corePoolSize,//核心线程数
         *  int maximumPoolSize,//线程池中最大线程数
         *  long keepAliveTime,//线程池中非核心空闲线程的存活时间
         *  TimeUnit unit,//存活时间单位
         *  BlockingQueue<Runnable> workQueue,//阻塞队列
         *  ThreadFactory threadFactory,//线程工厂
         *  RejectedExecutionHandler handler//拒接策略
         *  )
         */
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            Runnable thread = new Thread(() -> {
                System.out.println("这里是通过实现Runnable接口启动的新线程:" + Thread.currentThread().getName());
            });
            threadPoolExecutor.execute(thread);
        }
        //关闭线程池
        threadPoolExecutor.shutdown();
        //未将线程池关闭则死循环直至线程池关闭成功
        while (!threadPoolExecutor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
