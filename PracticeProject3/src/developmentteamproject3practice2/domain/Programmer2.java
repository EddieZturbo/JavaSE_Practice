package developmentteamproject3practice2.domain;

import developmentteamproject3practice2.service.Status2;

/**
 * @author shkstart
 * @create 2022-08-08 10:48
 */
public class Programmer2 extends Employee2{
    private int memberId;
    private Status2 status2 = Status2.FREE;
    private Equipment2 equipment2;

    public Programmer2() {
    }

    public Programmer2(int id2, String name2, int age2, double salary2, Equipment2 equipment2) {
        super(id2, name2, age2, salary2);
        this.equipment2 = equipment2;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status2 getStatus2() {
        return status2;
    }

    public void setStatus2(Status2 status2) {
        this.status2 = status2;
    }

    public Equipment2 getEquipment2() {
        return equipment2;
    }

    public void setEquipment2(Equipment2 equipment2) {
        this.equipment2 = equipment2;
    }

    public String information1(){
        return memberId + "/" + getId2() + "\t\t" + getName2() + "\t\t" + getAge2() + "\t\t" + getSalary2() + "\t\t";
    }

    public String detailForView2(){
        return information1() + "程序员";
    }

    @Override
    public String toString() {
        return detail2() + "\t程序员\t" + status2 + "\t\t\t\t\t\t" + equipment2.getDescription2();
    }
}
