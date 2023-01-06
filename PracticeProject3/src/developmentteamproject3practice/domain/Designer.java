package developmentteamproject3practice.domain;

/**
 * @author shkstart
 * @create 2022-08-04 20:37
 */
public class Designer extends Programmer{
    private double bonus;//表示奖金

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary,Equipment equipment, double bonus) {
        super(id, name, age, salary,equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetail() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t\t" + getEquipment().getDescription();
    }
    public String getDetailForView(){
        return getMemberId() + "/" + getId() + "\t\t" + getName() + "\t\t" + getAge() + "\t\t" + getSalary() + "\t\t" + "设计师" + "\t\t" + bonus;
    }
}
