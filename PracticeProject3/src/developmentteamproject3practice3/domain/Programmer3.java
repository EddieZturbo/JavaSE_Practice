package developmentteamproject3practice3.domain;

import developmentteamproject3practice3.service.Status3;

/**
 * @author EddieZhang
 * @create 2022-08-11 11:36
 */
public class Programmer3 extends Employee3{
    private int memberId3;//用来记录成员加入开发团队后在团队中的ID
    private Status3 status3 = Status3.FREE;//自定义类 表示员工当前的状态 初始化为FREE状态
    private Equipment3 equipment3;//员工对应的设备

    public Programmer3() {
    }

    public Programmer3(int id3, String name3, int age3, double salary3, Equipment3 equipment3) {
        super(id3, name3, age3, salary3);
        this.equipment3 = equipment3;
    }

    public int getMemberId3() {
        return memberId3;
    }

    public void setMemberId3(int memberId3) {
        this.memberId3 = memberId3;
    }

    public Status3 getStatus3() {
        return status3;
    }

    public void setStatus3(Status3 status3) {
        this.status3 = status3;
    }

    public Equipment3 getEquipment3() {
        return equipment3;
    }

    public void setEquipment3(Equipment3 equipment3) {
        this.equipment3 = equipment3;
    }

    public String informationForView3(){
        return memberId3 + "/" + getId3() + "\t\t" + getName3() + "\t\t" + getAge3() + "\t\t" + getSalary3() + "\t\t";
    }
    public String getInformationForView3(){
        return informationForView3() + "程序员";

    }
    @Override
    public String toString() {
        return detail3() + "\t程序员\t" + status3 + "\t\t\t\t\t\t" + equipment3.getDescription3();
    }

}
