package threadpractice;

/**
 * @author EddieZhang
 * @create 2022-08-09 18:16
 * /**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 * 印账户余额。
 * 问题：该程序是否有安全问题，如果有，如何解决？
 *
 * 分析：
 * 是否是多线程；有两个用户及两个线程
 * 是否有共享数据；共享同一个账户
 * 存在线程安全问题
 * 解决线程安全问题的几种方式：lock（） synchronized（）--》同步机制：同步代码块/同步方法
 */

/**
 * 分析：
 * 是否是多线程；有两个用户及两个线程
 * 是否有共享数据；共享同一个账户
 * 存在线程安全问题
 * 解决线程安全问题的几种方式：lock（） synchronized（）--》同步机制：同步代码块/同步方法
 */

//创建多线程--》extends于Thread体系结构/implements于Runnable接口

//**********************************************************************************************************
//创建线程方式：implements于Runnable接口  解决线程安全问题的方法：synchronized（）--》同步机制：同步代码块/同步方法

/**
 implements于Runnable接口
 *创建实现于Runnable的实现类
 * 重写Runnable中的抽象方法run（）
 * 创建实现类的对象
 * 创建Thread类的对象并将实现类放进构造器中
 * 通过Thread对象调用start（）方法
 */
class AccountThread implements Runnable {//创建实现于Runnable的实现类
    private double balance = 0;

    public synchronized void deposit(double amount) {
        balance += amount;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ":进行存钱操作 余额为：" + balance + "$");
    }

    @Override
    public void run() {//重写Runnable中的抽象方法run（） 方法体中写要进行的操作
        for (int i = 0; i < 3; i++) {
            deposit(1000);
        }
    }
}

public class ThreadSecurityTest {
    public static void main(String[] args) {
        AccountThread accountThread = new AccountThread();//创建实现类的对象
        Thread thread = new Thread(accountThread);//创建Thread类的对象并将实现类放进构造器中
        Thread thread1 = new Thread(accountThread);//创建Thread类的对象并将实现类放进构造器中
        thread.setName("张锦豪");
        thread1.setName("张锦豪的对象");
        thread.start();//通过Thread对象调用start（）方法
        thread1.start();//通过Thread对象调用start（）方法
    }
}