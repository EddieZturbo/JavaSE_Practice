package reflectiontestclassstructure;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 @author EddieZhang
 @create 2022-08-20 9:31
 */
public class ReflectionTestStructure {
    /**
     * 通过反射获取运行时类的完整结构--属性
     */
    @Test
    public void test() throws NoSuchFieldException{
        //通过.class获得运行时类的Class
        Class<Person1> person1Class = Person1.class;
        //getFields()获取当前运行时类及其父类的相关public属性
        Field[] fields = person1Class.getFields();
        for (Field fieldData :
                fields) {
            System.out.println(fieldData);
            //public boolean reflectiontestclassstructure.Person1.isMale
            //public int reflectiontestclassstructure.Creature.age
        }
        //Field[] getDeclaredField()获取当前运行时类的全部属性不包含其父类的属性
        Field[] declaredFields = person1Class.getDeclaredFields();
        for (Field declaredFieldData:declaredFields
             ) {
            System.out.println(declaredFieldData);
            //private int reflectiontestclassstructure.Person1.personAge
            //protected double reflectiontestclassstructure.Person1.weight
            //public boolean reflectiontestclassstructure.Person1.isMale
        }
        //Field Field()方法可以指明获取运行时类及其父类中的任意一个属性
                //需要.setAccessible(true)
        //Field Field()方法的方法中:
//           public int getModifiers() 以整数形式返回此Field的修饰符
//           public Class<?> getType() 得到Field的属性类型
//           public String getName() 返回Field的名称。
        //属性的--权限修饰符 属性类型 属性名
        Field personAge = person1Class.getDeclaredField("personAge");
        personAge.setAccessible(true);
        Field species = person1Class.getDeclaredField("weight");
        species.setAccessible(true);
        int personAgeModifiers = personAge.getModifiers();
        Class<?> personAgeType = personAge.getType();
        String personAgeName = personAge.getName();
        System.out.println("权限修饰符:" + personAgeModifiers + "\t属性类型:" + personAgeType + "\t属性名:" + personAgeName);
        //权限修饰符:2	属性类型:int	属性名:personAge
        int speciesModifiers = species.getModifiers();
        Class<?> speciesType = species.getType();
        String speciesName = species.getName();
        System.out.println("权限修饰符:" + speciesModifiers + "\t属性类型:" + speciesType + "\t属性名:" + speciesName);
        //权限修饰符:4	属性类型:double	属性名:weight
        //DEFAULT          = 0x00000000
        //PUBLIC           = 0x00000001
        //PRIVATE          = 0x00000002
        //PROTECTED        = 0x00000004
        //STATIC           = 0x00000008
        //FINAL            = 0x00000010
        //SYNCHRONIZED     = 0x00000020
        //NATIVE           = 0x00000100
        //INTERFACE        = 0x00000200
        //ABSTRACT         = 0x00000400


    }
    /**
     * 通过反射获取运行时类的完整结构--方法
     */
    @Test
    public void test1() throws NoSuchMethodException {
        Class<Person1> person1Class = Person1.class;
        //getMethods()获取当前运行时类及其父类的相关public方法
        Method[] person1ClassMethods = person1Class.getMethods();
        for (Method methodsData :
                person1ClassMethods) {
            System.out.println(methodsData);
            //public boolean reflectiontestclassstructure.Person1.equals(java.lang.Object)
            //public java.lang.String reflectiontestclassstructure.Person1.toString()
            //public int reflectiontestclassstructure.Person1.hashCode()
            //public boolean reflectiontestclassstructure.Person1.isMale()
            //public java.lang.String reflectiontestclassstructure.Person1.getInformation()
            //public void reflectiontestclassstructure.Person1.setPersonAge(int)
            //public int reflectiontestclassstructure.Person1.getPersonAge()
            //public void reflectiontestclassstructure.Person1.eat()
            //public void reflectiontestclassstructure.Person1.setMale(boolean)
            //public double reflectiontestclassstructure.Person1.getWeight()
            //public void reflectiontestclassstructure.Person1.setWeight(double)
            //public java.lang.String reflectiontestclassstructure.Creature.getName()
            //public void reflectiontestclassstructure.Creature.setName(java.lang.String)
            //public java.lang.String reflectiontestclassstructure.Creature.getSpecies()
            //public void reflectiontestclassstructure.Creature.setAge(int)
            //public void reflectiontestclassstructure.Creature.setSpecies(java.lang.String)
            //public int reflectiontestclassstructure.Creature.getAge()
            //public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
            //public final void java.lang.Object.wait() throws java.lang.InterruptedException
            //public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
            //public final native java.lang.Class java.lang.Object.getClass()
            //public final native void java.lang.Object.notify()
            //public final native void java.lang.Object.notifyAll()
        }
        System.out.println("-------------------------------------------------------------------------");

        //Method[] getDeclaredMethods()方法能够获得当前运行时类的所有方法 不包含其父类的方法
        Method[] declaredMethods = person1Class.getDeclaredMethods();
        for (Method declaredMethodsData :
                declaredMethods) {
            System.out.println(declaredMethodsData);
            //public boolean reflectiontestclassstructure.Person1.equals(java.lang.Object)
            //public java.lang.String reflectiontestclassstructure.Person1.toString()
            //public int reflectiontestclassstructure.Person1.hashCode()
            //public java.lang.String reflectiontestclassstructure.Person1.getInformation()
            //public boolean reflectiontestclassstructure.Person1.isMale()
            //public void reflectiontestclassstructure.Person1.setWeight(double)
            //public void reflectiontestclassstructure.Person1.setMale(boolean)
            //private void reflectiontestclassstructure.Person1.details()
            //public void reflectiontestclassstructure.Person1.eat()
            //public int reflectiontestclassstructure.Person1.getPersonAge()
            //public void reflectiontestclassstructure.Person1.setPersonAge(int)
            //public double reflectiontestclassstructure.Person1.getWeight()
        }
        System.out.println("-------------------------------------------------------------------------");
        //Method getDeclaredMethod()方法可以指明获取运行时类及其父类中的任意一个属性
                //需要setAccessible(true)
        //Method getDeclaredMethod()方法中:
                // public Class<?> getReturnType()取得全部的返回值
                // public Class<?>[] getParameterTypes()取得全部的参数
                // public int getModifiers()取得修饰符
                // public Class<?>[] getExceptionTypes()取得异常信息
        //通过调用相关方法获取指定方法的 权限修饰符 返回值类型 方法名(形参列表) 注解(声明周期要为RUNTIME) 异常
        Method getInformation = person1Class.getDeclaredMethod("personGetInformation",String.class);
        getInformation.setAccessible(true);
        int modifiers = getInformation.getModifiers();
        Class<?> returnType = getInformation.getReturnType();
        String methodName = getInformation.getName();
        Class<?>[] parameterTypes = getInformation.getParameterTypes();
        Annotation[] annotations = getInformation.getAnnotations();
        System.out.println("权限修饰符:" + modifiers + "\t返回值类型:" + returnType + "\t方法名:" + methodName + "\t形参列表:" + parameterTypes[0] + "\t注解:" + annotations[0]);
        //权限修饰符:1	返回值类型:class java.lang.String	方法名:personGetInformation	形参列表:class java.lang.String	注解:@reflectiontestclassstructure.TestAnnotation({"It is information of person!!"})

        for (Annotation annotation :
                annotations) {
            System.out.println(annotation);
            //@reflectiontestclassstructure.TestAnnotation({"It is information of person!!"})
        }
    }
    /**
     * 通过反射获取运行时类的完整结构--构造器
     */
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person1> person1Class = Person1.class;
        //getConstructors()获取当前运行时类及其父类的相关public构造器
        Constructor<?>[] person1ClassConstructors = person1Class.getConstructors();
        for (Constructor constructorsData :
                person1ClassConstructors) {
            System.out.println(constructorsData);
            //public reflectiontestclassstructure.Person1(int,int,double,boolean)
            //public reflectiontestclassstructure.Person1(int,double,boolean)
            //public reflectiontestclassstructure.Person1(java.lang.String,int,java.lang.String)
            //public reflectiontestclassstructure.Person1()
        }
        System.out.println("-------------------------------------------------------------------------");
        //Constructor[] getDeclaredConstructors()方法能够获得当前运行时类的所有构造器 不包含其父类的构造器
        Constructor<?>[] declaredConstructors = person1Class.getDeclaredConstructors();
        for (Constructor constructorData :
                declaredConstructors) {
            System.out.println(constructorData);
            //private reflectiontestclassstructure.Person1(java.lang.String,int,java.lang.String,int,double,boolean)
            //public reflectiontestclassstructure.Person1(int,int,double,boolean)
            //public reflectiontestclassstructure.Person1(int,double,boolean)
            //public reflectiontestclassstructure.Person1(java.lang.String,int,java.lang.String)
            //public reflectiontestclassstructure.Person1()
        }
        System.out.println("-------------------------------------------------------------------------");
        //Constructor getDeclaredConstructor()方法可以指明获取运行时类及其父类中的任意一个构造器
        Constructor<Person1> declaredConstructor = person1Class.getDeclaredConstructor(String.class, int.class, String.class, int.class, double.class, boolean.class);
        //要求setAccessible(true)
        declaredConstructor.setAccessible(true);
        int modifiers = declaredConstructor.getModifiers();
        String name = declaredConstructor.getName();
        Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
        Annotation[] annotations = declaredConstructor.getAnnotations();
        System.out.println(modifiers + " \t" +  name + " \t"  + parameterTypes[0] + " \t"  + annotations[0]);
        //2 	reflectiontestclassstructure.Person1 	class java.lang.String 	@reflectiontestclassstructure.TestAnnotation({"It is a constructor!!"})
        //形参列表
        for (Class parameterData :
                parameterTypes) {
            System.out.println(parameterData);
            //class java.lang.String
            //int
            //class java.lang.String
            //int
            //double
            //boolean
        }
        //通过构造器调用newInstance()创造运行时类的对象
        Person1 person1 = declaredConstructor.newInstance("人类", 5000, "EddieZhang", 21, 68.8, true);
        System.out.println(person1);
        //Creature{species='人类', age=5000, name='EddieZhang'}Person1{personAge=21, weight=68.8, isMale=true}

    }
}
