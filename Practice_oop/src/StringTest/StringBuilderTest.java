package StringTest;

/**
 @author EddieZhang
 @create 2023-02-06 2:47 PM
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            stringBuffer.append((char) ('A' + i));
        }
        System.out.println(stringBuffer.toString());
    }
}
