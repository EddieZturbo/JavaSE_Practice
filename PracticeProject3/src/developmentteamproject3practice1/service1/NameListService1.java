package developmentteamproject3practice1.service1;

import developmentteamproject3practice1.domain1.*;

import static developmentteamproject3practice1.service1.Data1.*;

/**
 * @author shkstart
 * @create 2022-08-06 11:29
 */

/**
 * 所有员工类
 */
public class NameListService1 {
    private Employee1[] employee1s;//声明Employee1[]类的数组 负责将Data中数据保存进去

    public NameListService1() {//在构造器中初始化数组 根据不同类型构建不同对象以及关联的Equipment子类的对象
        employee1s = new Employee1[12];
        for(int i = 0;i < EMPLOYEES.length;i++){

            int numberIdEmployees = Integer.parseInt(EMPLOYEES[i][1]);//员工id
            String nameEmployees = EMPLOYEES[i][2];//员工姓名
            int ageEmployees = Integer.parseInt(EMPLOYEES[i][3]);//员工年龄
            double salaryEmployees = Double.parseDouble(EMPLOYEES[i][4]);//员工薪资

            double bonusEmployees;

            Equipment1 equipment1;

             int typeEmployees = Integer.parseInt(EMPLOYEES[i][0]);
        switch (typeEmployees){
            case EMPLOYEE://10 员工
                employee1s[i] = new Employee1(numberIdEmployees,nameEmployees,ageEmployees,salaryEmployees);
                break;
            case PROGRAMMER://11 程序员
                equipment1 = createEquipment(i);//设计获取Equipment1的方法
                employee1s[i] = new Programmer1(numberIdEmployees,nameEmployees,ageEmployees,salaryEmployees,equipment1);
                break;
            case DESIGNER://12 设计师
                equipment1 = createEquipment(i);
                bonusEmployees = Double.parseDouble(EMPLOYEES[i][5]);
                employee1s[i] = new Designer1(numberIdEmployees,nameEmployees,ageEmployees,salaryEmployees,equipment1,bonusEmployees);
                break;
            case ARCHITECT://13 架构师
                equipment1 = createEquipment(i);
                bonusEmployees = Double.parseDouble(EMPLOYEES[i][5]);
                int stockEmployees = Integer.parseInt(EMPLOYEES[i][6]);
                employee1s[i] = new Architect1(numberIdEmployees,nameEmployees,ageEmployees,salaryEmployees,equipment1,bonusEmployees,stockEmployees);

        }
        }
    }

    private Equipment1 createEquipment(int i) {
            int typeEQUIPMENTS = Integer.parseInt(EQUIPMENTS[i][0]);//遍历EQUIPMENTS每一行里的第0个位置的元素
            String equipmentModel = EQUIPMENTS[i][1];
            switch (typeEQUIPMENTS){
                case PC://21 电脑设备
                    String equipmentDisplay = EQUIPMENTS[i][2];
                    return new PrivateComputer1(equipmentModel,equipmentDisplay);
                case NOTEBOOK://22 笔记本设备
                    double priceEquipments = Double.parseDouble(EQUIPMENTS[i][2]);
                    return new NoteBook1(equipmentModel,priceEquipments);
                case PRINTER://23 打印机设备
                    String equipmentName = EQUIPMENTS[i][1];
                    String equipmentType = EQUIPMENTS[i][2];
                    return new Printer1(equipmentName,equipmentType);
            }

        return null;
    }


    public Employee1[] getAllEmployees1(){
        Employee1[] employee1s1 = new Employee1[EMPLOYEES.length];//new一个新的数组来接遍历的数组元素
        for(int i = 0;i < EMPLOYEES.length;i++){
            employee1s1[i] = employee1s[i];
        }
        return employee1s1;
    }

    public Employee1 getEmployee1(int id) throws TeamException1 {//throws处理
        for(int i = 0;i < EMPLOYEES.length;i++){
            if (id == employee1s[i].getId()){
                return employee1s[i];
            }
        }

        throw new TeamException1("找不到指定员工");//手动throw异常
    }


}
