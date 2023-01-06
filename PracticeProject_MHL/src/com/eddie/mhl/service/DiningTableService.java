package com.eddie.mhl.service;

import com.eddie.mhl.dao.DiningTableDAO;
import com.eddie.mhl.domain.DiningTable;

import java.util.List;

/**
 @author EddieZhang
 @create 2022-09-13 20:18
 */
public class DiningTableService {
    //定义diningTableDAO对象
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    /*
     * @Description 返回所有Table的信息
     * @Author EddieZhang
     * @Date 2022/9/13 20:20
     * @Param []
     * @Return com.eddie.mhl.domain.DiningTable
     * @Since version-1.0
     */
    public List<DiningTable> getTableInfo() {
        List<DiningTable> diningTables = diningTableDAO.queryMultiply("select id as id,state as state from diningTable where id >= ?", DiningTable.class, 1);
        return diningTables;
    }

    /*
     * @Description 预定
     * @Author EddieZhang
     * @Date 2022/9/13 21:19
     * @Param []
     * @Return com.eddie.mhl.domain.DiningTable
     * @Since version-1.0
     */
    public DiningTable bookDiningTable(int id) {
        return diningTableDAO.querySingleRow("select * from diningTable where id = ?", DiningTable.class, id);
    }

    /*
     * @Description 如果可以预定 则更新餐桌的状态以及相关数据
     * @Author EddieZhang
     * @Date 2022/9/13 21:23
     * @Param []
     * @Return boolean
     * @Since version-1.0
     */
    public boolean updateTableState(String name, String telephone, int id) {
        int i = diningTableDAO.update("update diningTable set state = '已经预定',orderName=?,orderTel=? where id = ?", name, telephone, id);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    //提供一个根据id验证餐桌是否存在的方法
    public boolean existTable(int id) {
        DiningTable diningTable = diningTableDAO.querySingleRow("select * from diningTable where id = ?", DiningTable.class, id);
        if (diningTable != null) {
            return true;
        } else {
            return false;
        }
    }

    //根据id验证餐桌的状态
    public String getStateById(int id) {
        Object object = diningTableDAO.queryObject("select state from diningTable where id = ?", id);
        return (String) object;
    }

    //提供一个更新diningTable状态为用餐中的方法
    public boolean updateDiningTableState(int tableId) {
        int update = diningTableDAO.update("update diningTable set state = '用餐中' where id = ?", tableId);
        if (update <= 0) {
            return false;
        } else {
            return true;
        }
    }

    //提供一个更新diningTable状态为空的方法
    public boolean updateDiningTableStateToNull(int tableId) {
        int update = diningTableDAO.update("update diningTable set state = '空' where id = ?", tableId);
        int i1 = diningTableDAO.update("update diningTable set orderName = '',orderTel = '' where id = ?", tableId);
        if (update > 0 && i1 > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
    }


}
