package interfacetest;

/**
 * @author shkstart
 * @create 2022-08-01 9:32
 */
public class ComparableCircle extends Circle implements CompareObject {
    public ComparableCircle() {
    }

    public ComparableCircle(double redius) {
        super(redius);
    }

    @Override
    public int compareTO(Object O) {
        if (this == O) {
            return 0;
        }
        if (O instanceof ComparableCircle) {
            ComparableCircle c = (ComparableCircle) O;//强转
            if (this.getRedius() == c.getRedius()) {
                return 0;
            }else{
            int compare = (this.getRedius() > c.getRedius()) ? 1 : -1;
            return compare;

            }
        }
        else {


            throw new RuntimeException("参数传入不同类型 无法比较");
        }
    }
}
