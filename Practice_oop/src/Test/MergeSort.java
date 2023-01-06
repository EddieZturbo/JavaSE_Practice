package Test;

/**
 @author EddieZhang
 @create 2022-09-27 1:06
 */
public class MergeSort {


    public static void main(String[] args) {
        //MergeSort
        //分治思想 先分 后治
        int[] nums = new int[]{12, 546, 21313, 545, -5, 0, 546, -5959, 3486, -59789879, -1};
        int[] temp = new int[nums.length];
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(nums, 0, nums.length - 1, temp);
        for (int num :
                nums) {
            System.out.println(num);
        }

    }

    //分
    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {//递归终止条件
            return;
        }

        int mid = (right - left) / 2 + left;//数组的中线 将数组分成两部分

        //对数组的两段再次划分 直至无法进行划分
        mergeSort(nums, left, mid, temp);//左段
        mergeSort(nums, mid + 1, right, temp);//右段

        //治
        merging(nums, left, mid, right, temp);

    }


    //治
    public void merging(int[] nums, int left, int mid, int right, int[] temp) {
        int leftIndex = left;//左段的首元素指针
        int rightIndex = mid + 1;//右段的首元素指针
        int tempIndex = 0;//临时数组的首元素指针
        while (leftIndex <= mid && rightIndex <= right) {
            if(nums[rightIndex] < nums[leftIndex]){
                temp[tempIndex++] = nums[rightIndex++];
            }else {
                temp[tempIndex++] = nums[leftIndex++];
            }
        }
        while(leftIndex <= mid){
            temp[tempIndex++] = nums[leftIndex++];
        }
        while(rightIndex <= right){
            temp[tempIndex++] = nums[rightIndex++];
        }

        //将temp数组copy至数组中
        tempIndex = 0;
        int arrayIndex = left;
        while (arrayIndex <= right) {
            nums[arrayIndex++] = temp[tempIndex++];
        }
    }


    /**
     * 先分 后治
     * 分
     * 将数组分成两段 将分成两段的数组的每一段再进行划分 直至数组无法再进行划分为止
     *
     * 治
     * 将数组进行有序合并 直至数组合并成一个有序的整体
     * 使用到两个零时变量 一个在左段数组的首元素指针 一个在右段数组的首元素指针
     * 比较两个指针对应的元素的大小 较小的赋值进入到临时数组中 直至其中一段先将所有元素按顺序放置在临时数组中 另外一段则直接将剩余元素 依次放置临时数组 此时临时数组为有序数组
     * 将临时数组的所有元素copy到原来数组中
     * 使用到 一个临时数组 用于临时储存每一段的排序
     */


}