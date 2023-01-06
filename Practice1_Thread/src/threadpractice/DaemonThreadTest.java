package threadpractice;

/**
 @author EddieZhang
 @create 2022-09-05 20:46
 */

/**
 * 当一个进程全是守护线程的时候这个进程就会结束
 * 进程中只要有用户线程 进程就不会终止
 * 一个Java应用程序至少有三个线程 main（）主线程【用户线程】 gc垃圾回收【守护线程】 异常处理【守护线程】
 * 将一个线程处理为守护线程的方法：==> 线程名.setDaemon(true) 即可 在线程.start()前设置
 *
 */
public class DaemonThreadTest {
    public static void main(String[] args) {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        Thread thread = new Thread(myDaemonThread);
        thread.setName("我是线程一~~");
        thread.setDaemon(true);//将线程设置为守护线程 会随着所有用户线程的结束而结束
        thread.start();
        //以下是用户线程main的操作
        for (int i = 0; i < 60; i++) {
            if ((i & 2) == 0){
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }

        Runnable DaemonThreadTest2 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        };
        Thread thread1 = new Thread(DaemonThreadTest2);
        thread1.setName("我是线程二");
        thread1.start();
    }
}

class MyDaemonThread implements Runnable{
    int count = 0;
    @Override
    public void run() {
        /*
            此时这是一个死循环的线程 作为用户线程时是不会结束的
            设置为守护线程后会随着用户线程的结束而结束
         */
        while(true){
            System.out.println("我是一个线程~~" + Thread.currentThread().getName() + " 我现在输出的是 " + ++count);
        }
    }
}
