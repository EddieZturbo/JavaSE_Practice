package developmentteamproject3practice3.domain;

/**
 * @author EddieZhang
 * @create 2022-08-11 11:31
 */
public class Printer3 implements Equipment3{
    private String name3;//打印机设备的名称
    private String type3;//打印机的类型

    public Printer3() {
    }

    public Printer3(String name3, String type3) {
        this.name3 = name3;
        this.type3 = type3;
    }

    @Override
    public String getDescription3() {
        return name3 + "(" + type3+ ")";
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }
}
