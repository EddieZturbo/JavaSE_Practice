package developmentteamproject3practice3.service;

/**
 * @author EddieZhang
 * @create 2022-08-11 11:47
 */

import developmentteamproject3practice3.domain.*;

import static developmentteamproject3practice3.service.Data3.*;

/**
 * @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 * @Author EddieZhang
 * @Date 2022/8/11 11:47
 * @Since version-1.0
 */
public class NameListService3 {
    private Employee3[] employees3;//声明一个Employee3[]数组 用来保存公司所有员工对象

    //使用构造器对Employee3[]数组进行初始化
    public NameListService3() {
        employees3 = new Employee3[12];//根据项目提供的Data类构建相应大小的employees数组
        //给数组经行赋值
        //根据Data类中的数据构建不同的对象，
        // 包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象

        for (int i = 0; i < employees3.length; i++) {
            int typeEmployee3 = Integer.parseInt(EMPLOYEES[i][0]);//获取Data3中每个员工的类型并转换成int型
            //获取Data3中四个共同需要的属性
            int idEmployee3 = Integer.parseInt(EMPLOYEES[i][1]);
            String nameEmployee3 = EMPLOYEES[i][2];
            int ageEmployee3 = Integer.parseInt(EMPLOYEES[i][3]);
            double salaryEmployee3 = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment3 equipment3 = null;
            double bonusEmployee3 = 0;
            switch (typeEmployee3) {
                case EMPLOYEE://10
                    employees3[i] = new Employee3(idEmployee3,nameEmployee3,ageEmployee3,salaryEmployee3);
                    break;
                case PROGRAMMER://11
                    equipment3 = getEquipment3(i);
                    employees3[i] = new Programmer3(idEmployee3,nameEmployee3,ageEmployee3,salaryEmployee3,equipment3);
                    break;
                case DESIGNER://12
                    equipment3 = getEquipment3(i);
                    bonusEmployee3 =Double.parseDouble(EMPLOYEES[i][5]) ;
                    employees3[i] = new Designer3(idEmployee3,nameEmployee3,ageEmployee3,salaryEmployee3,equipment3,bonusEmployee3);
                    break;
                case ARCHITECT://13
                    equipment3 = getEquipment3(i);
                    bonusEmployee3 =Double.parseDouble(EMPLOYEES[i][5]) ;
                     int stockEmployee3 =Integer.parseInt(EMPLOYEES[i][6]) ;
                    employees3[i] = new Architect3(idEmployee3,nameEmployee3,ageEmployee3,salaryEmployee3,equipment3,bonusEmployee3,stockEmployee3);
            }


        }
    }

    private Equipment3 getEquipment3(int key) {
            int typeEquipment3 =Integer.parseInt(EQUIPMENTS[key][0]) ;//获取Data3中每个员工对应的设备的类型并转换成int型
            String modelEquipment3 = EQUIPMENTS[key][1];//model
            switch (typeEquipment3){
                case PC://21
                    String displayEquipment3 = EQUIPMENTS[key][2];//display
                    return new PrivateComputer3(modelEquipment3,displayEquipment3);
                case NOTEBOOK://22
                    double priceEquipment3 =Double.parseDouble(EQUIPMENTS[key][2]);//price
                    return new NoteBook3(modelEquipment3,priceEquipment3);
                case PRINTER://23
                    String nameEquipment3 = EQUIPMENTS[key][1];
                    String typePrintEquipment3 = EQUIPMENTS[key][2];
                    return new Printer3(nameEquipment3,typePrintEquipment3);
            }
        return null;
    }

    /**
     * @Description 获取当前所有员工
     * @Author EddieZhang
     * @Date 2022/8/11 11:55
     * @Param []
     * @Return developmentteamproject3practice3.domain.Employee3[]包含所有员工对象的数组
     * @Since version-1.0
     */
    public Employee3[] getAllEmployees3() {
        Employee3[] employee3s = new Employee3[employees3.length];//new一个Employee3[] 数组 用来接收employees3中的元素
        for(int i = 0;i < employees3.length;i++){
            employee3s[i] = employees3[i];
        }
        return employee3s;
    }

    /**
     * @Description 获取指定ID的员工对象 异常：找不到指定的员工
     * @Author EddieZhang
     * @Date 2022/8/11 11:55
     * @Param [id]指定员工的ID
     * @Return developmentteamproject3practice3.domain.Employee3指定员工对象
     * @Since version-1.0
     */
    public Employee3 getEmployee3(int id) throws TeamException3 {//throws处理
        for(int i = 0;i < employees3.length;i++){
            if(id == employees3[i].getId3()){//遍历employees3数组中的元素 判断id是否与索引值相等
                return employees3[i];
            }
        }
       throw new TeamException3("找不到指定的员工");//手动throw异常
    }
}
