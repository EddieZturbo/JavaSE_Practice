package beforejdk8;

/**
 * @author EddieZhang
 * @create 2022-08-14 17:44
 */

/**
 * System中提供的public static native long currentTimeMillis()方法用来
 * 返回当前时间与1970.01.01.00.00.00之间以毫秒为单位的时间差
 * 时间戳是指格林威治时间1970年01月01日00时00分00秒(北京时间1970年01月01
 * 日08时00分00秒)起至现在的总秒数
 * 计算世界时间的主要标准有
 * UTC(Coordinated Universal Time)
 * GMT(Greenwich Mean Time)
 * CST(Central Standard Time)
 */
public class SystemCurrentTimeMillisTest {
    public static void main(String[] args) {
        //System中提供的public static native long currentTimeMillis()
        long currentTimeMillis = System.currentTimeMillis();
        //返回当前时间与1970.01.01.00.00.00之间以毫秒为单位的时间差
        System.out.println(currentTimeMillis);//1660470429596
    }
}
