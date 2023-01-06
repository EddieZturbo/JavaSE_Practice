package ThreadStateTest;

/**
 @author EddieZhang
 @create 2022-09-05 22:22
 */

/**
 * 创建一个线程
 * 在main方法中查看线程的状态
 */
public class ThreadStateTest {
    public static void main(String[] args) {
        ThreadState threadState = new ThreadState();
        Thread thread = new Thread(threadState);
        System.out.println(thread.getState());
        thread.setName("线程一号");
        thread.start();
        while(thread.getState() != Thread.State.TERMINATED){
            System.out.println(thread.getState());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(thread.getState());
    }
}
class ThreadState implements Runnable{

    @Override
    public void run() {
        while(true){
            for (int i = 0; i < 15; i++) {
                System.out.println("我是一个线程" + Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            break;
        }
    }
}
