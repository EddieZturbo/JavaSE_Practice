package developmentteamproject3practice2.domain;

/**
 * @author shkstart
 * @create 2022-08-08 10:41
 */
public class NoteBook2 implements Equipment2 {
    private String model2;
    private double price2;

    public NoteBook2() {
    }

    public NoteBook2(String model2, double price2) {
        this.model2 = model2;
        this.price2 = price2;
    }

    @Override
    public String getDescription2() {
        return model2 + "(" + price2 + ")";
    }

    public String getModel2() {
        return model2;
    }

    public void setModel2(String model2) {
        this.model2 = model2;
    }

    public double getPrice2() {
        return price2;
    }

    public void setPrice2(double price2) {
        this.price2 = price2;
    }
}
