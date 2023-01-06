package algorithm.search_algorithm;

import org.junit.Test;

/**
 @author EddieZhang
 @create 2022-10-10 11:07
 */
public class InterpolationSearch {

    /**
     * 插值插值
     * 相对于二分查找的改变
     * 前提是有序的序列 对于分布均匀的序列 使用插值插值效率优于二分查找 反之
     * 查找思路与二分查找相同 关键点在于求中间界限的公式不同
     * int mid = left + (right - left) * (target - nums[left]) / (nums[right] - nums[left]);
     */
    @Test
    public void test1() {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        int search = search(nums, 100);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (target < nums[left] || target > nums[right]) {
            return -1;
        }
        while (left <= right) {
            int mid = left + (right - left) * (target - nums[left]) / (nums[right] - nums[left]);
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
