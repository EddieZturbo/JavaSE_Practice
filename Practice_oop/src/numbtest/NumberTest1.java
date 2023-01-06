package numbtest;

/**
 * @author shkstart
 * @create 2022-08-01 15:57
 */
public class NumberTest1 {
    //遍历1000以内的所有质数
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i = 2;i <= 1000;i++){
            boolean flag = true;
            for(int j = 2;j <= Math.sqrt(i);j++){
                if(i % j == 0){
                    flag = false;
                    break;
                }

            }
            if(flag){
                System.out.println(i);
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("本次运行所用时间：" + (end - start) + "s");
    }
}
