package practice1;

/**
 @author EddieZhang
 @create 2023-02-08 11:18 AM
 */
public class SwitchTest {
    public static void main(String[] args) {
        String s = "A";
        switch (s){
            case "A":
                System.out.println("A");
                break;
            case "B":
                System.out.println("B");
                break;
            case "C":
                System.out.println("C");
                break;
            case "D":
                System.out.println("D");
                break;
            case "E":
                System.out.println("E");
                break;
            default:
                System.out.println("Z");
        }


    }


    enum Boy {
        EDDIE("Eddie", 21),
        IRVING("Irving", 33),
        JAMES("James", 38),
        CURRY("Curry", 34),
        DURANT("Durant", 34);
        String name;
        Integer age;
        Boy(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
