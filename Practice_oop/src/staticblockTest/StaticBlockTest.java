package staticblockTest;

/**
 * 继承体系初始化
 @author EddieZhang
 @create 2022-09-11 9:39
 */
public class StaticBlockTest {
    public static void main(String[] args) {
        System.out.println("******************************Person person = new Eddie();******************************");
    Person person = new Eddie();
        //我是父类的static代码块
        //我是子类的static代码块
        //我是父类的非static代码块
        //我是父类空参构造器
        //我是子类的非static代码块
        //我是子类的空参构造器
        System.out.println("******************************person.sleep();******************************");
    person.sleep();//我是子类的sleep方法
//        person.programming();编译不通过 编译时看左边 运行时看右边
        System.out.println("******************************Eddie eddie = new Eddie();******************************");
        Eddie eddie = new Eddie();
        System.out.println("******************************eddie.programming();******************************");
        eddie.programming();
        System.out.println("******************************eddie.sleep();******************************");
        /*
                @Override
            public void sleep() {
                super.sleep();
                System.out.println("我是子类的sleep方法");
            }
         */
        eddie.sleep();
        //我是父类的sleep方法
        //我是子类的sleep方法

    }

}
class Eddie extends Person{
    private String major;
    static String homeAddress;
    static {
        System.out.println("我是子类的static代码块");
    }
    {
        System.out.println("我是子类的非static代码块");
    }

    public Eddie() {
        System.out.println("我是子类的空参构造器");
    }

    public Eddie(String major) {
        this.major = major;
        System.out.println("我是子类的有参构造器");
    }

    public Eddie(String name, String gender, int age, String major) {
        super(name, gender, age);
        this.major = major;
        System.out.println("我是子类的全参构造器");
    }

    @Override
    public void sleep() {
        super.sleep();
        System.out.println("我是子类的sleep方法");
    }
    public void programming(){
        System.out.println("我是子类的programming方法");
    }

    @Override
    public String toString() {
        return "Eddie{" +
                "major='" + major + '\'' +
                '}';
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public static String getHomeAddress() {
        return homeAddress;
    }

    public static void setHomeAddress(String homeAddress) {
        Eddie.homeAddress = homeAddress;
    }
}
class Person{
    private String name;
    private String gender;
    private int age;
    static String nation;
    static {
        nation = "China";
        System.out.println("我是父类的static代码块");
    }
    {
        System.out.println("我是父类的非static代码块");
    }

    public Person() {
        System.out.println("我是父类空参构造器");
    }

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        System.out.println("我是父类带参构造器");
    }
    public void sleep(){
        System.out.println("我是父类的sleep方法");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getNation() {
        return nation;
    }

    public static void setNation(String nation) {
        Person.nation = nation;
    }
}
