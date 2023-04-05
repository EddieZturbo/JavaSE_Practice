package bio_portToPort.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 @author EddieZhang
 @create 2023-04-05 12:00 AM
 */
public class MyThreadPool {
    private ExecutorService threadPool;

    /**
     * 初始化线程池
     * @param coreThreadNum
     * @param maxThreadNum
     * @param blockQueueNum
     */
    public MyThreadPool(Integer coreThreadNum,Integer maxThreadNum,Integer blockQueueNum){
        /**
         * public ThreadPoolExecutor(int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue)
         */
        threadPool = new ThreadPoolExecutor(
                coreThreadNum,
                maxThreadNum,
                12,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(blockQueueNum)
                );

    }

    /**
     * 将线程加入到线程池中执行
     * @param thread
     */
    public void executeThreadWithPool(Runnable thread){
        threadPool.execute(thread);
    }
}
