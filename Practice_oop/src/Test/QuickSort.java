package Test;

/**
 @author EddieZhang
 @create 2022-09-28 8:34
 */

/**
 * 快速排序 基本思想 递归寻找基准的  准确位置 将数组划分成两段 基准左边为不大于基准的 右边为不小于基准的
 * 需要用到的临时变量
 * 指向基准的指针 指向数组最左端的指针 指向数组最右端的指针
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, 346, -565, 0, 599, -6, 4641, 4646, -1, 46, -2};
        QuickSort quickSort = new QuickSort();
        quickSort.searchKey(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    //定义基准 前后双指针寻找基准的准确位置
    //基准将数组分成两段 左端不大于基准 右端不小于基准
    //递归将基准的两段分别进行相同的操作
    public void searchKey(int[] array, int left, int right) {
        if (left >= right) {//递归终止条件
            return;
        }
        //定义三个变量
        int key = array[left];//指向基准的指针 默认为数组的最左侧
        int leftIndex = left;
        int rightIndex = right;
        //左右指针相继向中间遍历
        while (leftIndex != rightIndex) {
            //由于基准在数组的左侧 因此 右侧指针先行遍历
            while (leftIndex < rightIndex && array[rightIndex] >= key) {
                //如果右侧指针遍历到的元素不小于基准 则继续向中间遍历 否则将其交换至左侧指针位置
                rightIndex--;
            }
            array[leftIndex] = array[rightIndex];

            while (leftIndex < rightIndex && array[leftIndex] <= key) {
                //如果左侧的指针遍历到的元素不大于基准 则继续向中间遍历 否则将其交换至右侧指针位置
                leftIndex++;
            }
            array[rightIndex] = array[leftIndex];

        }
        //当左右指针相遇 表明找到基准的准确位置
        array[leftIndex] = key;


        //递归
        //基准的左段
        searchKey(array, left, leftIndex - 1);
        //基准的右段
        searchKey(array, leftIndex + 1, right);


    }
}

