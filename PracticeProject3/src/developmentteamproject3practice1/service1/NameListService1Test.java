package developmentteamproject3practice1.service1;

import developmentteamproject3practice1.domain1.Employee1;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2022-08-06 15:42
 */
public class NameListService1Test {

    @Test
    public void getAllEmployees1() {
        NameListService1 l1 = new NameListService1();
        Employee1[] l1AllEmployees1 = l1.getAllEmployees1();
        for(int i = 0;i < l1AllEmployees1.length;i++){
        System.out.println(l1AllEmployees1[i]);

        }
    }

    @Test
    public void getEmployee1() {
        NameListService1 l1 = new NameListService1();
        int id = 1;
        try {
            Employee1 l1Employee1 = l1.getEmployee1(id);
            System.out.println(l1Employee1);
        } catch (TeamException1 e) {
            System.out.println(e.getMessage());
        }
    }
}