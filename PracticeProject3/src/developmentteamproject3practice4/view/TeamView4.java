package developmentteamproject3practice4.view;

import developmentteamproject3practice4.domain.Employee4;
import developmentteamproject3practice4.domain.Programmer4;
import developmentteamproject3practice4.service.NameListService4;
import developmentteamproject3practice4.service.TeamException4;
import developmentteamproject3practice4.service.TeamService4;

/**
 @author EddieZhang
 @create 2022-08-27 15:56
 */
public class TeamView4 {
    private NameListService4 nameListService4 = new NameListService4();
    private TeamService4 teamService4 = new TeamService4();

    /**
     * @Description 主界面显示及控制方法
     * @Author EddieZhang
     * @Date 2022/8/27 15:58
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void enterMainMenu4(){
        TeamView4 teamView4 = new TeamView4();
        char readMenuSelection = 0;
        while(true){
            System.out.println("-------------------------------------开发团队调度软件-------------------------------------");
            System.out.println();
            System.out.println("ID\t姓名\t\t年龄\t工资\t\t职位\t\t状态\t\t奖金\t\t\t股票\t\t领用设备");
            if(readMenuSelection != '1'){
                teamView4.listAllEmployees4();
            }
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4):");
            readMenuSelection = TSUtility4.readMenuSelection();
            switch (readMenuSelection){
                case '1'://1-团队列表
                    teamView4.getTeam4();
                break;
                case '2'://2-添加团队成员
                    teamView4.addMember4();
                break;
                case '3'://3-删除团队成员
                    teamView4.deleteMember();
                break;
                case '4'://4-退出
                    System.out.println("请确认是否要退出(Y/N):");
                    char confirmSelection = TSUtility4.readConfirmSelection();
                    if(confirmSelection == 'Y'){
                        return;
                    }
            }
        }

    }
    //以下方法供enterMainMenu4使用
    /**
     * @Description 以表格形式列出公司所有员工
     * @Author EddieZhang
     * @Date 2022/8/27 16:00
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    private void listAllEmployees4(){
        Employee4[] service4Employees4 = nameListService4.getEmployees4();
        for (Employee4 e4 :
                service4Employees4) {
            System.out.println(e4);
        }

    }
    /**
     * @Description 显示团队成员列表
     * @Author EddieZhang
     * @Date 2022/8/27 16:00
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    private void getTeam4(){
        System.out.println("--------------------团队成员列表---------------------");
        if(teamService4.getTeam4() == null){
            System.out.println("团队中还没有成员哦~~");
        }else{
        Programmer4[] teamService4Team4 = teamService4.getTeam4();
        for (Programmer4 p4 :
                teamService4Team4) {
            System.out.println(p4.detailForView());
        }
        System.out.println("-----------------------------------------------------");
        }

    }
    /**
     * @Description 实现添加成员操作
     * @Author EddieZhang
     * @Date 2022/8/27 16:00
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    private void addMember4(){
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加成员的id:");
        int readId = TSUtility4.readInt();
        try {
            teamService4.addMem4(nameListService4.getEmployee4(readId));
            System.out.println("添加成功");
        } catch (TeamException4 e) {
            System.out.println(e.getMessage());
        }
        //按回车键继续...
        TSUtility4.readReturn();

    }
    /**
     * @Description 实现删除成员操作
     * @Author EddieZhang
     * @Date 2022/8/27 16:00
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    private void deleteMember(){
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除成员的memberId:");
        int readMemberId = TSUtility4.readInt();
        System.out.print("确定是否要删除成员(Y/N):");
        char selection = TSUtility4.readConfirmSelection();
        if(selection == 'N'){
            return;
        }
        try {
            teamService4.removeMember4(readMemberId);
            System.out.println("删除成功");
        } catch (TeamException4 e) {
            System.out.println(e.getMessage());
        }
        //按回车键继续...
        TSUtility4.readReturn();
    }

    /**
     * @Description main方法 程序的入口 对程序进行测试
     * @Author EddieZhang
     * @Date 2022/8/27 16:02
     * @Param [args]
     * @Return void
     * @Since version-1.0
     */
    public static void main(String[] args) {
        TeamView4 teamView4 = new TeamView4();
        teamView4.enterMainMenu4();
    }
}
