package developmentteamproject3practice4.service;

import developmentteamproject3practice4.domain.Employee4;
import org.junit.Test;

/**
 @author EddieZhang
 @create 2022-08-25 11:31
 */
public class NameListService4Test {

    @Test
    public void getEmployees4() {
        NameListService4 nameListService4 = new NameListService4();
        Employee4[] nameListService4Employees4 = nameListService4.getEmployees4();
        for (Employee4 e4 :
                nameListService4Employees4) {
            System.out.println(e4.toString());
        }
    }

    @Test
    public void getEmployee4() {
        NameListService4 nameListService4 = new NameListService4();
        int id = 122;
        try {
            Employee4 employee4 = nameListService4.getEmployee4(id);
            System.out.println(employee4);
        } catch (TeamException4 e) {
            System.out.println(e.getMessage());
        }
    }
}