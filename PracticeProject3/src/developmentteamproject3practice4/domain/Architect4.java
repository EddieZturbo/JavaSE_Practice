package developmentteamproject3practice4.domain;

/**
 @author EddieZhang
 @create 2022-08-25 9:50
 */
public class Architect4 extends Designer4{
    private int stock4;//表示股票数量

    public Architect4() {
    }

    public Architect4(int id4, String name4, int age4, double salary4, Equipment4 equipment4, double bonus4, int stock4) {
        super(id4, name4, age4, salary4, equipment4, bonus4);
        this.stock4 = stock4;
    }

    @Override
    public String toString() {
        return detail4() + "\t架构师\t" + getStatus4() + "\t" + getBonus4() + "\t\t" + stock4 + "\t" + getEquipment4().getDescription4();
    }

    @Override
    public String detailForView() {
        return super.detailForView() + "架构师" + "\t\t" + getBonus4() + "\t\t" + stock4;
    }

    public int getStock4() {
        return stock4;
    }

    public void setStock4(int stock4) {
        this.stock4 = stock4;
    }
}
