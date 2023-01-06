package staticproxytest;


/**
 * 代理设计模式的原理:
 * 使用一个代理将对象包装起来, 然后用该代理对象取代原始对象。任何对原
 * 始对象的调用都要通过代理。代理对象决定是否以及何时将方法调用转到原
 * 始对象上。
 *  静态代理，特征是代理类和目标
 * 对象的类都是在编译期间确定下来，不利于程序的扩展。同时，每一个代
 * 理类只能为一个接口服务，这样一来程序开发中必然产生过多的代理。最
 * 好可以通过一个代理类完成全部的代理功能
 * 动态代理是指客户通过代理类来调用其它对象的方法，并且是在程序运行时
 * 根据需要动态创建目标类的代理对象。
 * 动态代理使用场合:
 * 调试
 * 远程方法调用
 * 动态代理相比于静态代理的优点：
 * 抽象角色中（接口）声明的所有方法都被转移到调用处理器一个集中的方法中
 * 处理，这样，我们可以更加灵活和统一的处理众多的方法
 */

/**
 * * StaticProxy:
 *      静态代理
 *       静态代理，特征是代理类和目标
 *  * 对象的类都是在编译期间确定下来，不利于程序的扩展。同时，每一个代
 *  * 理类只能为一个接口服务，这样一来程序开发中必然产生过多的代理。最
 *  * 好可以通过一个代理类完成全部的代理功能
 @author EddieZhang
 @create 2022-08-20 23:07
 */
//接口
interface ClothFactory{
    void produceCloth();

}
//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory clothFactory;

    public ProxyClothFactory() {
    }

    public ProxyClothFactory(ClothFactory clothFactory) {//可以传入被代理类
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂开始准备工作！");
        clothFactory.produceCloth();
        System.out.println("代理工厂做好首尾工作！");

    }
}
//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("被代理的Nike工厂生成一批Fear Of God x Air Jordan");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        //创建代理类的对象--将被代理类的对象传入构造器中
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);
        //此时的工厂是通过代理类的方法进行生产的 其中代理类的方法中存在被代理类的生产方法（此方法是通过代理类的构造器传入的给到接口类--此时的接口类的实现类是被代理类）
        proxyClothFactory.produceCloth();
        //代理工厂开始准备工作！//代理类的操作
        //被代理的Nike工厂生成一批Air max 97//被代理类的操作
        //代理工厂做好首尾工作！//代理类的操作
    }

}
