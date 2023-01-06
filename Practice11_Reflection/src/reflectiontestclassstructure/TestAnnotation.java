package reflectiontestclassstructure;

/**
 @author EddieZhang
 @create 2022-08-20 9:49
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * 自定义Annotation
 * 1.声明为@interface
 * 2.内部定义成员 value（）可以自定义default默认信息
 */
@Retention(RetentionPolicy.RUNTIME)//元注解--对注解的解释 注解的声明周期 默认是class --此时想要使用反射 声明周期要求为RUNTIME;
@Target({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR, LOCAL_VARIABLE, MODULE})//元注解--用于指定被修饰的 Annotation 能用于修饰哪些程序元素
public @interface TestAnnotation  {//
    String[] value() default "HelloAnnotation";
}
