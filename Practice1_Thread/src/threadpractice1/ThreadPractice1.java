package threadpractice1;

/**
 @author EddieZhang
 @create 2022-09-14 17:38
 */
public class ThreadPractice1 {
    public static void main(String[] args) {
        AThread aThread = new AThread();
        Thread threadA = new Thread(aThread);
        threadA.setName("A");
        threadA.start();
        BThread bThread = new BThread(aThread);
        Thread threadB = new Thread(bThread);
        threadB.setName("B");
        threadB.start();


    }
}
