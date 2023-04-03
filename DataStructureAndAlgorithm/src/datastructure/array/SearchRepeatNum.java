package datastructure.array;

import java.util.HashSet;

/**
 @author EddieZhang
 @create 2023-04-03 5:17 PM
 */
public class SearchRepeatNum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 6, 6, 5, 5, 5, 8, 4, 56, 6, 3, 158, 4, 2, 1, 3, 58, 4, 8};
        System.out.println(searchRepeatNum(nums));
    }

    /**
     * 查找数组中的重复元素 遇到重复的元素就返回 没有就返回-1
     * @param nums
     * @return
     */
    public static int searchRepeatNum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int item :
                nums) {
            if (set.contains(item)) {
                return item;
            }
            set.add(item);
        }
        return -1;
    }

}
