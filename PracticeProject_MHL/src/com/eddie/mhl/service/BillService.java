package com.eddie.mhl.service;

import com.eddie.mhl.dao.BillDAO;
import com.eddie.mhl.dao.MultipleDAO;
import com.eddie.mhl.domain.Bill;
import com.eddie.mhl.domain.Menu;
import com.eddie.mhl.domain.Multiple;

import java.util.List;
import java.util.UUID;

/**
 @author EddieZhang
 @create 2022-09-16 16:57
 */
public class BillService {
    BillDAO billDAO = new BillDAO();

    MultipleDAO multipleDAO = new MultipleDAO();
    MenuService menuService = new MenuService();

    DiningTableService diningTableService = new DiningTableService();
    //显示账单的方法
    public void showBill(){
        List<Multiple> multiples = multipleDAO.queryMultiply("select bill.*,menu.name from bill,menu where bill.id = ?", Multiple.class, 1);
        if(multiples.size() < 1){
            System.out.println("没有账单哦~~");
        }
        for (Multiple bill : multiples) {
            System.out.println(bill);
        }
    }
    //根据台号id显示该台的账单
    public Bill showBillByTableId(int tableId){
        return billDAO.querySingleRow("select bill.*,menu.name from bill,menu where bill.id = ?",Bill.class,tableId);
    }

    /*
     * @Description
     * @Author EddieZhang
     * @Date 2022/9/16 17:22
     * @Param [menuId 菜品编号, nums 菜品的数量, diningTableId 用餐台号]
     * @Return boolean 成功返回ture 否则返回false
     * @Since version-1.0
     */
    public boolean orderingMenu(int menuId,int nums,int diningTableId){
        //生成一个随机的账单（使用UUID）
        UUID billId = UUID.randomUUID();
        String strBillId = String.valueOf(billId);
        //根据id获取一个menu对象
        Menu menuById = menuService.getMenuById(menuId);
        //将账单 更新到bill表中
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')", strBillId, menuId, nums, menuById.getPrice() * nums, diningTableId);
        if(update <= 0){
            return false;
        }
        //需要对diningTable的状态进行更新

        return diningTableService.updateDiningTableState(diningTableId);
    }

    //修改bill的结账状态的方法
    public boolean updateBillState(String str,int id){
        int i = billDAO.update("update bill set state = ? where diningTableId = ?", str, id);
        if(i > 0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
