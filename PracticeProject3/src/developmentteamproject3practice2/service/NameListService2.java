package developmentteamproject3practice2.service;

import developmentteamproject3practice2.domain.*;

import static developmentteamproject3practice2.service.Data2.*;

/**
 * @author shkstart
 * @create 2022-08-08 10:56
 */

/**
 * @Description 负责将Data中的数据封装到 Employee2[] 数组中，同时提供相关操作 Employee2[] 的方法
 * @Author EddieZhang
 * @Date 2022/8/8 10:57
 * @Since version-1.0
 */
public class NameListService2 {
    private Employee2[] employees2;//用来保存公司所有员工对象的数组

    /**
     * 根据项目提供的Data类构建相应大小的employees数组
     * 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
     * 将对象存于数组中
     */
    public NameListService2() {//用来初始化Employee2[]
        employees2 = new Employee2[12];//根据Data中的数据构建相应大小的数组 动态初始化数组 确定数组的长度

        for (int i = 0; i < employees2.length; i++) {
            int typeEmployee2 = Integer.parseInt(EMPLOYEES[i][0]);//获取EMPLOYEES数组中每个员工的type类型并转换成int型


            int idEmployee2 = Integer.parseInt(EMPLOYEES[i][1]);//获取EMPLOYEES数组中每个员工的id并转换成int型
            String nameEmployee2 = EMPLOYEES[i][2];//获取EMPLOYEES数组中每个员工的name
            int ageEmployee2 = Integer.parseInt(EMPLOYEES[i][3]);//获取EMPLOYEES数组中每个员工的age并转换成int型
            double salaryEmployee2 = Double.parseDouble(EMPLOYEES[i][4]);//获取EMPLOYEES数组中每个员工的salary并转换成double型

            Equipment2 equipment2;//Equipment2调用方法获取指定员工关联的设备

            double bonusEmployee2;//获取EMPLOYEES数组中每个员工的bonus并转换成double型


            switch (typeEmployee2) {
                case EMPLOYEE://10 员工
                    employees2[i] = new Employee2(idEmployee2, nameEmployee2, ageEmployee2, salaryEmployee2);
                    break;
                case PROGRAMMER://11 程序员
                    equipment2 = getEquipment2(i);//调用getEquipment2方法获取指定员工关联的设备
                    employees2[i] = new Programmer2(idEmployee2, nameEmployee2, ageEmployee2, salaryEmployee2, equipment2);
                    break;
                case DESIGNER://12 设计师
                    equipment2 = getEquipment2(i);
                    bonusEmployee2 = Double.parseDouble(EMPLOYEES[i][5]);
                    employees2[i] = new Designer2(idEmployee2, nameEmployee2, ageEmployee2, salaryEmployee2, equipment2, bonusEmployee2);
                    break;
                case ARCHITECT://13 架构师
                    equipment2 = getEquipment2(i);
                    int stockEmployee2 = Integer.parseInt(EMPLOYEES[i][6]);
                    bonusEmployee2 = Double.parseDouble(EMPLOYEES[i][5]);
                    employees2[i] = new Architect2(idEmployee2, nameEmployee2, ageEmployee2, salaryEmployee2, equipment2, bonusEmployee2, stockEmployee2);
            }

        }


    }

    private Equipment2 getEquipment2(int key) {//获取指定员工关联的设备
        int typeEquipment2 = Integer.parseInt(EQUIPMENTS[key][0]);///获取EQUIPMENTS数组中每个设备的type类型并转换成int型
        String modelEquipment2 = EQUIPMENTS[key][1];
        switch (typeEquipment2) {
            case PC://21
                String displayEquipment2 = EQUIPMENTS[key][2];
                return new PrivateComputer2(modelEquipment2, displayEquipment2);
            case NOTEBOOK://22
                double priceEquipment2 = Double.parseDouble(EQUIPMENTS[key][2]);
                return new NoteBook2(modelEquipment2, priceEquipment2);
            case PRINTER://23
                String nameEquipment2 = EQUIPMENTS[key][1];
                String typePrinter2 = EQUIPMENTS[key][2];
                return new Printer2(nameEquipment2, typePrinter2);
        }


        return null;
    }


    /**
     * @Description 获取当前所有员工
     * @Author EddieZhang
     * @Date 2022/8/8 11:01
     * @Param []
     * @Return developmentteamproject3practice2.domain.Employee2[] 包含所有员工对象的数组
     * @Since version-1.0
     */
    public Employee2[] getAllEmployees2() {
        Employee2[] employee2s = new Employee2[employees2.length];//new一个新的Employee2[]数组承接存放了员工对象的employees2数组
        for (int i = 0; i < employees2.length; i++) {
            employee2s[i] = employees2[i];
        }
        return employee2s;
    }

    /**
     * @Description 获取指定ID的员工对象
     * @Author EddieZhang
     * @Date 2022/8/8 11:02
     * @Param [id]指定员工的ID
     * @Return developmentteamproject3practice2.domain.Employee2 指定员工的对象
     * @Since version-1.0
     */
    public Employee2 getEmployee2(int id) throws TeamException2 {//throws处理
        for (int i = 0; i < employees2.length; i++) {
            if (employees2[i].getId2() == id) {
                return employees2[i];
            }
        }
        throw new TeamException2("找不到指定的员工");//手动throw一个异常
    }
}
