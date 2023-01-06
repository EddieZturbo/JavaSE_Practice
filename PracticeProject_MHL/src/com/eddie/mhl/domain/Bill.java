package com.eddie.mhl.domain;

import java.util.Date;

/**
 @author EddieZhang
 @create 2022-09-16 16:50
 */
public class Bill {
    private int id;
    private String billId;
    private int menuId;
    private int nums;
    private double money;
    private int diningTableId;
    private Date billDate;
    private String state;

    @Override
    public String toString() {
        return "" + id + "\t\t" + menuId + "\t\t" + nums + "\t\t" + money + "\t" + diningTableId + "\t" + billDate + "\t" + state ;
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

    public Bill(int id, String billId, int menuId, int nums, double money, int diningTableId, Date billDate, String state) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.diningTableId = diningTableId;
        this.billDate = billDate;
        this.state = state;
    }

    public Bill() {
    }
}
