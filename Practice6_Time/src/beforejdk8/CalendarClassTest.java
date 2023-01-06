package beforejdk8;

/**
 * @author EddieZhang
 * @create 2022-08-14 19:25
 */

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.DAY_OF_YEAR;
import static java.util.Calendar.WEEK_OF_YEAR;

/**
 * java.util.Calendar(日历)类
 *  Calendar是一个抽象基类，主用用于完成日期字段之间相互操作的功能
 *  获取Calendar实例的方法
 *  使用Calendar.getInstance()方法
 *  调用它的子类GregorianCalendar的构造器
 *  一个Calendar的实例是系统时间的抽象表示，
 * 通过get(int field)方法来取得想
 * 要的时间信息。比如YEAR、MONTH、DAY_OF_WEEK、HOUR_OF_DAY 、
 * MINUTE、SECOND
 *  public void set(int field,int value)
 *  public void add(int field,int amount)
 *  public final Date getTime() Calendar类-->Date类
 *  public final void setTime(Date date)
 *  注意:
 *  获取月份时：一月是0，二月是1，以此类推，12月是11
 *  获取星期时：周日是1，周二是2 ， 。。。。周六是7
 */
public class CalendarClassTest {
    public static void main(String[] args) {
        //获取Calendar实例的方法
//        Calendar.getInstance()方法
        Calendar calendar1 = Calendar.getInstance();
        //通过get(int field)方法来取得想要的时间信息。比如YEAR、MONTH、DAY_OF_WEEK、HOUR_OF_DAY 、MINUTE、SECOND
        int dayOfYear = calendar1.get(DAY_OF_YEAR);
        System.out.println("现在是2022年的第: " + dayOfYear + " 天");//现在是2022年的第: 226 天
        int weekOfYear = calendar1.get(WEEK_OF_YEAR);
        System.out.println("现在是2022年的第: " + weekOfYear + " 周");//现在是2022年的第: 34 周
        //从一个Calendar对象中获取Date对象
        Date calendar1Time = calendar1.getTime();
//        calendar1.setTime设置calendar1时间
        calendar1.setTime(calendar1Time);
        System.out.println(calendar1Time.toString());
//        public void set(int field,int value)
        calendar1.set(calendar1.DAY_OF_YEAR,8);
        System.out.println("8天后的日期为:" + calendar1.getTime());

    }
}
