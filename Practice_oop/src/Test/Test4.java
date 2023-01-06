package Test;

import java.util.HashMap;
import java.util.Map;

/**
 @author EddieZhang
 @create 2022-10-07 22:37
 */
public class Test4 {
    public static void main(String[] args) {
        int [] nums = new int[]{1,248,6,848,35,6,86,5,21};
        Test4 test4 = new Test4();
        int[] result = test4.test(nums, 1);
        if (result == null){
            System.out.println("数组中没有满足的结果哦~~");
        }else {
            System.out.printf("结果是[%d,%d]",result[0],result[1]);
        }


    }
    public int [] test(int [] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();//定义一个map用来储存数值（key）以及其在数组中的索引位置（value）
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){//判断map中是否有一个值加上数组中的值等于target
                //如果这个值存在 则返回这个值的value（在数组中对应的索引）以及数组中的值的索引
                return new int[]{map.get(target - nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        //若遍历完整个数组未发现结果 则返回null
        return null;
    }
}
