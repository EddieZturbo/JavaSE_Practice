package threadpractice2;

/**
 @author EddieZhang
 @create 2022-09-14 20:18
 */
class AccountThread implements Runnable {
    private double balance = 10000;//账户余额


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (this) {//同步代码块 将多线程共同操作的共享数据部分同步起来 解决线程安全问题
//                notify();
                if (balance < 1000) {
                    break;
                }
                withdrawMoney();
                System.out.println("我是线程:" + Thread.currentThread().getName() + "\t我取了1000$" + "\t账户中还剩下:" + balance + " $");
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        }
    }

    public void withdrawMoney() {
        this.balance -= 1000;
    }


}

public class SecurityThreadTest {
    public static void main(String[] args) {
        AccountThread accountThread = new AccountThread();
        Thread thread = new Thread(accountThread);
        Thread thread2 = new Thread(accountThread);
        thread.setName("一号");
        thread2.setName("二号");
        thread.start();
        thread2.start();
    }
}
