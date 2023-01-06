package threadpractice;

/**
 * @author EddieZhang
 * @create 2022-08-08 22:29

/**
 *创建三个卖票的窗口 三个同时进行的线程
 * 一共100张票
 * 使用实现Runnable接口的方式
 * 目前存在线程安全问题 待解决...
 */

/**
 * 使用实现Runnable接口的方式
 * ①：实现Runnable接口
 * ②：实现Runnable接口的abstract方法 run（）
 * ③：创建实现类的对象
 * ④：创建Thread对象 并将实现类的对象放入Thread的构造器中
 * ⑤：通过Thread对象调用start（）方法
 */

class WindowsTicket implements Runnable {//①：实现Runnable接口
    private int ticket2 = 100;

    @Override
    public void run() {//②：实现Runnable接口的abstract方法 run（）
        while (true) {
            if (ticket2 > 0) {
                System.out.println(Thread.currentThread().getName() + " " + "唱票：" + ticket2-- + " 张票");
            } else {
                break;
            }
        }


    }
}


public class WindowsTicketTest1 {
    public static void main(String[] args) {
        WindowsTicket windowsTicket1 = new WindowsTicket();//③：创建实现类的对象

        Thread thread1 = new Thread(windowsTicket1); //④：创建Thread对象 并将实现类的对象放入Thread的构造器中
        Thread thread2 = new Thread(windowsTicket1);
        Thread thread3 = new Thread(windowsTicket1);

        thread1.setName("一号窗口");//通过setName给线程命名
        thread2.setName("二号窗口");
        thread3.setName("三号窗口");


        thread1.start();//⑤：通过Thread对象调用start（）方法
        thread2.start();//⑤：通过Thread对象调用start（）方法
        thread3.start();//⑤：通过Thread对象调用start（）方法


    }


}
