package interfacetest;

/**
 * @author shkstart
 * @create 2022-08-01 9:41
 */
public class InterfaceTest {
    public static void main(String[] args) {
        Circle m = new Circle(5);
        ComparableCircle c1 = new ComparableCircle(1);
        ComparableCircle c2 = new ComparableCircle(17);
        System.out.println(c1.compareTO(c2));
        if(c1.compareTO(c2) == 0){
            System.out.println("c1和c2一样大");
        }else if (c1.compareTO(c2) == -1){
            System.out.println("c1比c2小");
        }else{
            System.out.println("c1比c2大");
        }
    }
}
