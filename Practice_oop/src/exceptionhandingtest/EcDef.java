package exceptionhandingtest;

/**
 * @author shkstart
 * @create 2022-08-04 15:46
 */
/*
自定义异常类
①继承异常类
②提供serialVersionUID
③重载构造器

 */

public class EcDef extends Exception{//①继承异常类
    static final long serialVersionUID = 13465653435L;//②提供serialVersionUID

    //③重载构造器
    public EcDef() {
    }

    public EcDef(String message) {
        super(message);
    }
}
