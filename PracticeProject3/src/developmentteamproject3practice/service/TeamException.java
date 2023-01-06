package developmentteamproject3practice.service;

/**
 * @author shkstart
 * @create 2022-08-05 10:35
 */

/**
 * 自定义异常类
 * ①继承于异常体系（通常是Exception/RuntimeException）
 * ②提供serialVersionUID
 * ③重载构造器
 */
public class TeamException extends Exception{// ①继承于异常体系（通常是Exception/RuntimeException）
    static final long serialVersionUID = -33875169934229948L;//②提供serialVersionUID

    public TeamException() {
    }

    public TeamException(String msg) {//③重载构造器
        super(msg);
    }//③重载构造器
}
