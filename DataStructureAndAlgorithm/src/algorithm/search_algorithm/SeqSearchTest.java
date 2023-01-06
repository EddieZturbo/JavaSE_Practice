package algorithm.search_algorithm;

/**
 @author EddieZhang
 @create 2022-09-29 13:23
 */

import java.util.ArrayList;

/**
 * 线性查找
 * 遍历数组按照下标进行查找 找到就返回该元素的索引 找不到就返回-1
 */
public class SeqSearchTest {
    public static void main(String[] args) {
        int[] nums = new int[]{12,56,21,12,55,6484,12,3,0};
        SeqSearchTest seqSearchTest = new SeqSearchTest();
        ArrayList arrayList = seqSearchTest.seqSearch(nums, 1000);
        if(arrayList.get(0).equals(-1)){
            System.out.println("数组中未查询到value哦~");
        }else {
        System.out.println("数值在数组中的索引位置为:" + arrayList.toString());
        }


    }
    //查找指定的数 找到就返回在数组中的索引位置 找不到就返回-1
    public ArrayList seqSearch(int [] nums, int values){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if(values == nums[i]){
                arrayList.add(i);
            }

        }
        if (arrayList.isEmpty()){
            arrayList.add(-1);
        }
        return arrayList;

    }

}
