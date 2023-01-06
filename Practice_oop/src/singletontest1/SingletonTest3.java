package singletontest1;

/**
 * @author shkstart
 * @create 2022-07-31 9:44
 */

/**
 * 单例设计模式--饿汉式
 */
class SingletonTest2 {
    //私有构造器
    private SingletonTest2() {
    }
    //私有静态对象
    private static SingletonTest2 singletonTest2 = new SingletonTest2();
    //公共静态方法
    public static SingletonTest2 getInstance(){
        return singletonTest2;
    }


}

/**
 * 单例设计模式--懒汉式 存在线程安全问题
 */
class SingletonTest3 {
    //私有构造器
    private SingletonTest3(){

    }
    //私有静态对象
    private static SingletonTest3 singletonTest3;
    //公共静态方法
    public static SingletonTest3 getInstance(){
        if(singletonTest3 == null){
            singletonTest3 = new SingletonTest3();
        }
        return singletonTest3;
    }
}

/**
 * 单例设计模式--懒汉式 解决线程安全问题
 */
class SingletonTest4{
    //私有构造器
    private SingletonTest4(){

    }
    //私有静态对象
    private static SingletonTest4 singletonTest4;
    //公共静态方法
    public static SingletonTest4 getInstance(){
        synchronized (SingletonTest4.class) {//使用同步代码块解决线程安全问题
            if(singletonTest4 == null){
                singletonTest4 = new SingletonTest4();
            }
            return singletonTest4;
        }
    }

}