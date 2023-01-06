package afterjdk8;

/**
 * @author EddieZhang
 * @create 2022-08-14 20:51
 */

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * java.time – 包含值对象的基础包★
 *
 * 本地日期（LocalDate）、
 * 本地时间（LocalTime）、
 * 本地日期时间（LocalDateTime）、☆高频使用 类似于Calendar
 *
 * method--------------------------------------------------------------describe
 * now() / * now(ZoneId zone) -----------------------------------------静态方法，根据当前时间创建对象/指定时区的对象
 * of() ---------------------------------------------------------------静态方法，根据指定日期/时间创建对象
 * getDayOfMonth()/getDayOfYear() -------------------------------------获得月份天数(1-31) /获得年份天数(1-366)
 * getDayOfWeek() -----------------------------------------------------获得星期几(返回一个 DayOfWeek 枚举值)
 * getMonth() ---------------------------------------------------------获得月份, 返回一个 Month 枚举值
 * getMonthValue() / getYear() ----------------------------------------获得月份(1-12) /获得年份
 * getHour()/getMinute()/getSecond() ----------------------------------获得当前对象对应的小时、分钟、秒
 * withDayOfMonth()/withDayOfYear()/withMonth()/withYear() ------------将月份天数、年份天数、月份、年份修改为指定的值并返回新的对象
 * plusDays(), plusWeeks(),plusMonths(), plusYears(),plusHours() ------向当前对象添加几天、几周、几个月、几年、几小时
 * minusMonths() / minusWeeks()/minusDays()/minusYears()/minusHours() -从当前对象减去几月、几周、几天、几年、几小时
 *
 *
 * 用 ISO-8601日历系统 它们的实例是不可变的对象
 * ISO-8601日历系统是国际标准化组织制定的现代公民的日期和时间的表示法，也就是公历
 *
 * 时区（ZonedDateTime）
 * 和持续时间（Duration）的类
 * java.time.chrono – 提供对不同的日历系统的访问
 * java.time.format – 格式化和解析时间和日期★
 * java.time.temporal – 包括底层框架和扩展特性★
 * java.time.zone – 包含时区支持的类
 *
 * 瞬时：Instant 类似于java.util.Date
 * Instant：时间线上的一个瞬时点。 这可能被用来记录应用程序中的事件时间戳。
 * method---------------------------------describe
 * now() ---------------------------------静态方法，返回默认UTC时区的Instant类的对象
 * ofEpochMilli(long epochMilli) ---------静态方法，返回在1970-01-01 00:00:00基础上加上指定毫秒数之后的Instant类的对象
 * atOffset(ZoneOffset offset) -----------结合即时的偏移来创建一个 OffsetDateTime
 * toEpochMilli() 返回1970-01-01 00:00:00--到当前时间的毫秒数，即为时间戳
 *
 * 它只是简单的表示自1970年1月1日0时0分0秒（UTC）开始的秒数
 * 在Java中从1970年开始以毫秒为单位
 * 时间戳是指格林威治时间1970年01月01日00时00分00秒(北京时间1970年01月01日08时00分00秒)起至现在的总秒数
 */
public class NewDateClass {
    public static void main(String[] args) {
//        瞬时：Instant 类似于java.util.Date
        Instant now = Instant.now();
        System.out.println(now);//2022-08-14T13:10:40.912953900Z
        long epochSecond = now.getEpochSecond();//返回1970-01-01 00:00:00--到当前时间的毫秒数，即为时间戳
        System.out.println(epochSecond);//1660482698

//        本地日期时间（LocalDateTime）、☆高频使用 类似于Calendar
        LocalDateTime localDateTime = LocalDateTime.now();//静态方法，根据当前时间创建对象/指定时区的对象
        System.out.println(localDateTime);//2022-08-14T21:10:40.928954800
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println(dayOfWeek);//SUNDAY
        Month localDateTimeMonth = localDateTime.getMonth();
        System.out.println(localDateTimeMonth);//AUGUST
        LocalDateTime localDateTime1 = LocalDateTime.of(2000, 12, 07, 00, 00, 00, 00);//静态方法，根据指定日期/时间创建对象
        System.out.println(localDateTime1);//2000-12-07T00:00
    }
}
