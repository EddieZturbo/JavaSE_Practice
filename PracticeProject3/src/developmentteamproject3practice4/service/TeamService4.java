package developmentteamproject3practice4.service;

/**
 @author EddieZhang
 @create 2022-08-27 12:32
 */

import developmentteamproject3practice4.domain.Architect4;
import developmentteamproject3practice4.domain.Designer4;
import developmentteamproject3practice4.domain.Employee4;
import developmentteamproject3practice4.domain.Programmer4;

import static developmentteamproject3practice4.service.Status4.*;

/**
 * @Description 关于开发团队成员的管理：添加、删除等
 * @Author EddieZhang
 * @Date 2022/8/27 12:33
 * @Since version-1.0
 */
public class TeamService4 {
    private static int counter4 = 1;//静态变量；用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。（提示：应使用增1的方式）
    private final int MAX_MEMBER = 5;//常量；表示开发团队的最大成员数
    private Programmer4[] programmers4 = new Programmer4[MAX_MEMBER];//用来储存开发团队成员对象的数组
    private int total4 = 0;//用来记录团队成员的实际人数

    public TeamService4() {
    }


    /**
     * @Description 返回当前团队的所有对象
     * @Author EddieZhang
     * @Date 2022/8/27 12:39
     * @Param []
     * @Return developmentteamproject3 practice4.domain.Programmer4[]包含所有成员对象的数组，数组大小与成员人数一致
     * @Since version-1.0
     */
    public Programmer4[] getTeam4() {
        if (programmers4.length < 0 || total4 <= 0) {//判断团队中是否有成员
            return null;
        }
        //数组非空--返回包含所有成员对象的数组，数组大小与成员人数一致
        Programmer4[] programmer4s = new Programmer4[total4];//new一个新的数组“接”储存了团队成对象的数组数据
        for(int i = 0;i< total4;i++){
            programmer4s[i] = programmers4[i];
        }
        return programmer4s;//返回包含所有成员对象的数组
    }

    /**
     * @Description 向团队中添加成员
     * @Author EddieZhang
     * @Date 2022/8/27 12:40
     * @Param [employee4]待添加成员的对象
     * @Return void异常：添加失败， TeamException中包含了失败原因
     * @Since version-1.0
     */
    public void addMem4(Employee4 employee4) throws TeamException4 {
//        成员已满，无法添加
        if (total4 >= MAX_MEMBER) {//根据团队中的实际人数和最大团队人数进行比较判断团队是否满员
            throw new TeamException4("成员已满，无法添加");
        }
//        该成员不是开发人员，无法添加
        if (!(employee4 instanceof Programmer4)) {
            throw new TeamException4("该成员不是开发人员，无法添加");
        }
        //至此可以将employee4向下转型为Programmer
        Programmer4 programmer4 = (Programmer4) employee4;
//        该员工已在本开发团队中
        for (int i = 0; i < total4; i++) {//遍历开发团队中的已存所有成员
            if (programmer4.getId4() == programmers4[i].getId4()) {//根据员工在团队或公司中的共同属性id来判断是否已在开发团队中
                throw new TeamException4("该员工已在本开发团队中");
            }
        }

//        该员工已是某团队成员
//        该员正在休假，无法添加
        //根据员工的status进行判断
        if(BUSY.equals(programmer4.getStatus4())){
            throw new TeamException4("该员工已是某团队成员");
        } else if (VOCATION.equals(programmer4.getStatus4())) {
            throw new TeamException4("该员正在休假，无法添加");
        }

//        团队中至多只能有一名架构师
//        团队中至多只能有两名设计师
//        团队中至多只能有三名程序员
        //遍历团队中的所有成员 记录各个岗位的员工个数
        int numberOfProgrammer = 0,numberOfDesigner = 0,numberOfArchitect = 0;//设计int型的变量记录各个岗位员工在团队中存在的个数
        for (int i = 0;i < total4;i++){
            if(programmers4[i] instanceof Architect4){
                numberOfArchitect++;
            } else if (programmers4[i] instanceof Designer4) {
                numberOfDesigner++;
            } else if (programmers4[i] instanceof Programmer4) {
                numberOfProgrammer++;
            }
        }
        if(programmer4 instanceof Architect4){
            if(numberOfArchitect >= 1){
                throw new TeamException4("团队中至多只能有一名架构师");
            }
        } else if (programmer4 instanceof Designer4) {
            if(numberOfDesigner >= 2){
            throw new TeamException4("团队中至多只能有两名设计师");
            }
        } else if (programmer4 instanceof Programmer4) {
            if(numberOfProgrammer >= 3){
                throw new TeamException4("团队中至多只能有三名程序员");
            }
        }
        //至此 将员工添加至开发团队中
        programmers4[total4++] = programmer4;//将员工赋值到数组中
        programmer4.setStatus4(BUSY);//将员工的status改为BUSY
        programmer4.setMemberId4(counter4++);//给加入进开发团队的员工提供memberId
    }

    /**
     * @Description 从团队中删除成员
     * @Author EddieZhang
     * @Date 2022/8/27 12:41
     * @Param [Id]待删除成员的memberId
     * @Return void异常：找不到指定memberId的员工，删除失败
     * @Since version-1.0
     */
    public void removeMember4(int memberId) throws TeamException4{
        boolean flag = true;
        int i = 0;
        for(;i < total4;i++){//遍历开发团队中的所有成员
            if(programmers4[i].getMemberId4() == memberId){//判断待删除成员的Id是否存在于开发团队中
                flag = false;
                programmers4[i].setStatus4(FREE);//将待删除成员的status改为FREE
                break;//此时的i为待删除的成员索引位置
            }
        }
        if(flag){
            throw new TeamException4("找不到指定memberId的员工，删除失败");
        }
        for(int j = i;j < total4 - 1;j++){//从待删除成员的索引位置开始遍历到最后一个成员
            programmers4[j] = programmers4[j + 1];//待删除成员的索引位置的后一个逐个向前覆盖
        }
        programmers4[--total4] = null;//最后一个位置置空
    }

    public int getTotal4() {
        return total4;
    }
}
