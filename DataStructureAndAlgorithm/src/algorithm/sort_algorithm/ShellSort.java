package algorithm.sort_algorithm;

/**
 @author EddieZhang
 @create 2022-09-21 14:32
 */

import org.junit.Test;

/**
 * 希尔排序
 */
@SuppressWarnings(value = "all")
public class ShellSort {
    @Test
    public void test1() {
        int[] nums = new int[]{-12, 56, 25, 98, 33, -65, 1, 3, 4, 6, -5, -999, 15, 2, 25, 33, 17};
        int gap = nums.length;//gap的值

        while (true) {
            if (gap == 1) {
                break;
            }
            gap = gap >> 1;//每一趟排序将增量缩减至原本的一半
            //根据增量分组 对每一组进行直接插入排序
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < nums.length; j = j + gap) {

                    int preNum = j - gap;//有序段的末尾元素的索引位置
                    int current = nums[j];//无序段的首元素 即要插入至有序段的元素的值
                    while (preNum >= 0 && nums[preNum] > current) {//从有序段末尾元素开始至有序段的首元素 判断有序段的元素是否大于待插入元素 若大于则后移一位
                        nums[preNum + gap] = nums[preNum];
                        preNum -= gap;//从有序段末尾元素开始至有序段的首元素
                    }
                    //当出while循环表明 遇到不大于待插入元素的 就将待插入元素置于其后一个位置
                    nums[preNum + gap] = current;
                }
            }
        }
        for (int num :
                nums) {
            System.out.println(num);
        }
    }

    //希尔排序
    @Test
    public void test2() {
        int[] nums = new int[]{-12, 56, 25, 98, 33, -65, 1, 3, 4, 6, -5, -999, 15, 2, 25, 33, 17};
        int gap = nums.length;//增量
        while (true) {
            if (gap == 1) {
                break;
            }
            gap = gap >> 1;//增量每次逐渐减少为原来的二分之一
            //根据增量进行分组
            for (int i = 0; i < gap; i++) {

                //对每组进行插入排序
                for (int j = i; j < nums.length - gap; j += gap) {
                    int preNum = j;//有序段的末尾元素的索引
                    int current = nums[j + gap];//待插入的元素值 位于有序段的末尾元素的后gap个
                    while (preNum >= i && nums[preNum] > current) {
                        nums[preNum + gap] = nums[preNum];
                        preNum -= gap;
                    }
                    nums[preNum + gap] = current;
                }
            }
        }
        for (int num :
                nums) {
            System.out.println(num);
        }
    }


    /**
     * 希尔排序
     * 插入排序的改良 （插入排序中 如果出现数组普遍后段较小 那么需要比较的次数就很多 ）为了改良————》希尔排序
     * 核心是 定义增量
     * 先将数组按照增量进行分组 将分组进行插入排序
     * 当增量为1时 数组为一个完整的有序的数组
     *
     */
    @Test
    public void test3() {
        int[] nums = new int[]{-12, 56, 25, 98, 33, -65, 1, 3, 4, 6, -5, -999, 15, 2, 25, 33, 17};
        //定义增量int
        int gap = nums.length;
        while (true) {
            if (gap == 1) {//当增量为1时 数组为一个完整的有序的数组
                break;
            }
            //增量缩减
            gap = gap >> 1;//每次缩减为原本的二分之一
            //按照增量进行分组
            for (int i = 0; i < gap; i++) {
                //对每组进行简单插入排序
                for (int j = i; j < nums.length - gap; j += gap) {
                    int sortedLast = j;//有序的末尾元素位置
                    int first = nums[j + gap];//无序的首元素
                    while (sortedLast >= i && nums[sortedLast] >= first) {
                        nums[sortedLast + gap] = nums[sortedLast];//若大于待插入元素 则后移
                        sortedLast -= gap;//有序段向前指
                    }
                    //出while循环 表明找到了小于待插入元素的 将待插入元素赋值在其后
                    nums[sortedLast + gap] = first;
                }
            }

        }
        for (int num :
                nums) {
            System.out.println(num);
        }

    }

    @Test
    public void test4() {
        int[] nums = new int[]{-12, 56, 25, 98, 33, -65, 1, 3, 4, 6, -5, -999, 15, 2, 25, 33, 17};
        //ShellSort
        //关键就是增量缩减
        //定义增量
        int gap = nums.length;
        while(true){
            gap = gap >> 1;
            for (int i = 0; i < gap; i++) {
                for (int j = i; j < nums.length - gap; j += gap) {
                    int preNum = j;
                    int current = nums[j + gap];
                    while (preNum >= i && nums[preNum] > current){
                        nums[preNum + gap] = nums[preNum];
                        preNum -= gap;
                    }
                    nums[preNum + gap] = current;
                }

            }
            if(1 == gap){
                break;
            }
        }
        for (int num :
                nums) {
            System.out.println(num);
        }
    }




}

