package Test;

/**
 @author EddieZhang
 @create 2022-10-07 22:29
 */
public class ConstructorTest {
    public class Base{
        int w, x, y ,z;
        public Base(int a,int b)
        {
            x=a; y=b;
        }
        public Base(int a, int b, int c, int d)
        {
            this(a,b);
            w=d;z=c;
        }}
}
