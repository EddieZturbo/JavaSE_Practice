package Test;

import java.util.HashMap;
import java.util.Map;

/**
 @author EddieZhang
 @create 2022-09-21 22:54
 */
public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int[] ints = test3.twoSum(new int[]{1, 15, 35, 2555, 6, 2, 0}, 8);
        for (int num :
                ints) {
            System.out.println(num);
        }

    }
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int [2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return null;

    }
}
