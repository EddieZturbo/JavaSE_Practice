package threadpractice; /**
 @author EddieZhang
 @create 2022-08-21 22:12
 */

/**
 * 创建线程方式一:
 * 继承于Thread体系结构
 * 1.继承于Thread体系结构
 * 2.重写Thread中的run()方法--其中声明的方法体为要进行的操作
 * 3.创建线程类的对象
 * 4.通过线程类的对象调用start()方法 启动当前线程 调用当前对象的run()方法
 */
class MyThread4 extends Thread{//1.继承于Thread体系结构
    @Override
    public void run() {//2.重写Thread中的run()方法--其中声明的方法体为要进行的操作
        for(int i = 0;i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadTest3 {
    public static void main(String[] args) {
        MyThread4 myThread4 = new MyThread4();//3.创建线程类的对象
        myThread4.setName("线程一");
        myThread4.start();//4.通过线程类的对象调用start()方法 启动当前线程 调用当前对象的run()方法
        //启动多个线程--再创建一个线程类的对象 调用start方法
        MyThread4 myThread41 = new MyThread4();
        myThread41.setName("线程二");
        myThread41.start();
        for (int i = 0;i <= 10;i++){
            System.out.println(Thread.currentThread().getName() + ":" + "*");
        }
    }
}
