package developmentteamproject3practice1.domain1;

/**
 * @author shkstart
 * @create 2022-08-06 10:42
 */
public class NoteBook1 implements Equipment1{//implements Equipment1 成为接口的实现类 实现接口的抽象方法
    private String model1;//表示机器型号
    private double price1;//表示价格

    public NoteBook1() {
    }

    public NoteBook1(String model, double price) {
        this.model1 = model;
        this.price1 = price;
    }

    @Override
    public String getDescription() {
        return model1 + "(" + price1 + ")";
    }

    public String getModel() {
        return model1;
    }

    public void setModel(String model) {
        this.model1 = model;
    }

    public double getPrice() {
        return price1;
    }

    public void setPrice(double price) {
        this.price1 = price;
    }
}
