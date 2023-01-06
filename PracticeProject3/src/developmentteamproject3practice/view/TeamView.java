package developmentteamproject3practice.view;

import developmentteamproject3practice.domain.Employee;
import developmentteamproject3practice.domain.Programmer;
import developmentteamproject3practice.service.NameListService;
import developmentteamproject3practice.service.TeamException;
import developmentteamproject3practice.service.TeamService;

/**
 * @author shkstart
 * @create 2022-08-05 18:25
 */
public class TeamView {
    private NameListService listService = new NameListService();
    private TeamService teamService = new TeamService();

    /**
     * @Description 主界面显示及控制方法
     * @Author EddieZhang
     * @Date 2022/8/5 18:27
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void enterMainMenu() {
        char readMenuSelection = 0;
        while (true) {
            if (readMenuSelection != '1') {
                System.out.println("-------------------------------------开发团队调度软件--------------------------------------");
                System.out.println();
                listAllEmployees();
                System.out.println();
                System.out.println("----------------------------------------------------------------------------------------------");
                System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)： ");
            }
            readMenuSelection = TSUtility.readMenuSelection();
            switch (readMenuSelection) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("是否要退出(Y/N):");
                    char readConfirmSelection = TSUtility.readConfirmSelection();
                    if (readConfirmSelection == 'Y') {
                        return;
                    }

            }

        }

    }

    //以下方法供enterMainMenu使用

    /**
     * 以表格形式列出公司所有成员
     */
    private void listAllEmployees() {
        Employee[] listServiceEmployees = listService.getEmployees();
        for (int i = 0; i < listServiceEmployees.length; i++) {
            System.out.println(listServiceEmployees[i]);

        }


    }

    /**
     * 显示团队成员列表操作
     */
    private void getTeam() {
        Programmer P1 = new Programmer();
        Programmer[] allTeam = teamService.getAllTeam();
        System.out.println("--------------------团队成员列表---------------------");
        System.out.println();
        System.out.println("TDI/ID\t姓名\t\t年龄\t\t工资\t\t职位\t\t奖金\t\t股票");

        if (teamService.getTotal() <= 0 || allTeam == null) {//判断团队中是否有成员
            System.out.println("还没有数据哦！！");
        } else {
            for (int i = 0; i < allTeam.length; i++) {
                System.out.println(allTeam[i].getDetailForView());

            }

        }
        System.out.println("------------------------------------------------");
    }

    /**
     * 实现添加成员操作
     */
    private void addMember() {
        System.out.print("请输入要添加的员工ID:");
        int readID = TSUtility.readInt();
        try {
            teamService.addMember(listService.getEmployee(readID));
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败,原因: " + e.getMessage());
        }
        //按回车键继续
        TSUtility.readReturn();

    }

    /**
     * 实现删除成员操作
     */
    private void deleteMember() {
        System.out.print("请输入要删除的员工TID:");
        int readID = TSUtility.readInt();
        System.out.print("确认是否要删除(Y/N):");
        char confirmSelection = TSUtility.readConfirmSelection();
        if (confirmSelection == 'N') {
            return;
        } else {
            try {
                teamService.removeMember(readID);
                System.out.println("删除成功");
            } catch (TeamException e) {
                System.out.println("删除失败,原因: " + e.getMessage());
            }
            //按回车键继续
            TSUtility.readReturn();
        }

    }


    public static void main(String[] args) {
        TeamView v1 = new TeamView();
        v1.enterMainMenu();
    }
}
