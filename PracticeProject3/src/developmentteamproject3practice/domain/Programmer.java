package developmentteamproject3practice.domain;

import developmentteamproject3practice.service.Status;

/**
 * @author shkstart
 * @create 2022-08-04 20:26
 */
public class Programmer extends Employee{
    private int memberId;//记录成员加入开发团队后在团队中的ID
    private Status status = Status.FREE;//声明三个对象属性，分别表示成员的状态
    private Equipment equipment;//成员领用的设备

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary,Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString() + "\t程序员\t" + status + "\t\t\t\t\t\t" + equipment.getDescription();

    }
    public String getDetailForView(){
        return memberId + "/" + getId() + "\t\t" + getName() + "\t\t" + getAge() + "\t\t" + getSalary() + "\t\t" + "程序员";
    }
}
