package com.eddie.mhl.view;

import com.eddie.mhl.domain.DiningTable;
import com.eddie.mhl.domain.Employees;
import com.eddie.mhl.domain.Menu;
import com.eddie.mhl.service.BillService;
import com.eddie.mhl.service.DiningTableService;
import com.eddie.mhl.service.EmployeesService;
import com.eddie.mhl.service.MenuService;
import com.eddie.mhl.utils.Utility;

import java.util.List;

/**
 @author EddieZhang
 @create 2022-09-13 14:32
 */
/*
 * @Description 项目的界面设计
 * @Author EddieZhang
 * @Date 2022/9/13 14:32
 * @Since version-1.0
 */
public class MHLView {

    private boolean flag = true;//设计一个boolean变量来控制while循环
    private String str = "";//接收用户的选项
    private EmployeesService employeesService = new EmployeesService();//定义EmployeesService属性

    private DiningTableService diningTableService = new DiningTableService();//定义DiningTableService属性

    private MenuService menuService = new MenuService();//定义MenuService属性

    BillService billService = new BillService();//定义BillService属性

    public static void main(String[] args) {
        MHLView mhlView = new MHLView();
        mhlView.mainMenu();
    }

    /*
     * @Description 一级菜单的设计
     * @Author EddieZhang
     * @Date 2022/9/13 14:44
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void mainMenu() {
        while (flag) {
            System.out.println("===================MHL===================");
            System.out.println("\t\t\t\t 1\t登录");
            System.out.println("\t\t\t\t 2\t退出");
            System.out.println();
            System.out.print("请输入选项:");
            str = Utility.readString(1);
            switch (str) {
                case "1":
                    System.out.print("请输入员工号:");
                    String readAccount = Utility.readString(20);
                    System.out.print("请输入密码:");
                    String readPassword = Utility.readString(20);
                    Employees employee = employeesService.getEmployeesPasswordAndAccount(readAccount, readPassword);
                    if (employee != null) {
                        System.out.println("===================（ " + employee.getname() + " ）登录成功===================\n");
                        secondMenu();
                    } else {
                        System.out.println("您输入的账号或密码有误！请重新登录~~");
                    }
                    break;
                case "2":
                    flag = false;//退出
                    break;
                default:
                    System.out.println("输入的选项有误！请重新输入~");
            }
        }
        System.out.println("已退出系统~~");


    }

    /*
     * @Description 二级菜单的设计
     * @Author EddieZhang
     * @Date 2022/9/13 14:44
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void secondMenu() {
        while (flag) {
            System.out.println("===================MHLSecondMenu===================");
            System.out.println("\t\t\t\t 1\t显示餐桌状态");
            System.out.println("\t\t\t\t 2\t预定餐桌");
            System.out.println("\t\t\t\t 3\t显示所有菜品");
            System.out.println("\t\t\t\t 4\t点餐服务");
            System.out.println("\t\t\t\t 5\t查看账单");
            System.out.println("\t\t\t\t 6\t结账");
            System.out.println("\t\t\t\t 9\t退出");
            System.out.print("请输入你的选择:");
            str = Utility.readString(1);
            switch (str) {
                case "1":
                    listDiningTable();//显示所有餐桌状态信息的方法
                    break;
                case "2":
                    bookDiningTable();//预定餐桌
                    break;
                case "3":
                    menuList();//显示所有菜品
                    break;
                case "4":
                    orderingService();//点餐服务
                    break;
                case "5":
                    showBill();//查看账单
                    break;
                case "6":
                    payingTheBill();//结账
                    break;
                case "9":
                    flag = false;
                    break;
                default:
                    System.out.println("输入的选项有误！请重新输入~");

            }
        }
    }

    /*
     * @Description 显示所有餐桌的状态信息
     * @Author EddieZhang
     * @Date 2022/9/13 21:12
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void listDiningTable() {
        System.out.println("===================显示餐桌状态===================");
        System.out.print("餐桌编号\t\t\t\t\t\t餐桌状态");
        List<DiningTable> tableInfo = diningTableService.getTableInfo();
        System.out.println();
        for (int i = 0; i < tableInfo.size(); i++) {
            System.out.print(tableInfo.get(i).getId() + "\t\t\t\t\t\t\t" + tableInfo.get(i).getState());
            System.out.println();
        }
        System.out.println();
        System.out.println("===================显示完毕===================");
    }

    /*
     * @Description 预定餐桌方法
     * @Author EddieZhang
     * @Date 2022/9/13 21:31
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void bookDiningTable() {
        System.out.println("===================预定餐桌===================");
        System.out.print("请选择要预定餐桌的编号(-1退出):");
        int readInt = Utility.readInt();
        if (readInt == -1) {
            System.out.println("===================取消预定===================");
            return;
        }
        DiningTable table = diningTableService.bookDiningTable(readInt);
        if (table == null) {
            System.out.println("餐桌不存在请重新输入~");
            return;
        }
        if("已经预定".equals(diningTableService.bookDiningTable(readInt).getState())){
            System.out.println("餐桌已经被预约~~");
        }else {
            System.out.print("确认是否预定?");
            char confirmSelection = Utility.readConfirmSelection();
            if (confirmSelection == 'Y') {
                System.out.print("预定人姓名:");
                String readName = Utility.readString(12);
                System.out.print("预定人电话:");
                String readTelephone = Utility.readString(12);
                boolean updateTableState = diningTableService.updateTableState(readName,readTelephone,readInt);
                if (updateTableState) {
                    System.out.println("===================预定成功===================");
                }else {
                    System.out.println("===================预定失败===================");
                }
            } else {
                return;
            }
        }
    }

    /*
     * @Description 显示所有菜品
     * @Author EddieZhang
     * @Date 2022/9/16 15:58
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void menuList(){
        System.out.println("===================Menu界面===================");
        System.out.println("菜品编号\t\t菜品名称\t\t菜品类型\t价格");
        menuService.showMenu();
        System.out.println("===================显示完毕===================");
    }

    //点餐服务
    public void orderingService(){
        System.out.println("===================点餐服务===================");
        menuList();
        System.out.print("请选择点餐的桌号(-1退出):");
        int readDiningTable = Utility.readInt();
        if(readDiningTable == -1){
            System.out.println("===================取消点餐===================");
            return;
        }
        //验证桌号是否存在
        boolean b = diningTableService.existTable(readDiningTable);
        if(!b){
            System.out.println("===================餐桌号不存在===================");
            return;
        }
        //验证餐桌的状态是否为空
//        String stateById = diningTableService.getStateById(readDiningTable);
//        if(!("空".equals(stateById))){
//            System.out.println("===================餐桌已被占用===================");
//        }
        System.out.print("请选择菜品编号(-1退出):");
        int readDishesNum = Utility.readInt();
        if(readDishesNum == -1){
            System.out.println("===================取消点餐===================");
            return;
        }
        //验证菜品是否存在
        Menu menu = menuService.getMenuById(readDishesNum);
        if(menu == null){
            System.out.println("===================菜品不存在===================");
            return;
        }
        System.out.print("请选择菜品数量(-1退出):");
        int readNums = Utility.readInt();
        if(readNums == -1){
            System.out.println("===================取消点餐===================");
            return;
        }

        System.out.print("确认是否点菜(Y/N):");
        char confirmSelection = Utility.readConfirmSelection();
        if(confirmSelection == 'N'){
            System.out.println("===================取消点餐===================");
            return;
        }

        //可以点餐
        boolean orderingMenu = billService.orderingMenu(readDishesNum, readNums, readDiningTable);
        if(orderingMenu){
            System.out.println("===================下单成功===================");
        }else {
            System.out.println("===================点单失败===================");
        }
    }

    //查看账单
    public void showBill(){
        System.out.println("===================账单显示===================");
        System.out.println("账单号\t菜品名称\t菜品数量\t消费金额\t台号\t流水日期\t\t订单状态\t菜品名称");
        billService.showBill();
        System.out.println("===================显示完成===================");
    }

    //结账方法
    public void payingTheBill(){
        System.out.println("===================结账服务===================");
        System.out.print("请选择要结账的餐桌编号(-1退出)");
        int readTableId = Utility.readInt();
        if(readTableId == -1){
            return;
        }
        if(billService.showBillByTableId(readTableId) == null){//对桌号进行校验
            System.out.println("此桌号没有待结账单哦~~");
            return;
        }
        System.out.print("结账方式(现金/支付宝/微信)回车表示退出:");
        String readString = Utility.readString(3, "退出");
        if("退出".equals(readString)){
            return;
        }
        System.out.print("确认是否结账(Y/N):");
        char confirmSelection = Utility.readConfirmSelection();
        if(confirmSelection == 'N'){
            return;
        }
        //至此进行结账操作
        //修改bill表的state
        boolean b1 = billService.updateBillState(readString, readTableId);
        //修改diningTable信息  以及相关信息置空
        boolean b = diningTableService.updateDiningTableStateToNull(readTableId);
        if(b1 == true && b == true){
            System.out.println("===================结账成功===================");
        }else {
            System.out.println("===================结账失败===================");
        }

        System.out.println("===================结账服务===================");
    }


}


