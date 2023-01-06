package com.eddie.mhl.service;

import com.eddie.mhl.dao.MenuDAO;
import com.eddie.mhl.domain.Menu;

import java.util.List;

/**
 @author EddieZhang
 @create 2022-09-16 15:41
 */
public class MenuService {
    MenuDAO menuDAO = new MenuDAO();//定义一个MenuDAO属性

    /*
     * @Description 返回菜单信息的方法
     * @Author EddieZhang
     * @Date 2022/9/16 15:43
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void showMenu(){
        List<Menu> queryMultiply = menuDAO.queryMultiply("select * from menu where id >= ?", Menu.class, 1);
        for (Menu menu : queryMultiply   ) {
            System.out.println(menu);
        }

    }
    //根据menuId 返回menu对象
    public Menu getMenuById(int id){
        return menuDAO.querySingleRow("select * from menu where id = ?", Menu.class, id);
    }


    public static void main(String[] args) {
        MenuService menuService = new MenuService();
    }
}
