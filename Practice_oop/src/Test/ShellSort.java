package Test;

/**
 @author EddieZhang
 @create 2022-09-29 10:14
 */

/**
 * 希尔排序
 * 对于插入排序的优化
 * 核心是利用增量进行分组 对每个组进行直接插入排序先 当增量不断缩减为1时 数组为一个完整的 再进行直接插入排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int [] nums = new int[]{15,-15,1654,31,0,-454,21,22130,545,2354,-4,1};

        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(nums);
        for(int num : nums  ){
            System.out.println(num);

        }
    }
    public void shellSort(int [] nums  ){
        //定义增量
        int gap = nums.length-1;
        while(true){
            if(gap == 1){
                return;
            }
            //增量每次进行缩减至原本的二分之一
            gap = gap >> 1;
            //根据增量进行分组
            for (int i = 0; i < gap; i++) {
                //对每一组进行直接插入排序
                for (int j = i; j < nums.length - gap; j+=gap) {
                    int leftLastIndex = j;//数组的有序段末尾元素
                    int rightFirst = nums[j + gap];//数组无序段的待插入元素
                    while(leftLastIndex >= i && nums[leftLastIndex] >= rightFirst){
                        nums[leftLastIndex + gap] = nums[leftLastIndex];
                        leftLastIndex -= gap;
                    }
                    nums[leftLastIndex + gap] = rightFirst;
                }
            }
        }
    }
}
