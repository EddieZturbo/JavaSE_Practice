package enumerationpractice;

import java.util.Arrays;

/**
 * @author EddieZhang
 * @create 2022-08-12 17:29
 */
public class EnumerationTest {
    public static void main(String[] args) {
        System.out.println(EnumerationSeason.SPRING);
        System.out.println(EnumerationSeason.SUMMER);
        System.out.println(EnumerationSeason.AUTUMN);
        System.out.println(EnumerationSeason.WINTER);
        System.out.println("-------------------------------------------");
        System.out.println(EnumerationSeason2.AUTUMN_ONE.toString());//toString()方法 未重写时默认：常量的名称

        System.out.println(EnumerationSeason2.valueOf("WINTER_ONE"));//valueOf()方法

        EnumerationSeason2[] enumerationSeason2s = EnumerationSeason2.values();//values()方法
        System.out.println(Arrays.toString(enumerationSeason2s));

    }
}
/**
 * 自定义一组常量的时候 考虑自定义枚举类
 * 自定义枚举类（enumeration）
 * 1.   属性 private final
 *      构造器 private,并给属性进行初始化
 *      对象 public static final
 *
 * 2.   提供属性的get方法
 *
 * 3.   重写toString（）方法
 */
class EnumerationSeason{
    //属性 private final
    private final String seasonName;
    private final String seasonDesc;

    //构造器 private,并给属性进行初始化
    private EnumerationSeason(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //对象 public static final
    public static final EnumerationSeason SPRING = new EnumerationSeason("春天","万物复苏");
    public static final EnumerationSeason SUMMER = new EnumerationSeason("夏天","烈日炎炎");
    public static final EnumerationSeason AUTUMN = new EnumerationSeason("秋天","秋高气爽");
    public static final EnumerationSeason WINTER = new EnumerationSeason("冬天","寒风刺骨");

    //提供属性的get方法

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //重写toString（）方法

    @Override
    public String toString() {
        return "EnumerationSeason{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

/**
 * 使用enum自定义枚举类
 * 定义的enum枚举类 默认继承于java.long.Enum类
 * 1.   创建enum类
 * enum EnumerationSeason2{
 *
 * }
 * 2.   创建对象
 * AUTUMN_ONE("秋天","秋高气爽"),
 * WINTER_ONE("冬天","东暖花开");
 * 3.   声明属性 private final
 * 4.   声明构造器 private
 * 5.   提供属性的get方法
 * 6.   根据需要重写toString()方法--默认是常量的名
 */
//创建 enum 类
enum EnumerationSeason2 {//和普通Java类一样 枚举类可以实现一个或多个interface
    SPRING_ONE("春天","春暖花开"),
    //可以单独对象单独实现接口中的方法 独立调用
        SUMMER_ONE("夏天","夏日炎炎"),
    //可以单独对象单独实现接口中的方法 独立调用
            AUTUMN_ONE("秋天","秋高气爽"),
    //可以单独对象单独实现接口中的方法 独立调用
                WINTER_ONE("冬天","东暖花开");
    //设计属性 声明为 private final
    private final String seasonName1;
    private final String seasonDesc1;

    //设计构造器 声明为private
    private EnumerationSeason2(String seasonName1, String seasonDesc1) {
        this.seasonName1 = seasonName1;
        this.seasonDesc1 = seasonDesc1;
    }

    //提供属性的get方法

    public String getSeasonName1() {
        return seasonName1;
    }

    public String getSeasonDesc1() {
        return seasonDesc1;
    }
    //根据需要重写toString()方法 默认是常量名

    @Override
    public String toString() {
        return "EnumerationSeason2{" +
                "seasonName1='" + seasonName1 + '\'' +
                ", seasonDesc1='" + seasonDesc1 + '\'' +
                '}';
    }

    //可以实现接口中的方法 供所有对象共用 也可单独对象单独实现方法



}