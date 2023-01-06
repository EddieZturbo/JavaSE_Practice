package threadpractice1;

/**
 @author EddieZhang
 @create 2022-09-14 17:38
 */
public class AThread implements Runnable {
        boolean flag = true;

    private boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println((int)(Math.random() * 100 + 1) + "\t我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
