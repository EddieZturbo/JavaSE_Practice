package developmentteamproject3practice2.domain;

/**
 * @author shkstart
 * @create 2022-08-08 10:54
 */
public class Designer2 extends Programmer2{
    private double bonus2;//表示奖金

    public Designer2() {
    }

    public Designer2(int id2, String name2, int age2, double salary2, Equipment2 equipment2, double bonus2) {
        super(id2, name2, age2, salary2, equipment2);
        this.bonus2 = bonus2;
    }


    public double getBonus2() {
        return bonus2;
    }

    public void setBonus2(double bonus2) {
        this.bonus2 = bonus2;
    }

    @Override
    public String detailForView2() {
        return super.information1() + "设计师" + "\t\t" + bonus2;
    }

    @Override
    public String toString() {
        return detail2() + "\t设计师\t" + getStatus2() + "\t" + bonus2 + "\t\t\t\t" + getEquipment2().getDescription2();
    }
}
