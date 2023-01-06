package developmentteamproject3practice1.domain1;

/**
 * @author shkstart
 * @create 2022-08-06 10:44
 */
public class Printer1 implements Equipment1{//implements Equipment1 成为接口的实现类 实现接口的抽象方法
    private String name1;//表示机器名称
    private String type1;//表示机器类型

    public Printer1() {
    }

    public Printer1(String name, String type) {
        this.name1 = name;
        this.type1 = type;
    }

    @Override
    public String getDescription() {
        return name1 + "(" + type1 + ")";
    }

    public String getName() {
        return name1;
    }

    public void setName(String name) {
        this.name1 = name;
    }

    public String getType() {
        return type1;
    }

    public void setType(String type) {
        this.type1 = type;
    }
}
