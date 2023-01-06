package MainDomeTest;

/**
 * @author shkstart
 * @create 2022-07-30 12:31
 */
public class MainDemoTest {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,4,5};
        System.out.println(num1[0] + 1);
        String str1 = String.valueOf(num1[0]);
        System.out.println(str1 + 1);

        int[] numScore = new int[args.length];
        for(int i = 0;i < args.length;i++){
            numScore[i] = Integer.parseInt(args[i]);
            System.out.println(numScore[i]);
//            System.out.println("****" + args[i]);

        }
    }
}
