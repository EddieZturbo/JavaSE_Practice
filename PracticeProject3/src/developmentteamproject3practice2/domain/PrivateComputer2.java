package developmentteamproject3practice2.domain;

/**
 * @author shkstart
 * @create 2022-08-08 10:39
 */
public class PrivateComputer2 implements Equipment2 {
    private String model2;//表示机器型号
    private String display2;//表示显示器名称

    public PrivateComputer2() {
    }

    public PrivateComputer2(String model2, String display2) {
        this.model2 = model2;
        this.display2 = display2;
    }

    @Override
    public String getDescription2() {
        return model2 + "(" + display2 + ")";
    }

    public String getModel2() {
        return model2;
    }

    public void setModel2(String model2) {
        this.model2 = model2;
    }

    public String getDisplay2() {
        return display2;
    }

    public void setDisplay2(String display2) {
        this.display2 = display2;
    }
}
