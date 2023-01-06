package com.eddie.mhl.service;

import com.eddie.mhl.dao.EmployeesDAO;
import com.eddie.mhl.domain.Employees;

import java.util.List;

/**完成对Employees表的各种操作 使用过调用EmployeesDAO对象来完成
 @author EddieZhang
 @create 2022-09-13 15:50
 */
public class EmployeesService {
    //定义一个EmployeesDAO属性
    private EmployeesDAO employeesDAO = new EmployeesDAO();

    //校验的方法根据传进来的account和password 与数据库中的数据进行验证--数据库中查询不到就返回null
    public Employees getEmployeesPasswordAndAccount(String account,String password){
        Employees employees = employeesDAO.querySingleRow("select * from employees where account = ? and password = md5(?)", Employees.class, account, password);
        return employees;
    }
    public List<Employees> getEmployeesInfo(){
        List<Employees> employeesList = employeesDAO.queryMultiply("select ? from employees", Employees.class, "*");
        return employeesList;
    }

    public static void main(String[] args) {
    }



}
