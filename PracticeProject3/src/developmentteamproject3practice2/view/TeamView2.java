package developmentteamproject3practice2.view;

import developmentteamproject3practice2.domain.Employee2;
import developmentteamproject3practice2.domain.Programmer2;
import developmentteamproject3practice2.service.NameListService2;
import developmentteamproject3practice2.service.TeamException2;
import developmentteamproject3practice2.service.TeamService2;

/**
 * @author shkstart
 * @create 2022-08-08 15:51
 */
public class TeamView2 {
    private NameListService2 nameListService2 = new NameListService2();
    private TeamService2 teamService2 = new TeamService2();


    /**
     * @Description 主界面显示及控制方法
     * @Author EddieZhang
     * @Date 2022/8/8 15:53
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void enterMainMenu2() {
        char readMenuSelection = '0';
        while (true) {
            if (readMenuSelection != '1') {
            System.out.println("-------------------------------------开发团队调度软件--------------------------------------");
            System.out.println();
            System.out.println("ID     姓名      年龄    工资         职位      状态      奖金        股票     领用设备");
            System.out.println();
                listAllEmployees2();
            System.out.println();
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4):");
            }
            readMenuSelection = TSUtility2.readMenuSelection();
            switch (readMenuSelection) {
                case '1'://1-团队列表
                    getTeam2();
                    break;
                case '2'://2-添加团队成员
                    addMember2();
                    break;
                case '3'://3-删除团队成员
                    deleteMember2();
                    break;
                case '4'://4-退出
                    System.out.print("请确认是否要退出(Y/N):");
                    char readConfirmSelection = TSUtility2.readConfirmSelection();
                    if (readConfirmSelection == 'Y') {
                        return;
                    }

            }

        }

    }

    /**
     * 以下方法供enterMainMenu2()方法使用
     */
    /**
     * 以表格形式列出公司所有成员
     */
    private void listAllEmployees2() {
        Employee2[] employee2s = nameListService2.getAllEmployees2();
        for (int i = 0; i < employee2s.length; i++) {
            System.out.println(employee2s[i]);
        }


    }

    /**
     * 以表格形式列出公司所有成员
     */
    private void getTeam2() {
        System.out.println("--------------------团队成员列表---------------------");
        System.out.println();
        Programmer2[] programmer2s = teamService2.getTeam2();
        if (teamService2.getTotal2() < 1 || teamService2.getTeam2() == null) {
            System.out.println("还没有数据哦!!");
        } else {
            for (int i = 0; i < programmer2s.length; i++) {
                System.out.println(programmer2s[i].detailForView2());
            }
        }
        System.out.println("-------------------------------------------------");
    }

    /**
     * 实现添加成员操作
     */
    private void addMember2() {
        System.out.println("---------------------添加成员---------------------");
        System.out.println();
        System.out.print("请输入要添加的员工ID:");
        int readID = TSUtility2.readInt();
        try {
            teamService2.addMember2(nameListService2.getEmployee2(readID));
            System.out.println("添加成功");
        } catch (TeamException2 e) {
            System.out.println(e.getMessage());
        }

        //按回车键继续
        TSUtility2.readReturn();


    }

    /**
     * 实现删除成员操作
     */
    private void deleteMember2() {
        System.out.println("---------------------删除成员---------------------");
        System.out.println();
        System.out.print("请输入要删除的员工TID:");
        int readTID = TSUtility2.readInt();
        System.out.print("确认是否要删除(Y/N):");
        char confirmSelection = TSUtility2.readConfirmSelection();
        if(confirmSelection == 'N'){
            return;
        }
        try {
            teamService2.removeMember2(readTID);
            System.out.println("删除成功");
        } catch (TeamException2 e) {
            System.out.println(e.getMessage());
        }

        //按回车键继续
        TSUtility2.readReturn();

    }

    public static void main(String[] args) {
        TeamView2 teamView2 = new TeamView2();
        teamView2.enterMainMenu2();

    }

}
