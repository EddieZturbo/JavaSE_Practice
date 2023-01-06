package stringtestpractice1;

/**
 * @author EddieZhang
 * @create 2022-08-10 18:32
 */

import java.util.Arrays;

/**
 * @Description //2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
 * *     //转为”abfedcg”
 * @Author EddieZhang
 * @Date 2022/8/11 18:30
 * @Param
 * @Return
 * @Since version-1.0
 */
public class StringTest1 {
    public static void main(String[] args) {
        StringTest1 stringTest1 = new StringTest1();
        String string222 = new String("HelloWorld");
        stringTest1.stringTest222(string222, 2, 8);
        System.out.println("-----------------------------------------------------");
        stringTest1.stringTest223(string222, 2, 8);
        System.out.println("-----------------------------------------------------");
        stringTest1.stringTest224(string222, 2, 8);

        System.out.println("-----------------------------");
        System.out.println(stringTest1.stringTest31());


        System.out.println("/////////////////////////////////////////////////////////");
        stringTest1.stringTest2231(string222, 2, 8);

    }

    public void stringTest222(String stringXx, int indexStart, int indexEnd) {
        //将String转成char型数组
        if (stringXx != null && stringXx.length() != 0) {
            char[] toCharArray = stringXx.toCharArray();
            for (int i = indexStart, j = indexEnd; i < j; i++, j--) {//按照要求将char型数组的元素进行反转
                char temp = toCharArray[i];
                toCharArray[i] = toCharArray[j];
                toCharArray[j] = temp;
            }
            for (int i = 0; i < toCharArray.length; i++) {
                System.out.println(toCharArray[i]);
            }
            String string2 = new String(toCharArray);
            System.out.println(string2);

        }
    }


    /**
     * @Description //使用拼接数组的方式 //2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
     * //转为”abfedcg”
     * @Author EddieZhang
     * @Date 2022/8/11 18:29
     * @Param [stringXx, indexStart, indexEnd]
     * @Return void
     * @Since version-1.0
     */
    public void stringTest223(String stringXx, int indexStart, int indexEnd) {
        if (stringXx != null && stringXx.length() != 0) {
            //第一部分 反转前的部分
            String reverseString = stringXx.substring(0, indexStart);
            //第二部分 反转的部分
            for (int i = indexEnd; i >= indexStart; i--) {
                reverseString += stringXx.charAt(i);
            }
            //第三部分 反转后的部分
            reverseString += stringXx.substring(indexEnd + 1);
            System.out.println(reverseString);

        }
    }

    //优化  将String转换成StringBuffer或StringBuilder
    //考虑是否纯在线程安全问题来选择
    public void stringTest224(String stringXx, int indexStart, int indexEnd) {
        if (stringXx != null && stringXx.length() != 0) {
            StringBuilder stringBuilder = new StringBuilder(stringXx.length());//利用StringBuilder构造器指明capacity
            //第一部分 反转前的部分
            stringBuilder.append(stringXx.substring(0, indexStart));
            //第二部分 反转的部分
            for (int i = indexEnd; i >= indexStart; i--) {
                stringBuilder.append(stringXx.charAt(i));
            }
            //第三部分 反转后的部分
            stringBuilder.append(stringXx.substring(indexEnd + 1));

            System.out.println(stringBuilder.toString());
        }

    }


    /**
     * //2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
     * *     //转为”abfedcg”
     *
     * @param stringXx
     * @param indexStart
     * @param indexEnd
     */
    public void stringTest2231(String stringXx, int indexStart, int indexEnd) {
        if (stringXx.length() != 0) {//判断数组是否为空
            char[] chars1 = stringXx.toCharArray();
            if (indexStart < indexEnd) {//反转范围的起止值限制
                for (int i = indexStart, j = indexEnd; i < j; i++, j--) {//从前往后遍历
//                    for(int j = indexEnd;i < j;j--){//从后向前遍历
                    char temp = chars1[i];//进行位置交换
                    chars1[i] = chars1[j];
                    chars1[j] = temp;
//                    }
                }

            }
            String result2231 = new String(chars1);
            System.out.println(result2231);

        }
    }

    public void stringTest2232(String stringXx, int indexStart, int indexEnd) {

    }

    public void stringTest2233(String stringXx, int indexStart, int indexEnd) {

    }

    /**
     * @Description //3. 获取一个字符串在另一个字符串中出现的次数。
     * *     //比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
     * @Author EddieZhang
     * @Date 2022/8/12 11:31
     * @Since version-1.0
     */
    public int stringTest31() {
        String mainString31 = new String("abkkcadkabkebfkabkskab");
        String subString31 = new String("ab");
        int count31 = 0;//记录子字符串在主字符串中出现的次数
        int index = 0;//子字符串在主字符串中出现的索引位置
        if (mainString31.length() >= subString31.length()) {
            while ((index = mainString31.indexOf(subString31, index)) != -1) {//调用indexOf方法在主字符串中从第一个索引开始查找子字符串 若！= -1 表明找到了 count31++
                index += subString31.length();//往 子类长度 后 的索引位置继续寻找
                count31++;
            }
            return count31;
        }
        return 0;//表明为进去条件过 次数为0
    }


}

/**
 * @Description //3. 获取一个字符串在另一个字符串中出现的次数。
 * //比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 * @Author EddieZhang
 * @Date 2022/8/11 18:28
 * @Since version-1.0
 */
class StringTest2 {
    public void stringTest3() {
        String string5 = "abkkcadkabkebfkabkskab";
        String s5 = "ab";
        int count = 0;
        int index;
        if (string5.length() >= s5.length()) {
            while ((index = string5.indexOf(s5)) != -1) {//int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
                count++;
                string5 = string5.substring(index + s5.length());
            }
            System.out.println(count);
        }
    }

    //优化stringTest3()
    public void stringTest4() {
        String string6 = "abkkcadkabkebfkabkskab";
        String s6 = "ab";
        int count1 = 0;
        int index1 = 0;
        if (string6.length() >= s6.length()) {
            while ((index1 = string6.indexOf(s6, index1)) != -1) {//int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
                count1++;
                index1 += s6.length();
            }
        }
        System.out.println(count1);
    }


    public int[] testTwoNumSum(int[] intArray, int target) {
        int n = intArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intArray[i] + intArray[j] == target) {
                    int[] result = new int[]{i, j};
                    return result;
                }
            }

        }
        return new int[0];
    }


    /**
     * 输入：nums = [2,7,11,15], target = 9
     * 外层循环（决定行）
     * 行数1  2，7      2，11    2，15  ---内层循环（决定每一行的内容）
     * 行数2  7，11     7，15           ---内层循环（决定每一行的内容）
     * 行数3  11，15                    ---内层循环（决定每一行的内容）
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param intArray1
     * @param target1
     * @return
     */
    public int[] testTwoNumSum1(int[] intArray1, int target1) {
        if (intArray1.length != 0) {//判断数组是否为空
            for (int i = 0; i < intArray1.length - 1; i++) {//外层循环 从数组索引位置的第一个（0位）到倒数第二个 即i < intArray1.length - 1
                for (int j = i + 1; j < intArray1.length; j++) {//内层循环 从第二个开始...
                    if (intArray1[i] + intArray1[j] == target1) {
                        int[] result1 = new int[]{i, j};
                        return result1;
                    }
                }
            }
        }
        throw new RuntimeException("数组为空");


    }



    public static void main(String[] args) {
        StringTest2 stringTest2 = new StringTest2();
        stringTest2.stringTest3();
        System.out.println("---------------------------------------");
        stringTest2.stringTest4();
        System.out.println("---------------------------------------");
        int[] number1 = new int[]{1, 4, 5, 6, 8, 11, 10};
        int[] ints = stringTest2.testTwoNumSum(number1, 9);
        System.out.println(Arrays.toString(ints));
        System.out.println("--------------------------");
        int[] testTwoNumSum1 = stringTest2.testTwoNumSum1(number1, 9);
        System.out.println(Arrays.toString(testTwoNumSum1));
    }
}


