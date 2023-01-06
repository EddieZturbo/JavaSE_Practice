package threadpractice;

/**
 * @author shkstart
 * @create 2022-08-07 11:29
 */

/**
 * 多线程的创建
 * 方式一：继承于Thread类
 * ①：创建一个继承于Thread类的子类
 * ②：重写Thread类中的run方法-->此线程要执行的操作重写在run方法的方法体中
 * ③：创建继承于Thread类的子类的对象-->需要在主线程（main方法）中操作
 * ④：通过此对象 调用start（）方法-->①线程开始要执行 调用当前线程的 ②run（）
 */

class MyThread1 extends Thread {//①：创建一个继承于Thread类的子类

    @Override
    public void run() {//②：重写Thread类中的run方法
        for (int i = 0; i < 100; i++) {//遍历100内的所有偶数
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        /**
         * 启动一个线程 --> 创建继承于Thread类的子类的对象 通过此对象 调用start（）方法
         */
        MyThread1 t1 = new MyThread1();//③：创建继承于Thread类的子类的对象
        t1.start();//④：通过此对象 调用start（）方法-->线程开始要执行 调用当前线程的 run（）

        /**
         * 再启动一个线程 --> 再创建一个继承于Thread类的子类的对象 通过此对象 调用start（）方法 tip:(一个线程对象只能调用一次start()方法启动)
         */
        MyThread1 t2 = new MyThread1();//再创建一个继承于Thread类的子类的对象
        t2.start();//通过此对象 调用start（）方法-->线程开始要执行 调用当前线程的 run（）

        //以下操作在主线程 main（）中执行
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "main()");
            }
        }
    }
}

//相当于主线程 main（）和 MyThread线程 同时在进行