package developmentteamproject3practice1.view1;

import developmentteamproject3practice1.domain1.Employee1;
import developmentteamproject3practice1.domain1.Programmer1;
import developmentteamproject3practice1.service1.NameListService1;
import developmentteamproject3practice1.service1.TeamException1;
import developmentteamproject3practice1.service1.TeamService1;

/**
 * @author shkstart
 * @create 2022-08-06 17:08
 */
public class TeamView1 {
    private NameListService1 nameListService1 = new NameListService1();//供类中的方法使用
    private TeamService1 teamService1 = new TeamService1();//供类中的方法使用

    public TeamView1() {
    }

    /**
     * @Description 主界面显示及控制方法
     * @Author EddieZhang
     * @Date 2022/8/6 17:10
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void enterMainMenu1() {
        char readMenuSelection = 0;
        while (true) {
            if (readMenuSelection != '1') {
                System.out.println("-------------------------------------开发团队调度软件--------------------------------------");
                System.out.println();
                listAllEmployees1();
                System.out.println();
                System.out.println("----------------------------------------------------------------------------------------------");
                System.out.println();
                System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4): ");
            }
            readMenuSelection = TSUtility1.readMenuSelection();
            switch (readMenuSelection) {
                case '1'://1-团队列表
                    getTeam1();
                    break;
                case '2'://2-添加团队成员
                    addMember1();
                    break;
                case '3'://3-删除团队成员
                    deleteMember1();
                    break;
                case '4'://4-退出
                    System.out.print("请选择是否确认要退出(Y/N):");
                    char readConfirmSelection = TSUtility1.readConfirmSelection();
                    if (readConfirmSelection == 'Y') {
                        return;
                    }
            }

        }

    }

    //以下方法供enterMainMenu1()方法调用

    /**
     * 以表格形式列出公司所有成员
     */
    private void listAllEmployees1() {
        Employee1[] nameListService1AllEmployees1 = nameListService1.getAllEmployees1();
        for (int i = 0; i < nameListService1AllEmployees1.length; i++) {
            System.out.println(nameListService1AllEmployees1[i]);
        }

    }

    /**
     * 显示团队列表操作
     */
    private void getTeam1() {
        System.out.println("--------------------团队成员列表---------------------");
        System.out.println();
        System.out.println("TDI/ID  \t姓名    \t年龄      \t工资       \t职位      \t奖金        \t股票");
        Programmer1[] teamService1Team1 = teamService1.getTeam1();
        if (teamService1.getTotal1() < 1 || teamService1Team1 == null) {
            System.out.println("开发团队中还没有数据哦!!");
        } else {
            for (int i = 0; i < teamService1Team1.length; i++) {//遍历团队成员数组 根据成员类型显示成员信息
                System.out.println(teamService1Team1[i].getInformationForView());

            }
        }
        System.out.println("-------------------------------------------------");
    }


    /**
     * 实现添加成员操作
     */
    private void addMember1() {
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加成员的ID:");
        int readID = TSUtility1.readInt();
        try {
            Employee1 nameListService1Employee1 = nameListService1.getEmployee1(readID);
            teamService1.addMember1(nameListService1Employee1);
            System.out.println("添加成功");
        } catch (TeamException1 e) {
            System.out.println(e.getMessage());
        }

        //按回车键继续
        TSUtility1.readReturn();


    }

    /**
     * 实现删除成员操作
     */
    private void deleteMember1() {
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除成员的TID:");
        int readTID = TSUtility1.readInt();
        System.out.print("确认是否要删除(Y/N):");
        char readConfirmSelection = TSUtility1.readConfirmSelection();
        if (readConfirmSelection == 'N') {
            return;
        } else {
            try {
                teamService1.removeMember1(readTID);
                System.out.println("删除成功");
            } catch (TeamException1 e) {
                System.out.println(e.getMessage());
            }


            //按回车键继续
            TSUtility1.readReturn();

        }

    }

    public static void main(String[] args) {
        TeamView1 view1 = new TeamView1();
        view1.enterMainMenu1();

    }
}
