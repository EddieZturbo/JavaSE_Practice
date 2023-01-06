package exceptionhandingtest;

/**
 * @author shkstart
 * @create 2022-08-04 15:44
 */
public class EcmDef {
    public static void main(String[] args) {
        try{{
        }
        int i = Integer.parseInt(args[0]);
        int j = Integer.parseInt(args[1]);
        int result = new EcmDef().ecm(i,j);

            System.out.println(result);
        }catch (NumberFormatException e){
            System.out.println("对 数 据 类 型 不 一 致 ");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("缺 少 命 令 行 参 数");
        }catch (ArithmeticException e){
            System.out.println("除0");
        }catch (EcDef e){
            System.out.println(e.getMessage());
        }
    }
    public static int ecm(int i,int j) throws EcDef {
        if(i < 0 || j < 0){
            throw new EcDef("分子或者分母为负数了哦！！");
        }
        return i / j;
    }
}
