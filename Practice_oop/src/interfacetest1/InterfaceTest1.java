package interfacetest1;

/**
 * @author shkstart
 * @create 2022-08-01 9:41
 */
public class InterfaceTest1 {
    public static void main(String[] args) {
        Circle1 m = new Circle1(5);
        ComparableCircle1 c1 = new ComparableCircle1(1);
        ComparableCircle1 c2 = new ComparableCircle1(1);
        if(c1.compareTO(c2) == 0){
            System.out.println("c1和c2一样大");
        }else if (c1.compareTO(c2) < 0){
            System.out.println("c1比c2小");
        }else{
            System.out.println("c1比c2大");
        }
        System.out.println(c1.compareTO(m));
    }
}
