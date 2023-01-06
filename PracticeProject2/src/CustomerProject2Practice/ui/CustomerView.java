package CustomerProject2Practice.ui;

import CustomerProject2Practice.CMU.CMUtility;
import CustomerProject2Practice.bean.Customer;
import CustomerProject2Practice.servise.CustomerList;

/**
 * @author shkstart
 * @create 2022-07-30 9:22
 */
//创建类 设计类的成员
public class CustomerView {
    //设计类的属性
    private CustomerList customerList = new CustomerList(5);

    //设计类的constructor方法

    public CustomerView() {
    }


    //设计类的方法
    /**
     * 主菜单
     */
    public void enterMainMemu(){
        while(true){
            System.out.println("-----------------客户信息管理软件-----------------");
            System.out.println();
            System.out.println("                 1 添 加 客 户");
            System.out.println("                 2 修 改 客 户");
            System.out.println("                 3 删 除 客 户");
            System.out.println("                 4 客 户 列 表");
            System.out.println("                 5 退      出");
            System.out.println();
            System.out.print("请选择(1-5)：");
            char readMenuSelection = CMUtility.readMenuSelection();
            switch (readMenuSelection){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCusromers();
                    break;
                case '5':
                    System.out.print("确认是否要退出（Y/N）:");
                    char confirmSelection = CMUtility.readConfirmSelection();
                    if(confirmSelection == 'Y'){
                        return;
                    }
                    break;
            }
        }
    }
    /**
     * 添加客户
     */
    private void addNewCustomer(){

        System.out.println("---------------------添加客户---------------------");
        System.out.println();
        System.out.print("姓名：");
        String readName = CMUtility.readString(5);
        System.out.print("姓别：");
        char readGender = CMUtility.readChar();
        System.out.print("年龄：");
        int readAge = CMUtility.readInt();
        System.out.print("电话：");
        String readPhone = CMUtility.readString(15);
        System.out.print("邮箱：");
        String readMail = CMUtility.readString(25);
        System.out.println();
        boolean b = customerList.addCustomer(new Customer(readName, readGender, readAge, readPhone, readMail));
        if(b == false){
            System.out.println("---------------------添加失败 已达上限---------------------");
        }
        System.out.println("---------------------添加完成---------------------");

    }

    /**
     * 修改客户
     */
    private void modifyCustomer(){
        System.out.println("---------------------修改客户---------------------");
        while(true){
        System.out.print("请选择待修改客户编号(-1退出)：");
        int readNumber = CMUtility.readInt();
        if(readNumber == -1){
            return;
        }else{
            Customer cust = customerList.getCustomer(readNumber-1);
            System.out.println();
        System.out.print("姓名(" + cust.getName() + ")：");
        String readName = CMUtility.readString(5,cust.getName());
        System.out.print("姓别(" + cust.getGender() + ")：");
        char readGender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄(" + cust.getAge() + ")：");
        int readAge = CMUtility.readInt(cust.getAge());
        System.out.print("电话(" + cust.getPhone() + ")：");
        String readPhone = CMUtility.readString(15,cust.getPhone());
        System.out.print("邮箱(" + cust.getEmail() + ")：");
        String readMail = CMUtility.readString(25,cust.getEmail());
        System.out.println();
            Customer newCust = new Customer(readName,readGender,readAge,readPhone,readMail);
            boolean b = customerList.replaceCustomer(readNumber-1, newCust);
            if(b == false){
                System.out.println("---------------------修改失败 索引无效---------------------");
            }
        System.out.println("---------------------修改完成---------------------");
        }

        }


    }

    /**
     * 删除客户
     */
    private void deleteCustomer(){
        System.out.println("---------------------删除客户---------------------");
        while(true){
            System.out.print("请选择待删除客户编号(-1退出)：");
            int readNumber = CMUtility.readInt();
            if(readNumber == -1){
                return;
            }else{
                System.out.print("确认是否删除(Y/N):");
                char readConfirmSelection = CMUtility.readConfirmSelection();
                if(readConfirmSelection == 'Y'){
                boolean b1 = customerList.deleteCustomer(readNumber - 1);
                if(b1 == false){
                    System.out.println("---------------------删除失败 索引无效---------------------");
                }
                System.out.println("---------------------删除完成---------------------");
                }
            }

        }

    }

    /**
     * 客户列表
     */
    private void listAllCusromers(){
        Customer[] allCustomers = customerList.getAllCustomers();
        if(customerList.getTotal() == 0){
            System.out.println("数据是空的哦");
        }
        for(int i = 0;i < customerList.getTotal();i++){
            System.out.println("编号" + (i + 1) + ",\t姓名：" + allCustomers[i].getName() + ",\t姓别：" + allCustomers[i].getGender() + ",\t年龄：" + allCustomers[i].getAge() + ",\t电话：" + allCustomers[i].getPhone() + ",\t电子邮箱：" + allCustomers[i].getEmail());
        }
    }

    public static void main(String[] args) {
        CustomerView v1 = new CustomerView();
        v1.enterMainMemu();
    }





}
