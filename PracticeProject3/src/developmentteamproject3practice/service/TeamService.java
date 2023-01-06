package developmentteamproject3practice.service;

/**
 * @author shkstart
 * @create 2022-08-05 15:18
 */

import developmentteamproject3practice.domain.Architect;
import developmentteamproject3practice.domain.Designer;
import developmentteamproject3practice.domain.Employee;
import developmentteamproject3practice.domain.Programmer;

/**
 * @Description 关于开发团队成员的管理：曾 删 改 查 ...类的处理
 * @Author EddieZhang
 * @Date 2022/8/5 15:19
 * @Since version-1.0
 */
public class TeamService {
    private static int counter = 1;//用来为开发团队新增成员自动生成团队中的唯一ID：即memberId（应自增1）
    private final int MAX_MEMBER = 5;//表示开发团队中最大成员数
    private Programmer[] team = new Programmer[MAX_MEMBER];//用来保存当前开发团队中的成员对象 数组长度为MAX_MEMBER
    private int total;//记录团队中成员的实际人数

    public TeamService() {
    }

    /**
     * @Description 返回当前团队中的所有对象
     * @Author EddieZhang
     * @Date 2022/8/5 15:25
     * @Param []
     * @Return developmentteamproject3practice.domain.Programmer[] 包含所有成员对象的数组 数组大小与成员人数一致
     * @Since version-1.0
     */
    public Programmer[] getAllTeam() {
        Programmer[] team1 = new Programmer[total];
        for (int i = 0; i < total; i++) {
            team1[i] = team[i];
        }
        return team1;
    }

    /**
     * @Description 向团队中添加成员
     * @Author EddieZhang
     * @Date 2022/8/5 15:26
     * @Param [employee] 待添加成员的对象
     * @Return void 添加失败发回TeamException
     * @Since version-1.0
     */
    public void addMember(Employee employee) throws TeamException {

//        成员已满，无法添加
        if (total >= team.length) {
            throw new TeamException("成员已满，无法添加");
        }
//        该成员不是开发人员，无法添加
        if (!(employee instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }

//        该员工已在本开发团队中
        if (isExcit(employee)) {
            throw new TeamException("该员工已在本开发团队中");

        }

//        该员工已是某团队成员
//        该员正在休假，无法添加
        Programmer p = (Programmer) employee;

        if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {
            throw new TeamException("该员工已是某团队成员");
        } else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
            throw new TeamException("该员正在休假，无法添加");
        }

//        团队中至多只能有一名架构师
//        团队中至多只能有两名设计师
//        团队中至多只能有三名程序员
        int numberOfProgrammer = 0, numberOfDesigner = 0, numberOfArchitect = 0;//记录团队中已存在成员类型的数量
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numberOfArchitect++;
            } else if (team[i] instanceof Designer) {
                numberOfDesigner++;
            } else if (team[i] instanceof Programmer) {
                numberOfProgrammer++;
            }
        }
        if (p instanceof Architect) {
            if (numberOfArchitect >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numberOfDesigner >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Programmer) {
            if (numberOfProgrammer >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }


        //自此 上诉限制均已排除完毕 可以添加至团队中 成为团队一员
        team[total++] = p;
        p.setMemberId(counter++);//给团队的id
        p.setStatus(Status.BUSY);//更改状态


    }

    /**
     * @Description 删除团队中的成员
     * @Author EddieZhang
     * @Date 2022/8/5 15:28
     * @Param [memberId] 待删除成员的memberId
     * @Return void 找不到指定员工的异常 删除失败
     * @Since version-1.0
     */

    public void removeMember(int memberId) throws TeamException {
        int n;
        boolean flag = true;
        for (n = 0; n < total; n++) {
            if (team[n].getMemberId() == memberId) {//判断是否与成员id相等 若相等则表示找到要删除的成员了
                flag = false;
                team[n].setStatus(Status.FREE);//更改删除成员的状态
                team[n].setMemberId(0);
                break;
            }
        }
        System.out.println(n);
        if (flag) {
            throw new TeamException("找不到指定memberId的员工 删除失败");
        }
        for (int j = n + 1; j < total; j++) {
            team[j - 1] = team[j];
//                    team[j].setMemberId( team[j + 1].getMemberId());
        }
        team[--total] = null;


    }

    /**
     * @Description 判断新加入成员是否已经在团队中
     * @Author EddieZhang
     * @Date 2022/8/5 16:15
     * @Param [employee]
     * @Return boolean
     * @Since version-1.0
     */
    private boolean isExcit(Employee employee) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == employee.getId()) {
                return true;
            }
        }
        return false;
    }

    public int getTotal() {
        return total;
    }


}
