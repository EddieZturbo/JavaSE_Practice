package algorithm.sort_algorithm;

/**
 @author EddieZhang
 @create 2022-09-21 20:52
 */

import org.junit.Test;

/**
 * 快速排序
 */
public class QuickSort {
    @Test
    public void test1() {
        int[] nums = new int[]{-12, 56, 25, 98, 33, -65, 1, 3, 4, 6, -5, -999, 15, 2, 25, 33, 17};
//        sort(nums, 0, nums.length - 1);
//        for (int num :
//                nums) {
//            System.out.println(num);
//        }
        sort1(nums, 0, nums.length - 1);
        for (int num :
                nums) {
            System.out.println(num);
        }
    }


//    public void sort(int[] array, int left, int right) {
//        if (left > right) {
//            return;
//        }
//        int temp = array[left];
//        int leftIndex = left;
//        int rightIndex = right;
//        while (leftIndex != rightIndex) {
//            while (leftIndex < rightIndex && array[rightIndex] >= temp) {
//                rightIndex--;
//            }
//            array[leftIndex] = array[rightIndex];
//            while (leftIndex < rightIndex && array[leftIndex] <= temp) {
//                leftIndex++;
//            }
//            array[rightIndex] = array[leftIndex];
//        }
//        array[leftIndex] = temp;
//
//
//        //递归调用
//        sort(array, left, leftIndex - 1);
//        sort(array, leftIndex + 1, right);
//
//
//    }


    //快速排序
    public void sort1(int[] array, int left, int right) {
        if (right < left) {
            return;
        }
        int temp = array[left];//基准 默认为 数组的第一个元素
        int leftIndex = left;
        int rightIndex = right;


        //寻找 基准的准确索引位置 通过 左 右 指针 分别向数组中间移动寻找
        //最右边的指针向左遍历 发现是大于等于基准的元素 就继续向左移
        //发现小于基准的元素 就赋给最左边指针所在索引位置
        //最左边的指针向右遍历 发现是小于等于基准的元素 就继续向左移
        //发现小于基准的元素 就赋给最右边的指针所在位置
        //直至 左 右 指针 相遇处 即基准的准确索引位置
        //应该以上操作 保证基准元素的左侧都是小于等于基准的 右侧都是大于等于基准的

        while (leftIndex != rightIndex) {//while循环结束表明 左 右 指针 相遇处 即基准的准确索引位置
            //由于定的基准在最左侧 因此要从最右侧开始先

            while (leftIndex < rightIndex && array[rightIndex] >= temp) {//右边指针
                //最右边的指针向左遍历 发现是大于等于基准的元素 就继续向左移
                rightIndex--;
            }//发现小于基准的元素 就赋给最左边指针所在索引位置
            array[leftIndex] = array[rightIndex];

            while (leftIndex < rightIndex && array[leftIndex] <= temp) {//左边指针
                leftIndex++;//最左边的指针向右遍历 发现是小于等于基准的元素 就继续向左移
            }//发现小于基准的元素 就赋给最右边的指针所在位置
            array[rightIndex] = array[leftIndex];
        }

        //while循环结束表明 左 右 指针 相遇处 即基准的准确索引位置
        //将基准赋值在准确的索引位置上
        array[leftIndex] = temp;

        //至此 第一轮找到整个数组的基准准确位置 基准的左侧均为小于等于的值 右侧均为大于等于的值
        //递归调用 对基准的左侧和右侧进行同上操作
        sort1(array, left, leftIndex - 1);//基准的左侧
        sort1(array, leftIndex + 1, right);//基准的右侧
    }


    /**
     * 快速排序
     */
    public void sort2(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        //寻找基准位置默认基准数为数组的第一个元素 每一遍 寻找一个基准 最为数组的中间值 通过左右两个指针向中间遍历 寻找基准的准确索引位置
        int kay = array[left];//基准数
        int liftIndex = left;//数组左侧的指针
        int rightIndex = right;//数组右侧的指针

        while (liftIndex != rightIndex) {//表明 左右 指针指向同一个索引位置 即为基准的位置
            //由于基准为最左侧的元素 右侧指针先出发向中间遍历
            while (liftIndex < rightIndex && array[rightIndex] >= kay) {
                rightIndex--;//如果右侧指针指向的元素大于基准 则继续向中间移动
            }
            //反之 将小于基准的元素 赋值给左侧指针指向的索引位置
            array[liftIndex] = array[rightIndex];

            //左侧指针出发向中间遍历
            while (liftIndex < rightIndex && array[liftIndex] <= kay) {
                liftIndex++;//如果左侧指针指向的元素 大于基准 则继续向中间移动
            }
            //反之 将大于基准的元素 赋值给右侧指针指向的索引位置
            array[rightIndex] = array[liftIndex];
        }
        //while循环结束 表明左右 指针指向同一个索引位置 即为基准的位置
        //将此索引位置赋值为基准
        array[liftIndex] = kay;

        //第一遍遍历 基准将数组分为两端 左端全部为不大于基准 右端全部为不小于基准
        //对数组的 左右 两段继续调用以上方法
        //左段 基准的左边
        sort2(array, left, liftIndex - 1);
        //右段 基准的右边
        sort2(array, liftIndex + 1, right);
    }


    /**
     * 快速排序
     * 定义基准 定义左右两边的指针 寻找基准的准确位置
     * 基准的准确位置将数组划分为两段 左段为小于基准的 右段为大于基准的
     * 递归调用 对左段和右段进行相同的操作
     * 直至一个数组的 左右 指针 指向同一个 表明已经排序完成
     */
    @Test
    public void test2() {
        int[] nums = new int[]{-12, 56, 25, 98, 33, -65, 1, 3, 4, 6, -5, -999, 15, 2, 25, 33, 17};
        quickSort(nums, 0, nums.length - 1);
        for (int num :
                nums) {
            System.out.println(num);
        }
    }


    public void quickSort(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return;
        }
        int left = leftIndex;//the first item index
        int right = rightIndex;//the end item index
        int middle = nums[leftIndex];//the middle item initial is the first item
        while (left != right) {
            while (left < right && middle <= nums[right]) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && middle >= nums[left]) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = middle;

        //recursion
        quickSort(nums, leftIndex, left - 1);//left section
        quickSort(nums, left + 1, rightIndex);//right section


    }

}
