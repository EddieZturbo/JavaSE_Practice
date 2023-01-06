package developmentteamproject3practice3.domain;

/**
 * @author EddieZhang
 * @create 2022-08-11 11:30
 */
public class NoteBook3 implements Equipment3{
    private String model3;//表示机器的型号
    private double price3;//表示价格

    public NoteBook3() {
    }

    public NoteBook3(String model3, double price3) {
        this.model3 = model3;
        this.price3 = price3;
    }

    @Override
    public String getDescription3() {
        return model3 + "(" + price3 + ")";
    }

    public String getModel3() {
        return model3;
    }

    public void setModel3(String model3) {
        this.model3 = model3;
    }

    public double getPrice3() {
        return price3;
    }

    public void setPrice3(double price3) {
        this.price3 = price3;
    }
}
