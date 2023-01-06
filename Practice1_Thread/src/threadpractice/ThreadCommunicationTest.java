package threadpractice;

/**
 * @author EddieZhang
 * @create 2022-08-09 20:30
 */

/**
 * 例 题
 * 使用两个线程打印 1-100。线程1, 线程2 交替打印(涉及到Thread通信)
 */
//创建线程
class ThreadCommunicate implements Runnable {//实现Runnable接口类
    private int number = 1;

    @Override
    public void run() {//重写Runnable接口中的abstract方法run（）方法体中写要进行的操作
        while (true) {
            synchronized (this) {
                this.notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + " , " + number + "  *");
                    number++;
                } else {
                    break;
                }
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
    }
}

public class ThreadCommunicationTest {
    //创建实现类的对象
    public static void main(String[] args) {
        ThreadCommunicate threadCommunicate = new ThreadCommunicate();
        //创建Thread类的对象 将实现类的对象放进构造器中
        Thread thread = new Thread(threadCommunicate);
        Thread thread1 = new Thread(threadCommunicate);
//        通过Thread对象调用setName（）方法 给线程命名
        thread.setName("线程一");
        thread1.setName("线程二");
        //通过Thread对象调用start（）方法 启动线程 调动当前线程的run（）方法
        thread.start();
        thread1.start();

    }
}
