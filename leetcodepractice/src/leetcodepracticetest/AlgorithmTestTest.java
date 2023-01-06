package leetcodepracticetest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author EddieZhang
 * @create 2022-08-13 9:50
 */
public class AlgorithmTestTest {
    @Test
    public void test1() {
//        给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//        输入：nums = [2,7,11,15], target = 9
//        输出：[0,1]
//        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
        int[] number1 = new int[]{3, 3, 11, 15, 24, 5, 6};
        lable:
        for (int i = 0; i < number1.length - 1; i++) {
            for (int j = 1; j < number1.length; j++) {
                if (number1[i] + number1[j] == 9) {
                    System.out.println("[" + i + "," + j + "]");
                    break lable;
                }
            }
        }
    }

    @Test
    public void test2() {
        //位运算 ^ 异或位运算
        //相同数^ 结果为0
        //不同数^ 结果为1
        //任何数与0^ 结果为任何数

        //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
        //输入: [4,1,2,1,2]
        //输出: 4
        int[] arraysInt1 = new int[]{4, 1, 2, 1, 2};
        Arrays.sort(arraysInt1);
        int number1 = 0;
        for (int i = 0; i < arraysInt1.length; i++) {
            number1 = number1 ^ arraysInt1[i];
        }
        System.out.println(number1);
    }
    @Test
    public void test3(){
        long start = System.currentTimeMillis();
        int allSum = 0;
        String sum1 = "";
        String sum2 = "";
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList1.add(9);
        arrayList1.add(9);
        arrayList1.add(9);
        arrayList1.add(9);
        arrayList1.add(9);
        arrayList1.add(9);
        arrayList1.add(9);
        for(int i = (arrayList1.size()-1);i >= 0;i--){
            sum1 += arrayList1.get(i);
        }
        arrayList2.add(9);
        arrayList2.add(9);
        arrayList2.add(9);
        arrayList2.add(9);
        for (int j = (arrayList2.size()-1);j >= 0;j--){
            sum2 += arrayList2.get(j);
        }
        int n1 = Integer.parseInt(sum1);
        int n2 = Integer.parseInt(sum2);
        allSum = n1 + n2;
        String resultStr1 = String.valueOf(allSum);
        String result = "";
        for(int k = (resultStr1.length()-1);k >= 0;k--){
            result += resultStr1.charAt(k);
        }
        int parseInt = Integer.parseInt(result);
        int resultInt = parseInt;
        System.out.println(resultInt);
        long end = System.currentTimeMillis();
        System.out.println("本次运算用时:" + (end - start));

    }
}