package developmentteamproject3practice4.service;

/**
 @author EddieZhang
 @create 2022-08-25 9:51
 */

import developmentteamproject3practice4.domain.*;

import static developmentteamproject3practice4.service.Data4.*;

/**
 * @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 * @Author EddieZhang
 * @Date 2022/8/25 9:52
 * @Since version-1.0
 */
public class NameListService4 {
    private Employee4[] employees4;//Employee4[]数组用来储存所有员工对象

    public NameListService4() {
        employees4 = new Employee4[12];//根据Data数据动态初始化员工数组-确定数组的大小--根据数据类型构建不同对象并赋值到数组中
        //根据员工的类型构建不同的对象赋值给数组
        for (int i = 0; i < EMPLOYEES.length; i++) {
            int typeEmployees4 = Integer.parseInt(EMPLOYEES[i][0]);//获取每个员工的员工类型并转换成int类型
            int idEmployees4 = Integer.parseInt(EMPLOYEES[i][1]);//公共部分--id
            String nameEmployees4 = EMPLOYEES[i][2];//公共部分--name
            int ageEmployees4 = Integer.parseInt(EMPLOYEES[i][3]);//公共部分--age
            double salaryEmployees4 = Double.parseDouble(EMPLOYEES[i][4]);//公共部分--salary

            Equipment4 equipment4;//设计一个获取员工关联设备的方法

            double bonusEmployees4;//获取bonus并转成double类型

            switch (typeEmployees4) {//根据员工的类型构建不同的对象赋值给数组
                case EMPLOYEE://10 Employee4
                    employees4[i] = new Employee4(idEmployees4, nameEmployees4, ageEmployees4, salaryEmployees4);
                    break;
                case PROGRAMMER://11 Programmer4
                    equipment4 = getEquipment4(i);
                    employees4[i] = new Programmer4(idEmployees4, nameEmployees4, ageEmployees4, salaryEmployees4, equipment4);
                    break;
                case DESIGNER://12 Designer4
                    equipment4 = getEquipment4(i);
                    bonusEmployees4 = Double.parseDouble(EMPLOYEES[i][5]);
                    employees4[i] = new Designer4(idEmployees4, nameEmployees4, ageEmployees4, salaryEmployees4, equipment4, bonusEmployees4);
                    break;
                case ARCHITECT:// Architect4
                    equipment4 = getEquipment4(i);
                    bonusEmployees4 = Double.parseDouble(EMPLOYEES[i][5]);
                    int stockEmployees4 = Integer.parseInt(EMPLOYEES[i][6]);
                    employees4[i] = new Architect4(idEmployees4, nameEmployees4, ageEmployees4, salaryEmployees4, equipment4, bonusEmployees4, stockEmployees4);
            }


        }

    }

    /**
     * @Description 获取员工关联设备的方法
     * @Author EddieZhang
     * @Date 2022/8/25 10:40
     * @Param []
     * @Return developmentteamproject3practice4.domain.Equipment4
     * @Since version-1.0
     */
    private Equipment4 getEquipment4(int eId) {
        int typeEquipment4 = Integer.parseInt(EQUIPMENTS[eId][0]);//根据员工的id获取相关联设备的类型并转换成int型
        String modelEquipment4 = EQUIPMENTS[eId][1];
        switch (typeEquipment4) {//根据不同的设备类型构建不同的对象
            case PC://21 PrivateComputer4
                String displayEquipment4 = EQUIPMENTS[eId][2];
                return new PrivateComputer4(modelEquipment4, displayEquipment4);
            case NOTEBOOK://22 NoteBook4
                double priceEquipment4 = Double.parseDouble(EQUIPMENTS[eId][2]);
                return new NoteBook4(modelEquipment4, priceEquipment4);
            case PRINTER://23 Printer4
                String nameEquipment4 = EQUIPMENTS[eId][1];
                String typePrinter = EQUIPMENTS[eId][2];
                return new Printer4(nameEquipment4, typePrinter);
        }
        return null;
    }

    /**
     * @Description 获取当前所有员工
     * @Author EddieZhang
     * @Date 2022/8/25 9:57
     * @Param []
     * @Return developmentteamproject3practice4.domain.Employee4[]包含所有员工对象的数组
     * @Since version-1.0
     */
    public Employee4[] getEmployees4() {
        Employee4[] employee4s = new Employee4[employees4.length];//new一个新的员工数组接收employees4数组中的所有员工对象
        for (int i = 0; i < employees4.length; i++) {//将employees4数组中的所有员工对象赋值给employee4s数组
            employee4s[i] = employees4[i];
        }
        return employee4s;//返回包含所有员工对象的数组
    }

    /**
     * @Description 获取指定id的员工对象--抛出异常（找不到指定员工）
     * @Author EddieZhang
     * @Date 2022/8/25 9:58
     * @Param [id]指定员工的id
     * @Return developmentteamproject3practice4.domain.Employee4返回指定员工的对象
     * @Since version-1.0
     */
    public Employee4 getEmployee4(int id) throws TeamException4 {//throws处理
        for (int i = 0; i < employees4.length; i++) {//遍历员工数组中的所有员工对象的id属性与形参id进行匹配
            if (id == employees4[i].getId4()) {//匹配成功则表明找到指定员工
                return employees4[i];//返回此员工对象
            }
        }
        throw new TeamException4("找不到指定员工");//匹配不到员工手动throw异常
    }

}
