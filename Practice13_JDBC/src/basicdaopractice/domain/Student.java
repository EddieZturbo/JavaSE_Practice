package basicdaopractice.domain;

/**
 @author EddieZhang
 @create 2022-09-12 9:40
 */
public class Student {
    int id;//学号
    String name;//姓名
    double chinese;//语文成绩
    double english;//英语成绩
    double math;//数学成绩

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chinese=" + chinese +
                ", english=" + english +
                ", math=" + math +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public Student(int id, String name, double chinese, double english, double math) {
        this.id = id;
        this.name = name;
        this.chinese = chinese;
        this.english = english;
        this.math = math;
    }

    public Student() {
    }
}
