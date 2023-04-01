package leetcodepracticetest;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author EddieZhang
 * @create 2022-08-12 16:42
 */
public class AlgorithmTest {
    public static void main(String[] args) {
        String result = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个总数:");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        System.out.print("输入测试数据空格隔开:");
        String msg = "";
        while(msg.isEmpty()){
            msg = scanner.nextLine();
        }
        System.out.println("输入的字符串是:" + msg);
        String[] split = msg.split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }

        System.out.print("要做多少次运算:");
        int m = scanner.nextInt();
        System.out.print("输入要进行调整运算的要求");
        String allRequest = "";
        while (allRequest.isEmpty()){
            allRequest = scanner.nextLine();
        }
        String[] s = allRequest.split(" ");
        char[] sign = new char[m];//所有的符号
        int[] position = new int[m];//所有要进行计算的数的位置
        int temp1 = 0;//临时指针
        int temp2 = 0;//临时指针
        for (int i = 0; i < s.length; i++) {
            if (i % 2 == 0) {
                //偶数位置 第几个数
                position[temp2++] = Integer.parseInt(s[i]);
            } else {
                //奇数位置 符号
                sign[temp1++] = s[i].toCharArray()[0];
            }
        }
        for (int i = 0; i < m; i++) {
            int t = position[i];
            char o = sign[i];
            result = result + calculateExpression(numbers, t, o) + " ";
        }
        System.out.println(result);
    }

    public static String calculateExpression(int[] numbers, int t, char o) {
        double result = numbers[0];
        double temp = 1.0;
        for (int i = 1; i < numbers.length; i++) {
            if (i == t) {
                switch (o) {
                    case '+':
                        result += numbers[i];
                        break;
                    case '-':
                        result -= numbers[i];
                        break;
                    case '*':
                        result = (result -= numbers[i - 1]) + (numbers[i - 1] *= numbers[i]);
                        break;
                    case '/':
                        result = (result -= numbers[i - 1]) + ((temp *= numbers[i - 1]) / (temp *= numbers[i]));
                        break;
                }
            } else {
                result += numbers[i];
            }
        }
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(result);
    }

}

