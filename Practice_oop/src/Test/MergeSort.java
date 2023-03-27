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
        mergeSort.mergeSort(nums, temp, 0, nums.length - 1);
        for (int num :
                nums) {
            System.out.println(num);
        }

    }

    //分
    public void mergeSort(int[] originArray, int[] tempArray, int left, int right) {
        if(left == right){//当划分到只剩下一个元素的时候就停止划分
            return;
        }
        int mid = ((right - left) >> 1) + left;
        //对数组的左段和右段分别进行递归划分
        mergeSort(originArray, tempArray, left, mid);
        mergeSort(originArray, tempArray, mid + 1, right);

        //合并（治理）
        merge(originArray,tempArray,left,mid,right);
    }


    //治
    public void merge(int[] originArray, int[] tempArray, int left, int mid, int right) {
        int leftFirstIndex = left;//左段的首元素指针
        int rightFirstIndex = mid + 1;//右段的首元素指针
        int tempFirstIndex = 0;//临时数组的首元素指针
        while(leftFirstIndex <= mid && rightFirstIndex <= right){
            if(originArray[leftFirstIndex] <= originArray[rightFirstIndex]){
                tempArray[tempFirstIndex++] = originArray[leftFirstIndex++];
            }else{
                tempArray[tempFirstIndex++] = originArray[rightFirstIndex++];
            }
        }
        //若左端的元素未完全进行排序的 则直接依次放置temp数组中
        while (leftFirstIndex <= mid){
            tempArray[tempFirstIndex++] = originArray[leftFirstIndex++];
        }
        //若右端的元素未完全进行排序的 则直接依次放置temp数组中
        while (rightFirstIndex <= right){
            tempArray[tempFirstIndex++] = originArray[rightFirstIndex++];
        }
        //至此 所有的元素有序的在temp数组中 将temp数组的所有元素依次赋值到origin数组中即可
        tempFirstIndex = 0;
        int tempIndex = left;
        while(tempIndex <= right){
            originArray[tempIndex++] = tempArray[tempFirstIndex++];
        }


    }

}