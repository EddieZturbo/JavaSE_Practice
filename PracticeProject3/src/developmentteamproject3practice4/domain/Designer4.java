package developmentteamproject3practice4.domain;

/**
 @author EddieZhang
 @create 2022-08-25 9:49
 */
public class Designer4 extends Programmer4{
    private double bonus4;//表示奖金

    public Designer4() {
    }

    public Designer4(int id4, String name4, int age4, double salary4, Equipment4 equipment4, double bonus4) {
        super(id4, name4, age4, salary4, equipment4);
        this.bonus4 = bonus4;
    }

    public double getBonus4() {
        return bonus4;
    }

    public void setBonus4(double bonus4) {
        this.bonus4 = bonus4;
    }

    @Override
    public String toString() {
        return detail4() + "\t设计师\t" + getStatus4() + "\t" + bonus4 + "\t\t\t\t" + getEquipment4().getDescription4();
    }

    @Override
    public String detailForView() {
        return super.detailForView() + "设计师" + "\t\t" + bonus4;
    }
}
