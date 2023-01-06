package algorithm.sort_algorithm;

/**
 @author EddieZhang
 @create 2022-09-23 13:21
 */

import org.junit.Test;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 3, 7, 11, 2, 52, 9};
        int[] temp = new int[array.length];
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergingSort(array, 0, array.length - 1, temp);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void mergingSort(int[] beforeArray, int left, int right, int[] tempArray) {
        if (left == right) {//当划分到一个元素一组时就结束递归
            return;
        }
        //将原数组进行递归划分 将数组划分为左右两段
        int mid = (right - left) / 2 + left;//mid为数组的中线 左段的最后一个元素
        //进行左段的递归划分
        mergingSort(beforeArray, left, mid, tempArray);
        //进行右段的递归划分
        mergingSort(beforeArray, mid + 1, right, tempArray);

        //将划分的数组进行排序合并
        merge(beforeArray, left, mid, right, tempArray);

    }

    //将划分的数组进行排序合并
    public void merge(int[] array, int left, int mid, int right, int[] temp) {
        int l0 = left;//指向左段首元素索引的指针
        int r0 = mid + 1;//指向右段首元素索引的指针
        int temp0 = 0;//指向temp数组首元素索引的指针
        //进行排序合并
        while (l0 <= mid && r0 <= right) {
            if (array[l0] < array[r0]) {
                temp[temp0++] = array[l0++];
            } else {
                temp[temp0++] = array[r0++];
            }
        }
        //如果左段已经排序完毕 而右段仍有元素 则将有段的剩余元素依次放入temp数组中
        while (r0 <= right) {
            temp[temp0++] = array[r0++];
        }
        //如果右段已经排序完毕 而左段仍有元素 则将左段的剩余元素依次放入temp数组中
        while (l0 <= mid) {
            temp[temp0++] = array[l0++];
        }

        //将temp中的元素copy至原数组中
        temp0 = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            array[tempLeft] = temp[temp0];
            temp0 += 1;
            tempLeft += 1;
        }
    }


    /**
     * 归并排序
     * 分治的思想 借助临时数组（空间换时间）
     * 先分   将数组进行递归的划分为左右两段 直至划分到以单个元素为一组
     * 后治   将每组进行有序合并 直至数组合并为一个完整的即可
     */
    @Test
    public void test1() {
        int[] array = new int[]{5, 1, 3, 7, 11, 2, 52, 9};
        int [] temp = new int[array.length];
        mergingSort1(array,0,array.length - 1,temp);
        for (int num :
                array) {
            System.out.println(num);
        }
    }

    /**
     * 分
     */
    public void mergingSort1(int[] array, int left, int right, int[] temp) {
        if (left == right) {//递归的终止条件
            return;
        }
        int mid = (right - left) / 2 + left;//每次划分数组的中线 为左段的最后一个元素位置


        //递归划分数组
        //划分数组的左段
        mergingSort1(array, left, mid, temp);
        //划分数组的右段
        mergingSort1(array, mid + 1, right, temp);

        //治
        merge1(array,left,mid,right,temp);
    }

    /**
     * 治
     * 分好组的元素进行比较
     * 借助临时变量 左段的首元素指针 右段的首元素指针
     * 两边的元素进行比较 选出小的一个放进temp数组中 小的那一段的指针继续向后移动 直至比较所有的元素 若另一段还有元素 则依次放入temp数组中即可
     */
    public void merge1(int[] array, int left, int mid, int right, int[] temp) {
        int temp0 = 0;//temp数组的首元素指针
        int left0 = left;//左段的首元素指针
        int right0 = mid + 1;//右段的首元素指针
        while (left0 <= mid && right0 <= right) {
            if (array[left0] < array[right0]) {
                temp[temp0++] = array[left0++];
            } else {
                temp[temp0++] = array[right0++];
            }
        }
        while (right0 <= right) {
            temp[temp0++] = array[right0++];
        }
        while (left0 <= mid) {
            temp[temp0++] = array[left0++];
        }
        //将temp中的元素copy到array数组中
        temp0 = 0;//temp数组指针位置置为首元素
        int arrayIndex = left;//数组的最左侧元素位置
        while(arrayIndex <= right){
            array[arrayIndex++] = temp[temp0++];
        }
    }
}
