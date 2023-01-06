package developmentteamproject3practice1.service1;

/**
 * @author shkstart
 * @create 2022-08-06 10:56
 */
public class Status1 {
    private final String NAME1;


    //私有构造器
    private Status1(String name){
        this.NAME1 = name;
    }

    //公共静态final对象
    public static final Status1 FREE1 = new Status1("FREE1");
    public static final Status1 VOCATION1 = new Status1("VOCATION1");
    public static final Status1 BUSY1 = new Status1("BUSY1");

    //公共方法
    public String getNAME1() {
        return NAME1;
    }


    @Override
    public String toString() {
        return NAME1;
    }
}
