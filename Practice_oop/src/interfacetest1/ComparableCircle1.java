package interfacetest1;

/**
 * @author shkstart
 * @create 2022-08-01 9:32
 */
public class ComparableCircle1 extends Circle1 implements CompareObject1 {
    public ComparableCircle1() {
    }

    public ComparableCircle1(double redius) {
        super(redius);
    }

    @Override
    public int compareTO(Object O) {
        if (this == O) {
            return 0;
        }
        if (O instanceof ComparableCircle1) {
            ComparableCircle1 c = (ComparableCircle1) O;//强转
            return this.getRedius().compareTo(c.getRedius());
        }
        else{

        throw new RuntimeException("参数传入不同类型 无法比较");
        }
    }
}

