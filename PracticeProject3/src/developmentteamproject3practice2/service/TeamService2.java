package developmentteamproject3practice2.service;

import developmentteamproject3practice2.domain.Architect2;
import developmentteamproject3practice2.domain.Designer2;
import developmentteamproject3practice2.domain.Employee2;
import developmentteamproject3practice2.domain.Programmer2;

/**
 * @author shkstart
 * @create 2022-08-08 12:00
 */
public class TeamService2 {

    private static int counter2 = 1;//静态变量 用户为开发团队新增成员自动生成团队中唯一的ID，即memberId2（应采用自增1的方式）
    private final int MAX_MEMBER2 = 5;//常量 表示开发团队最大成员数
    private Programmer2[] team2 = new Programmer2[MAX_MEMBER2];//用来保存当前团队中的个成员对象
    private int total2 = 0;//记录团队中的实际人数


    public TeamService2() {
    }

    /**
     * @Description 返回当前团队的所有对象
     * @Author EddieZhang
     * @Date 2022/8/8 12:05
     * @Param []
     * @Return developmentteamproject3practice2.domain.Programmer2[]包含所有成员对象的数组，数组大小与成员人数一致
     * @Since version-1.0
     */
    public Programmer2[] getTeam2() {
        if (total2 < 1) {
            return null;
        }
        Programmer2[] team3 = new Programmer2[total2];
        for (int i = 0; i < team3.length; i++) {
            team3[i] = team2[i];

        }
        return team3;
    }

    /**
     * @Description 向团队中添加成员
     * @Author EddieZhang
     * @Date 2022/8/8 12:06
     * @Param [employee2]
     * @Return 异常：添加失败， TeamException中包含了失败原因
     * @Since version-1.0
     */
    public void addMember2(Employee2 employee2) throws TeamException2 {
//        成员已满，无法添加
        if (total2 >= MAX_MEMBER2) {//根据total2数量判断开发团队是否满员
            throw new TeamException2("成员已满，无法添加");
        }

//        该成员不是开发人员，无法添加
        if (!(employee2 instanceof Programmer2)) {//用instanceof判断employee2是否属于Programmer2
            throw new TeamException2("该成员不是开发人员，无法添加");
        }


//        该员工已在本开发团队中
        //至此 employee2都是开发人员 可将employee2强制转换成Programmer2
        Programmer2 emp2 = (Programmer2) employee2;
        for (int i = 0; i < total2; i++) {
            if (team2[i].getId2() == emp2.getId2()) {//根据员工的id判断是否已在开发团队中
                throw new TeamException2("该员工已在本开发团队中");
            }

        }

        //根据员工的Status2状态判断
//        该员工已是某团队成员
//        该员正在休假，无法添加
//        for (int i = 0; i < total2; i++) {
//            if ("BUSY".equals(emp2.getStatus2().getNAME2())) {
//                throw new TeamException2("该员工已是某团队成员");
//            }
//            if ("VOCATION".equals(emp2.getStatus2().getNAME2())) {
//                throw new TeamException2("该员正在休假，无法添加");
//            }
//        }

        switch (emp2.getStatus2()){
            case BUSY:
                throw new TeamException2("该员工已是某团队成员");
            case VOCATION:
                throw new TeamException2("该员正在休假，无法添加");

        }


//        团队中至多只能有一名架构师
//        团队中至多只能有两名设计师
//        团队中至多只能有三名程序员
        int number2Programmer = 0, number2Designer = 0, number2Architect = 0;//设计三个int型变量 分别计算团队中已存在的员工类型的数量
        for (int i = 0; i < team2.length; i++) {
            if (team2[i] instanceof Architect2) {
                number2Architect++;
            }
            if (team2[i] instanceof Designer2) {
                number2Designer++;
            }
            if (team2[i] instanceof Programmer2) {
                number2Programmer++;
            }

        }

        if (emp2 instanceof Architect2) {
            if (number2Architect >= 1) {
                throw new TeamException2("团队中至多只能有一名架构师");
            }
        } else if (emp2 instanceof Designer2) {
            if (number2Designer >= 2) {
                throw new TeamException2("团队中至多只能有两名设计师");
            }
        } else if (emp2 instanceof Programmer2) {
            if (number2Programmer >= 3) {
                throw new TeamException2("团队中至多只能有三名程序员");
            }
        }

        //至此 已排查完全部的添加条件 可以进行添加
        team2[total2++] = emp2;//给数组各个元素赋值 --》 total2++
        emp2.setMemberId(counter2++);//给 将加入开发团队的emp2员工setMemberId --》  counter2++
        emp2.setStatus2(Status2.BUSY);//将加入开发团队的emp2员工的Status2状态改成BUSY
    }

    public int getTotal2() {
        return total2;
    }

    /**
     * @Description 从团队中删除成员
     * @Author EddieZhang
     * @Date 2022/8/8 12:07
     * @Param [memberId]待删除成员的memberId
     * @Return 异常：找不到指定memberId的员工，删除失败
     * @Since version-1.0
     */
    public void removeMember2(int memberId) throws TeamException2 {
        boolean flag = true;
        int key;
        for (key = 0; key < total2; key++) {
            if (memberId == team2[key].getMemberId()) {//遍历开发团队成员数组 通过member id 判断是否在团队中 进行删除
                flag = false;
                team2[key].setStatus2(Status2.FREE);//删除团队成员需要将员工状态set 成BUSY
                break;//通过 if（）条件判断 找到了待删除成员 并确定了索引位置key 跳出循环


            }
        }
        if(flag){
            throw new TeamException2("找不到指定memberId的员工，删除失败");
        }
//        需要遍历待删除成员到团队最后一名成员 从待删除成员后一个开始逐个向前覆盖

        for (int j = key + 1;j < total2;j++) {
            team2[j - 1] = team2[j];
        }
        //最后一个位置置空
        team2[--total2] = null;



    }

}
