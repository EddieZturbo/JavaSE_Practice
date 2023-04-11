package algorithm.search_algorithm;

/**
 @author EddieZhang
 @create 2022-09-29 13:55
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class BinarySearch {
    /**
     * 二分查找算法
     * 思路 对有序数组进行二分法查找
     * 将数组分成左右两段 中间值为key 如果要找的值为key就直接返回 如果要找的值小于key 就在左边进行遍历查找 如果要找的值大于key就在右边进行遍历查找
     * 左端和右段可以继续按照上诉情况继续进行二分查找
     * 当全部遍历完成后未发现有值是和要找的值相等的 就返回-1表明找不到
     */
    @Test
    public void test1() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(nums, 0, nums.length - 1, 9));
        System.out.println(binarySearch.binarySearch(nums, 1));
    }

    //递归方法
    public int binarySearch(int[] nums, int left, int right, int value) {
        if (right < left){
            //递归的结束条件
            return -1;
        }
        int middle = ((right - left) >> 1) + left;
        if (value < nums[middle]){
            //value将在数组的左侧
            return binarySearch(nums,left,middle - 1,value);
        }else if(value > nums[middle]){
            //value将在数组的右侧
            return binarySearch(nums,middle + 1,right,value);
        }else {
            return middle;
        }
    }


    //非递归
    public int binarySearch(int[] nums, int value) {
        //如果目标值不在数组的范围内则直接返回-1（判断目标值是否比最小的小比最大的大即表明不在数组范围内）
        if (value < nums[0] && value > nums[nums.length - 1]) {
            return -1;
        }
        int leftIndex = 0;//最左元素的指针
        int rightIndex = nums.length - 1;//最有元素的指针
        while (leftIndex <= rightIndex) {
            int middle = ((rightIndex - leftIndex) >> 1) + leftIndex;//数组的中间元素指针
            if (value > nums[middle]) {
                //表明目标值在数组的右侧
                leftIndex = middle + 1;
            } else if (value < nums[middle]) {
                //表明目标值在数组的左侧
                rightIndex = middle - 1;
            } else {
                //中间值就是目标值 直接返回
                return middle;
            }
        }
        //循环结束表明没找到则返回-1
        return -1;
    }


    /**
     * 二分查找算法优化
     * 查找有序数组中指定值的位置 所有的值
     * 返回结果在一个集合中
     */
    @Test
    public void test2() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7, 8, 9};
        List<Integer> integers = BinarySearch2(nums, 7);
        System.out.println(integers);


    }

    /**
     *
     * @param nums 一个有序数组
     * @param target 指定要查找的值
     * @return 返回查找到的所有的值的位置 返回一个List集合中
     */
    public List<Integer> BinarySearch2(int[] nums, int target) {
        int left = 0;//数组的左边界
        int right = nums.length - 1;//数组的右边界
        List<Integer> list = new ArrayList<>();
        while (left <= right) {
            int middle = (right - left) / 2 + left;//将数组进行二分的中间界
            if (target < nums[middle]) {//如果目标在中间界的左边 则将数组的右边界更新为中间界-1
                right = middle - 1;
            } else if (target > nums[middle]) {//如果目标在中简界的右边 则将数组的左边界更新为中间界+1
                left = middle + 1;
            } else {//表明找到了
                //目标也许不止一个 找到一个后继续进行左右的搜索 找到所有的
                //向左边搜索
                int temp = middle - 1;
                while (true) {
                    if (temp < left || nums[temp] != target) {
                        break;
                    } else {
                        list.add(temp);
                        temp -= 1;
                    }
                }
                list.add(middle);
                //向右边搜索
                int temp1 = middle + 1;
                while (true) {
                    if (temp1 > right || nums[temp1] != target) {
                        break;
                    } else {
                        list.add(temp1);
                        temp1 += 1;
                    }
                }
                return list;
            }
        }
        list.add(-1);
        return list;
    }
}


