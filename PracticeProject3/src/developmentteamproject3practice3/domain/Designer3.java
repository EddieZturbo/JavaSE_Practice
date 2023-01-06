package developmentteamproject3practice3.domain;

/**
 * @author EddieZhang
 * @create 2022-08-11 11:44
 */
public class Designer3 extends Programmer3{
    private double bonus3;//奖金

    public Designer3() {
    }

    public Designer3(int id3, String name3, int age3, double salary3, Equipment3 equipment3, double bonus3) {
        super(id3, name3, age3, salary3, equipment3);
        this.bonus3 = bonus3;
    }

    public double getBonus3() {
        return bonus3;
    }

    public void setBonus3(double bonus3) {
        this.bonus3 = bonus3;
    }

    @Override
    public String getInformationForView3() {
        return super.informationForView3() + "设计师" + "\t\t" + bonus3;
    }

    @Override
    public String toString() {
        return detail3() + "\t设计师\t" + getStatus3() + "\t" + bonus3 + "\t\t\t\t" + getEquipment3().getDescription3();
    }
}