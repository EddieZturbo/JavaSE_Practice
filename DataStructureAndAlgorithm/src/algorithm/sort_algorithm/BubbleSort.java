package algorithm.sort_algorithm;

/**
 @author EddieZhang
 @create 2022-09-21 8:47
 */

import org.junit.Test;

/**
 * 冒泡排序
 */
public class BubbleSort {
    @Test
    public void test1() {
        //冒泡排序 代码原始版
        int[] numbers = new int[]{-9, -8, -7, -6, -5, -4, -3, -2, 1, 5, 6, 8};
        int count = 0;
        for (int i = 0; i < numbers.length - 1; i++) {//大循环一共执行数组的长度 - 1 次
            for (int j = 0; j < numbers.length - 1 - i; j++) {//小循环在每个大循环中一共执行（数组长度 - 1 - i（确定最大的个数））次
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
                count++;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println("count = " + count);//count = 66 需要进行优化 若在一次循环中发现并未发生交换 则表明数组已有序 直接退出循环
    }

    @Test
    public void test2() {
        //冒泡排序 代码优化版
        int[] nums = new int[]{-9, -8, -7, -6, -5, -4, -3, -2, 1, 5, 6, 8};
        int count1 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;//每一个次大循环 的标记为true
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp1 = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp1;
                    count1++;
                    flag = false;//如果本次大循环有交换就将 标记改为false 表明继续下一个大循环
                }
            }
            if (flag) {
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("count1 = " + count1);//0
    }

    @Test
    public void test3() {
        //冒泡排序 代码最终版
        int[] nums = new int[]{-5, 5, 1, -5, -95, 1, 2, 3, 4, 5, 6};//前段为乱序 需要进行交换 后端为有序 无需再进行交换
        int count = 0;
        int theLastChangeIndex = 0;//记录最后一次交换的索引位置 用来确定有序区的范围
        int sortBorder = nums.length - 1;//无序数列的边界，每次比较只需要比到这里为止
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;//每一个次大循环 的标记为true
            for (int j = 0; j < sortBorder; j++) {//只需遍历无序区
                if (nums[j] > nums[j + 1]) {
                    flag = false;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    count++;
                    theLastChangeIndex = j;
                }
            }
            sortBorder = theLastChangeIndex;//根据最后一次交换的索引位置 确定有序区的范围
            if (flag) {
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("count = " + count);
    }


    /**
     * 冒泡排序
     * 优化冒泡排序
     * ①:数组已经有序
     *      无需进行后续的循环比较 通过在大循环开始时第一flag标记 若一轮结束未进行元素交换 表明数组有序了 无需继续后续的循环
     * ②:数组的后端有序
     *      每次大循环 无需对已经有序的段进行（无效）比较 因此需要借助两个变量记录有序的位置 并让后续循环直接跳过有序段 对无序段进行比较
     *      border边界    内层循环每次遍历到 < 边界（最后一个交换的元素前即可）
     *      theLastChange最后一个交换的元素位置（此位置的后续无需进行遍历）
     */
    @Test
    public void test5() {
        int[] nums = new int[]{-9, -8, -7, -6, -5, -4, -3, -2, 1, 100, -100, 5, 6, 8};
        int theLastChange = 0;
        int border = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {//外层循环 每次循环可以确定一个较大的元素 一共需要n-1次循环
            boolean flag = true;//每次一个大轮的循环开始时 flag为true 若这一轮中有无元素进行交换 表名数组已经有序 无需继续循环
            for (int j = 0; j < border; j++) {
                if (nums[j] > nums[j + 1]) {//每两个元素进行比较 若前一个>后一个就进行交换
                    flag = false;//如果有需要交换 表明目前数组非有序 需要继续进行下一轮的比较
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    theLastChange = j;//最后一个交换的元素位置
                }
            }
            border = theLastChange;//将最后一个交换的元素的位置 作为边界
            if (flag) {
                break;
            }
        }
        for (int num :
                nums) {
            System.out.println(num);
        }

    }

    @Test
    public void test6() {
        int[] nums = new int[]{12, 56, 855, -5, -55, 0, 15, 354, -986, 6566};
        //BubbleSort
        int border = nums.length - 1;//有序和无序的边界 边界的后面为有序 不需要再进行重复的比较
        int end = 0;//最后一个交换的位置索引 表明此索引后的元素已经有序
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < border; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = false;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    end = j;
                }
            }
            //循环结束后 找到最后一个交换的位置 即为边界
            border = end;
            if (flag) {
                break;
            }
        }
        //遍历输出BubbleSort后的数组
        for (int num :
                nums) {
            System.out.println(num);
        }
    }

    @Test
    public void test7() {
        //bubbleSort
        int[] nums = new int[]{12, 56, 855, -5, -55, 0, 15, 354, -986, 6566};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tem = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tem;
                }
            }
        }
        for (int item :
                nums) {
            System.out.println(item);
        }

    }

    /**
     * doubleSort
     */
    @Test
    public void test8() {
        int[] nums = new int[]{12, 56, 855, -5, -55, 0, 15, 354, -986, 6566};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for (int item :
                nums) {
            System.out.println(item);
        }


    }

    /**
     * bubbleSort
     * eventually version
     */
    @Test
    public void test9() {
        int[] nums = new int[]{12, 56, 855, -5, -55, 0, 15, 354, -986, 6566};
        int lastChangeIndex = 0;
        int border = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < border; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = false;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    lastChangeIndex = j;
                }
            }
            border = lastChangeIndex;
            if (flag) {
                break;
            }
        }
        for (int item :
                nums) {
            System.out.println(item);
        }


    }

    /**
     * bubble sort
     */
    @Test
    public void bubbleSortTest10() {
        int[] nums = new int[]{12, 56, 855, -5, -55, 0, 15, 354, -986, 6566};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for (int item :
                nums) {
            System.out.println(item);
        }
        System.out.println("8888888888888888888888888888888888888");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }


}
