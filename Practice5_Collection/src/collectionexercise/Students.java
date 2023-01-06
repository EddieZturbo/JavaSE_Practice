package collectionexercise;

/**
 * @author EddieZhang
 * @create 2022-08-16 8:45
 */
public class Students {
    private String name;
    private int score;
    private int id;

    public Students() {
    }

    public Students(String name, int score, int id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Students students = (Students) o;

        if (score != students.score) return false;
        if (Double.compare(students.id, id) != 0) return false;
        return name != null ? name.equals(students.name) : students.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + score;
        temp = Double.doubleToLongBits(id);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
