package fileclasstest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author EddieZhang
 * @create 2022-08-16 21:03
 */
/*
package java.io;
 java.io.File类：文件和文件目录路径的抽象表示形式，与平台无关
 File 能新建、删除、重命名文件和目录，但 File 不能访问文件内容本身。如果需要访问文件内容本身，则需要使用输入/输出流(IO Stream)。
 想要在Java程序中表示一个真实存在的文件或目录，那么必须有一个File对象，但是Java程序中的一个File对象，可能没有一个真实存在的文件或目录。
 File对象可以作为参数传递给流的构造器--指明读取/写入的 “目标 ”

*File 类的使用：常用构造器
 public File(String pathname)
    以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储。
         绝对路径：是一个固定的路径,从盘符开始
         相对路径：是相对于某个位置开始
 public File(String parent,String child)
    以parent为父路径，child为子路径创建File对象。
 public File(File parent,String child)
    根据一个父File对象和子文件路径创建File对象

*File 类的使用：路径分隔符
 路径中的每级目录之间用一个路径分隔符隔开。
 路径分隔符和系统有关：
 windows和DOS系统默认使用“\”来表示
 UNIX和URL使用“/”来表示
 Java程序支持跨平台运行，因此路径分隔符要慎用。
 为了解决这个隐患，File类提供了一个常量：
public static final String separator。根据操作系统，动态的提供分隔符
//For instance:
File file1 = new File("d:\\atguigu\\info.txt");
File file2 = new File("d:" + File.separator + "atguigu" + File.separator + "info.txt");
File file3 = new File("d:/atguigu");

*File 类的使用：常用方法
 File类的获取功能
 public String getAbsolutePath()：获取绝对路径
 public String getPath() ：获取路径
 public String getName() ：获取名称
 public String getParent()：获取上层文件目录路径。若无，返回null
 public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
 public long lastModified() ：获取最后一次的修改时间，毫秒值
以下两个方法适用于文件目录
 public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
 public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
 File类的重命名功能
 public boolean renameTo(File dest):把文件重命名为指定的文件路径
 File类的判断功能
 public boolean isDirectory()：判断是否是文件目录
 public boolean isFile() ：判断是否是文件
 public boolean exists() ：判断是否存在
 public boolean canRead() ：判断是否可读
 public boolean canWrite() ：判断是否可写
 public boolean isHidden() ：判断是否隐藏
 File类的创建功能
 public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
 public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
 public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下。
 File类的删除功能
 public boolean delete()：删除文件或者文件夹删除注意事项：
Java中的删除不走回收站。
要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录

 */
public class FileClassTest {
    /*
    File类的实例化
    构造器
     public File(String pathname)
        以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储。
             绝对路径：是一个固定的路径,从盘符开始
             相对路径：是相对于某个位置开始
     public File(String parent,String child)
        以parent为父路径，child为子路径创建File对象。
     public File(File parent,String child)
        根据一个父File对象和子文件路径创建File对象

    *尚未在硬盘层面存在真实的文件--只是内存层面 File类的对象*

     */
    @Test
    public void test() {
        // public File(String pathname)
        //        以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储。
        //             绝对路径：是一个固定的路径,从盘符开始
        //             相对路径：是相对于某个位置开始

        File file = new File("hello.txt");// 相对路径：是相对于某个位置开始
        File file1 = new File("D:\\Java18.0.0.0\\IntelliJ_IDLE\\Practice\\Practice9_IO\\Hello.txt");// 绝对路径：是一个固定的路径,从盘符开始
        System.out.println(file);//hello.txt
        System.out.println(file1);//D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice9_IO\Hello.txt

        // public File(String parent,String child)
        //    以parent为父路径，child为子路径创建File对象。

        File file2 = new File("D:\\Java18.0.0.0", "IntelliJ_IDLE");
        System.out.println(file2);//D:\Java18.0.0.0\IntelliJ_IDLE

        // public File(File parent,String child)
        //    根据一个父File对象和子文件路径创建File对象

        File file3 = new File(file2, "hi.txt");
        System.out.println(file3);//D:\Java18.0.0.0\IntelliJ_IDLE\hi.txt
    }


    /*
    File 类的使用：常用方法
         File类的获取功能
             public String getAbsolutePath()：获取绝对路径☆
             public String getPath() ：获取路径
             public String getName() ：获取名称
             public String getParent()：获取上层文件目录路径。若无，返回null☆
             public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
             public long lastModified() ：获取最后一次的修改时间，毫秒值
            以下两个方法适用于文件目录
             public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
             public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
     */
    @Test
    public void test1() {
        File file = new File("hello.txt");// 相对路径：是相对于某个位置开始
        File file1 = new File("D:\\Java18.0.0.0\\IntelliJ_IDLE\\Practice\\Practice9_IO\\Hello.txt");// 绝对路径：是一个固定的路径,从盘符开始

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(new Date(file.lastModified()));
        //hello.txt
        //hello.txt
        //null
        //10
        //Tue Aug 16 21:36:42 CST 2022
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice9_IO\Hello.txt
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice9_IO\Hello.txt
        //Hello.txt
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice9_IO
        //0
        //0
        System.out.println("-----------------------------------------------------------------------------------------");
        File file2 = new File("D:\\Java18.0.0.0\\IntelliJ_IDLE\\Practice");// 绝对路径：是一个固定的路径,从盘符开始
        String[] listFileName = file2.list();
        String toString = listFileName.toString();
        for (String listFileNames :
                listFileName) {
            System.out.println(listFileNames.toString());
        }
        //.idea
        //leetcodepractice
        //out
        //Practice1_Thread
        //Practice2_String
        //Practice3_Enumeration
        //Practice4_Annotation
        //Practice5_Collection
        //Practice6_Time
        //Practice7_Comparable
        //Practice8_Generic
        //Practice9_IO
        //PracticeProject2
        //PracticeProject3
        //Practice_oop
        //Project.iml
        //
        //Process finished with exit code 0
        System.out.println("-----------------------------------------------------------------------------------------");
        File[] files = file2.listFiles();
        for (File filesFile :
                files) {
            System.out.println(filesFile.toString());
        }
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\.idea
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\leetcodepractice
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\out
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice1_Thread
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice2_String
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice3_Enumeration
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice4_Annotation
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice5_Collection
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice6_Time
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice7_Comparable
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice8_Generic
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice9_IO
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\PracticeProject2
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\PracticeProject3
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Practice_oop
        //D:\Java18.0.0.0\IntelliJ_IDLE\Practice\Project.iml

    }

    /*
         File类的重命名功能
             public boolean renameTo(File dest):把文件重命名为指定的文件路径
            file.renameTo(file1);--重命名file的文件路径变成-->file1路径
            要求:file在硬盘中真实存在;file1不能在硬盘中真实存在
            //变回来--
            renameTo1 = file1.renameTo(file);
     */
    @Test
    public void test2() {
        File file = new File("hello.txt");// 相对路径：是相对于某个位置开始
        File file1 = new File("D:\\Java18.0.0.0\\IntelliJ_IDLE\\Practice\\Practice9_IO\\Hello.txt");// 绝对路径：是一个固定的路径,从盘符开始
        boolean renameTo = file.renameTo(file1);
        System.out.println(renameTo);
        //true

        //变回来--
        boolean renameTo1 = file1.renameTo(file);
        System.out.println(renameTo1);
    }

    /*
         File类的判断功能
             public boolean isDirectory()：判断是否是文件目录
             public boolean isFile() ：判断是否是文件
             public boolean exists() ：判断是否存在
             public boolean canRead() ：判断是否可读
             public boolean canWrite() ：判断是否可写
             public boolean isHidden() ：判断是否隐藏
     */
    @Test
    public void test3() {
        File file = new File("hello.txt");// 相对路径：是相对于某个位置开始(真实存在)
        File file1 = new File("hello1.txt");// 相对路径：是相对于某个位置开始(不存在)

        System.out.println(file.isDirectory());//判断是否是文件目录
        System.out.println(file.isFile());//判断是否是文件
        System.out.println(file.exists());//判断是否存在
        System.out.println(file.canRead());//判断是否可读
        System.out.println(file.canWrite());//判断是否可写
        System.out.println(file.isHidden());//判断是否隐藏
        //false
        //true
        //true
        //true
        //true
        //false
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(file1.isDirectory());//判断是否是文件目录
        System.out.println(file1.isFile());//判断是否是文件
        System.out.println(file1.exists());//判断是否存在
        System.out.println(file1.canRead());//判断是否可读
        System.out.println(file1.canWrite());//判断是否可写
        System.out.println(file1.isHidden());//判断是否隐藏
        //false
        //false
        //false
        //false
        //false
        //false
        //false
    }

    /*
         File类的创建功能
             public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
             public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
             public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建;注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下
         File类的删除功能
             public boolean delete()：删除文件或者文件夹删除注意事项：
            Java中的删除不走回收站。
            要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
     */
    @Test
    public void test4() throws IOException {
        File file = new File("hi.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Create file success！");
        } else {//文件存在
            file.delete();
            System.out.println("Delete file success！");
        }


    }

    /**
     *  public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
     *  public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建;注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下
     */
    @Test
    public void test5() {
        File file = new File("D:\\Java18.0.0.0\\IntelliJ_IDLE\\Practice\\Practice9_IO1\\hi.txt");//不存在 同时上一层dir也不存在
        boolean mkdir = file.mkdir();//创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建
        if(mkdir){
            System.out.println("Create dir success!");
        }

        boolean mkdirs = file.mkdirs();
        if(mkdirs){
            System.out.println("Create dirs success!");//创建文件目录。如果上层文件目录不存在，一并创建注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下
        }
        //Create dirs success!

    }
}
