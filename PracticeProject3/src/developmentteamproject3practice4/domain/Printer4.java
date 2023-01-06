package developmentteamproject3practice4.domain;

/**
 @author EddieZhang
 @create 2022-08-25 9:01
 */
public class Printer4 implements Equipment4{
    private String name4;
    private String type4;//表示机器的类型

    @Override
    public String toString() {
        return "Printer4{" +
                "name4='" + name4 + '\'' +
                ", type4='" + type4 + '\'' +
                '}';
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public String getType4() {
        return type4;
    }

    public void setType4(String type4) {
        this.type4 = type4;
    }

    public Printer4(String name4, String type4) {
        this.name4 = name4;
        this.type4 = type4;
    }

    public Printer4() {
    }

    @Override
    public String getDescription4() {
        return name4 + "(" + type4 + ")";
    }
}
