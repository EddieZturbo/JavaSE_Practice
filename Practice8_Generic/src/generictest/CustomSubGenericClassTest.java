package generictest;

/**
 * @author EddieZhang
 * @create 2022-08-16 16:43
 */

/**
 * 自定义泛型类的子类
 * 父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型
 * 子类除了指定或保留父类的泛型，还可以增加自己的泛型
 * 子类可以指明泛型的类型
 *
 * 子类可以不用先指明泛型的类型
 */
class Father1<T1, T2> {
}
// 子类不保留父类的泛型
// 1)没有类型 擦除
class Son1 extends Father1 {// 等价于class Son extends Father<Object,Object>{
}
// 2)具体类型
class Son2 extends Father1<Integer, String> {
}
// 子类保留父类的泛型
// 1)全部保留
class Son3<T1, T2> extends Father1<T1, T2> {
}
// 2)部分保留
class Son4<T2> extends Father1<Integer, T2> {
}

