package CustomerProject2Practice1.ui;

import CustomerProject2Practice1.CMU1.CMUtility1;
import CustomerProject2Practice1.bean.Customer1;
import CustomerProject2Practice1.servise.CustomerList1;

/**
 * @author shkstart
 * @create 2022-08-02 17:40
 */
//创建类 设计类的成员
public class CustomerView1 {
    //设计类的属性
    private CustomerList1 c1 = new CustomerList1(5);
    //设计类的constructor方法

    //设计类的方法

    /**
     * 显示主菜单 相应用户输入，根据用户操作分别调用其他相应的成员方法（如addNewCustomer），以完成客户信息处理
     */
    public void enterMainMenu1(){
        while(true){
            System.out.println("-----------------客户信息管理软件-----------------");
            System.out.println();
            System.out.println("                 1 添 加 客 户");
            System.out.println("                 2 修 改 客 户");
            System.out.println("                 3 删 除 客 户");
            System.out.println("                 4 客 户 列 表");
            System.out.println("                 5 退      出");
            System.out.println();
            System.out.print("请选择(1-5):");
            char readMenuSelection = CMUtility1.readMenuSelection();
            switch (readMenuSelection){
                case '1':
                    addNewCustomer1();
                    break;
                case '2':
                    modifyCustomer1();
                    break;
                case '3':
                    deleteCustomer1();
                    break;
                case '4':
                    listAllCustomers1();
                    break;
                case '5':
                    System.out.print("请确认是否要退出(Y/N):");
                    char readConfirmSelection = CMUtility1.readConfirmSelection();
                    if(readConfirmSelection == 'Y'){
                        return;
                    }
            }

        }

    }


    /**
     * 添加客户
     */
    public void addNewCustomer1(){
            System.out.println("---------------------添加客户---------------------");
            System.out.print("姓名:");
            String readName = CMUtility1.readString(5);
            System.out.print("姓别:");
            char readGender = CMUtility1.readChar();
            System.out.print("年龄:");
            int readAge = CMUtility1.readInt();
            System.out.print("电话:");
            String readPhone = CMUtility1.readString(15);
            System.out.print("邮箱:");
            String readEmail = CMUtility1.readString(25);
            Customer1 customer1 = new Customer1(readName,readGender,readAge,readPhone,readEmail);
            if(c1.addCustomer1(customer1)){
            System.out.println("---------------------添加完成---------------------");
            }else{
                System.out.println("---------------------添加失败 超出容量---------------------");
            }
    }

    /**
     * 修改客户
     */
    public void modifyCustomer1(){
        System.out.println("---------------------修改客户---------------------");
        System.out.print("请选择待修改客户编号(-1退出):");
        int readInt = CMUtility1.readInt();
        if(readInt == -1){
            return;
        }
        Customer1 customer1 = c1.getCustomer1(readInt - 1);
        System.out.print("姓名(" + customer1.getName() + "):");
        String readName = CMUtility1.readString(5, customer1.getName());
        System.out.print("姓别(" + customer1.getGender() + "):");
        char readGender = CMUtility1.readChar(customer1.getGender());
        System.out.print("年龄(" + customer1.getAge() + "):");
        int readAge = CMUtility1.readInt(customer1.getAge());
        System.out.print("电话(" + customer1.getPhone() + "):");
        String readPhone = CMUtility1.readString(15, customer1.getPhone());
        System.out.print("邮箱(" + customer1.getEmail() + "):");
        String readEmail = CMUtility1.readString(25, customer1.getEmail());
        Customer1 customer2 = new Customer1(readName,readGender,readAge,readPhone,readEmail);
        if(c1.replaceCustomer1(readInt - 1,customer2)){
            System.out.println("---------------------修改完成---------------------");
        }else{
            System.out.println("---------------------修改失败 索引无效---------------------");
        }

    }

    /**
     * 删除客户
     */
    public void deleteCustomer1(){
        System.out.println("---------------------删除客户---------------------");
        System.out.print("请选择待删除客户编号(-1退出):");
        int readInt = CMUtility1.readInt();
        if(readInt == -1){
            return;
        }
        System.out.print("确认是否删除(Y/N):");
        char confirmSelection = CMUtility1.readConfirmSelection();
        if(confirmSelection == 'N'){
            return;
        }
        if (c1.deleteCustomer1(readInt - 1)){
            System.out.println("---------------------删除完成---------------------");
        }else{
        System.out.println("---------------------删除失败 索引无效---------------------");

        }


    }

    /**
     * 客户列表
     */
    public void listAllCustomers1(){
        System.out.println("---------------------------客户列表---------------------------");
        if(c1.getTotal1() < 1){
            System.out.println("还没有数据哦!!");
        }else{
        System.out.println("编号" + "\t\t" + "姓名" + "\t\t" + "性别" + "\t\t" + "年龄" + "\t\t" + "电话" + "\t\t\t\t    " + "邮箱");
        for(int i = 0;i < c1.getTotal1();i++){
        System.out.println((i+1) + "\t\t" +  c1.getCustomer1(i).getName() + "\t\t" + c1.getCustomer1(i).getGender() + "\t\t" + c1.getCustomer1(i).getAge() + "\t\t" + c1.getCustomer1(i).getPhone() + "\t\t\t" + c1.getCustomer1(i).getEmail());
        }
        System.out.println("-------------------------客户列表完成-------------------------");
        }

    }


    public static void main(String[] args) {
        CustomerView1 view1 = new CustomerView1();
        view1.enterMainMenu1();


    }
}
