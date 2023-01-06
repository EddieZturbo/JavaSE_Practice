package developmentteamproject3practice1.domain1;

/**
 * @author shkstart
 * @create 2022-08-06 11:20
 */
public class Designer1 extends Programmer1{
    private double bonus1;//表示奖金

    public Designer1() {
    }

    public Designer1(int id, String name, int age, double salary, Equipment1 equipment1, double bonus1) {
        super(id, name, age, salary, equipment1);
        this.bonus1 = bonus1;
    }

    public double getBonus1() {
        return bonus1;
    }

    public void setBonus1(double bonus1) {
        this.bonus1 = bonus1;
    }

    @Override
    public String getInformationForView() {
        return super.information1() + "设计师" + "\t\t" + bonus1;
    }

    @Override
    public String toString() {
        return getDetail1() + "\t设计师\t" + getStatus1() + "\t" + bonus1 + "\t\t\t\t" + getEquipment1().getDescription();
    }
}
