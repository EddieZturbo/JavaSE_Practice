package internetaddresstest;

/**
 @author EddieZhang
 @create 2022-08-19 9:15
 */

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 */
public class URLTest1 {
    @Test
    public void test(){
        HttpURLConnection httpURLConnection = null;//url.openConnection()打开连接
        InputStream inputStream = null;//写入 获取输入流
        FileOutputStream fileOutputStream = null;//实例化输出流 指明输出到的文件位置
        try {
            URL url = new URL("http://localhost:8080/examples/kyrie-rockets.jpg");//实例化URL--指明文件对象资源地址

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();
            fileOutputStream = new FileOutputStream(new File("kyrie-rockets1.jpg"));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {//对数据进行读入和写出操作
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        } finally {//关闭资源
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            if(httpURLConnection != null){
                httpURLConnection.disconnect();

            }
        }
    }
}
