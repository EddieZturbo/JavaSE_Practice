package threadpractice;

/**
 * @author EddieZhang
 * @create 2022-08-08 22:14
 */

/**
 * 创建线程 方式二:
 * 实现Runnable接口
 * ①：实现Runnable接口
 * ②：实现Runnable接口的抽象run（）方法
 * ③：创建实现类的对象
 * ④：创建thread对象并将创建的实现类的对象放进thread的构造器中
 * ⑤：通过thread对象调用start（）方法
 */
class MyRunnable implements Runnable {//①：实现Runnable接口

    @Override
    public void run() {//②：实现Runnable接口的抽象run（）方法
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " " +  i);

            }

        }

    }
}


public class RunnableThreadTest {
    public static void main(String[] args) {

        MyRunnable r1 = new MyRunnable();//    ③：创建实现类的对象

        Thread t1 = new Thread(r1);//        ④：创建thread对象并将创建的实现类的对象放进thread的构造器中

        t1.start();//⑤：通过thread对象调用start（）方法 start()的作用 ①：启动线程 ②：调用当前线程的run（）；
        //调用了Runnable中的target的run（）；


        //再次调用一个线程
        Thread t2 = new Thread(r1);
        t2.start();

    }
}
