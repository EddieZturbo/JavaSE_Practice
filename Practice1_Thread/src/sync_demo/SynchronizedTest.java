package sync_demo;

import java.util.concurrent.ConcurrentHashMap;

/**
 @author EddieZhang
 @create 2023-01-31 8:56 AM
 */
public class SynchronizedTest {
    public static Integer bankBalance = 10000;

    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();

        Thread thread1 = new Thread(() -> {
                while (bankBalance>0) {
                    reduceBalance();
                    System.out.println(Thread.currentThread().getName() + "\t当前额度为:" + bankBalance);
                }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            while (bankBalance>0) {
                reduceBalance();
                System.out.println(Thread.currentThread().getName() + "\t当前额度为:" + bankBalance);
            }
        });
        thread2.start();
        Thread thread3 = new Thread(() -> {
            while (bankBalance>0) {
                reduceBalance();
                System.out.println(Thread.currentThread().getName() + "\t当前额度为:" + bankBalance);
            }
        });
        thread3.start();
    }

    public static void reduceBalance(){
        synchronized (SynchronizedTest.class) {
            bankBalance -= 1000;
        }
    }
}
