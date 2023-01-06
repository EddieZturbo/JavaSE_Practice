package numbtest;

/**
 * @author shkstart
 * @create 2022-08-01 16:17
 */
public class NumberTest2 {
    //求1000以内所有完数的和 tip：完数:如果一个数等于其所有因子之和,我们就称这个数为"完数",比如6的因子为1,2,3 6 = 1 + 2 + 3,那么6就是一个完数
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 6; i <= 1000; i++) {
            int sum = 0;
            for (int j = 1; j <= (i / 2); j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("本次运行所用时：" + (end - start) + "s");
    }
}
