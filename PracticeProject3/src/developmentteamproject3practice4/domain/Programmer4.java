package developmentteamproject3practice4.domain;

import developmentteamproject3practice4.service.Status4;

/**
 @author EddieZhang
 @create 2022-08-25 9:03
 */
public class Programmer4 extends Employee4{
    private int memberId4;//记录成员加入开发团队后的ID
    private Status4 status4 = Status4.FREE;
    private Equipment4 equipment4;

    public Programmer4() {
    }

    public Programmer4(int id4, String name4, int age4, double salary4, Equipment4 equipment4) {
        super(id4, name4, age4, salary4);
        this.equipment4 = equipment4;
    }

    @Override
    public String toString() {
        return detail4() + "\t程序员\t" + status4 + "\t\t\t\t\t\t" + equipment4.getDescription4();
    }
    public String detailForView(){
        return memberId4 + "/" + getId4() + "\t\t" + getName4() + "\t\t" + getAge4() + "\t\t" + getSalary4() + "\t\t";
    }



    public int getMemberId4() {
        return memberId4;
    }

    public void setMemberId4(int memberId4) {
        this.memberId4 = memberId4;
    }

    public Status4 getStatus4() {
        return status4;
    }

    public void setStatus4(Status4 status4) {
        this.status4 = status4;
    }

    public Equipment4 getEquipment4() {
        return equipment4;
    }

    public void setEquipment4(Equipment4 equipment4) {
        this.equipment4 = equipment4;
    }

}
