package developmentteamproject3practice3.view;

import developmentteamproject3practice3.domain.Employee3;
import developmentteamproject3practice3.domain.Programmer3;
import developmentteamproject3practice3.service.NameListService3;
import developmentteamproject3practice3.service.TeamException3;
import developmentteamproject3practice3.service.TeamService3;

/**
 * @author EddieZhang
 * @create 2022-08-14 8:27
 */
public class TeamView3 {
    private NameListService3 nameListService3 = new NameListService3();
    private TeamService3 teamService3 = new TeamService3();


    /**
     * @Description 主界面显示及控制方法
     * @Author EddieZhang
     * @Date 2022/8/14 8:29
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void enterMainMenu3(){
        char readMenuSelection = 0;
        while(true){
            System.out.println("-------------------------------------开发团队调度软件--------------------------------------");
            System.out.println();
            if(readMenuSelection != '1'){
            System.out.println("ID\t姓名\t\t年龄\t工资\t\t职位\t\t状态\t\t奖金\t\t\t股票\t\t领用设备");
            listAllEmployees3();
            }
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4):");
            readMenuSelection = TSUtility3.readMenuSelection();
            switch(readMenuSelection){
                case '1'://1-团队列表
                    getTeam3();
                    break;
                case '2'://2-添加团队成员
                    addMember3();
                    break;
                case '3'://3-删除团队成员
                    deleteMember3();
                    break;
                case '4'://4-退出
                    System.out.print("确认是否要退出(Y/N): ");
                    char readConfirmSelection = TSUtility3.readConfirmSelection();
                    if(readConfirmSelection == 'Y'){
                        return;
                    }
            }

        }

    }


    /**
     * @Description 以表格形式列出所有公司成员
     * @Author EddieZhang
     * @Date 2022/8/14 8:30
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void listAllEmployees3(){
        Employee3[] allEmployees3 = nameListService3.getAllEmployees3();
        for (Employee3 employee3s:allEmployees3
        ){
            System.out.println(employee3s);
        }
    }


    /**
     * @Description 显示团队成员列表
     * @Author EddieZhang
     * @Date 2022/8/14 8:31
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void getTeam3(){
        System.out.println("--------------------团队成员列表---------------------");
        Programmer3[] teamService3Team3 = new Programmer3[0];
        try {
            teamService3Team3 = teamService3.getTeam3();
        } catch (TeamException3 e) {
            System.out.println("还没有数据哦！！");
        }
        for(int i = 0;i < teamService3.getTotal3();i++){
                System.out.println(teamService3Team3[i].getInformationForView3());
            }

        System.out.println("-----------------------------------------------------");
    }


    /**
     * @Description 实现添加成员
     * @Author EddieZhang
     * @Date 2022/8/14 8:31
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void addMember3(){
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加成员的ID:");
        int readID = TSUtility3.readInt();
        try {
            teamService3.addMember3(nameListService3.getEmployee3(readID));
            System.out.println("添加成功");
        } catch (TeamException3 e) {
            System.out.println(e.getMessage());
        }
        //按回车键继续...
        TSUtility3.readReturn();
    }


    /**
     * @Description 实现删除成员操作
     * @Author EddieZhang
     * @Date 2022/8/14 8:32
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void deleteMember3(){
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除成员的ID:");
        int readID = TSUtility3.readInt();
        System.out.print("确认是否要删除(Y/N):");
        char selection = TSUtility3.readConfirmSelection();
        if(selection == 'N'){
            return;
        }else{
            try {
                teamService3.removeMember3(readID);
                System.out.println("删除成功");
            } catch (TeamException3 e) {
                System.out.println(e.getMessage());
            }
        }
        //按回车键继续...
        TSUtility3.readReturn();

    }

    public static void main(String[] args) {
        TeamView3 teamView3 = new TeamView3();
        teamView3.enterMainMenu3();
    }
}
