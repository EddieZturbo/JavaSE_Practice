package threadpractice;

/**
 * @author shkstart
 * @create 2022-08-07 22:59
 */

/**
 * 创建线程 方法一：
 * ①：创建继承于Thread体系结构的子类
 * ②：重写run（）方法
 * ③：创建继承于Thread体系结构的子类对象
 * ④：用继承于Thread体系结构的子类对象调用start（）方法
 */
class MyThread2 extends Thread{//①：创建继承于Thread体系结构的子类


    @Override
    public void run() {//②：重写run（）方法
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println("Tread" + Thread.currentThread().getName() + " " + i);
            }

        }
    }
}


public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread2 m1 = new MyThread2();//③：创建继承于Thread体系结构的子类对象
        m1.start();//④：用继承于Thread体系结构的子类对象调用start（）方法

        //再启用一个线程
        MyThread2 m2 = new MyThread2();//再次创建继承于Thread体系结构的子类对象
        m2.start();//用再次创建继承于Thread体系结构的子类对象调用start（）方法




        //以下代码在主线程（main（）方法）中跑
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println("main" + Thread.currentThread().getName() + " " + i + "main()");
            }

        }

    }

}
