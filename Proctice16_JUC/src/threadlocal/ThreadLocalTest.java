package threadlocal;

/**
 @author EddieZhang
 @create 2023-02-17 9:17 AM
 */
public class ThreadLocalTest {
    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                ThreadLocalTest.setSomeThing("Eddie" + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + " 设置变量");
                System.out.println(Thread.currentThread().getName() + " 获取变量" + ThreadLocalTest.getSomeThing());
            },"Thread[" + i + "]").start();
        }
    }
    private static void setSomeThing(String someThing){
        threadLocal.set(someThing);
    }
    private static String getSomeThing(){
        return threadLocal.get();
    }
}
