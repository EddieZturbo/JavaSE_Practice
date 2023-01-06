package annotationpractice;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author EddieZhang
 * @create 2022-08-12 21:08
 */
public class AnnotationTest {
    @MyAnnotation(value = "hi")//也可以在使用时对成员value经行更改
    public static void main(String[] args) {

    }
}
/**
 * 自定义Annotation（注解）
 * 参照 @SuppressWarnings
 * 1.声明为@interface
 * 2.内部定义成员通常用value表示
 * 3.可以指定成员的默认值 default
 * 4.如果自定义注解没有成员 表明是一个表示作用 如 @override
 */
@Retention(RetentionPolicy.RUNTIME)//元注解--对现有注解进行解释说明的注解 用于修饰其他 Annotation 定义 注解的声明周期 默认是class
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})//元注解--用于指定被修饰的 Annotation 能用于修饰哪些程序元素
@interface MyAnnotation{//1.声明为@interface
    String[] value() default "hello";//2.内部定义成员通常用value表示
    //3.可以指定成员的默认值 default
}