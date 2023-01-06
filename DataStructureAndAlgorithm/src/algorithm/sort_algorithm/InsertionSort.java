package algorithm.sort_algorithm;

/**
 @author EddieZhang
 @create 2022-09-21 13:09
 */

import org.junit.Test;

/**
 * 插入排序
 */
public class InsertionSort {
    @Test
    public void test1() {
        int[] nums = new int[]{-5, -8, -6, 8, -5, 9, -45, 6, 45, 91, 2, -9, 2, -8};
        //默认将数组分为两端 一段为有序（开始时默认第一个元素为有序） 一段为未排序

        for (int i = 0; i < nums.length - 1; i++) {//外层从无序段开始遍历每一个未排序的元素有序的插入到有序段
            int preNum = i;//有序段的最后一个元素的索引位置
            int current = nums[i + 1];//记录无序段的要插入的元素
            //无序段的要插入元素要与有序段从最后一个开始到有序段的第一个的每一个元素进行比较
            while (preNum >= 0 && nums[preNum] > current) {//如果有序段的元素>要插入的元素就后移
                nums[preNum + 1] = nums[preNum];
                preNum--;//有序段元素的前一个 直至第一个为止
            }
            //退出while循环表明待插入元素遇到不大于的了 即将待插入元素置于遇到的不大于的元素后一位
            nums[preNum + 1] = current;
        }
        for (int num :
                nums) {
            System.out.println(num);
        }
    }


    /**
     * 插入排序
     * 将数组默认分为两段
     * 一段为有序段（最开始默认数组的首元素为有序段）
     * 一段为无序段
     * 需要两个变量 记录有序段的末尾元素位置 记录无序段的首元素（默认位于有序段的末尾元素的后一个）
     * 循环将无序段的首元素进行向有序段按序插入操作
     *      将无序段的首元素与有序段的元素进行比较 从有序段的末尾开始 一直到有序段的首元素停止
     *          若有序段的元素>=无序段的首元素 则将此有序段的元素向后移动一位 无序段的首元素继续和有序段的后续元素进行比较
     *          若遇到有序段的元素<无序段的首元素 则将此无序段的元素赋值于此有序段的元素后一位即可
     */
    @Test
    public void test2(){
        int[] nums = new int[]{-5, -8, -6, 8, -5, 9, -45, 6, 45, 91, 2, -9, 2, -8};
        for (int i = 0; i < nums.length - 1; i++) {
        int sortedLast = i;//有序段的末尾元素索引 最初默认为数组的首元素
        int right0 = nums[sortedLast + 1];//无序段的首元素 默认位于有序段的末尾元素的后一个
            while(sortedLast >= 0 && nums[sortedLast] >= right0){//将无序段的首元素与有序段的元素进行比较 从有序段的末尾开始 一直到有序段的首元素停止
                //若有序段的元素>=无序段的首元素 则将此有序段的元素向后移动一位 无序段的首元素继续和有序段的后续元素进行比较
                nums[sortedLast + 1] = nums[sortedLast];
                sortedLast--;
            }
            //出了while循环表明遇到了<right0的元素 将right0元素插入此元素的后一个即可
            nums[sortedLast + 1] = right0;
        }
        for (int num :
                nums) {
            System.out.println(num);
        }

    }

    @Test
    public void test3(){
        int[] nums = new int[]{-5, -8, -6, 8, -5, 9, -45, 6, 45, 91, 2, -9, 2, -8};
        //InsertSort
        for (int i = 0; i < nums.length - 1; i++) {
            int end = i;//有序部分的末尾元素索引
            int first = nums[i + 1];//无序部分的首元素 即待插入元素
            for (int j = i; j < nums.length - 1; j++) {
                while(end >= 0 && nums[end] >= first){
                    nums[end + 1] = nums[end];
                    end--;
                }
                nums[end + 1] = first;
            }
        }
        //InsertSort后的数组进行输出
        for (int num :
                nums) {
            System.out.println(num);
        }

    }

}
