package fileutilstest;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 @author EddieZhang
 @create 2022-08-18 18:52
 */
/*
        commons-io-2.5.jar提供了许多现成的API
 */
public class FileUtilsTest {
    public static void main(String[] args) {
        try {
            FileUtils.copyFile(new File("Practice9_IO\\1 wbNftKjM0CGqzH-7AnHrYQ4.jpeg"),new File("Practice9_IO\\1 wbNftKjM0CGqzH-7AnHrYQ5.jpeg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
