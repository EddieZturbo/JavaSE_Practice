package reflectiontestclassstructure;

/**
 @author EddieZhang
 @create 2022-08-20 9:38
 */
@TestAnnotation(value = "继承于生物体系的人类")
public class Person1 extends Creature implements FunctionTest,Comparable{
    @TestAnnotation(value = "人的年龄")
    private int personAge;
    @TestAnnotation(value = "人体体重单位kg")
    protected double weight;//体重 单位KG
    @TestAnnotation(value = "ture表示男性false表示女性")
    public boolean isMale;//是否为男性

    public Person1() {
    }

    public Person1(String species, int age, String name) {
        super(species, age, name);
    }

    public Person1(int personAge, double weight, boolean isMale) {
        this.personAge = personAge;
        this.weight = weight;
        this.isMale = isMale;
    }

    public Person1(int age, int personAge, double weight, boolean isMale) {
        super(age);
        this.personAge = personAge;
        this.weight = weight;
        this.isMale = isMale;
    }
    @TestAnnotation(value = "It is a constructor!!")
    private Person1(String species, int age, String name, int personAge, double weight, boolean isMale) {
        super(species, age, name);
        this.personAge = personAge;
        this.weight = weight;
        this.isMale = isMale;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public void eat() {
        System.out.println("人类一日三餐");
    }
    private void  details(){
        System.out.println("这很细节 It is a secret!!");
    }

    @TestAnnotation(value = "重写了父类Creature的getInformation方法")
    @Override
    public String getInformation() {
        return super.getInformation() + "PersonAge: " + this.personAge + "\tWeight: " + this.weight + "\tIs Male: " + this.isMale;
    }
    @TestAnnotation(value = "It is information of person!!")
    public String personGetInformation(String details) {
        return super.getInformation() + "PersonAge: " + this.personAge + "\tWeight: " + this.weight + "\tIs Male: " + this.isMale + "\tDetails:\t" + details;
    }

    @Override
    public String toString() {
        return super.toString() + "Person1{" +
                "personAge=" + personAge +
                ", weight=" + weight +
                ", isMale=" + isMale +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Person1 person1 = (Person1) o;

        if (personAge != person1.personAge) return false;
        if (Double.compare(person1.weight, weight) != 0) return false;
        return isMale == person1.isMale;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + personAge;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isMale ? 1 : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
