package com.eddie.mhl.domain;

/**
 @author EddieZhang
 @create 2022-09-17 8:57
 */

import java.util.Date;

/**
 * 实现多表查询 的类 将需要使用到的多表查询到的字段 添加
 */
public class Multiple {
    //bill表中的
    private int id;
    private String billId;
    private int menuId;
    private int nums;
    private double money;
    private int diningTableId;
    private Date billDate;
    private String state;

    //需要多表查询的列相应添加为属性 按照规发属性名和列名要一致 如果遇到列名冲突 可以在sql查询语句中使用 as 别名
    //menu表中
    private String name;//菜品的名称
    //要提供get set 方法 将数据库中的数据封装类的时候 通过反射机制 调用对应类的空参构造器 通过set方法 给类的属性赋值

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Multiple(int id, String billId, int menuId, int nums, double money, int diningTableId, Date billDate, String state, String name) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.diningTableId = diningTableId;
        this.billDate = billDate;
        this.state = state;
        this.name = name;
    }

    @Override
    public String toString() {
        return "" + id + "\t\t" + menuId + "\t\t" + nums + "\t\t" + money + "\t" + diningTableId + "\t" + billDate + "\t" + state  + "\t\t" + name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(int diningTableId) {
        this.diningTableId = diningTableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    public Multiple() {
    }


}
