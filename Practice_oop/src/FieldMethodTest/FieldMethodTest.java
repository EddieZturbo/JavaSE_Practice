package FieldMethodTest;

class Base {
    int count = 10;
    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {
    int count = 20;
    public void display() {
        System.out.println(this.count);
    }
}


/**
 * @author shkstart
 * @create 2022-07-28 15:47
 */
public class FieldMethodTest {
    public static void main(String[] args){
        Sub s = new Sub();
        System.out.println(s.count);
        s.display();
        Base b = s;//把s的地址值赋给b
        System.out.println(b == s);//==引用类型判断的是地址值是否相同
        System.out.println(b.count);
        b.display();
    }

}
