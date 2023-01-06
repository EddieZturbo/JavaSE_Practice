package developmentteamproject3practice3.service;

/**
 * @author EddieZhang
 * @create 2022-08-11 11:39
 */
/**
 * @Description 自定义枚举类 三个状态
 * @Author EddieZhang
 * @Date 2022/8/11 11:44
 * @Since version-1.0
 */
public class Status3 {
    private final String NAME;

    //私有构造器
    private Status3(String name) {
        this.NAME = name;
    }
    //公共静态对象
    public static final Status3 FREE = new Status3("FREE");
    public static final Status3 BUSY = new Status3("BUSY");
    public static final Status3 VOCATION = new Status3("VOCATION");

    //公共方法
    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
