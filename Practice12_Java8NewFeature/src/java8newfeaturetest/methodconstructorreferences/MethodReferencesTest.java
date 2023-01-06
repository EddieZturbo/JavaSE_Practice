package java8newfeaturetest.methodconstructorreferences;

/**
 @author EddieZhang
 @create 2022-08-21 16:31
 */

/** 方法引用
 *  当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *  方法引用可以看做是Lambda表达式深层次的表达。换句话说，方法引用就是Lambda表达式，
 * 也就是函数式接口的一个实例，通过方法的名字来指向一个方法，可以认为是Lambda表达式的一个语法糖。
 *  要求：实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的方法的参数列表和返回值类型保持一致！
 *  格式：使用操作符 “::” 将类(或对象) 与 方法名分隔开来。
 *  如下三种主要使用情况：
 *  对象::实例方法名
 *  类::静态方法名
 *  类::实例方法名
 *
 */
public class MethodReferencesTest {
}
