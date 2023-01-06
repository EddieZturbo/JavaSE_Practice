package reflectiontest;

/**
 @author EddieZhang
 @create 2022-08-19 17:12
 */
public class Person {

    private String name;
    private int age;
    private String major;
    private boolean isMale;

    public Person() {
    }

    public Person(String name, int age, String major, boolean isMale) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.isMale = isMale;
    }

    private Person(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }
    public void showInformation(){
        System.out.println("Name: " + this.name +  "Age: " + this.age + "Major: " + this.major + "Is Male: " + this.isMale);
    }
    private void showPrivateInformation(){
        System.out.println("Name: " + this.name + "Age: " + this.age + "Is Male: " + this.isMale);
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", isMale=" + isMale +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}
