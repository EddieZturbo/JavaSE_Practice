package CustomerProject2Practice.servise;

import CustomerProject2Practice.bean.Customer;

/**
 * @author shkstart
 * @create 2022-07-30 9:22
 */
//创建类 设计类的成员
public class CustomerList {
    //设计类的属性
    private Customer[] customers;//创建Customer类数组 存放客户对象
    private int total;//记录已存放的客户对象的数量


    //设计类constructor方法

    public CustomerList() {
    }

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];//动态初始化数组 确定数组长度及确定最多存储的客户数量
    }
    //设计类的方法

    /**
     * 添加客户
     * @param customer 存入的新客户对象
     * @return添加成功返回true false表明数组已满 添加失败
     */
    public boolean addCustomer(Customer customer){
        if(total >= customers.length){//判断存入客户的数量是否超出数组存储范围 超出则返回false表示添加失败
           return false;
        }
        customers[total++] = customer;//未超范围的正常给数组赋值 及添加客户 total客户数量++ 返回true表示添加成功
        return true;
    }

    /**
     * 替换数组（修改数组）
     * @param index 指定所替换对象在数组中的位置 由0开始
     * @param customer 指定替换的新客户对象
     * @return 添加成功返回true false表示index索引值不在正确范围内 无法替换修改
     */
    public boolean replaceCustomer(int index,Customer customer){
        if(index < 0 || index >= customers.length){//判断index索引值是否在正确范围内 不在表明索引无效 返回false
            return false;
        }
        customers[index] = customer;//index在有效范围内 给数组所在索引位置附上新的客户的地址值 完成替换 并返回true
        return true;
    }

    /**
     * 删除客户
     * @param index 指定要删除对象在数组中的位置 由0开始
     * @return 删除成功返回true false表示index索引值不在正确范围内 无法删除
     */
    public boolean deleteCustomer(int index){
        if(index < 0 || index >= customers.length){//判断index索引值是否在正确范围内 不在表明索引无效 返回false
            return false;
        }
        for(int i = index;i < total;i++){//index在有效范围内 遍历要删除索引位置到最后一个客户索引位置的数组元素 逐一向前覆盖 原本是最后一个元素的位置置空
            customers[index] = customers[index + 1];
            customers[--total] = null;
        }
        return true;
    }

    /**
     * 返回数组中记录的所有客户对象
     * @return 返回数组中所有客户对象
     */
    public Customer[] getAllCustomers(){
        Customer[] cust = new Customer[total+1];
        for(int i = 0;i < total+1;i++){
            cust[i] = customers[i];

        }
        return cust;
    }

    /**
     * 搜索客户
     * @param index 指定要搜索的对象在数组中的位置 由0开始
     * @return 返回封装了客户信息的Customer对象
     */
    public Customer getCustomer(int index){//判断index索引值是否在正确范围内 不在表明索引无效 返回null
        if(index < 0 || index > total){
            return null;
        }
        return customers[index];//返回index指定位置的Customer对象

    }

    /**
     * 客户数量
     * @return 返回total值
     */
    public int getTotal(){
        return total;
    }
}
