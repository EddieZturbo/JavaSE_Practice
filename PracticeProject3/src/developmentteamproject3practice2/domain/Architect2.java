package developmentteamproject3practice2.domain;

/**
 * @author shkstart
 * @create 2022-08-08 10:54
 */
public class Architect2 extends Designer2{
    private int stock2;

    public Architect2() {
    }

    public Architect2(int id2, String name2, int age2, double salary2, Equipment2 equipment2, double bonus2, int stock2) {
        super(id2, name2, age2, salary2, equipment2, bonus2);
        this.stock2 = stock2;
    }

    public int getStock2() {
        return stock2;
    }

    public void setStock2(int stock2) {
        this.stock2 = stock2;
    }

    @Override
    public String detailForView2() {
        return super.information1() + "架构师" + "\t\t" + getBonus2() + "\t\t" + stock2;
    }

    @Override
    public String toString() {
        return detail2() + "\t架构师\t" + getStatus2() + "\t" + getBonus2() + "\t\t" + stock2 + "\t" + getEquipment2().getDescription2();
    }
}
