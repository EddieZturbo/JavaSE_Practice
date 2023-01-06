package datastructure.sparsearray;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * SparseArray--稀疏数组
 */
@SuppressWarnings(value = "all")
public class SparseArray2 {
    private static File fileInputStream;

    public static void main(String[] args) {
        /**
         * 初始化二维数组
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 1 0 0 0 0 0 0 0 0
         *     0 0 0 0 2 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         */
        int[][] array = new int[11][11];//动态初始化一个二维数组
        //给数组赋值有效元素
        array[1][2] = 1;
        array[2][4] = 2;
        //遍历二维数组
        System.out.println("-----------------------------遍历二维数组-----------------------------");
        for (int[] row :
                array) {
            for (int item :
                    row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        //将二维数组转成稀疏数组
        System.out.println("-----------------------------将二维数组转成稀疏数组-----------------------------");
        /*
            稀疏数组的格式
            11 11 2----行数 列数 有效值个数（从第二行为有效值的信息）
            1  2  1----有效值的行数 有效值的列数 有效值的值
            2  4  2----有效值的行数 有效值的列数 有效值的值
            ...        有效值的行数 有效值的列数 有效值的值
         */
        //遍历二维数组 得到有效值的个数 可以确定第一行的信息以及稀疏数组的行数
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array[i][j] != 0) {//判断是否为有效值
                    count++;
                }
            }

        }
        //初始化一个稀疏数组
        int[][] sparseArray = new int[count + 1][3];//根据获取到的有效值个数信息 动态初始化稀疏数组
        //赋值稀疏数组的第一行
        sparseArray[0][0] = 11; //行数
        sparseArray[0][1] = 11; //列数
        sparseArray[0][2] = count; //有效值个数
        //赋值稀疏数组的有效值行 通过遍历二维数组的有效值给稀疏数组相应的赋值
        int numRows = 1;//稀疏数组的行 从索引为1的第二行开始（有效值从第二行开始）
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array[i][j] != 0) {//判断是否为有效值
                    sparseArray[numRows][0] = i;//有效值的行数
                    sparseArray[numRows][1] = j;//有效值的列数
                    sparseArray[numRows][2] = array[i][j];//有效值的值
                    numRows++;
                }
            }
        }
        //遍历稀疏数组
        for (int[] rows :
                sparseArray) {
            for (int item :
                    rows) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        //将稀疏数组转成二维数组
        System.out.println("-----------------------------将稀疏数组转成二维数组-----------------------------");
        //创建二维数组并初始化二维数组
        int[][] oldArray = new int[sparseArray[0][0]][sparseArray[0][1]];//数组的外层行数和内层列数 分别赋值为稀疏数组第一行的第一个元素和第二个元素
        //根据稀疏数组有效值信息给二维数组相应的位置赋上有效值
        //遍历稀疏数组除第一行后的每一行（有效值行）
        for (int i = 1; i < sparseArray.length; i++) {
            oldArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //遍历二维数组
        for (int[] row :
                oldArray) {
            for (int item :
                    row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        //将稀疏数组储存至磁盘中
        System.out.println("-----------------------------将稀疏数组储存至磁盘中-----------------------------");
        sparseArrayToIo(sparseArray);

        //读取磁盘中的稀疏数组数据到内存中
        System.out.println("-----------------------------读取磁盘中的稀疏数组数据到内存中-----------------------------");
        int[][] sparseArrayFromIo = sparseArrayFromIo("spareArray3.txt");
        //遍历稀疏数组
        for (int[] rows :
                sparseArrayFromIo) {
            for (int item :
                    rows) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }

    /*
     * @Description 将稀疏数组储存至磁盘中
     * @Author EddieZhang
     * @Date 2022/9/10 10:44
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public static void sparseArrayToIo(int[][] sparseArray) {
        FileOutputStream fileOutputStream = null;
        try {
            //指定要储存到的文件
            File file = new File("spareArray3.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            //造流
            fileOutputStream = new FileOutputStream(file);
            //将数据写入到流中
            for (int i = 0; i < sparseArray.length; i++) {
                for (int j = 0; j < 3; j++) {
                    fileOutputStream.write(sparseArray[i][j]);
                }

            }
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * @Description 读取磁盘中的稀疏数组数据到内存中--(使用map集合来接收)
     * @Author EddieZhang
     * @Date 2022/9/10 10:54
     * @Param [file]
     * @Return int[][]
     * @Since version-1.0
     */
    public static int[][] sparseArrayFromIo(String path) {
        FileInputStream fileInputStream = null;
        try {
            //指定要读取的文件
            File file = new File(path);
            //造流
            fileInputStream = new FileInputStream(file);
            //定义一个map集合用来储存读取到的数据
            Map<Integer,Integer> map = new HashMap<>();
            //定义两个变量 分别表示key和value
            int k = 0;
            int v = 0;
            while((v = fileInputStream.read()) != -1){
                map.put(k,v);
                k++;
            }
            //此时map集合中储存了稀疏数组
            //创建一个二维数组 将map集合中的数据赋值给二维数组
            int index = 0;
            int [][] sparseArray = new int[map.size() / 3][3];
            for (int i = 0; i < map.size() / 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sparseArray[i][j] = map.get(index);
                    index++;
                }
            }
            return sparseArray;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null){
        //释放资源
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
