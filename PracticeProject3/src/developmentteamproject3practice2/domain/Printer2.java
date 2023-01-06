package developmentteamproject3practice2.domain;

/**
 * @author shkstart
 * @create 2022-08-08 10:42
 */
public class Printer2 implements Equipment2 {
    private String name2;
    private String type2;//表示机器的型号

    public Printer2() {
    }

    public Printer2(String name2, String type2) {
        this.name2 = name2;
        this.type2 = type2;
    }

    @Override
    public String getDescription2() {
        return name2 + "(" + type2 + ")";
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }
}
