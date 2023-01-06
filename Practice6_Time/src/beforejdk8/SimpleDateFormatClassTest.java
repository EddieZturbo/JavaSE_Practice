package beforejdk8;

/**
 * @author EddieZhang
 * @create 2022-08-14 18:15
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat类
 *  Date类的API不易于国际化，大部分被废弃了，java.text.SimpleDateFormat类是一个不与语言环境有关的方式来格式化和解析日期的具体类。
 *  它允许进行格式化：日期文本、解析：文本日期
 *  格式化：
 *  SimpleDateFormat() ：默认的模式和语言环境创建对象
 *  public SimpleDateFormat(String pattern)：该构造方法可以用参数pattern指定的格式创建一个对象，该对象调用：
 *  public String format(Date date)：方法格式化时间对象date
 *  解析：
 *  public Date parse(String source)：从给定字符串的开始解析文本，以生成一个日期。
 */
public class SimpleDateFormatClassTest {
    public static void main(String[] args) throws ParseException {
//--------------------------SimpleDateFormat() ：默认的模式和语言环境创建对象------------------------------------------------
        Date date1 = new Date();//new一个java.util.Date类的对象空参构造器返回当前时间
        System.out.println(date1);//Sun Aug 14 18:19:31 CST 2022\
        //进行格式化（format）日期-->字符串
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat();//SimpleDateFormat() ：默认的模式和语言环境创建对象
        String format = simpleDateFormat1.format(date1);
        System.out.println(format);//2022/8/14 下午6:21
        //进行解析（parse）格式化的逆过程 字符串-->日期
        String strDate1 = "2022/8/14 下午6:21";
        try {
            Date parseDate = simpleDateFormat1.parse(strDate1);
            System.out.println(parseDate);//Sun Aug 14 18:21:00 CST 2022
        } catch (ParseException e) {
            System.out.println(e.getMessage());//Unparseable date: "2022/8/14 午6:2"
        }
        System.out.println("*******************************************************************************************");
        //-----------public SimpleDateFormat(String pattern)：该构造方法可以用参数pattern指定的格式创建一个对象-----------------
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy年MM月dd日 EEE HH:mm:ss");
        //进行格式化（format）日期-->字符串
        String format1 = simpleDateFormat2.format(date1);
        System.out.println(format1);//2022年08月14日 周日 18:39:15
        //进行解析（parse）格式化的逆过程 字符串-->日期
        try {
            Date parseDate2 = simpleDateFormat2.parse(format1);
            System.out.println(parseDate2);//Sun Aug 14 18:41:34 CST 2022
        } catch (ParseException e) {
            System.out.println(e.getMessage());//Unparseable date:
        }

        System.out.println("*******************************************************************************************");
        //字符串String strDate3 = "2020-09-08";转换成java.sql.Date
        String strDate3 = "2020-09-08";
        //simpleDateFormat3.parse(strDate3)解析成Date（java.util.Date）
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
            Date parseDate3 = simpleDateFormat3.parse(strDate3);
            parseDate3.getTime();

            //java.util.Date转成java.sql.Date
        java.sql.Date sqlDate1 = new java.sql.Date(parseDate3.getTime());
        System.out.println(sqlDate1);
    }

}
