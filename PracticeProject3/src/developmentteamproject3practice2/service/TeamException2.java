package developmentteamproject3practice2.service;

/**
 * @author shkstart
 * @create 2022-08-08 11:03
 */

/**
 * 自定义异常类
 * ①：继承于Exception体系结构
 * ②：提供serialVersionUID
 * ③：重载构造器
 */
public class TeamException2 extends Exception{//①：继承于Exception体系结构

    static final long serialVersionUID = -33875169931229948L;//②：提供serialVersionUID

    public TeamException2(String msag) {//③：重载构造器
        super(msag);
    }//③：重载构造器
}
