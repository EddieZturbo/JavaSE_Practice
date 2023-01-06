package developmentteamproject3practice4.domain;

/**
 @author EddieZhang
 @create 2022-08-25 8:56
 */
public class PrivateComputer4 implements Equipment4{
    private String model4;//表示机器的型号
    private String display;//表示显示器的型号

    public PrivateComputer4() {
    }

    public PrivateComputer4(String model4, String display) {
        this.model4 = model4;
        this.display = display;
    }

    @Override
    public String getDescription4() {
        return model4 + "(" + display + ")";
    }

    @Override
    public String toString() {
        return "PrivateComputer4{" +
                "model4='" + model4 + '\'' +
                ", display='" + display + '\'' +
                '}';
    }

    public String getModel4() {
        return model4;
    }

    public void setModel4(String model4) {
        this.model4 = model4;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
