package templatemethodtest;

/**
 * @author shkstart
 * @create 2022-07-31 14:43
 */
public class TemplateMethodTest1 {
    public static void main(String[] args) {
        TemplateMethod m1 = new SubTemplateMethod();
        m1.getTime();
    }
}


//创建abstract类 设计类的成员
abstract class TemplateMethod {
    //设计类的属性


    //设计类的constructor方法


    //设计类的方法
    public final void getTime() {
        long start = System.currentTimeMillis();
        code();//不确定的 可变部分 交给子类重写
        long end = System.currentTimeMillis();
        System.out.println("执行时间是：" + (end - start) + "s");
    }

    public abstract void code();
}

//创建 abstract class TemplateMethod的子类 设计类的成员
class SubTemplateMethod extends TemplateMethod {
    //设计类的属性


    //设计类的constructor方法


    //设计类的方法


    @Override
    public void code() {
        //求1000以内的所有质数并打印输出
        for (int i = 2; i <= 1000; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }

            }
            if (flag) {
                System.out.println(i);
            }

        }
    }
}