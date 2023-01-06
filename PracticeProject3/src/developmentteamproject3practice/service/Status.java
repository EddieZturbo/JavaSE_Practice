package developmentteamproject3practice.service;

/**
 * @author shkstart
 * @create 2022-08-04 20:28
 */
public class Status {
    private final String NAME;


    private Status(String name) {
        this.NAME = name;
    }
    public static final Status FREE = new Status("FREE");//空闲状态
    public static final Status VOCATION = new Status("VOCATION");//已加入开发团队
    public static final Status BUSY = new Status("BUSY");//正在休假

    public String getNAME(){
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
