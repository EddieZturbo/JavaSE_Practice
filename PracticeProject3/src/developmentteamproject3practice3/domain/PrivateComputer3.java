package developmentteamproject3practice3.domain;

/**
 * @author EddieZhang
 * @create 2022-08-11 11:29
 */
public class PrivateComputer3 implements Equipment3{
    private String model3;//表示机器的型号
    private String display3;//表示显示器型号

    public PrivateComputer3() {
    }

    public PrivateComputer3(String model3, String display3) {
        this.model3 = model3;
        this.display3 = display3;
    }

    @Override
    public String getDescription3() {
        return model3 + "(" + display3 + ")";
    }

    public String getModel3() {
        return model3;
    }

    public void setModel3(String model3) {
        this.model3 = model3;
    }

    public String getDisplay3() {
        return display3;
    }

    public void setDisplay3(String display3) {
        this.display3 = display3;
    }
}
