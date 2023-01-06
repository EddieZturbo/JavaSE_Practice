package threadpractice1;

import java.util.Scanner;

/**
 @author EddieZhang
 @create 2022-09-14 17:38
 */
public class BThread implements Runnable {
    private AThread aThread;
    Scanner scanner = new Scanner(System.in);

    public void setAThread(AThread aThread) {
        this.aThread = aThread;
    }


    public BThread() {
    }

    public BThread(AThread aThread) {
        this.aThread = aThread;
    }

    @Override
    public void run() {
        while(true){
            System.out.print("我是线程" + Thread.currentThread().getName() + "\t请输入一个字符Q表示退出:\n");
            char q = scanner.next().toUpperCase().charAt(0);
            if ('Q' == q) {
                aThread.setFlag(false);//结束A线程的输出循环
                break;//B线程也退出
            }

        }
    }
}
