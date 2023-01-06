package datastructure.sparsearray;

/**
 @author EddieZhang
 @create 2022-09-08 23:31
 */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 稀疏数组
 */
public class SparseArray {
    /**
     *     稀疏数组可以简单的看作为是压缩，在开发中也会使用到。比如将数据序列化到磁盘上，减少数据量，在IO过程中提高效率等等。
     *
     *         为什么要进行压缩？
     *              - 由于稀疏矩阵中存在大量的“空”值，占据了大量的存储空间，而真正有用的数据却少之又少，
     *              - 且在计算时浪费资源，所以要进行压缩存储以节省存储空间和计算方便。
     *
     */
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
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][4] = 2;
        for (int[] row : array) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        System.out.println("-------------------------------------------------------------------------");
        //将二维数组转换成稀疏数组
        /*
        稀疏数组
        11 11 2
        1  2  1
        2  4  2
        //第一行存储原始数据总行数，总列数，总的非0数据个数（有效数据个数）
        //接下来每一行都存储非0数所在行，所在列，和具体值

        1.要遍历普通数组得到有多少有效数据的个数
        2.创建稀疏数组
        3.给稀疏数组赋值
         */
        //得到有效数据个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("array数组中共有 " + sum + " 个有效数据");
        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];//行数是由有效数据的个数加上1 列数固定是3
        //给稀疏数组赋值--第一行
        sparseArray[0][0] = 11;//稀疏数组第一行第一列填写原数组的行数
        sparseArray[0][1] = 11;//稀疏数组第一行第二列填写原数组的列数
        sparseArray[0][2] = sum;//稀疏数组第一行第三列填写有效数据的个数

        //给稀疏数组赋值--第一行以后的有效数据行
        int count = 0;//标识第几个有效数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;//稀疏数组有效数据行第一列填写所在原数组的行数
                    sparseArray[count][1] = j;//稀疏数组有效数据行第二列填写所在原数组的列数
                    sparseArray[count][2] = array[i][j];//稀疏数组有效数据行第三列填写有效数据的值
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

        System.out.println("----------------------------------------------------------------------------");
        //将稀疏数组转成普通数组
        //初始化二维数组 将稀疏数组中的第一行存储原始数据总行数，总列数作为二维数组的外层和内存的长度
        int[][] oldArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        //将有效数据按照稀疏数组中的位置赋值到二维数组相应的位置中
        //遍历稀疏数组拿到有效数据的位置以及值的信息
        for (int i = 1; i <= count; i++) {//从稀疏数组的第二行遍历（稀疏数组中有效值具体信息从第二行开始）
            oldArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];//将（稀疏数组中从第二行开始存储有效值的所在行，所在列，和具体值）赋给二维数组相应的位置
        }
        //遍历普通数组
        for (int[] rows :
                oldArray) {
            for (int item :
                    rows) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        System.out.println("--------------------------------------------------------------------------------");
        // 将稀疏数组储存至磁盘中
        sparseArrayToIo(sparseArray);
        System.out.println("--------------------------------------------------------------------------------");
        //将稀疏数组从磁盘中读取
        int[][] sparseArrayFromIo = sparseArrayFromIo("spareArray.txt");
        for (int[] row :
                sparseArrayFromIo) {
            for (int item :
                    row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }


    }

    /*
        将稀疏数组储存至磁盘中
     */
    public static void sparseArrayToIo(int[][] sparseArray) {
        FileWriter fileWriter = null;
        try {
            //指明要储存的路径
            File file = new File("spareArray.txt");
            if (!file.exists()) {//判断文件是否已经存在 若不存在则新建文件
                file.createNewFile();
            }
            //造流
            fileWriter = new FileWriter(file);
            //遍历稀疏数组并将数组中的数据写入到流中
            for (int i = 0; i < sparseArray.length; i++) {//外层循环
                for (int j = 0; j < 3; j++) {//内层循环
                    fileWriter.write(sparseArray[i][j]);
                }
            }
            fileWriter.flush();//刷新
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //释放资源
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /*
        将稀疏数组从磁盘中读取
     */
    public static int[][] sparseArrayFromIo(String pathName) {
        FileReader fileReader = null;
        int[][] oldSparseArray = new int[0][];//动态初始化稀疏数组
        try {
            //指定要读取的文件的地址
            File file = new File(pathName);
            //造流
            fileReader = new FileReader(file);
            //造map集合将读取到的稀疏数组放到map集合中
            Map<Integer,Integer> map = new HashMap<>();
            int k = 0;//key
            int v = 0;//value
            while((v = fileReader.read()) != -1){
                map.put(k,v);
                k++;
            }

            //将map读取到的数据对应的赋值到稀疏数组中
            oldSparseArray = new int[map.size()/3][3];
            //循环遍历稀疏数组 将map中的数据对应的赋值给稀疏数组
            int index = 0;//map的key
            for (int i = 0; i < oldSparseArray.length; i++) {
                for (int j = 0; j < 3; j++) {
                    oldSparseArray[i][j] = map.get(index);
                    index++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return oldSparseArray;
        }

    }
}
