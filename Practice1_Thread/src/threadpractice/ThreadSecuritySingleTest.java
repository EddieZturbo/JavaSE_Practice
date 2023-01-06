package threadpractice;

/**
 * @author EddieZhang
 * @create 2022-08-10 11:17
 */
//两种单例设计模式 饿汉式/懒汉式

/**
 * @Description 饿汉式单例设计模式
 * @Author EddieZhang
 * @Date 2022/8/10 11:21
 * @Since version-1.0
 */
class SingleDesignMode1 {
    //私有构造器
    private SingleDesignMode1() {
    }

    //私有静态对象--饿汉式直接new
    private static SingleDesignMode1 singleDesignMode1 = new SingleDesignMode1();

    //公共静态方法--返回对象
    public static SingleDesignMode1 getInstance() {
        return singleDesignMode1;
    }
}

/**
 * @Description 懒汉式单例设计模式--存在线程安全问题
 * @Author EddieZhang
 * @Date 2022/8/10 11:22
 * @Since version-1.0
 */
class SingleDesignMode2 {
    //私有构造器

    private SingleDesignMode2() {
    }

    //私有静态对象--懒汉式不new先
    private static SingleDesignMode2 singleDesignMode2;

    //公共静态方法
    public static SingleDesignMode2 getInstance() {//存在线程安全问题
        if (singleDesignMode2 == null) {
            singleDesignMode2 = new SingleDesignMode2();
        }
        return singleDesignMode2;
    }

}

/**
 * @Description 线程安全的懒汉式单例设计模式
 * @Author EddieZhang
 * @Date 2022/8/10 11:30
 * @Since version-1.0
 */
class SecuritySingleDesignMode {
    //私有构造器
    private SecuritySingleDesignMode() {
    }

    //私有静态对象--懒汉式不new先
    private static SecuritySingleDesignMode securitySingleDesignMode;

    //公共静态方法
    public static SecuritySingleDesignMode getInstance() {
        if (securitySingleDesignMode == null) {//相当于在口处立个标识提高效率
            synchronized (SecuritySingleDesignMode.class) {
                if (securitySingleDesignMode == null) {
                    securitySingleDesignMode = new SecuritySingleDesignMode();
                }
            }
        }
        return securitySingleDesignMode;
    }
}
class SecuritySingleDesignMode1 {
    //私有构造器
    private SecuritySingleDesignMode1() {
    }

    //私有静态对象--懒汉式不new先
    private static SecuritySingleDesignMode1 securitySingleDesignMode1;

    //公共静态方法
    public static synchronized SecuritySingleDesignMode1 getInstance() {
        //此处的synchronized锁为：SecuritySingleDesignMode1.class
        if(securitySingleDesignMode1 == null){
            securitySingleDesignMode1 = new SecuritySingleDesignMode1();
        }
        return securitySingleDesignMode1;
    }
}


/**
 * 写一个线程安全的懒汉式单例设计模式
 * 单例设计模式有 饿汉式/懒汉式 两种 其中懒汉式设计模式存在线程安全问题
 * 运用解决线程安全问题的方法写一个安全的懒汉式单例设计模式
 */


public class ThreadSecuritySingleTest {
}
