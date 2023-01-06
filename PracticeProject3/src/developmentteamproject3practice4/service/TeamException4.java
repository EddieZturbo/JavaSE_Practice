package developmentteamproject3practice4.service;

/**
 @author EddieZhang
 @create 2022-08-25 10:00
 */
/**
 * 自定义异常类
 * 1.继承于异常体系结构
 * 2.提供UID
 * 3.重载构造器
 */

/**
 * @Description 自定义异常类
 * @Author EddieZhang
 * @Date 2022/8/25 10:00
 * @Since version-1.0
 */
public class TeamException4 extends Exception{//1.继承于异常体系结构
    static final long serialVersionUID = -338751699312442548L;//2.提供UID

    public TeamException4(String message1) {//3.重载构造器
        super(message1);
    }
}
