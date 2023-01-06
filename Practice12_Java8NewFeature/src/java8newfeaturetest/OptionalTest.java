package java8newfeaturetest;

/**
 @author EddieZhang
 @create 2022-08-24 21:30
 */

import org.junit.Test;

import java.util.Optional;

/** Optional--在开发中使用可以避免空指针异常
 *  Optional<T> 类(java.util.Optional) 是一个容器类，它可以保存类型T的值，代表这个值存在。
 * 或者仅仅保存null，表示这个值不存在。原来用 null 表示一个值不存在，现在 Optional 可以更好的表达这个概念。并且可以避免空指针异常。
 *
 *  Optional类的Javadoc描述如下：这是一个可以为null的容器对象。如果值存在
 * 则isPresent()方法会返回true，调用get()方法会返回该对象
 */
public class OptionalTest {
    /* 创建Optional类对象的方法
         Optional.of(T t) : 创建一个 Optional 实例，t必须非空；--搭配get()使用
         Optional.empty() : 创建一个空的 Optional 实例--内部的value = null;
         Optional.ofNullable(T t)：t可以为null--搭配orElse()使用
     */
    @Test
    public void test(){
        // 创建Optional类对象的方法：
            // Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
        Girl girl = new Girl();
//        girl = null;
        Optional<Girl> girlOptional = Optional.of(girl);
        System.out.println(girlOptional);//Optional[girl{name='null'}]
        System.out.println("------------------------------------------------");
            // Optional.ofNullable(T t)：t可以为null
        girl = null;
        Optional<Girl> girlOptional1 = Optional.ofNullable(girl);
        System.out.println(girlOptional1);//Optional.empty
        System.out.println("------------------------------------------------");
            // Optional.empty() : 创建一个空的 Optional 实例
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);//Optional.empty




    }
    @Test
    public void test1(){
        //在使用Optional类之前很容易出现空指针异常
        boy boy = new boy();
        Girl girl1 = new Girl("Rihanna");
//        Girl girl1 = boy.getGirl();
//        String girl1Name = girl1.getName();
//        System.out.println(boy);//boy{girl=null}
//        System.out.println(boy.getGirl());//null
//        boy.getGirl().getName();//NullPointerException

        //未使用Optional类的优化写法--不会出现空指针异常
//        if(boy != null){
//            Girl girl = boy.getGirl();
//            if(girl != null){
//                //return girl.getName();
//            }
//        }
        //return null;

        //使用Optional类--可以规避空指针异常
            //将boy包装到Optional类中--boy可能是个null
            Optional<Girl> optionalGirl = Optional.ofNullable(girl1);//使用ofNullable(T t)：t可以为null
                // T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象--如果对象为空的可以返回指定的默认值
                Girl girl = optionalGirl.orElse(new Girl("Tyler Swift"));
                System.out.println(girl);//girl{name='Tyler Swift'}

        // 判断Optional容器中是否包含对象：
            // boolean isPresent() : 判断是否包含对象
        boolean optionalGirlPresent = optionalGirl.isPresent();
        System.out.println(optionalGirlPresent);//true
        // 获取Optional容器的对象：
            // T get(): 如果调用对象包含值，返回该值，否则抛异常
        Girl girl2 = optionalGirl.get();
        System.out.println(girl2);//girl{name='Rihanna'}
    }
}
class Girl {
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Girl girl = (Girl) o;

        return name != null ? name.equals(girl.name) : girl.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl(String name) {
        this.name = name;
    }

    public Girl() {
    }
}
class boy{
    private Girl girl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        boy boy = (boy) o;

        return girl != null ? girl.equals(boy.girl) : boy.girl == null;
    }

    @Override
    public int hashCode() {
        return girl != null ? girl.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "boy{" +
                "girl=" + girl +
                '}';
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public boy(Girl girl) {
        this.girl = girl;
    }

    public boy() {
    }
}
