package developmentteamproject3practice3.service;

/**
 * @author EddieZhang
 * @create 2022-08-12 23:39
 */

import developmentteamproject3practice3.domain.Architect3;
import developmentteamproject3practice3.domain.Designer3;
import developmentteamproject3practice3.domain.Employee3;
import developmentteamproject3practice3.domain.Programmer3;

/**
 * @Description 关于开发团队的管理：添加，删除等
 * @Author EddieZhang
 * @Date 2022/8/12 23:39
 * @Since version-1.0
 */
public class TeamService3 {
    private static int counter3 = 1;//静态变量 用来为开发团队新增成员自动生成团队中唯一的ID，即memberId3（应采用自增1）
    private final int MAX_MEMBER3 = 5;//表示开发团队的最大成员数
    private Programmer3[] team3 = new Programmer3[MAX_MEMBER3];//用来保存当前开发团队中的各个成员对象
    private int total3 = 0;//记录团队中成员的实际人数

    /**
     * @Description 返回当前团队中的所有对象
     * @Author EddieZhang
     * @Date 2022/8/12 23:44
     * @Param []
     * @Return developmentteamproject3practice3.domain.Programmer3[]当前团队中的所有对象
     * @Since version-1.0
     */
    public Programmer3[] getTeam3() throws TeamException3 {
        Programmer3[] programmer3s = new Programmer3[team3.length];//new一个Programmer3[]去接收team3中的所有元素
        if (total3 < 1) {
            throw new TeamException3("还没有数据哦！！");
        } else {
            for (int i = 0; i < total3; i++) {
                programmer3s[i] = team3[i];
            }
        }
        return programmer3s;
    }

    /**
     * @Description 向团队中添加成员 添加失败抛出异常throws TeamException3
     * @Author EddieZhang
     * @Date 2022/8/12 23:45
     * @Param [employee3]待添加的成员
     * @Return void
     * @Since version-1.0
     */
    public void addMember3(Employee3 employee3) throws TeamException3 {
//        成员已满，无法添加
        if (total3 >= team3.length) {//根据total3判断是否满员
            throw new TeamException3("成员已满，无法添加");
        }
//        该成员不是开发人员，无法添加
        if (!(employee3 instanceof Programmer3)) {//instanceof判断待添加员工employee3是否为开发人员
            throw new TeamException3("该成员不是开发人员，无法添加");
        }
        //至此都是开发人员了可以将employee3强制转换为Programmer3类型
        Programmer3 programmer3 = (Programmer3) employee3;

//        该员工已在本开发团队中
        for (int i = 0; i < total3; i++) {//遍历开发团队成员 通过员工和团队成员共有的id属性判断待添加员工是否已在团队中
            if (team3[i].getId3() == programmer3.getId3()) {
                throw new TeamException3("该员工已在本开发团队中");
            }
        }

//        该员工已是某团队成员
//        该员正在休假，无法添加
        //通过员工的Status3状态进行判断
        if ("BUSY".equalsIgnoreCase(programmer3.getStatus3().getNAME())) {
            throw new TeamException3("该员工已是某团队成员");
        } else if ("VOCATION".equalsIgnoreCase(programmer3.getStatus3().getNAME())) {
            throw new TeamException3("该员正在休假，无法添加");
        }

//        团队中至多只能有一名架构师
//        团队中至多只能有两名设计师
//        团队中至多只能有三名程序员
        int numOfProgrammer3 = 0, numOfDesigner3 = 0, numOfArchitect3 = 0;//定义int型变量记录开发团队中已有的成员类型数量
        for (int i = 0; i < total3; i++) {
            if (team3[i] instanceof Architect3) {
                numOfArchitect3++;
            } else if (team3[i] instanceof Designer3) {
                numOfDesigner3++;
            } else if (team3[i] instanceof Programmer3) {
                numOfProgrammer3++;
            }

        }
        if (programmer3 instanceof Architect3) {
            if (numOfArchitect3 >= 1) {
                throw new TeamException3("团队中至多只能有一名架构师");
            }
        } else if (programmer3 instanceof Designer3) {
            if (numOfDesigner3 >= 2) {
                throw new TeamException3("团队中至多只能有两名设计师");
            }
        } else if (programmer3 instanceof Architect3) {
            if (numOfProgrammer3 >= 3) {
                throw new TeamException3("团队中至多只能有三名程序员");

            }
        }
        //至此以排除所有限制条件 可以进行添加
        team3[total3++] = programmer3;//赋值到Programmer3[]团队数组中 total3++
        programmer3.setMemberId3(counter3++);//给员工赋上MemberId3
        programmer3.setStatus3(Status3.BUSY);//添加员工后更改员工状态为Status3.BUSY


    }

    /**
     * @Description 从团队中删除成员 删除失败抛出异常throws TeamException3
     * @Author EddieZhang
     * @Date 2022/8/12 23:46
     * @Param [index]待删除成员的memberId
     * @Return void
     * @Since version-1.0
     */
    public void removeMember3(int index) throws TeamException3 {
        int i = 0;
        boolean flag = true;
            for (; i < total3; i++) {
                if (index == team3[i].getMemberId3()) {//遍历团队成员数组 根据memberId判断待删除成员是否在团队中
                    flag = false;
                    team3[i].setStatus3(Status3.FREE);//找到本团队的员工将要删除的员工状态改为FREE
                    break;//找到待删除员工索引位置 跳出本次循环
                }
            }
            if(flag){//如果flag仍然为true 表明未进入条件中 表明找不到指定员工 throw异常
                throw new TeamException3("找不到指定员工！！");
            }
            for (int j = i; j < total3 - 1; j++) {//从找到待删除员工的索引位置开始遍历至最后一位
                team3[j] = team3[j + 1];
            }
//        for (int j = key + 1;j < total2;j++) {
//            team2[j - 1] = team2[j];
//        }
            team3[--total3] = null;

    }

    public int getTotal3() {
        return total3;
    }
}
