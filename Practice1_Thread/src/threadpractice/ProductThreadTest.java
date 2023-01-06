package threadpractice;

/**
 * @author EddieZhang
 * @create 2022-08-09 21:40
 */

/**经典例题：生产者/消费者问题
 * 生产者(Producer)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 * 这里可能出现两个问题：
 * 生产者比消费者快时，消费者会漏掉一些数据没有取到。
 * 消费者比生产者快时，消费者会取相同的数据。
 */

/**Analysis：
 * 1.是否为多线程的问题；是
 * 2.是否存在共享数据；是
 * 3.是否存在线程安全问题；是，解决方法：同步机制 synchronized代码块/方法 /lock（锁）
 * 4.是否涉及线程的通信；是
 *
 */
//创建共同要用到的数据类
class Clerk{
    private int numberProduct = 0;


    public synchronized void produceProduct() {//synchronized方法解决线程安全问题
        if(numberProduct < 20){
            numberProduct++;
            notify();//只要生产了一个就可以notify消费者
            System.out.println(Thread.currentThread().getName() + ", 开始生产第 " + numberProduct + " 个产品");
        }else{
            //等待
            try {
                wait();//当生产的产品数量达到20就wait
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void consumeProduct() {//synchronized方法解决线程安全问题
        if(numberProduct > 0){
            System.out.println(Thread.currentThread().getName() + ", 开始消费第 " + numberProduct + " 个产品");
            numberProduct--;
            notify();//只要消费了一个就可以notify生产者
        }else{
            //等待
            try {
                wait();//当产品剩余0个时就暂停消费
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
//通过继承Thread体系结构创建线程
class Producer extends Thread{//创建继承Thread体系结构的类
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {//重写Thread的run（）方法 方法体中写要进行的操作
        System.out.println(Thread.currentThread().getName() + " 开始生产......");
        while(true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.produceProduct();
        }
    }
}
//通过继承Thread体系结构创建线程
class Customer extends Thread{//创建继承Thread体系结构的类
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {//重写Thread的run（）方法 方法体中写要进行的操作
        System.out.println(Thread.currentThread().getName() + " 开始消费......");
        while(true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.consumeProduct();
        }
    }
}



public class ProductThreadTest {
    public static void main(String[] args) {//创建继承Thread类的对象
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        Customer c1 = new Customer(clerk);

        p1.setName("生产者一");
        c1.setName("消费者一");
        //通过继承Thread类的对象调用start（）方法 启动 run（）方法
        p1.start();
        c1.start();

    }
}
