package jconsole_test;

/**
 *
 * @Author: zcl
 * @Date: 2021-12-17 10:04
 */
public class JconsoleTest {
    public static void main(String[] args) {
        MyThreadTest1 myThreadTest1 = new MyThreadTest1();
        Thread thread1 = new Thread(myThreadTest1);
        Thread thread2 = new Thread(myThreadTest1);
        Thread thread3 = new Thread(myThreadTest1);


        thread1.setName("线程一号");
        thread2.setName("线程二号");
        thread3.setName("线程三号");

        thread1.start();
        thread2.start();
        thread3.start();

        for (int i = 0; i < 60; i++) {
            if(i%2 == 0){
                System.out.println("我是线程 " + Thread.currentThread().getName() + "--" + i);

            }
        }
    }


}

class MyThreadTest1 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("我是线程 --" + Thread.currentThread().getName() + " " + ++count);
            if (count == 60) {
                break;
            }
        }
    }
}
