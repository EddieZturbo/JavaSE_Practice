package algorithm.sort_algorithm;

/**
 @author EddieZhang
 @create 2022-09-21 10:52
 */

import org.junit.Test;

/**
 * 选择排序
 */
public class SelectionSort {
    @Test
    public void test1() {
        int[] nums = new int[]{-5, -89, -6, -8, 5, 9, 45, 6, -596, -456, 888, -6, 9};
        for (int i = 0; i < nums.length; i++) {//外层循坏 每次循环选择出第i小的数 然后放在第i位 后续类推
            int minIndex = i;//记录每次比较的最小值索引位置
            for (int j = i; j < nums.length; j++) {//内层循环 遍历每次循环中出第i小的数的索引位置
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;//最小数的索引
                }

            }
            //将第i小的数 放在i的索引位置上
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        for (int num :
                nums) {
            System.out.println(num);
        }
    }


    /**
     * 选择排序
     * 每次遍历数组 选择倒数第 1 小的数 一直先择到倒数第 n 小的数 一共要遍历 n 遍
     * 给数组中的每一个元素选择它应该在的位置
     */
    @Test
    public void test2() {
        int[] nums = new int[]{-5, -89, -6, -8, 5, 9, 45, 6, -596, -456, 888, -6, 9};
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;//较小数的索引 每次默认为未排序部分的首个元素索引
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;//找出未排序部分的最小值 将其索引值记录下来
                }
            }
            //将第i小的值放在第i位
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        for (int num :
                nums) {
            System.out.println(num);
        }
    }

    @Test
    public void test3() {
        int[] nums = new int[]{-5, -89, -6, -8, 5, 9, 45, 6, -596, -456, 888, -6, 9};
        //SelectSort
        //每次选择出第i小的数 放在指定的第i个位置上
        for (int i = 0; i < nums.length; i++) {
            int position = i;
            for (int j = i; j < nums.length; j++) {
                if(nums[j] < nums[position]){
                    position = j;//找到每一轮最小值的索引位置
                }
            }
            int temp = nums[position];
            nums[position] = nums[i];
            nums[i] = temp;
        }
        for (int num :
                nums) {
            System.out.println(num);
        }
    }
}
