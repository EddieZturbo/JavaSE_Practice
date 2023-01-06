package beforejdk8;

/**
 * @author EddieZhang
 * @create 2022-08-14 17:52
 */

import java.util.Date;

/**
 * java.util.Date类
 * 表示特定的瞬间，精确到毫秒
 * 构造器：
 *  Date()：使用无参构造器创建的对象可以获取本地当前时间。
 *  Date(long date)
 * 常用方法
 *  getTime():返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象
 * 表示的毫秒数。
 *  toString():把此 Date 对象转换为以下形式的 String： dow mon dd
 * hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue,
 * Wed, Thu, Fri, Sat)，zzz是时间标准。
 *
 * java.sql.Date extends java.util.Date
 *
 */
public class DateClassTest {
    //创建java.util.Date类的对象
    public static void main(String[] args) {
        //构造器： Date():使用无参构造器创建的对象可以获取本地当前时间。
        Date date1 = new Date();
        System.out.println(date1);//Sun Aug 14 17:55:58 CST 2022
        //常用方法：getTime():返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
        long date1Time = date1.getTime();
        System.out.println(date1Time);//1660471077048
        //常用方法：toString():把此 Date 对象转换为以下形式的 String： dow mon dd
        String toString = date1.toString();
        System.out.println(toString);//Sun Aug 14 18:00:04 CST 2022

        System.out.println("--------------------------------------------------------------");
        //构造器：Date(long date):创建一个创建指定毫秒数的Date对象
        Date date2 = new Date(1660471077048L);
        System.out.println(date2);//Sun Aug 14 17:57:57 CST 2022
        long date2Time = date2.getTime();
        System.out.println(date2Time);//1660471077048
        System.out.println("--------------------------------------------------------------");


//        创建java.sql.Date类的对象
        java.sql.Date date3 = new java.sql.Date(1660471077048L);
        System.out.println(date3);//2022-08-14


        //如何将java.util.Date类的对象-->java.sql.Date类的对象
        Date date5 = new Date();//new一个java.sql.Date类的对象
        long date5Time = date5.getTime();//调用getTime()方法获得java.sql.Date类的对象的时间戳
        java.sql.Date date6 = new java.sql.Date(date5Time);//将java.sql.Date类的对象的时间戳放入构造器中--java.sql.Date(java.sql.Date类的对象的时间戳)


    }
}
