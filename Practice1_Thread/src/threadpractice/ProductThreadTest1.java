package threadpractice;

/**
 * @author EddieZhang
 * @create 2022-08-10 10:28
 */
/**经典例题：生产者/消费者问题
 * 生产者(Producer)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，
 * 店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 * 这里可能出现两个问题：
 * 生产者比消费者快时，消费者会漏掉一些数据没有取到。
 * 消费者比生产者快时，消费者会取相同的数据。
 */

/**
 * Analysis:
 * 1.是否为多线程；是
 * 2.是否有共享数据；是
 * 3.是否存在线程安全问题；是 解决方法：同步机制：synchronized代码块/方法  lock（锁）
 * 4.是否存在线程的通信；是
 */

/**
 * 继承Thread体系结构创建线程
 * 1.创建继承于Thread体系结构的类
 * 2.重写Thread中的run（）方法
 * 3.创建继承于Thread体系结构的类的对象
 * 4.通过类的对象调用start（）方法--》启动线程 调用当前对象的run（）方法
 *
 * 实现Runnable接口创建线程
 * 1.创建实现Runnable接口的实现类
 * 2.实现Runnable接口中的abstract方法run（）
 * 3.创建实现了Runnable接口的实现类的对象
 * 4.创建Thread对象--并将创建的实现类的对象放进构造器中
 * 5.通过Thread对象调用start（）方法--》启动线程 调用该对象的run（）方法
 *
 *
 */
//共同被使用的店员类
class Clerk1 {
    private int numberProduct1 = 0;//产品数量


    public  void produceProduct1() {//生产方法
        synchronized(this){
            if(numberProduct1 < 20){

                numberProduct1++;
                this.notify();//只要生产了一个产品就可以notify消费者线程
                System.out.println(Thread.currentThread().getName() + "  开始生产第 " + numberProduct1 + "个产品");
            }else{
                //等待
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public synchronized void consumeProduct1() {//消费方法
        synchronized(this){
            if(numberProduct1 > 0){

                System.out.println(Thread.currentThread().getName() + "  开始消费第 " + numberProduct1 + "个产品");
                numberProduct1--;
                this.notify();//只要消费了一个产品就可以notify生产者线程
            }else{
                //等待
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    }

        }
}
//生产者线程
class Producer1 implements Runnable{
    Clerk1 clerk1 ;

    public Producer1(Clerk1 clerk1) {
        this.clerk1 = clerk1;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk1.produceProduct1();
        }
    }
}
//消费者线程
class Customer1 implements Runnable{
    Clerk1 clerk1 ;

    public Customer1(Clerk1 clerk1) {
        this.clerk1 = clerk1;

    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk1.consumeProduct1();
        }
    }
}




public class ProductThreadTest1 {
    public static void main(String[] args) {
        Clerk1 clerk1 = new Clerk1();//new Clerk1对象

        Producer1 producer1 = new Producer1(clerk1);//创建实现了Runnable接口的实现类的对象
        Customer1 customer1 = new Customer1(clerk1);//创建实现了Runnable接口的实现类的对象

        Thread thread1 = new Thread(producer1);//创建Thread对象--并将创建的实现类的对象放进构造器中
        Thread thread2 = new Thread(customer1);//创建Thread对象--并将创建的实现类的对象放进构造器中

        thread1.setName("生产者线程");
        thread2.setName("消费者线程");

        thread1.start();//通过Thread对象调用start（）方法--》启动线程 调用该对象的run（）方法
        thread2.start();//通过Thread对象调用start（）方法--》启动线程 调用该对象的run（）方法


    }
}
