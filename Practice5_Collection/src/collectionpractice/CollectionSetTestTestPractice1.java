package collectionpractice;

import org.junit.Test;

import java.util.HashSet;

/**
 @author EddieZhang
 @create 2022-08-31 7:54
 */
public class CollectionSetTestTestPractice1 {
    @Test
    public void test1(){
//        HashSet<EmployeeTest> hashSet = new HashSet<>();
//        hashSet.add(new EmployeeTest("Eddie",22));
//        hashSet.add(new EmployeeTest("Irving",33));
//        hashSet.add(new EmployeeTest("James",37));
//        hashSet.add(new EmployeeTest("Curry",34));
//        hashSet.add(new EmployeeTest("Durant",34));
//        hashSet.add(new EmployeeTest("Eddie",22));
//        System.out.println(hashSet);
        HashSet<EmployeeTest2> hashSet = new HashSet<>();
        hashSet.add(new EmployeeTest2("Eddie",16888.0,new BirthdayTest(2000,12,7)));
        hashSet.add(new EmployeeTest2("Irving",16888.0,new BirthdayTest(2000,12,7)));
        hashSet.add(new EmployeeTest2("James",16888.0,new BirthdayTest(2000,12,7)));
        hashSet.add(new EmployeeTest2("Curry",16888.0,new BirthdayTest(2000,12,8)));
        hashSet.add(new EmployeeTest2("Durant",16888.0,new BirthdayTest(2000,12,5)));
        hashSet.add(new EmployeeTest2("Eddie",16888.0,new BirthdayTest(2000,12 ,7)));
        System.out.println(hashSet);
        System.out.println(hashSet.size());//5

    }
}
class EmployeeTest2{
    private String name;
    private Double salary;
    private BirthdayTest birthdayTest;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeTest2 that = (EmployeeTest2) o;

        if (!name.equals(that.name)) return false;
        return birthdayTest.equals(that.birthdayTest);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + birthdayTest.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeTest2{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthdayTest=" + birthdayTest +
                '}';
    }

    public EmployeeTest2(String name, Double salary, BirthdayTest birthdayTest) {
        this.name = name;
        this.salary = salary;
        this.birthdayTest = birthdayTest;
    }

    public EmployeeTest2() {
    }
}
class BirthdayTest{
    private int year;
    private int mouth;
    private int day;

    @Override
    public String toString() {
        return "BirthdayTest{" +
                "year=" + year +
                ", mouth=" + mouth +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BirthdayTest that = (BirthdayTest) o;

        if (year != that.year) return false;
        if (mouth != that.mouth) return false;
        return day == that.day;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + mouth;
        result = 31 * result + day;
        return result;
    }

    public BirthdayTest(int year, int mouth, int day) {
        this.year = year;
        this.mouth = mouth;
        this.day = day;
    }

    public BirthdayTest() {
    }
}
class EmployeeTest{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "EmployeeTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeTest that = (EmployeeTest) o;

        if (age != that.age) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
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

    public EmployeeTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public EmployeeTest() {
    }
}