package reflectiontestclassstructure;

/**
 @author EddieZhang
 @create 2022-08-20 9:32
 */
@TestAnnotation(value = "生物类")
public class Creature implements FunctionTest{
    protected String species;//生物的种类
    @TestAnnotation(value = "生长的年龄")
    public int age;//年龄
    private String name;//生物的名称

    public Creature() {
    }

    private Creature(String species) {
        this.species = species;
    }

    public Creature(int age) {
        this.age = age;
    }

    public Creature(String species, int age, String name) {
        this.species = species;
        this.age = age;
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("万物以食为天");
    }

    @TestAnnotation(value = "获取生物的基本信息的方法")
    public String getInformation(){
        return "Species: " + this.species + "\t CreatureAge: " + this.age + "\t CreatureName: " + this.name;
    }

    @TestAnnotation(value = "生物的String方法重写")
    @Override
    public String toString() {
        return "Creature{" +
                "species='" + species + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Creature creature = (Creature) o;

        if (age != creature.age) return false;
        if (species != null ? !species.equals(creature.species) : creature.species != null) return false;
        return name != null ? name.equals(creature.name) : creature.name == null;
    }

    @Override
    public int hashCode() {
        int result = species != null ? species.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
