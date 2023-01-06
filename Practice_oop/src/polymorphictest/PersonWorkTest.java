package polymorphictest;

/**
 * @author shkstart
 * @create 2022-08-01 18:47
 */
//创建类 设计类的成员
class Person{}
class Student extends Person{}
class Teacher extends Person{}
public class PersonWorkTest {
    public static void work(Person p){
        if(p instanceof Teacher){
            System.out.println("人要做好自己的本职工作");
        } else if (p instanceof Student) {
            System.out.println("学生要做好自己的本职工作");
        }else if(p instanceof Person){
            System.out.println("老师要做好自己的本职工作");
        }

    }

    public static void main(String[] args) {
        work(new Teacher());
        work(new Student());
        work(new Person());
    }
}







