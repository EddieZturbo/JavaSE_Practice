package reflectiontest;

/**
 @author EddieZhang
 @create 2022-08-19 21:17
 */

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * 体会反射的"动态性"★
 */
public class ReflectionTest$ {
    @Test
    public void test() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (int i = 0; i <= 100; i++) {
            int nextInt = new Random().nextInt(3);//产生随机数 0,1,2
            String str1 = "";
            switch (nextInt) {
                case 0:
                    str1 = "reflectiontest.Person";
                    break;
                case 1:
                    str1 = "java.util.Date";
                    break;
                case 2:
                    str1 = "java.lang.Object";
                    break;
            }
            Object instance = getInstance(str1);
            System.out.println(instance);
        }
    }

    /**
     * 创建指定类的对象
     * @param classPath 指定类的全类名classPath
     * @return 运行时类的Instance
     */
    public Object getInstance(String classPath) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Class的实例
        Class<?> forName = Class.forName(classPath);//调用Class的静态方法:forName(String classPath)★
        //获取运行时类的Instance
        Object newInstance = forName.getDeclaredConstructor().newInstance();
        return newInstance;
    }
}
