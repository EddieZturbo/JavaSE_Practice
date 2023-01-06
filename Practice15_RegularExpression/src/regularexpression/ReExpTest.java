package regularexpression;

/**
 @author EddieZhang
 @create 2022-09-17 10:41
 */

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegularExpression正则表达式
 * **正则表达式是处理文本的利器**		**正则表达式技术是对字符串进行模式匹配的技术**
 *
 */
public class ReExpTest {
    public static void main(String[] args) {
        //文本内容
        String content = "1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年" +
                " 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 ";

        String str = "(\\d\\d)(\\d\\d)";//编写正则表达式的格式内容 格式中有()表示分组 整体为大组 第一个()为小组1 第二个()为小组2
        //将字符串编译成pattern对象
        Pattern pattern = Pattern.compile(str);
        //pattern对象创建一个matcher匹配器对象
        Matcher matcher = pattern.matcher(content);//将要查询的内容传入匹配器
        while (matcher.find()) {//循环进行find
            System.out.println("文本中出现的年份有\t" + matcher.group());//group默认0 表示 大组 [0,1) 整体的子字符串
            System.out.println("文本中出现的年份(前两个数值)有\t" + matcher.group(1));//表示小组1 [2,3)
            System.out.println("文本中出现的年份(后两个数值)有\t" + matcher.group(2));//表示小组2 [4,5)
//            System.out.println("文本中出现的年份(后两个数值)有\t" + matcher.group(3));//表示小组2 [6,7)
            //...不能取没有的小组 否则报越界的异常 Exception in thread "main" java.lang.IndexOutOfBoundsException: No group 3
            //以下是底层源码
            /*
            public String group(int group) {
                if (first < 0)
                    throw new IllegalStateException("No match found");
                if (group < 0 || group > groupCount())
                    throw new IndexOutOfBoundsException("No group " + group);
                if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
                    return null;
                return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
            }
             */
        }
        /*
        content = "1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年"
        str = "(\d\d)(\d\d)"
        pattern = {Pattern@752} "(\d\d)(\d\d)"
        matcher = {Matcher@753} "java.util.regex.Matcher[pattern=(\d\d)(\d\d) region=0,755 lastmatch=1166]"
         parentPattern = {Pattern@752} "(\d\d)(\d\d)"
         groups = {int[20]@860} [0, 4, 0, 2, 2, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
          0 = 0
          1 = 4
          2 = 0
          3 = 2
          4 = 2
          5 = 4
          6 = -1
          7 = -1
          8 = -1
          9 = -1
          10 = -1
          11 = -1
          12 = -1
          13 = -1
          14 = -1
          15 = -1
          16 = -1
          17 = -1
          18 = -1
          19 = -1
         */


    }

    @Test
    public void test() {
        //内容文本
        String content = "sahfkjahfkjahfkudhfkihdkDKJSAHDKJAHSKDJHAKJHSDKJA1231534213545+*+-289420()=aiub ajkb af-b dusb a--b zjh1277408666@qq.com zjh20001207@icloud.com";
        Pattern compile = Pattern.compile("\\*|-|b");
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.print(matcher.group(0) + "\t");
            //*	-	b	b	-	b	b	-	-	b
        }
    }

    @Test
    public void test1() {
        //内容文本
        String content = "1-akuh -1-a211111aaaaaahello eddie2 eddie irving eddie 3eddie2";
        Pattern compile = Pattern.compile("eddie\\B");
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            //eddie
            //eddie
        }
    }

    /**
     * 非命名捕获
     */
    @Test
    public void test2() {
        //内容文本
        String content = "1-akuh -1-a211111aaaaaahello eddie2 eddie irving eddie 3eddie2";
        Pattern compile = Pattern.compile("([a-z][a-z])([a-z])([a-z][a-z])");
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("得到大组\t" + matcher.group(0));
            System.out.println("得到小组1\t" + matcher.group(1));
            System.out.println("得到小组2\t" + matcher.group(2));
            System.out.println("得到小组3\t" + matcher.group(3));
//            System.out.println("得到小组4\t" + matcher.group(4)); java.lang.IndexOutOfBoundsException: No group 4
//            得到大组	aaaaa
//            得到小组1	aa
//            得到小组2	a
//            得到小组3	aa
//            得到大组	ahell
//            得到小组1	ah
//            得到小组2	e
//            得到小组3	ll
//            得到大组	eddie
//            得到小组1	ed
//            得到小组2	d
//            得到小组3	ie
//            得到大组	eddie
//            得到小组1	ed
//            得到小组2	d
//            得到小组3	ie
//            得到大组	irvin
//            得到小组1	ir
//            得到小组2	v
//            得到小组3	in
//            得到大组	eddie
//            得到小组1	ed
//            得到小组2	d
//            得到小组3	ie
//            得到大组	eddie
//            得到小组1	ed
//            得到小组2	d
//            得到小组3	ie
        }
    }

    /**
     * 命名捕获 可以给分组命名
     */
    @Test
    public void test3() {
        //内容文本
        String content = "1-akuh -1-a211111aaaaaahello eddie2 eddie irving eddie 3eddie2";
        Pattern compile = Pattern.compile("(?<g1>[a-z][a-z])(?<g2>[a-z])(?<g3>[a-z][a-z])");
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("得到大组\t" + matcher.group(0));
            System.out.println("得到小组1\t" + matcher.group("g1"));//可以通过名称来取
            System.out.println("得到小组2\t" + matcher.group("g2"));//可以通过名称来取
            System.out.println("得到小组3\t" + matcher.group("g3"));//可以通过名称来取
//            System.out.println("得到小组4\t" + matcher.group(4)); java.lang.IndexOutOfBoundsException: No group 4
            //得到大组	aaaaa
            //得到小组1	aa
            //得到小组2	a
            //得到小组3	aa
            //得到大组	ahell
            //得到小组1	ah
            //得到小组2	e
            //得到小组3	ll
            //得到大组	eddie
            //得到小组1	ed
            //得到小组2	d
            //得到小组3	ie
            //得到大组	eddie
            //得到小组1	ed
            //得到小组2	d
            //得到小组3	ie
            //得到大组	irvin
            //得到小组1	ir
            //得到小组2	v
            //得到小组3	in
            //得到大组	eddie
            //得到小组1	ed
            //得到小组2	d
            //得到小组3	ie
            //得到大组	eddie
            //得到小组1	ed
            //得到小组2	d
            //得到小组3	ie
        }
    }

    /**
     * 非捕获匹配 匹配 pattern 但是不捕获该匹配的子表达式 不储存供以后使用的匹配 不能使用System.out.println("得到小组1\t" + matcher.group("g1"));
     */
    @Test
    public void test4() {
        //内容文本
        String content = "windows95 windows98 windowsNT windows2000 windows3.1";
//        Pattern compile = Pattern.compile("window95|windows98|windowsNT|windows2000|windows3.1");
        Pattern compile = Pattern.compile("windows(?!95|98|NT|2000)");

        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("得到大组\t" + matcher.group(0));
            //得到大组	windows
        }
    }


    //非贪婪匹配（尽可能匹配少的） Java默认是贪婪匹配 尽可能匹配多的
    @Test
    public void test5() {
        //内容文本
        String content = "JavaJavaJavaJavaJava";
        Pattern compile = Pattern.compile("[Java]+");

        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.print("得到大组\t" + matcher.group(0));
            //得到大组	JavaJavaJavaJavaJava
        }
    }


    //分组 捕获 反向引用
    @Test
    public void test6() {
        //内容
        String regularStr = "12315-555666888 54354-488315646 54641-555666999 48546-464444888 44644555666888";
        Pattern compile = Pattern.compile("\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}");
        Matcher matcher = compile.matcher(regularStr);
        while (matcher.find()) {
            System.out.println("找到 :" + matcher.group(0));
        }

    }

    //将 我....我要...学学学学....编程java! 通过正则表达式修改成    我要学编程java!
    @Test
    public void test7() {
        //内容
        String regularStr = "我....我要...学学学学....编程java!";
        Pattern compile = Pattern.compile("\\.");
        Matcher matcher = compile.matcher(regularStr);
        regularStr = matcher.replaceAll("");
        System.out.println("处理.后的:\t" + regularStr);
        //我我要学学学学编程java!

        //找到文本中与第一次出现的一个字符有重复的所有重复字符
        Pattern compile1 = Pattern.compile("(.)\\1+");
        Matcher matcher1 = compile1.matcher(regularStr);
        while (matcher1.find()) {
            System.out.println(matcher1.group(0));
            //我我
            //学学学学
        }
        //使用反向引用
        regularStr = matcher1.replaceAll("$1");
        //反向引用正则表达式中的组一（第一次出现的一个字符）
        // 替换掉 文本中与第一次出现的一个字符有重复的所有重复字符
        // 即为使用 (.) 取代所有的 (.)\1+
        System.out.println("处理重复后的:\t" + regularStr);
        //我要学编程java!

//        regularStr = Pattern.compile("(.)\\1+").matcher(regularStr).replaceAll("$1");//精简写法
    }


    /**
     * String 使用正则表达式 进行匹配
     */
    @Test
    public void test8() {
        //查看是否是合格的手机号码格式(是否是138/139/139开头的11位)
        String str = "19880895771";
        String str1 = "13927437612";
        if (str.matches("1(37|38|39)\\d{8}")) {
            System.out.println("合格");
        } else {
            System.out.println("不合格");
        }
        //不合格
        if (str1.matches("1(37|38|39)\\d{8}")) {
            System.out.println("合格");
        } else {
            System.out.println("不合格");
        }
        //合格
    }


    /**
     * String 使用正则表达式 进行替换
     */
    @Test
    public void test9() {
        String str = "1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年" +
                " 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 1531年 1166年 " +
                "1531年 1166年 1531年 1166年 1531年 1166年 1531年 ";
        str = str.replaceAll("[1166]{4}", "2000");
        System.out.println("替换后的str :" + str);
        //替换后的str :2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年
        // 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年
        // 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年
        // 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年
        // 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年
        // 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年
        // 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年
        // 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年
        // 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年 2000年 1531年
        // 2000年 1531年
    }

    /**
     * String 使用正则表达式 进行分割
     */
    @Test
    public void test10() {
        //按照要求 出现 # 或者 - 或者 ~ 或者 数字 就进行分割
        String str = "1-aku-h-1-a21#11~11aa4aa2aah-el#loeddie2eddieirvingeddie3eddie2";
        String[] split = str.split("#|~|_|-|\\d+");
        for (String splitStr : split) {
            System.out.print(splitStr + " ");
            //  aku h   a     aa aa aah el loeddie eddieirvingeddie eddie
        }
    }

    /**
     * 验证电子邮件
     * 要求
     * 只能有一个@
     * @前面是用户名，可以是a-z A-Z 0-9 _字符
     * @后面是域名 域名只能是英文字母 icloud.com
     */
    @Test
    public void test11() {
        String email = "20001207@icloud.com";
        if (email.matches("^[\\w-]+@([a-zA-Z]+\\.)+[A-Za-z]+$")) {
            System.out.println("是个email");
        } else {
            System.out.println("非法的email");
        }
    }


    /**
     * 验证是否是正数或负数的小数
     */
    @Test
    public void test12() {
        String[] strings = new String[]{"+123", "-345", "34.89", "-87.9", "-1.01", "0.45"};
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].matches("^(-|\\+)?([1-9]\\d*|0)(\\.\\d*)?$")) {
                System.out.println("匹配成功");
            } else {
                System.out.println("匹配失败");
            }

        }

    }


    /**
     * 对一个url进行解析
     * https://www.bilibili.com:8080/video/BV1fh411y7R8?p=903&spm_id_from=pageDriver&vd_source=714abe81613c048c13e8afe87725981a
     * 1.协议头   https
     * 2.域名     www.bilibili.com
     * 3.端口     8080
     * 4.文件名    BV1fh411y7R8?p=903&spm_id_from=pageDriver&vd_source=714abe81613c048c13e8afe87725981a
     */
    @Test
    public void test13() {
        String url = "https://www.bilibili.com:8080/video/BV1fh411y7R8?p=903&spm_id_from=pageDriver&vd_source=714abe81613c048c13e8afe87725981a";
        Pattern compile = Pattern.compile("^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]+([\\w.?=&]+)$");
        Matcher matcher = compile.matcher(url);
        if (matcher.matches()) {
            System.out.println("整体匹配:" + matcher.group(0));
            System.out.println("协议头:" + matcher.group(1));
            System.out.println("域名:" + matcher.group(2));
            System.out.println("端口:" + matcher.group(3));
            System.out.println("文件名:" + matcher.group(4));
        }
    }

    /**
     * 提取出所有姓名
     */
    @Test
    public void getName(){
        String str = "男子800米：\n" +
                "解天鸣、徐国荣、林家栋、吴杰轩、黄锦栩\n" +
                "女子800米：\n" +
                "巫柔静、杨林、黎庆凤、庞秋燕、黄素燕、\n" +
                "女子1500米：\n" +
                "林易淇、方楚慧、刘晓琳、苏涵、何泳茵\n" +
                "男子1500米：\n" +
                "卢盛培、汪丛睿、蔡享耕、谢轶舟、施铭轩\n" +
                "女子4x100米：\n" +
                "20家具设计一班 林玮莹、王诗懿、梁婧、林素心\n" +
                "20环境设计三班 陈嬿伊、邓雅垚、黎庆凤、丁悦\n" +
                "21服装设计一班 李菁菁、黎舒媚、李佳瑶、韩琳\n" +
                "20广播电视编导二班 曹洋、陈薇、马欣怡、罗舒婷\n" +
                "20服装设计一班 何秋婷、邵佳琪、姜盈、彭凯玲\n" +
                "男子4x100米：\n" +
                "19视觉传达三班 毛泽彭、敖卓帅、曾智航、邹文戈\n" +
                "21服装设计四班 陈俊宏、夏祖超、郭均渝、麦利雄\n" +
                "20广播电视编导二班 林抒涵、杨晓涛\n" +
                "21视觉传达三班 李锐、李子楠、庞东漩、吴国明\n" +
                "20产品造型一班 林家栋、张锦豪、杨家豪、陈颖杰\n" +
                "男子5000米：\n" +
                "翟广权、何晓东、马英焯、蔡炜林、王治\n" +
                "女子3000米：\n" +
                "刘嘉琪、徐星越\n" +
                "女子立定跳远：\n" +
                "侯丽清、陈嬿伊、郑淳丹、孔秋盈\n" +
                "男子立定跳远：\n" +
                "黎泉、郑杰豪、韦焯材、敖卓帅、叶骐汉\n" +
                "女子三级跳远：\n" +
                "林素心、韩佩芸、陈紫宣、彭凯玲、郑晓晴\n" +
                "男子三级跳远：\n" +
                "梁铭彬、麦利雄、王文卓、钟岱言、温铭鑫\n" +
                "男子铅球：\n" +
                "谭森坚、孔梦森、李子楠、陈伊凯、黄朝龙\n" +
                "女子铅球：\n" +
                "肖嘉馨、周运茹、冯家妍、宋晓楠、魏丹、彭秋芬\n" +
                "男子跳高：\n" +
                "李雨泽、乔冬波、伍思炫、李子楠\n" +
                "女子跳高：\n" +
                "谢雨苓、黄楚岚、余玲玲、彭凯玲、李洁\n" +
                "男子100米：\n" +
                "钟豪峻、黄闻威、郭沛源、杨兆男、刘鸿斌\n" +
                "女子100米：\n" +
                "魏孝儒、高丹丹、李佳瑶、王叶勤、谭秀珍\n" +
                "男子200米：\n" +
                "郭沛源、海睿、张德政、钟岱言、杨智杰\n" +
                "女子200米：\n" +
                "李佳瑶、林倩茹、李宝怡、吴忻霖、陈梓婷\n" +
                "男子400米：\n" +
                "李浩、冯孟灯、吴坤、钟永峰、陈梓斌\n" +
                "\n" +
                "女子400米：\n" +
                "刘韵诗、伍嘉仪、张飞扬、巫翰林、张丹丹\n" +
                "\n" +
                "男子200米：\n" +
                "林抒涵、何伟权、陈桢航\n" +
                "女子200米：\n" +
                "张妍毓、郑欣瑶、庞秋燕\n" +
                "男子400米：\n" +
                "范楚君、陈俊宏、海睿\n" +
                "女子400米：\n" +
                "陈可轩、张妍毓、叶小铭\n" +
                "男子800米：\n" +
                "卢盛培、冯孟灯、钟一鸣\n" +
                "女子800米：\n" +
                "叶小铭、陈可轩、刘韵诗\n" +
                "女子1500米：\n" +
                "蔡茵茵、韦希彤、郭海鹭\n" +
                "男子1500米：\n" +
                "刘鸿斌、叶承轩、翟耀男\n" +
                "女子4x100米：\n" +
                "21产品设计一班 魏孝儒、梁栩如、杨林、张舒涵、\n" +
                "20服装设计与工程二班 郑欣瑶、王叶勤、陈可轩、谭思捷\n" +
                "20产品造型二班 古珊珊、冯思琦、方慧苗、陈思茵\n" +
                "男子4x100米：\n" +
                "20环境设计一班 陈桢航、李昌霖、黎羽常、刘宏宇\n" +
                "21环境设计二班 叶骐汉、王家骏、范楚君、何晓东\n" +
                "20环境设计三班 林澄宇、伍思炫、范永龙、石展豪\n" +
                "四到八名\n" +
                "女子跳远：\n" +
                "严梓晴、黄玮婷、李菁菁、李征、区佩怡\n" +
                "男子跳远：\n" +
                "马英焯、梁峰萍、黎泉、严振宁、华英健\n" +
                "仰卧起坐：\n" +
                "杨雨欣、彭佳萌、施雯、王倩、蔡莹、冯安姿\n" +
                "\n" +
                "引体向上：\n" +
                "梁梦华、韦焯材、汪丛睿、张锦豪、卓振生\n" +
                "／／一至三名\n" +
                "女子跳远：\n" +
                "杨林、古珊珊、谢雨心\n" +
                "男子跳远：\n" +
                "陈俊宏、范楚君、张荻湘\n" +
                "仰卧起坐：\n" +
                "王欣、彭健怡、王彩钰\n" +
                "引体向上：\n" +
                "万霖声、何晓东、陈泽骞\n" +
                "男子5000米：\n" +
                "叶俊杰、卓振生、叶承轩\n" +
                "女子3000米：\n" +
                "魏孝儒、林蓥、黄素燕\n" +
                "女子立定跳远：\n" +
                "郭霓儿、邓洁杏、宋金歌、杨晓滢\n" +
                "男子立定跳远：\n" +
                "吴炫璋、杜昊哲、曾柏森\n" +
                "女子三级跳远：\n" +
                "张映琪、贺婷妮、曾紫媚\n" +
                "男子三级跳远：\t\n" +
                "翁瀚尧、孙庶杰、华英健\n" +
                "男子铅球：\n" +
                "赵曰溥、戚溢朗、周子浩\n" +
                "女子铅球：\n" +
                "陈桂纯、盘思婷、喻佩\n" +
                "男子跳高：\n" +
                "翁瀚尧、孙庶杰、余常乐、温铭鑫\n" +
                "女子跳高：\n" +
                "张映琪、张子琪、黄玮婷\n" +
                "男子100米：\n" +
                "林抒涵、余常乐、杨炎坤\n" +
                "\n" +
                "女子100米：\n" +
                "华南农业大学\n" +
                "古珊珊、李宗仪、陈思祺\n";

        Pattern compile = Pattern.compile("[\\u4e00-\\u9fa5]{2,4}");
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }


    }
    }


