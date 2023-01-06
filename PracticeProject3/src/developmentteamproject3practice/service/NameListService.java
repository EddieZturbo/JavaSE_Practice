package developmentteamproject3practice.service;

import developmentteamproject3practice.domain.*;

import static developmentteamproject3practice.service.Data.*;

/**
 * @author shkstart
 * @create 2022-08-04 21:18
 */

/**
 * 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 */
public class NameListService {
    /**
     * employees数组用来保存公司所有员工对象
     */
    private Employee[] employees;//声明Employee[] employees数组

    /**
     * 构造器用来初始化数组
     */
    public NameListService() {
        employees = new Employee[EMPLOYEES.length];//动态初始化数组 确定数组的长度
        for (int i = 0;i < EMPLOYEES.length;i++){
            int type = Integer.parseInt(EMPLOYEES[i][0]);//获取员工类型 按照类型进行赋值

            int id = Integer.parseInt(EMPLOYEES[i][1]);//获取共同需要的基本信息

            String name = EMPLOYEES[i][2];//获取共同需要的基本信息

            int age = Integer.parseInt(EMPLOYEES[i][3]);//获取共同需要的基本信息

            double salary = Double.parseDouble(EMPLOYEES[i][4]);//获取共同需要的基本信息

            Equipment equipment;//声明一个获得EQUIPMENTS数组中设备元素的方法;程序员 设计师 架构师

            double bonus;//声明设计师和架构师的bonus
            switch (type){
                case EMPLOYEE://10 普通员工
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER://11 程序员
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER://12 设计师
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT://13 架构师
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(EMPLOYEES[i][6]);//获取架构师需要的stock
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }
    private Equipment createEquipment(int i) {//根据员工类型 获得EQUIPMENTS数组中设备元素的方法
        int index = Integer.parseInt(EQUIPMENTS[i][0]);
        String model = EQUIPMENTS[i][1];
        switch (index){
            case PC://21
                String display = EQUIPMENTS[i][2];
                return new PrivateComputer(model,display);
            case NOTEBOOK://22
                double prise = Double.parseDouble(EQUIPMENTS[i][2]);
                return new NoteBook(model,prise);
            case PRINTER://23
                String name = EQUIPMENTS[i][1];
                String type = EQUIPMENTS[i][2];
                return new Printer(name,type);
        }
        return null;
    }
    /**
     * 获取当前所有员工
     * @return 返回所有员工对象的数组
     */
    public Employee[] getEmployees(){
        return employees;
    }
    public Employee getEmployee(int id) throws TeamException {//throws处理
        for(int i = 0;i < employees.length;i++){
            if(employees[i].getId() == id){
                return employees[i];
            }
        }
        throw new TeamException("找不到指定的员工");//手动throw自定义异常类
    }
}
