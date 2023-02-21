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

    public void searchKey(int[] array,int leftIndex,int rightIndex){
        if(leftIndex > rightIndex){
            return;
        }
        int left = leftIndex;//数组的左侧指针
        int right = rightIndex;//数组的右侧指针
        int key = array[leftIndex];//基准 初始为数组的左侧元素
        while(left != right){
            while(left < right && array[right] >= key){
                right--;
            }
            array[left] = array[right];
            while(left < right && array[left] <= key){
                left++;
            }
            array[right] = array[left];
        }
        //至此 left和right指针相遇时 为基准key的准确位置 将key赋值到准确的位置上
        array[left] = key;

        //分别对基准的左右两端进行递归快排
        searchKey(array,leftIndex,left - 1);//基准的左侧
        searchKey(array,leftIndex + 1,rightIndex);//基准的右侧
    }
}

