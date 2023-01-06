package developmentteamproject3practice3.domain;

/**
 * @author EddieZhang
 * @create 2022-08-11 11:45
 */
public class Architect3 extends Designer3{
    private int stock3;//股票

    public Architect3() {
    }

    public Architect3(int id3, String name3, int age3, double salary3, Equipment3 equipment3, double bonus3, int stock3) {
        super(id3, name3, age3, salary3, equipment3, bonus3);
        this.stock3 = stock3;
    }

    public int getStock3() {
        return stock3;
    }

    public void setStock3(int stock3) {
        this.stock3 = stock3;
    }

    @Override
    public String getInformationForView3() {
        return super.informationForView3() + "架构师" + "\t\t" + getBonus3() + "\t\t" + stock3;
    }

    @Override
    public String toString() {
        return detail3() + "\t架构师\t" + getStatus3() + "\t" + getBonus3() + "\t\t" + stock3 + "\t" + getEquipment3().getDescription3();
    }
}
