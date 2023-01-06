package CustomerProject2Practice1.servise;

import CustomerProject2Practice1.bean.Customer1;

/**
 * @author shkstart
 * @create 2022-08-02 17:40
 */
//创建类 设计类的成员
public class CustomerList1 {
    //设计类的属性
    private Customer1[] customers1;//创建对象数组用来保存客户对象
    private int total;//记录已保存的客户的数量 从 1 开始

    //设计类的constructor方法


    public CustomerList1() {
    }

    /**
     * 用来初始化数组
     * @param totalNumber 指定数组的最大空间 数组的长度（存储客户的最大空间）
     */
    public CustomerList1(int totalNumber) {
        customers1 = new Customer1[totalNumber];//动态初始化数组 确定数组的长度
    }


    //设计类的方法

    /**
     * 添加用户 及给数组各个位置上的元素赋值操作
     * @param customer1 指定要添加的新客户对象
     * @return 添加成功返回true false表示数组已满 添加失败
     */
    public boolean addCustomer1(Customer1 customer1){
        if(total > customers1.length){
            return false;//表示数组已满 添加失败
        }
        customers1[total++] = customer1;
        return true;
    }

    /**
     * 修改（替换）用户
     * @param index 指定所要替换的数组的索引位置 从0开始
     * @param customer1 指定要替换的新客户的对象
     * @return 替换成功返回true false表示索引无效 替换失败
     */
    public boolean replaceCustomer1(int index,Customer1 customer1){
        if(index < 0 || index >= total){//判断index是否在有效范围内
            return false;
        }
        customers1[index] = customer1;
        return true;
    }

    /**
     * 删除用户
     * @param index 指定所要删除的数组的索引位置 从0开始
     * @return 删除成功返回true false表示索引无效 删除失败
     */
    public boolean deleteCustomer1(int index){
        if(index < 0 || index >= total){//判断index是否在有效范围内
            return false;
        }
        for(int i = index;i <= total-1;i++){//遍历数组 从要删除的索引位置开始到最后一个客户索引位置结束
            customers1[index] = customers1[index + 1];//逐个向前覆盖
            customers1[--total] = null;//客户的数量total-- 最后一个置空

        }
        return true;
    }

    /**
     * 客户列表 返回数组中记录的所有客户对象
     * @return  数组中记录的所有客户对象
     */
    public Customer1[] getAllCustomers1(){
        if(total < 1){//判断是否有客户数据 为空返回null
            return null;
        }
        Customer1[] custs1 = new Customer1[customers1.length];//new一个新的数组用来接遍历客户数据
        for (int i = 0;i < customers1.length;i++){
            custs1[i] = customers1[i];
        }
        return custs1;
    }

    /**
     * 查找客户 返回按照index指定索引位置的客户对象记录
     * @param index 指定所要获取的客户在数组中的索引位置，从0开始
     * @return 封装了客户信息的Customer对象
     */
    public Customer1 getCustomer1(int index){
        if(index < 0 || index >= total){//判断index是否在有效范围内
            return null;
        }
        return customers1[index];
    }

    /**
     * 获取客户数量值
     * @return total表示客户的数量
     */
    public int getTotal1(){
        return total;
    }

    public Customer1[] getCustomers1() {
        return customers1;
    }

    public int getTotal() {
        return total;
    }
}
