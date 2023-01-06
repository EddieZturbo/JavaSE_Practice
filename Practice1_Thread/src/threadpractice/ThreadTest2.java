package threadpractice;

/**
 * @author shkstart
 * @create 2022-08-08 10:15
 */

/**
 * 线程的创建 方式一：
 * ①：继承于Thread体系的类
 * ②：重写Thread的run（）方法
 * ③：创建继承于Thread体系的类的对象
 * ④：通过继承于Thread体系的类的对象调用start方法
 */
class MyThread3 extends Thread{//①：继承于Thread体系的类


    @Override
    public void run() {//②：重写Thread的run（）方法
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " " + i + " "  + "Thread");
            }

        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        MyThread3 m3 = new MyThread3();//③：创建继承于Thread体系的类的对象
        m3.start();//④：通过继承于Thread体系的类的对象调用start方法

        //再运行一个线程
        MyThread3 myThread3 = new MyThread3();//再创建继承于Thread体系的类的对象
        myThread3.start();//通过继承于Thread体系的类的新对象调用start方法

        //以下代码在主线程（main（）方法）中运行
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " " + i + " "  + "main()");
            }

        }
    }
}
