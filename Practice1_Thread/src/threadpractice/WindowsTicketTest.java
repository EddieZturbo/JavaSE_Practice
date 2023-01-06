package threadpractice;

/**
 * @author shkstart
 * @create 2022-08-08 21:13
 */

/**
 *创建三个卖票的窗口 三个同时进行的线程
 * 一共100张票
 * 使用继承Thread体系结构的方式
 * 目前存在线程安全问题 待解决...
 */

class WindowsTicket1 extends Thread{//继承于Thread结构体系
    private static int ticket = 100;//设计static属性 共享静态变量

    //重写ran（）方法
    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + " 唱票: " + ticket-- + " 张票");
            }else{
                break;
            }

        }
    }

}
public class WindowsTicketTest {
    public static void main(String[] args) {
        //创建继承于Thread结构体系的类的对象
        WindowsTicket1 w1 = new WindowsTicket1();
        WindowsTicket1 w2 = new WindowsTicket1();
        WindowsTicket1 w3 = new WindowsTicket1();

        //给三个线程set name
        w1.setName("一号窗口");
        w2.setName("二号窗口");
        w3.setName("三号窗口");

        //三个线程分别调用start（）方法 同时进行售票
        w1.start();
        w2.start();
        w3.start();

    }
}
