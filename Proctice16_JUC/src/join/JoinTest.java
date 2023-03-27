package join;

/**
 @author EddieZhang
 @create 2023-02-24 12:55 PM
 */
public class JoinTest {
    public static void main(String[] args) {
        System.out.println("这里是main线程的前置方法");
        new Thread(() -> {
                System.out.println("这里是" + Thread.currentThread().getName() + "线程");
        },"ThreadEddie").start();
        Thread thread = new Thread(() -> {
            System.out.println("这里是" + Thread.currentThread().getName() + "线程");
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这里是main线程的后续方法");
    }
}
