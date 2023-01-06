package collectionpractice;

/**
 * @author EddieZhang
 * @create 2022-08-15 15:08
 */
public class Person {
     int number;
     String type;

    public Person() {
    }

    public Person(int number, String type) {
        this.number = number;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Person{" +
                "number=" + number +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (number != person.number) return false;
        return type != null ? type.equals(person.type) : person.type == null;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
