package Test;

import java.util.ArrayList;
import java.util.Random;

/**
 @author EddieZhang
 @create 2022-09-27 12:20
 */
public class OOMTest {
    byte[] buffer = new byte[new Random().nextInt(1024 * 200)];

    public static void main(String[] args) {
        ArrayList<OOMTest> list = new ArrayList<OOMTest>();
        while (true) {
            list.add(new OOMTest());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
