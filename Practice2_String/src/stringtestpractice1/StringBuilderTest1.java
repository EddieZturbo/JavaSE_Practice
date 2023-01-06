package stringtestpractice1;

import org.junit.Test;

/**
 @author EddieZhang
 @create 2022-09-02 16:08
 */
public class StringBuilderTest1 {
    @Test
    public void test1(){
        StringBuilder stringBuilder = new StringBuilder();
        /*在new对象时就初始化capacity为16
        	public StringBuilder() {
    			super(capacity:16);
			}
		*/
        System.out.println(stringBuilder.length());//0
        //public int length() {//length返回的是count值（已存在的char数量）
        //    return count;
        //}
        stringBuilder.append("张锦豪1");
        stringBuilder.append("张锦豪2");
        //public StringBuilder append(String str) {
        //   super.append(str);
        //   return this;
        //}
        stringBuilder.append("张锦豪3");
        stringBuilder.append("张锦豪4");
        stringBuilder.append("张锦豪4");//至此已占用16个char容量 即:miniCapacity为16 oldCapacity为16
        stringBuilder.append("张锦豪5");//此处即将占用20个char容量 即:miniCapacity为20 oldCapacity为16
        //——>进行扩容newCapacity
        /*
        if (minimumCapacity - oldCapacity > 0) {//此处为ture进去条件体进行newCapacity扩容
            value = Arrays.copyOf(value,
                    newCapacity(minimumCapacity) << coder);
        }
        */

        //newCapacity方法如下
        /*
        private int newCapacity(int minCapacity) {
        int oldLength = value.length;
        int newLength = minCapacity << coder;
        int growth = newLength - oldLength;
        int length = ArraysSupport.newLength(oldLength, growth, oldLength + (2 << coder));
        if (length == Integer.MAX_VALUE) {
            throw new OutOfMemoryError("Required length exceeds implementation limit");
        }
        return length >> coder;
    	}
    	*/
        stringBuilder.append("张锦豪7");
        stringBuilder.append("张锦豪8");
        stringBuilder.append("张锦豪9");
        stringBuilder.append("张锦豪10");
        stringBuilder.append("张锦豪11");
        stringBuilder.append("张锦豪12");
        stringBuilder.append("张锦豪13");
        stringBuilder.append("张锦豪14");
        stringBuilder.append("张锦豪15");
        System.out.println(stringBuilder.length());//66
        stringBuilder.append("张锦豪16");
        System.out.println(stringBuilder.length());//71


        stringBuilder.append("张锦豪17");
        System.out.println(stringBuilder.length());//76

    }
}
