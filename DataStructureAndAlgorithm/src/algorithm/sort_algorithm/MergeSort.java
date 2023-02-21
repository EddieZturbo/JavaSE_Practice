package algorithm.sort_algorithm;

/**
 @author EddieZhang
 @create 2022-09-23 13:21
 */

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 3, 7, 11, 2, 52, 9};
        int[] temp = new int[array.length];
        MergeSort mergeSort = new MergeSort();
        mergeSort.partition(array,temp,0,array.length - 1);
        for (int item :
                array) {
            System.out.println(item);
        }
    }

    /**
     * 归并排序
     * 分治思想 先分后治
     * 分
     */
    public void partition(int[] originArray, int[] tempArray, int left, int right) {
        if (left == right) {//当划分到第一个元素的时候就停止递归
            return;
        }
        int mid = ((right - left) / 2) + left;//中间值
        //分
        partition(originArray, tempArray, left, mid);//左端
        partition(originArray, tempArray, mid + 1, right);//右端

        //合并
        merge(originArray,tempArray,left,mid,right);
    }

    /**
     * 归并排序
     * 先分后治
     * 合并（治）
     */
    public void merge(int[] originArray,int[] tempArray,int left,int mid,int right) {
        int leftFirstIndex = left;
        int rightFirstIndex = mid + 1;
        int tempFirstIndex = 0;
        //进行合并排序
        while(leftFirstIndex <= mid && rightFirstIndex <= right){
            if(originArray[leftFirstIndex] < originArray[rightFirstIndex]){
                tempArray[tempFirstIndex++] = originArray[leftFirstIndex++];
            }else{
                tempArray[tempFirstIndex++] = originArray[rightFirstIndex++];
            }
        }
        //当右端全部排序完成后 左端若还有未进行排序的元素直接依次放入temp数组中
        while(leftFirstIndex <= mid){
            tempArray[tempFirstIndex++] = originArray[leftFirstIndex++];
        }
        //当左端全部排序完成后 右端若还有未进行排序的元素直接依次放入temp数组中
        while(rightFirstIndex <= right){
            tempArray[tempFirstIndex++] = originArray[rightFirstIndex++];
        }
        
        //将temp数组中的有序的元素转移到origin数组中
        tempFirstIndex = 0;//临时数组的首元素指针
        int tempIndex = left;//数组的首元素的临时指针
        while(tempIndex <= right){
            originArray[tempIndex++] = tempArray[tempFirstIndex++];
        }
    }
}
