package developmentteamproject3practice2.service;

import developmentteamproject3practice2.domain.Employee2;
import org.junit.Test;

/**
 * @author shkstart
 * @create 2022-08-08 12:37
 */
public class NameListService2Test {
    NameListService2 service2 = new NameListService2();

    @Test
    public void getAllEmployees2() {
        Employee2[] employee2s = service2.getAllEmployees2();
        for(int i = 0;i < employee2s.length;i++){
            System.out.println(employee2s[i]);


        }

    }

    @Test
    public void getEmployee2() {

        int index = 15;
        try {
            Employee2 employee2 = service2.getEmployee2(index);
            System.out.println(employee2);
        } catch (TeamException2 e) {
            System.out.println(e.getMessage());
        }
    }
}