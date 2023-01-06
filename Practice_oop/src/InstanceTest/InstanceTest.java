package InstanceTest;

/**
 * @author shkstart
 * @create 2022-07-28 16:13
 */
public class InstanceTest {

    public void method(Person e){
        e.getInfo();
        System.out.println(e.getInfo());
        if(e instanceof Graduate){
            System.out.println("“a graduated student”\n" +
                    "“a student”\n" +
                    "“a person”");
        } else if (e instanceof Student) {
            System.out.println("“a student”\n" +
                    "“a person ”");
        }else{
            System.out.println("“a person”");
        }

    }





    public static void main(String[] args) {
        InstanceTest i = new InstanceTest();
        i.method(new Student());
    }

}

    //创建类 设计类的成员
class Person{

    //设计类的属性
    protected String name = "person";
    protected int age = 50;


    //设计类的constructor方法


    //设计类的方法
    public String getInfo(){
        return "Name:" + name + "\n" + "age:" + age;
    }

}

class Student extends Person{
    protected String school = "pku";
    public String getInfo(){
        return "Name:" + name + "\nage" + age;
    }
}
class Graduate extends Student{
    public String major = "IT";

    @Override
    public String getInfo() {
        return "Name:" + name + "\nage:" + age + "\nschool:" + school + "\nmajor:" + major;
    }
}