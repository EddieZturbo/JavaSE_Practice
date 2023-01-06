package developmentteamproject3practice4.domain;

/**
 @author EddieZhang
 @create 2022-08-25 8:59
 */
public class NoteBook4 implements Equipment4{
    private String model4;
    private double price4;

    public NoteBook4() {
    }

    public String getModel4() {
        return model4;
    }

    public void setModel4(String model4) {
        this.model4 = model4;
    }

    @Override
    public String toString() {
        return "NoteBook4{" +
                "model4='" + model4 + '\'' +
                ", price4=" + price4 +
                '}';
    }

    public double getPrice4() {
        return price4;
    }

    public void setPrice4(double price4) {
        this.price4 = price4;
    }

    public NoteBook4(String model4, double price4) {
        this.model4 = model4;
        this.price4 = price4;
    }

    @Override
    public String getDescription4() {
        return model4 + "(" + price4 + ")";
    }
}
