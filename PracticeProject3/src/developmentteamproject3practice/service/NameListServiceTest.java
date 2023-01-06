package developmentteamproject3practice.service;

import developmentteamproject3practice.domain.Employee;
import org.junit.Test;

/**
 * @author shkstart
 * @create 2022-08-05 14:08
 */
public class NameListServiceTest {

    @Test
    public void getEmployees() {
        NameListService l1 = new NameListService();
        Employee[] l1Employees = l1.getEmployees();
        for(int i = 0;i < l1Employees.length;i++){
            System.out.println(l1Employees[i]);

        }
    }

    @Test
    public void getEmployee() {
        NameListService l1 = new NameListService();
        int id = 15;
        try {
            Employee l1Employee = l1.getEmployee(id);
            System.out.println(l1Employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}