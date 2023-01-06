package developmentteamproject3practice1.service1;

/**
 * @author shkstart
 * @create 2022-08-06 14:45
 */

/**
 * 自定义异常类
 * ①继承于异常体系
 * ②提供serialVersionUID
 * ③重载构造器
 */
public class TeamException1 extends Exception{//①继承于异常体系
    static final long serialVersionUID = -3387516993129948L;//②serialVersionUID

    public TeamException1(String mesg) {//③重载构造器
        super(mesg);
    }//③重载构造器
}
