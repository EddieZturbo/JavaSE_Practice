package algorithm.recursion;

/**
 @author EddieZhang
 @create 2022-09-10 11:34
 */

import org.junit.Test;

/**
 * Recursion
 * 递归:递归就是方法自己调用自己,每次调用时传入不同的变量.递归有助于编程者解决复杂的问题,同时可以让代码变得简洁
 * 实际应用场景，迷宫问题(回溯)
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
        int factorial = factorial(4);
        System.out.println("factorial = " + factorial);
        int peach = peach(1);
        System.out.println("第 1 天的桃子个数为:" + peach);
    }

    @Test
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        } else {
            System.out.println("n=" + n);
        }
    }
    @Test
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    /**
     * 猴子吃桃 猴子每天吃所有桃子的一半再多吃一个 吃到第十天还没吃的时候只剩下1个了 猴子最初有多少个桃子
     * @param day
     * @return
     */
    @Test
    public static int peach(int day){
        if(day == 9){
            return 1;
        }
        else {
            return (peach(day + 1) + 1) * 2;
        }
    }


}
