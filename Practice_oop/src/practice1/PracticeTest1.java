package practice1;

import java.util.Arrays;
import java.util.Scanner;

/**
 @author EddieZhang
 @create 2022-09-11 10:17
 */
public class PracticeTest1 {
    public static void main(String[] args) {
        System.out.println("-------------------------------A01-------------------------------------");
        double[] doubles = new double[]{22.5,55.5,66.5,55.5,1.1,555.5,-154.4,99999.44};
        A01 a01 = new A01();
        double maxNumber = a01.getMaxNumber(doubles);
        System.out.println(maxNumber);
        double maxNumber1 = a01.getMaxNumber1(doubles);
        System.out.println(maxNumber1);
        System.out.println("-------------------------------A02-------------------------------------");
        String str = "Irving";
        String[] strings = new String[]{"Eddie","Irving","James","Curry","Durant"};
        A02 a02 = new A02();
        int index = a02.findString(str, strings);
        System.out.println(index);
        System.out.println("-------------------------------A04-------------------------------------");
        Integer[]integers = new Integer[]{1,51,354,212,534,21,5454,313};
        A04 a04 = new A04();
        Object[] copyArray = a04.copyArray(integers);
        for (Object integer :
                copyArray) {
            System.out.println(integer);
        }

        System.out.println("-------------------------------A04-------------------------------------");
        A05 a05 = new A05();
        a05.setR(53.2);
        System.out.println("圆的周长为:\t" + a05.showCircumference(a05.getR()) + "平方米");
        System.out.println("圆的面积为:\t" + a05.showAreaCircle(a05.getR()) + "平方米");

        System.out.println("-------------------------------A04-------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数");
        String s = scanner.nextLine();
        double aDouble = Double.parseDouble(s);
        System.out.print("请输入第二个数");
        String s1 = scanner.nextLine();
        double aDouble1 = Double.parseDouble(s1);

        A06 a06 = new A06();
        a06.setD1(aDouble);
        a06.setD2(aDouble1);
        System.out.println("两数之和为\t" + a06.sum(a06.getD1(), a06.getD2()));
        System.out.println("两数之差为\t" + a06.sub(a06.getD1(), a06.getD2()));
        System.out.println("两数之积为\t" + a06.multiply(a06.getD1(), a06.getD2()));
        System.out.println("两数之商为\t" + a06.divide(a06.getD1(), a06.getD2()));
    }
}

/**
 * 编写类A01 定义一个方法 实现求某个double数组的max值 并返回
 */
class A01{
    public double getMaxNumber(double[] doubles){
        //Arrays
        Arrays.sort(doubles);
        return doubles[doubles.length-1];
    }
    public double getMaxNumber1(double[] doubles){
        //冒泡排序
        for (int i = 0; i < doubles.length; i++) {
            for (int j = 0; j < doubles.length - 1 - i; j++) {
                if(doubles[j] > doubles[j + 1]){
                    double temp = doubles[j];
                    doubles[j] = doubles[j + 1];
                    doubles[j + 1] = temp;
                }
            }

        }
        return doubles[doubles.length - 1];
    }

}

/**
 * 编写类A02 定义方法find 实现查找某字符串是否在某字符串数组中 并返回索引值 若不在则返回-1
 */
class A02{
    public int findString(String str,String[] strings){
        boolean flag = true;
        for (int i = 0; i < strings.length; i++) {
            if(str.equals(strings[i])){
                flag = false;
                return i;
            }
        }
        return -1;
    }
}

/**
 * 赋值数组的方法
 */
class A04{
    public Object[] copyArray(Object[] array){
        Object[] newCopy = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            newCopy [i] = array[i];
        }
        return newCopy;
    }

}

/**
 * 提供显示圆形的周长和面积的方法
 */
class A05{
    double r;
    public double showAreaCircle(double r){
        return this.r * this.r * Math.PI;
    }
    public double showCircumference(double r){
        return this.r * 2 * Math.PI;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}

/**
 * A06计算类 定义两个变量表示两个操作数 定义四个求和 差 乘积 商（除数为0的话要提示） 的方法 创建两个对象进行测试
 */
class A06{
    double d1;
    double d2;

    public double sum(double d1,double d2){
        return d1 + d2;
    }
    public double sub(double d1,double d2){
        return d1 - d2;
    }
    public double multiply(double d1,double d2){
        return d1 * d2;
    }
    public double divide(double d1,double d2){
        if(d2 == 0){
            throw new RuntimeException("除数不能为0哦~~");
        }
        return d1/d2;
    }

    public double getD1() {
        return d1;
    }

    public void setD1(double d1) {
        this.d1 = d1;
    }

    public double getD2() {
        return d2;
    }

    public void setD2(double d2) {
        this.d2 = d2;
    }
}
