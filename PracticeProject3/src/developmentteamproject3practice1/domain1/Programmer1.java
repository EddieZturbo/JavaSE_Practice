package developmentteamproject3practice1.domain1;

import developmentteamproject3practice1.service1.Status1;

/**
 * @author shkstart
 * @create 2022-08-06 10:52
 */
public class Programmer1 extends Employee1{
    private int memberId1;//表示成员加入团队后在团队中的ID
    private Status1 status1 = Status1.FREE1;//Status是在service包下自定义的类 声明三个对象属性，分表表示成员的状态
    private Equipment1 equipment1;//表示该成员领用的设备

    public Programmer1() {
    }

    public Programmer1(int id1, String name1, int age1, double salary1, Equipment1 equipment1) {
        super(id1, name1, age1, salary1);
        this.equipment1 = equipment1;
    }

    public int getMemberId() {
        return memberId1;
    }

    public void setMemberId(int memberId) {
        this.memberId1 = memberId;
    }


    public Equipment1 getEquipment1() {
        return equipment1;
    }

    public void setEmployee1(Employee1 employee1) {
        this.equipment1 = equipment1;
    }

    public Status1 getStatus1() {
        return status1;
    }

    public void setStatus1(Status1 status1) {
        this.status1 = status1;
    }

    public int getMemberId1() {
        return memberId1;
    }

    public String information1(){
        return memberId1 + "/" + getId() + "\t\t" + getName() + "\t\t" + getAge() + "\t\t" + getSalary() + "\t\t";
    }
    public String getInformationForView(){
        return information1() + "程序员";
    }

    @Override
    public String toString() {
        return getDetail1() + "\t程序员\t" + status1 + "\t\t\t\t\t\t" + equipment1.getDescription();
    }


}
