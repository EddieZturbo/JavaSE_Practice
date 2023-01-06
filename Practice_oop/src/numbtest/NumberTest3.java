package numbtest;

/**
 * @author shkstart
 * @create 2022-08-01 16:32
 */
//遍历 1000内的所有水仙花数 tip：是指一个三位数，其各位数字立方和等于该数字本身 例如：153就是一个水仙花数，因为153 = 1³ + 5³ + 3³
public class NumberTest3 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 100; i < 1000; i++) {
            new NumberTest3().methodNumber(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("本次运行所用时：" + (end - start) + "s");
    }

    //创建求水仙花数的方法

    public void methodNumber(int a) {
        int bai = a / 100;
        int shi = a / 10 % 10;
        int ge = a % 10;
        if (a == bai * bai * bai + shi * shi * shi + ge * ge * ge) {
            System.out.println(a);
        }

    }

}
