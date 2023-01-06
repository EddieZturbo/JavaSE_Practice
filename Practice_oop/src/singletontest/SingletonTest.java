package singletontest;

/**
 * @author shkstart
 * @create 2022-07-31 9:44
 */

/**
 * 单例设计模式--饿汉式
 */
class SingletonTest {
    //设计类的属性


    //设计类的constructor方法
    //私有构造器
    private SingletonTest() {
    }

    //私有静态对象
    private static SingletonTest single1 = new SingletonTest();

    //设计类的方法
    //公共静态方法返回对象
    public static SingletonTest getInstance() {
        return single1;
    }

}

/**
 * 单例设计模式--懒汉式
 */
class SingletonTest1 {
    //设计类的属性


    //设计类的constructor方法
    //私有构造器
    private SingletonTest1() {
    }

    //私有静态对象
    private static SingletonTest1 single2;

    //设计类的方法
    //公共静态方法
    public static SingletonTest1 getInstance() {
        if (single2 == null) {
            single2 = new SingletonTest1();
        }
        return single2;
    }

}

/**
 * 单例设计模式 饿汉式 不存在线程安全问题
 */
class SingleTonTest2{
    //私有构造器
    private SingleTonTest2(){

    }
    //私有静态对象 直接就new
    private static SingleTonTest2 singletonTest2 = new SingleTonTest2();

    //公共静态方法
    public static SingleTonTest2 getInstance(){
        return singletonTest2;
    }

}

/**
 * 单例设计模式 懒汉式 存在线程安全问题
 */
class SingleTonTest3{
    //私有构造器
    private SingleTonTest3(){

    }
    //私有静态对象
    private static SingleTonTest3 singleTonTest3;//先不创建对象
    //公共静态方法
    private static SingleTonTest3 getInstance(){
        if (singleTonTest3 == null){
            singleTonTest3 = new SingleTonTest3();
        }
        return singleTonTest3;
    }

}
/**
 * 单例设计模式 懒汉式 存在线程安全问题 通过synchronize同步代码块|同步方法 解决线程安全问题
 */
class SingleTonTest4{
    //私有构造器
    private SingleTonTest4(){

    }
    //私有静态对象
    private static SingleTonTest4 singleTonTest4;//先不创建对象
    //公共静态方法
    private static SingleTonTest4 getInstance(){
        synchronized (SingleTonTest4.class) {
            if (singleTonTest4 == null){
                singleTonTest4 = new SingleTonTest4();
            }
            return singleTonTest4;
        }
    }

}