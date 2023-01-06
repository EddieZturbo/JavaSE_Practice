package Test;

/**
 @author EddieZhang
 @create 2022-09-29 9:59
 */

/**
 * 简单插入排序 分析
 * 将数组默认分为两段 有序段和无序段
 * 最开始将数组的首元素 作为有序段的末尾元素 后续的即为无序段
 * 将无序段的元素依次按照顺序插入到有序段中 待插入元素与有序段的末尾元素进行比较 若大于待插入元素 则将末尾元素后移一位 若不大于待插入元素 则将待插入元素接在此元素后
 */
public class InsertionSort {
    public static void main(String[] args) {
        int [] nums = new int[]{-5,12,-546,0,1545,-596,13};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(nums);
        for(int num : nums  ){
            System.out.println(num);
        }
    }

    public void insertionSort(int[] nums) {
        //定义临时遍历用于遍历数组
        for (int i = 0; i < nums.length - 1; i++) {
            //每一次都将数组划分为有序段和无序段
            int leftLastIndex = i;//左段有序段的末尾元素索引
            int rightFirst = nums[i + 1];//右段无序段的待插入元素
            while (leftLastIndex >= 0 && nums[leftLastIndex] >= rightFirst) {
                nums[leftLastIndex + 1] = nums[leftLastIndex];
                leftLastIndex--;
            }
            nums[leftLastIndex + 1] = rightFirst;
        }
    }
}




