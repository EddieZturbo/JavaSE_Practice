package developmentteamproject3practice1.domain1;

/**
 * @author shkstart
 * @create 2022-08-06 11:22
 */
public class Architect1 extends Designer1{
    private int stock1;//表示股票

    public Architect1() {
    }

    public Architect1(int id, String name, int age, double salary, Equipment1 equipment1, double bonus1, int stock1) {
        super(id, name, age, salary, equipment1, bonus1);
        this.stock1 = stock1;
    }

    public int getStock1k() {
        return stock1;
    }

    public void setStock1(int stock1) {
        this.stock1 = stock1;
    }

    @Override
    public String getInformationForView() {
        return super.information1() + "架构师" + "\t\t" + getBonus1() + "\t\t" + stock1;
    }

    @Override
    public String toString() {
        return getDetail1() + "\t架构师\t" + getStatus1() + "\t" + getBonus1() + "\t\t" + stock1 + "\t" + getEquipment1().getDescription();
    }
}
