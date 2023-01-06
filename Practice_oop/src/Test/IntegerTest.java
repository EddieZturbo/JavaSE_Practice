package Test;

/**
 @author EddieZhang
 @create 2022-09-29 13:08
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer integer1= 128;
        Integer integer2 = Integer.valueOf("128");
        Integer integer3 = new Integer(127);
        System.out.println(integer1 == integer2);
        System.out.println(integer2 == integer3);
        //false
        //false
    }
}
