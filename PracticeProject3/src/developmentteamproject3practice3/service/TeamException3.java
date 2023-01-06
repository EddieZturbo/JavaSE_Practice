package developmentteamproject3practice3.service;

/**
 * @author EddieZhang
 * @create 2022-08-11 11:56
 */
/**
 * @Description 自定义异常类
 * @Author EddieZhang
 * @Date 2022/8/11 11:56
 * @Since version-1.0
 */

/**
 * 自定义异常类
 * 1.继承于Exception体系
 * 2.提供serialVersionUID
 * 3.重载构造器
 */
public class TeamException3 extends Exception{//1.继承于Exception体系
    static final long serialVersionUID = -338751694229948L;//2.提供serialVersionUID

    public TeamException3(String mesage) {//3.重载构造器
        super(mesage);
    }

}
