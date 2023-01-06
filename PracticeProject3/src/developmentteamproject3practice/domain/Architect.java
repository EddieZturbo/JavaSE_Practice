package developmentteamproject3practice.domain;

/**
 * @author shkstart
 * @create 2022-08-04 20:39
 */
public class Architect extends Designer{
    private int stock;//表示股票

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary,Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary,equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetail() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t\t" + stock + "\t" + getEquipment().getDescription();
    }
    public String getDetailForView(){
        return getMemberId() + "/" + getId() + "\t\t" + getName() + "\t\t" + getAge() + "\t\t" + getSalary() + "\t\t" + "架构师" + "\t\t" + getBonus() + "\t\t" + stock;
    }
}
