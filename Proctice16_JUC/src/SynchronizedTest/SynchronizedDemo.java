package SynchronizedTest;

import java.util.concurrent.TimeUnit;

/**
 @author EddieZhang
 @create 2023-02-10 9:51 AM
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo1 = new SynchronizedDemo();
        new Thread(() -> {
            synchronizedDemo1.test1(synchronizedDemo1.getClass().toString() + "synchronizedDemo1" + Thread.currentThread().getName());
        }).start();


        new Thread(() -> {
            synchronizedDemo1.test1(synchronizedDemo1.getClass().toString() + "synchronizedDemo1" + Thread.currentThread().getName());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (synchronizedDemo1) {
                synchronizedDemo1.notifyAll();
            }
        }).start();



    }

    public void test1(String s) {

        synchronized (this) {
            System.out.println("这里是一个同步代码块" + "\t" + s);
            try {
                System.out.println(s + "\twait()释放锁");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
