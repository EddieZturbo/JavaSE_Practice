package dynamicproxytest;

/*** 代理设计模式的原理:
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
 @author EddieZhang
 @create 2022-08-21 10:14
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 动态代理与AOP（Aspect Orient Programming)
 *  使用Proxy生成一个动态代理时，往往并不会凭空产生一个动态代理，这样没有
 * 太大的意义。通常都是为指定的目标对象生成动态代理
 *  这种动态代理在AOP中被称为AOP代理，AOP代理可代替目标对象，AOP代理
 * 包含了目标对象的全部方法。但AOP代理中的方法与目标对象的方法存在差异：
 *
 * ------AOP代理里的方法可以在执行目标方法之前、之后插入一些通用处理-------
 */

/**
 * DynamicProxy：
 * 动态代理
 * 动态代理是指客户通过代理类来调用其它对象的方法，并且是在程序运行时
 *  * 根据需要动态创建目标类的代理对象。
 */
//接口
interface ClothFactory1{
    void produceCloth1();
    String produceSale(double time);
}
//被代理类
class AdidasFactory implements ClothFactory1{

    @Override
    public void produceCloth1() {
        System.out.println("生产一批Essential x Yeezy");
    }

    @Override
    public String produceSale(double time) {
        return "第一批Essential x Yeezy在发售当日" + time + "S后售罄";
    }

}
//AOP（Aspect Orient Programming）******AOP代理里的方法可以在执行目标方法之前、之后插入一些通用处理
class ClothFactoryUtil{//******
    public void method1(){
        System.out.println("------------------动态代理增加的通用方法1------------------");
    }
    public void method2(){
        System.out.println("------------------动态代理增加的通用方法2------------------");
    }
}

/* 实现动态代理需要解决的问题:
    1.  如何根据被代理类动态的创建代理类及其对象;☆
    2.  当通过代理类调用方法时;如何动态的调用到被代理类中同名的方法;☆
 */
//创建动态代理类
class DynamicProxyFactory{
    //设计static方法返回一个代理类的对象--根据被代理类动态的创建代理类及其对象☆
    public static Object getProxyFactory(Object objProxied){//形参要传入被代理类对象
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();//自定义的实现InvocationHandler接口的类的对象
        myInvocationHandler.bind(objProxied);
        Object newProxyInstance = Proxy.newProxyInstance(objProxied.getClass().getClassLoader(), objProxied.getClass().getInterfaces(), myInvocationHandler);//☆
        //通过上诉方法得到根据被代理类动态的创建代理类及其对象并作为参数返回
        return newProxyInstance;

    }
}
//解决--当通过代理类调用方法时;如何动态的调用到被代理类中同名的方法
class MyInvocationHandler implements InvocationHandler {
    //需要被代理类的对象作为参数--传入到method.invoke()
    private Object proxiedObject;//设计被代理类的对象属性
    public void bind(Object obj){//设计bind()方法给声明的被代理类对象属性赋值--调用方法时形参传入被代理类对象
        this.proxiedObject = obj;
    }

    //当通过代理类调用方法时会自动调用invoke()方法
        //因此需要将被代理类要执行的方法传入invoke()方法中--以解决--当通过代理类调用方法时;如何动态的调用到被代理类中同名的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ClothFactoryUtil clothFactoryUtil = new ClothFactoryUtil();//******
        clothFactoryUtil.method1();//AOP代理里的方法可以在执行目标方法之前、之后插入一些通用处理******

        //以下方法为代理类调用的方法--此方法也作为调用被代理类对象要调用的同名的方法--回调目标对象的方法******
        Object returnInvoke = method.invoke(proxiedObject, args);//需要传入被代理类的对象以及参数

        clothFactoryUtil.method2();//AOP代理里的方法可以在执行目标方法之前、之后插入一些通用处理******

        //返回上诉方法的返回值作为当前类中invoke()方法的返回值
        return returnInvoke;



    }
}
public class DynamicProxyTest {
    public static void main(String[] args) {
        AdidasFactory adidasFactory = new AdidasFactory();//new被代理类的对象
        //通过动态代理类调用static的方法getProxyFactory-将被代理类的对象作为形参传入方法中--（根据被代理类动态的创建代理类及其对象）☆
        ClothFactory1 proxyFactory = (ClothFactory1) DynamicProxyFactory.getProxyFactory(adidasFactory);//类型为接口类型
        //通过动态创建的代理类对象调用相关方法--即调用了被代理类的相关方法（当通过代理类调用方法时动态的调用到被代理类中同名的方法）☆
        System.out.println(proxyFactory.produceSale(5.8));
        proxyFactory.produceCloth1();
        //------------------动态代理增加的通用方法1------------------
        //------------------动态代理增加的通用方法2------------------
        //第一批Essential x Yeezy在发售当日5.8S后售罄
        //------------------动态代理增加的通用方法1------------------
        //生产一批Essential x Yeezy
        //------------------动态代理增加的通用方法2------------------
    }

}
