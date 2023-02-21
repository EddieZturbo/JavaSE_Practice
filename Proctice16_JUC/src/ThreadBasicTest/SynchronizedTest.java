package ThreadBasicTest;

import java.util.concurrent.TimeUnit;

/**
 @author EddieZhang
 @create 2023-02-07 10:48 AM
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendMes();
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone.call();
        }).start();
    }

}
class Phone{
    public static synchronized void sendMes(){

            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("send Message \t" + Thread.currentThread().getName());
    }
    public static synchronized void call(){
            System.out.println("call\t" + Thread.currentThread().getName());
    }

}