package objectstreamtest;

import java.io.Serializable;

/**
 * @author EddieZhang
 * @create 2022-08-18 15:46
 */

/**
 * 自定义可序列化类
 *      1.实现Serializable接口
 *      2.提供public static final long serialVersionUID = 4345342L;//序列版本号
 *      3.确保自定义可序列化类的内部所有属性可序列化Serializable (默认情况下基本数据类型都是可序列化)
 *      4.ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *                                                  --transient修饰不希望被序列化的属性
 */
public class Person implements Serializable{

    public static final long serialVersionUID = 4345342L;//序列版本号
    private String name;
    private int age;
    private String major;
    private boolean isMale;

    private Student student;

    public Person() {
    }

    public Person(String name, int age, String major, boolean isMale, Student student) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.isMale = isMale;
        this.student = student;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", isMale=" + isMale +
                ", student=" + student +
                '}';
    }
}

class Student implements Serializable{
    public static final long serialVersionUID = 43453434542L;//序列版本号
    private String name;
    private double numId;
    private int score;

    public Student() {
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", numId=" + numId +
                ", score=" + score +
                '}';
    }

    public Student(String name, double numId, int score) {
        this.name = name;
        this.numId = numId;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNumId() {
        return numId;
    }

    public void setNumId(double numId) {
        this.numId = numId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
