package bufferedfilereaderwritertest;

/**
 * @author EddieZhang
 * @create 2022-08-18 10:57
 */

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 获取文本上每个字符出现的次数
 * 提示：遍历文本的每一个字符；字符及出现的次数保存在Map中；将Map中数据写入文件
 * <p>
 * 思路：
 * * 1.遍历文本每一个字符
 * * 2.字符出现的次数存在Map中
 */
public class BufferedFileWriterTest1Practice {
    @Test
    public void test() {

        BufferedWriter bufferedWriter = null;//实例化缓冲流写出map集合中存储的数据-指明要写出为的file
        try {
            Map<Character, Integer> map = new HashMap();//创建Map<Character,Integer>存放字符和对应出现的次数
            File file1 = new File("HelloEddieTest.txt");//实例化File
            FileReader fileReader1 = new FileReader(file1);//实例化节点流读入file
            bufferedWriter = new BufferedWriter(new FileWriter(new File("HelloEddieTestCharCount.txt")));
            //读入文件并按照字符以及字符出现的次数存储到map中
            int count;//记录读取到的每个字符
            while ((count = fileReader1.read()) != -1) {
                char charCount = (char) count;
                if (map.get(charCount) == null) {//判断charCount是否第一次出现
                    map.put(charCount, 1);
                } else {
                    map.put(charCount, map.get(charCount) + 1);
                }
            }

            //遍历map中存储的数据并写出到文件中
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();//获取map集合中的entry--获取为Set

            for (Map.Entry<Character, Integer> entry :
                    entrySet) {
                switch (entry.getKey()) {//getKey()通过key值确定写出格式--getValue()为字符出现次数
                    case ' ':
                        bufferedWriter.write("空格=" + entry.getValue());
                        break;
                    case '\t':
                        bufferedWriter.write("Tab键字符=" + entry.getValue());
                        break;
                    case '\n':
                        bufferedWriter.write("换行=" + entry.getValue());
                        break;
                    case '\r':
                        bufferedWriter.write("回车=" + entry.getValue());
                        break;
                    default://除了以上列出的特殊字符外 都按照以下方式（字符以及出现次数）写出
                        bufferedWriter.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                bufferedWriter.newLine();//换行
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
