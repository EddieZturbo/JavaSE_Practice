package developmentteamproject3practice1.domain1;

/**
 * @author shkstart
 * @create 2022-08-06 10:39
 */
public class PrivateComputer1 implements Equipment1{//implements Equipment1 成为接口的实现类 实现接口的抽象方法
    private String model1;//表示机器型号
    private String display1;//表示显示器名称

    public PrivateComputer1() {
    }

    public PrivateComputer1(String model, String display) {
        this.model1 = model;
        this.display1 = display;
    }



    @Override
    public String getDescription() {
        return model1 + "(" + display1 + ")";
    }

    public String getModel() {
        return model1;
    }

    public void setModel(String model) {
        this.model1 = model;
    }

    public String getDisplay() {
        return display1;
    }

    public void setDisplay(String display) {
        this.display1 = display;
    }

}
