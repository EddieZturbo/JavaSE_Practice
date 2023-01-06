package threadpractice;

/**
 @author EddieZhang
 @create 2022-08-21 22:23
 */

/**
 * 创建线程方式二
 * 实现Runnable接口--适合进行共享数据的操作
 * 1.实现Runnable接口
 * 2.实现Runnable接口中的抽象方法--方法体中声明要进行的操作
 * 3.创建线程类的对象
 * 4.创建Thread类的对象并将线程类的对象传入构造器中
 * 5.通过Thread类的对象调用start()方法启动线程 调用当前对象的run()方法
 */

class MyThread5 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

public class RunnableThreadTest1 {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        Thread thread = new Thread(myThread5);
        thread.setName("线程一");
        thread.start();
        Thread thread1 = new Thread(myThread5);
        thread1.setName("线程二");
        thread1.start();
        for (int i = 0;i <= 10;i++){
            System.out.println(Thread.currentThread().getName() + ":" + "**");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
