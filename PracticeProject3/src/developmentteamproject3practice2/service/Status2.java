package developmentteamproject3practice2.service;

/**
 * @author shkstart
 * @create 2022-08-08 10:50
 */

/**
 *
 */
//public class Status2 {
//    private final String NAME2;
//
//    private Status2(String NAME2) {
//        this.NAME2 = NAME2;
//    }
//
//    public static final Status2 FREE = new Status2("FREE");
//    public static final Status2 VOCATION = new Status2("VOCATION");
//    public static final Status2 BUSY = new Status2("BUSY");
//
//
//    public String getNAME2() {
//        return NAME2;
//    }
//
//    @Override
//    public String toString() {
//        return NAME2;
//    }
//}

/**
 * 改成enum类方式实现
 */
public enum Status2 {
    FREE,VOCATION,BUSY;
}