package WrapperTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author shkstart
 * @create 2022-07-29 9:29
 */
public class WrapperTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Vector v = new Vector();//矢量数组动态收缩长度
        while(true){
        System.out.print("请输入学生成绩");
        double o1 = scan.nextDouble();
        if(o1 < 0.0){
            break;
        }
            Object o = o1;
            Object obj = o;
            v.addElement(o);

        }
        Object obj1 = v.elementAt(0);


        //---------------------------------------------------------------------------------------------------------------


        System.out.println("向量的长度为：" + v.size());
        double[] d1 = new double[v.size()];
        for(int i = 0;i < v.size();i++){


            d1[i] = (double) v.get(i);
        }

        Arrays.sort(d1);
        System.out.println(Arrays.toString(d1));
        double[]scoreGap = new double[v.size()-1];
        for(int i = v.size()-2;i >=0;i--){
            scoreGap[i] = d1[v.size()-1] - d1[i];
            switch ((int) (scoreGap[i]/10)){
                case 3:
                    System.out.println("D等");
                    break;
                case 2:
                    System.out.println("C等");
                    break;
                case 1:
                    System.out.println("B等");
                    break;
                case 0:
                    System.out.println("A等");
                    break;

            }
        }
        System.out.println(Arrays.toString(scoreGap));






    }
}
