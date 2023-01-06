package practice2;

/**
 @author EddieZhang
 @create 2022-09-11 11:23
 */
public class Practice2_1 {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[2] = new Person("Eddie",22,"Java");
        people[0] = new Person("Irving",33,"Basketball");
        people[1] = new Person("James",37,"Basketball");
        //安装年龄进行冒泡排序
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if(people[j].age > people[j + 1].age){
                     Person person = people[j];
                     people[j] = people[j + 1];
                     people[j + 1] = person;
                }
            }

        }
        for (Person person :
                people) {
            System.out.println(person);
        }
    }
}
class Person{
    String name;
    int age;
    String job;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Person() {
    }
}
