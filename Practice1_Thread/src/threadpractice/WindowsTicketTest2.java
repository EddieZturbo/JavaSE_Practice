package threadpractice;

/**
 * @author EddieZhang
 * @create 2022-08-09 10:45
 */

/**
 *创建三个卖票的窗口 三个同时进行的线程
 * 一共100张票
 * 继承于Thread体系结构
 * 目前存在线程安全问题 待解决...
 */
/**
 * 创建线程 方式一 继承于Thread体系结构
 * ①：创建继承于Thread体系结构的子类
 * ②：重写Thread中的run（）方法-->方法体为要经行的操作
 * ③：创建继承于Thread体系结构的子类对象
 * ④：通过创建的对象 调用start（）方法--> start（）启动线程  执行对象的run（）方法
 */

class SaleThread extends Thread{//①：创建继承于Thread体系结构的子类
    private static int ticket2 = 100;//继承于Thread体系结构的方式 要想共享属性应声明成static
    @Override
    public void run() {//②：重写Thread中的run（）方法-->方法体为要经行的操作
        while(true){
            if(ticket2 > 0){//当票数大于0时继续售票
                System.out.println(Thread.currentThread().getName() + " " + "唱票：" + ticket2-- + " 张票");
            }else{//当票数不大于0时 表示售罄 停止售票
                break;
            }

        }
    }
}
public class WindowsTicketTest2 {
    public static void main(String[] args) {
        //继承Thread的方式：实现三个线程（三个窗口）需要new三个继承于Thread体系结构的子类对象
        SaleThread s1 = new SaleThread();//③：创建继承于Thread体系结构的子类对象
        SaleThread s2 = new SaleThread();//③：创建继承于Thread体系结构的子类对象
        SaleThread s3 = new SaleThread();//③：创建继承于Thread体系结构的子类对象

        s1.setName("一号窗口");//通过.setName（）方法给线程命名
        s2.setName("二号窗口");//通过.setName（）方法给线程命名
        s3.setName("三号窗口");//通过.setName（）方法给线程命名

        s1.start();//④：通过创建的对象 调用start（）方法--> start（）启动线程  执行对象的run（）方法
        s2.start();//④：通过创建的对象 调用start（）方法--> start（）启动线程  执行对象的run（）方法
        s3.start();//④：通过创建的对象 调用start（）方法--> start（）启动线程  执行对象的run（）方法
    }
}
