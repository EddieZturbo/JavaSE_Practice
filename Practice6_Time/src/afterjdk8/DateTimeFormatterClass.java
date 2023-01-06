package afterjdk8;

/**
 * @author EddieZhang
 * @create 2022-08-14 21:19
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * java.time.format.DateTimeFormatter 类：
 * 该类提供了三种格式化方法：
 *  预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
 *  本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
 *  自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
 *
 * method------------------------describe
 * ofPattern(String pattern) ----静态方法 ， 返 回 一 个 指 定 字 符 串 格 式 的DateTimeFormatter
 * format(TemporalAccessor t) ---格式化一个日期、时间，返回字符串
 * parse(CharSequence text) -----将指定格式的字符序列解析为一个日期、时间
 */
public class DateTimeFormatterClass {
    public static void main(String[] args) {
//        自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());//format(TemporalAccessor t) ---格式化一个日期、时间，返回字符串
        System.out.println(format);//2022-08-14 09:26:19
        TemporalAccessor parse = dateTimeFormatter.parse(format);
        System.out.println(parse);
    }
}
