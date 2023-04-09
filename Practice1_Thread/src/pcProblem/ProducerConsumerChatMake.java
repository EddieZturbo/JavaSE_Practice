package pcProblem;

import java.util.LinkedList;

/**
 @author EddieZhang
 @create 2023-04-09 11:04 AM
 */
public class ProducerConsumerChatMake {

    public static void main(String[] args) {
        LinkedList<Integer> buffer = new LinkedList<>();
        int maxSize = 10;
        Thread producer = new Thread(new Producer(buffer, maxSize));
        Thread consumer = new Thread(new Consumer(buffer));
        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {

    private final LinkedList<Integer> buffer;
    private final int maxSize;

    public Producer(LinkedList<Integer> buffer, int maxSize) {
        this.buffer = buffer;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                while (buffer.size() == maxSize) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int num = (int) (Math.random() * 100);
                buffer.add(num);
                System.out.println("Producer produced " + num);
                buffer.notifyAll();
            }
        }
    }
}

class Consumer implements Runnable {

    private final LinkedList<Integer> buffer;

    public Consumer(LinkedList<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                while (buffer.size() == 0) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int num = buffer.removeFirst();
                System.out.println("Consumer consumed " + num);
                buffer.notifyAll();
            }
        }
    }
}
