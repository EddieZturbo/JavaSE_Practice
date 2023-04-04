package bio_and_threadPool.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 @author EddieZhang
 @create 2023-04-04 9:50 PM
 */
public class MyThreadPool {
    private ExecutorService threadPoolExecutor;//声明一个线程池

    /**
     * 初始化线程池
     * public ThreadPoolExecutor(int corePoolSize,
     *                               int maximumPoolSize,
     *                               long keepAliveTime,
     *                               TimeUnit unit,
     *                               BlockingQueue<Runnable> workQueue)
     * @param coreThreadNum
     * @param maxThreadNum
     * @param queueNum
     */
    public MyThreadPool(Integer coreThreadNum,Integer maxThreadNum,Integer queueNum){
        threadPoolExecutor = new ThreadPoolExecutor(
                coreThreadNum,
                maxThreadNum,
                120,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(queueNum)
                );
    }

    /**
     * 将线程加入到线程池中执行
     * @param thread
     */
    public void executeThreadWithPool(Runnable thread){
        threadPoolExecutor.execute(thread);
    }

}
