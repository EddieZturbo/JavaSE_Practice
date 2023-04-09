package pcProblem;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 @author EddieZhang
 @create 2023-04-09 11:07 AM
 */
public class ProductConsumerUseLock {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        AtomicReference<Integer> inventory = new AtomicReference<>(0);//product stock default=0

        /**
         * product thread
         */
        new Thread(() -> {
            Thread.currentThread().setName("Producer-Thread");
            while (true) {
                reentrantLock.lock();
                while (inventory.get() > 0) {
                    //wait
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //product
                inventory.getAndSet(inventory.get() + 1);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //notice consumer
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "product 1 piece\t" + "total:" + inventory.get() + "pieces");
            }

        }).start();

        /**
         * Async Thread0
         */
        CompletableFuture.runAsync(() -> {
            Thread.currentThread().setName("Consumer0-Thread");
            while (true) {
                reentrantLock.lock();
                while (inventory.get().equals(0)) {
                    //wait
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //consume
                inventory.getAndSet(inventory.get() - 1);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //notice producer
                condition.signalAll();
                System.out.println(Thread.currentThread().getName() + "consume 1 piece\t" + "residue:" + inventory.get() + "pieces");
            }
        });

        /**
         * Async Thread1
         */
        CompletableFuture.runAsync(() -> {
            Thread.currentThread().setName("Consumer1-Thread");
            while (true) {
                reentrantLock.lock();
                while (inventory.get().equals(0)) {
                    //wait
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //consume
                inventory.getAndSet(inventory.get() - 1);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //notice producer
                condition.signalAll();
                System.out.println(Thread.currentThread().getName() + "consume 1 piece\t" + "residue:" + inventory.get() + "pieces");
            }
        });


        /**
         * Async Thread2
         */
        CompletableFuture.runAsync(() -> {
            Thread.currentThread().setName("Consumer2-Thread");
            while (true) {
                reentrantLock.lock();
                while (inventory.get().equals(0)) {
                    //wait
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //consume
                inventory.getAndSet(inventory.get() - 1);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //notice producer
                condition.signalAll();
                System.out.println(Thread.currentThread().getName() + "consume 1 piece\t" + "residue:" + inventory.get() + "pieces");
            }
        });

    }
}
