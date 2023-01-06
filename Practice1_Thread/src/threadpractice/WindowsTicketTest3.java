package threadpractice;

/**
 * @author EddieZhang
 * @create 2022-08-09 11:02
 * <p>
 * 创建三个卖票的窗口 三个同时进行的线程
 * 一共100张票
 * 实现Runnable接口
 * 目前存在线程安全问题 待解决...
 */
/**
 * 创建线程 通过实现Runnable接口的方式
 * ①：创建实现Runnable接口的实现类
 * ②：实现Runnable接口中的abstract方法run（）-->方法体为要经行的操作
 * ③：创建实现Runnable接口的实现类的对象
 * ④：创建Thread对象 并将实现Runnable接口的实现类的对象放入Thread构造器中
 * ⑤：通过Thread对象 调用start（）方法-->start（） 启动线程 调用当前对象的run（）方法
 */
class SaleTicket3 implements Runnable {//①：创建实现Runnable接口的实现类
private int ticket3 = 100;//通过实现Runnable接口的方式 不需要将属性声明成static 本身就是共享
    @Override
    public void run() {//②：实现Runnable接口中的abstract方法run（）-->方法体为要经行的操作1
        while(true){
            if (ticket3 > 0){
                System.out.println(Thread.currentThread().getName() + " " + "唱票： " + ticket3-- + " 张票");
            }else{
                break;
            }
        }
    }
}

public class WindowsTicketTest3 {

    public static void main(String[] args) {
        SaleTicket3 saleTicket3 = new SaleTicket3();//③：创建实现Runnable接口的实现类的对象
        //通过实现Runnable接口的方式 运行多个线程 new多个Thread
        //实现Runnable接口的实现类的对象是同一个 *共享数据*
        Thread thread3 = new Thread(saleTicket3);//④：创建Thread对象 并将实现Runnable接口的实现类的对象放入Thread构造器中
        Thread thread4 = new Thread(saleTicket3);//④：创建Thread对象 并将实现Runnable接口的实现类的对象放入Thread构造器中
        Thread thread5 = new Thread(saleTicket3);//④：创建Thread对象 并将实现Runnable接口的实现类的对象放入Thread构造器中
        thread3.setName("一号窗口");
        thread4.setName("二号窗口");
        thread5.setName("三号窗口");
        thread3.start();//⑤：通过Thread对象 调用start（）方法-->start（） 启动线程 调用当前对象的run（）方法
        thread4.start();//⑤：通过Thread对象 调用start（）方法-->start（） 启动线程 调用当前对象的run（）方法
        thread5.start();//⑤：通过Thread对象 调用start（）方法-->start（） 启动线程 调用当前对象的run（）方法
    }
}
