package developmentteamproject3practice1.service1;

/**
 * @author shkstart
 * @create 2022-08-06 15:28
 */

import developmentteamproject3practice1.domain1.Architect1;
import developmentteamproject3practice1.domain1.Designer1;
import developmentteamproject3practice1.domain1.Employee1;
import developmentteamproject3practice1.domain1.Programmer1;

/**
 * 团队员工类
 */
public class TeamService1 {
    private static int counter1 = 1;//用来为开发团队新增成员自动生成团队中唯一的ID即memberId（应当使用自增1）
    private final int MAX_MEMBER1 = 5;//表示开发团队最大成员数
    private Programmer1[] team1 = new Programmer1[MAX_MEMBER1];//用来保存当前团队中的各成员对象
    private int total1 = 0;//记录团队中实际人数


    /**
     * @Description 返回当前团队中所有成员对象
     * @Author EddieZhang
     * @Date 2022/8/6 15:34
     * @Param []
     * @Return developmentteamproject3practice1.domain1.Programmer1[]包含所有成员的对象数组 数组大小与成员人数一致
     * @Since version-1.0
     */
    public Programmer1[] getTeam1() {
        Programmer1[] team2 = new Programmer1[total1];
        if (total1 < 0) {
            return null;
        }
        for (int i = 0; i < total1; i++) {
            team2[i] = team1[i];
        }
        return team2;
    }

    public void addMember1(Employee1 employee1) throws TeamException1 {//考虑添加失败的几种可能情况 并相对应的throw异常

//        成员已满，无法添加
        if (total1 >= MAX_MEMBER1) {//根据total1判断成员数量是否已达上限
            throw new TeamException1("成员已满，无法添加");
        }
//        该成员不是开发人员，无法添加
        if (!(employee1 instanceof Programmer1)) {//instanceof来判断employee1是否属于Programmer类即判断该人员是否为开发人员
            throw new TeamException1("该成员不是开发人员，无法添加");
        }
//        该员工已在本开发团队中
        Programmer1 programmer1 = (Programmer1) employee1;//至此 employee1都是开发人员 因此定可强制转换成Programmer1
        for (int i = 0; i < total1; i++) {
            if (team1[i].getId() == programmer1.getId()) {//遍历开发团队成员 根据id是否相同来判断该员工是否已在开发团队中
                throw new TeamException1("该员工已在本开发团队中");
            }
        }

//        该员工已是某团队成员
//        该员正在休假，无法添加
        //根据员工的status1状态来判断
        Status1 programmer1Status1 = programmer1.getStatus1();
        if ("BUSY1".equalsIgnoreCase(programmer1Status1.getNAME1())) {
            throw new TeamException1("该员工已是某团队成员");
        } else if ("VOCATION1".equalsIgnoreCase(programmer1Status1.getNAME1())) {
            throw new TeamException1("该员正在休假，无法添加");
        }

//        团队中至多只能有一名架构师
//        团队中至多只能有两名设计师
//        团队中至多只能有三名程序员
        //设计一个记录团队成员类型数量的int型变量 根据已存在的成员类型数量来限制添加成员
        //判断时由子及父类（由小及大范围）
        int numberForProgrammer1 = 0, numberForDesigner1 = 0, numberForArchitect1 = 0;//记录团队成员类型数量
        for (int i = 0; i < total1; i++) {
            if (team1[i] instanceof Architect1) {//判断是否属于架构师
                numberForArchitect1++;
            } else if (team1[i] instanceof Designer1) {//判断是否属于设计师
                numberForDesigner1++;
            } else if (team1[i] instanceof Programmer1) {//判断是否属于程序员
                numberForProgrammer1++;
            }

        }
        if (programmer1 instanceof Architect1) {
            if (numberForArchitect1 >= 1) {
                throw new TeamException1("团队中至多只能有一名架构师");
            }
        } else if (programmer1 instanceof Designer1) {
            if (numberForDesigner1 >= 2) {
                throw new TeamException1("团队中至多只能有两名设计师");
            }
        } else if (programmer1 instanceof Programmer1) {
            if (numberForProgrammer1 >= 3) {
                throw new TeamException1("团队中至多只能有三名程序员");
            }
        }

        //至此 全部添加条件筛选完成 可以进行将成员至团队的操作
        team1[total1++] = programmer1;//给team1数组赋值 及添加开发团队成员

        programmer1.setStatus1(Status1.BUSY1);//更改添加团队成员的状态为BUSY

        programmer1.setMemberId(counter1++);//添加团队成员的TID


    }

    /**
     * @Description 从团队中删除成员
     * @Author EddieZhang
     * @Date 2022/8/6 16:43
     * @Param [memberId1]待删除成员的memberId
     * @Return void
     * @Since version-1.0
     */
    public void removeMember1(int memberId1) throws TeamException1 {
        int key;
        boolean flag = true;
        for (key = 0; key < total1; key++) {//遍历团队成员
            if (team1[key].getMemberId() == memberId1) {
                team1[key].setStatus1(Status1.FREE1);//相应的将删除后的人员状态改成FREE1
                flag = false;
                break;
            }
        }
        if (flag) {
            throw new TeamException1("找不到指定memberId的员工，删除失败");
        }
        for (int j = key + 1; j < total1; j++) {//找到后 从要删除成员的memberId1开始遍历数组至最后一个团队成员
            team1[j - 1] = team1[j];//逐个向前一个覆盖
        }
        team1[--total1] = null;//原来位置的最后一个成员置空

    }


    /**
     * 获取开发团队成员人数
     *
     * @return 开发团队成员人数
     */
    public int getTotal1() {
        return total1;
    }

}
