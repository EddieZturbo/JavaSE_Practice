package pcProblem;

import java.util.concurrent.atomic.AtomicReference;

/**
 @author EddieZhang
 @create 2023-04-09 10:37 AM
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        AtomicReference<Integer> inventory = new AtomicReference<>(0);//Product number default=0
        new Thread(() -> {
            Thread.currentThread().setName("Producer");
            while (true){
                synchronized (inventory){
                    while (inventory.get() > 0){
                        //wait consumer
                        try {
                            inventory.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //product
                    inventory.getAndSet(inventory.get() + 1);
                    inventory.notifyAll();//notice consumer
                    System.out.println(Thread.currentThread().getName() + "product 1 piece\t" + "total:" + inventory.get()+ "pieces");
                }
            }

        }).start();

        new Thread(() -> {
            Thread.currentThread().setName("Consumer");
            while(true){
                synchronized (inventory){
                    while(inventory.get().equals(0)){
                        //wait producer
                        try {
                            inventory.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //consume
                    inventory.getAndSet(inventory.get() - 1);
                    //notice product
                    inventory.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "consume 1 piece\t" + "residue:" + inventory.get()+ "pieces");
                }
            }
        }).start();

    }
}
