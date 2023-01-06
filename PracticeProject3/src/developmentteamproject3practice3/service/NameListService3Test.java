package developmentteamproject3practice3.service;

import developmentteamproject3practice3.domain.Employee3;
import org.junit.Test;

/**
 * @author EddieZhang
 * @create 2022-08-11 14:02
 */
public class NameListService3Test {
        NameListService3 nameListService3 = new NameListService3();

    @Test
    public void getAllEmployees3() {
//        for(int i = 0;i < nameListService3.getAllEmployees3().length;i++){
//        System.out.println(nameListService3.getAllEmployees3()[i]);
//        }
        Employee3[] nameListService3AllEmployees3 = nameListService3.getAllEmployees3();
        for (Employee3 employee33 :
                nameListService3AllEmployees3) {
            System.out.println(employee33);
        }
    }

    @Test
    public void getEmployee3() {
        int index = 1;
        try {
            Employee3 service3Employee3 = nameListService3.getEmployee3(index);
            System.out.println(service3Employee3);
        } catch (TeamException3 e) {
            System.out.println(e.getMessage());
        }
    }

}