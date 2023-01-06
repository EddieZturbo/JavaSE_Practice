package BankAccountTest;

/**
 * @author shkstart
 * @create 2022-07-29 17:29
 */
public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount1.setInterestRate(0.05);
        BankAccount1.setMinBalance(100);
        BankAccount1 a1 = new BankAccount1("474663",10000);
        BankAccount1 a2 = new BankAccount1("123544",12500);
        BankAccount1 a3 = new BankAccount1("865453",15320);
        BankAccount1 a4 = new BankAccount1("843523",20215);
        BankAccount1 a5 = new BankAccount1("654685",15868);
        BankAccount1 a6 = new BankAccount1("354866",10153);
        System.out.println("账户：" + a1.getId() + ",\t密码：" + a1.getPassWord() + ",\t余额为:" + a1.getBalance() + "，\t年利率为：" + BankAccount1.getInterestRate() + ",\t最低存款为：" + BankAccount1.getMinBalance());
        System.out.println("账户：" + a2.getId() + ",\t密码：" + a2.getPassWord() + ",\t余额为:" + a2.getBalance() + "，\t年利率为：" + BankAccount1.getInterestRate() + ",\t最低存款为：" + BankAccount1.getMinBalance());
        System.out.println("账户：" + a3.getId() + ",\t密码：" + a3.getPassWord() + ",\t余额为:" + a3.getBalance() + "，\t年利率为：" + BankAccount1.getInterestRate() + ",\t最低存款为：" + BankAccount1.getMinBalance());
        System.out.println("账户：" + a4.getId() + ",\t密码：" + a4.getPassWord() + ",\t余额为:" + a4.getBalance() + "，\t年利率为：" + BankAccount1.getInterestRate() + ",\t最低存款为：" + BankAccount1.getMinBalance());
        System.out.println("账户：" + a5.getId() + ",\t密码：" + a5.getPassWord() + ",\t余额为:" + a5.getBalance() + "，\t年利率为：" + BankAccount1.getInterestRate() + ",\t最低存款为：" + BankAccount1.getMinBalance());
        System.out.println("账户：" + a6.getId() + ",\t密码：" + a6.getPassWord() + ",\t余额为:" + a6.getBalance() + "，\t年利率为：" + BankAccount1.getInterestRate() + ",\t最低存款为：" + BankAccount1.getMinBalance());

    }
}
//创建类 设计类的成员
class BankAccount1{
    //设计类的属性
    private long id;//账号[1000,9999]随机生成四位数账号
    private String passWord;//密码
    private double balance;//余额

    private static double interestRate;//利率
    private static double minBalance;//最小余额

    //设计类的constructor方法
    public BankAccount1(){

    }
    public BankAccount1(String passWord,double balance){
        this.passWord = passWord;
        this.balance = balance;
        this.id = (long)(Math.random()*(9999-1000+1)+1000);//账号[1000,9999]随机生成四位数账号
    }



    //设计类的方法


    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static double getMinBalance() {
        return minBalance;
    }

    public String getPassWord() {
        return passWord;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount1.interestRate = interestRate;
    }

    public static void setMinBalance(double minBalance) {
        BankAccount1.minBalance = minBalance;
    }
}
