package datastructure.stack;

/**
 @author EddieZhang
 @create 2022-09-18 23:26
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        //模拟计算器 自定一运算优先级
        ArrayStack2 numArrayStack2 = new ArrayStack2(50);//创建一个stack 只存放数值
        ArrayStack2 operatorArrayStack2 = new ArrayStack2(50);//创建一个stack 只存放运算符
        //定义一个运算
        String formula = "321+20*6-1";
        //定义赋值变量
        int index = 0;//用于扫描formula的索引指针
        int num1 = 0;//记录pop出的数值
        int num2 = 0;//记录pop出的数值
        int operator = 0;//记录运算符
        int result = 0;//记录pop数值运算出的结果
        char scan = ' ';//记录每次扫描到的
        //循环扫描 formula的每一个数值以及字符
        while (true) {
            scan = formula.substring(index, index + 1).charAt(0);//将扫描到的一个字符String转成char
            if (index == formula.length() - 1) {//此时扫描到最后一个字符 顺序的从数栈和符号栈中pop出相应的数和符号，并运行.
                numArrayStack2.pushStack(scan - 48);//由于char使用ascii码
                int calculate = 0;
                while (!operatorArrayStack2.isEmpty()) {
                    int i1 = numArrayStack2.popStack();//先pop出一个
                    int i2 = numArrayStack2.popStack();//后pop出一个
                    calculate = numArrayStack2.calculate(i2, i1, operatorArrayStack2.popStack());
                    numArrayStack2.pushStack(calculate);
                }
                break;
            }
            //将扫描到的字符进行判断
            if (operatorArrayStack2.isOperator(scan)) {//判断是否是运算字符 是就往符号栈中进行push 否则就push进数值栈
                if (operatorArrayStack2.isEmpty()) {//判断符号栈是否为空 是就直接将符号push进 否则进行符号优先级的判断
                    operatorArrayStack2.pushStack(scan);
                } else {
                    //operatorArrayStack2.priority(scan);//新扫描到的运算符
                    int i = operatorArrayStack2.popStack();//已经在栈内的运算符
                    //operatorArrayStack2.priority(i);//已经在栈内的运算符
                    if (operatorArrayStack2.priority(scan) > operatorArrayStack2.priority(i)) {//如果新扫描到的运算符 大于原本栈中的运算符 就直接push进栈
                        //将原本的符号push回栈先
                        operatorArrayStack2.pushStack(i);
                        //将新的运算符压入栈
                        operatorArrayStack2.pushStack(scan);
                    } else {//pop出数值栈中的两个数值进行新的运算符的运算
                        //将原本的符号push回栈先
                        operatorArrayStack2.pushStack(i);
                        num1 = numArrayStack2.popStack();//先pop出一个
                        num2 = numArrayStack2.popStack();//后pop出一个
                        result = numArrayStack2.calculate(num2, num1, operatorArrayStack2.popStack());//得到一个运算结果
                        numArrayStack2.pushStack(result);//将运算结果push进数值栈
                        operatorArrayStack2.pushStack(scan);//将运算符push进符号栈
                    }
                }
            } else {//如果是数值就直接入数值栈
                //当处理多位数时候不能发现一个数就直接push进栈 需要判断后续还有没有连续的数字 是不是一个多位数 因此需要继续向后扫描 直至发现后面是一个非数字 而是一个运算符
                String nums = "" + (scan - 48);
                while (true) {//循环扫描后一位 判断后一位是否是数值
                    index++;
                    scan = formula.substring(index, index + 1).charAt(0);//将扫描到的一个字符String转成char
                    if (operatorArrayStack2.isOperator(scan)) {//发现后面是一个非数字 而是一个运算符
                        index--;
                        break;
                    } else {
                        nums += (scan - 48);
                    }
                }
                int i = Integer.parseInt(nums);
                numArrayStack2.pushStack(i);//将字符串中的数值 转成int类型
            }
            //扫描后一个字符
            index++;
        }
        int i = numArrayStack2.popStack();
        System.out.printf("formula结果为: %d", i);
    }
}

//创建一个栈
//数组模拟栈 （扩展相应的功能 检验是数值还是运算符号的功能 已经检测运算符号的优先级）
class ArrayStack2 {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈 数据放在数组中
    private int top = -1;//top表示栈顶 初始化为-1


    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];//初始化模拟栈的数组
    }

    public ArrayStack2() {
    }


    //栈满
    public boolean isFull() {
        return top == maxSize - 1;//
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void pushStack(int value) {
        //先判断栈是否已经满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        //若栈未满 则进行压栈操作
        top++;
        stack[top] = value;
    }

    //出栈
    public int popStack() {
        //先判断是否为空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈是空的");
        }
        //进行弹出栈操作
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况（遍历栈）
    public void showStack() {
        //判断是否为空栈
        if (isEmpty()) {
            throw new RuntimeException("栈是空的");
        }
        //循环遍历栈的数据
        for (int i = top; i > -1; i--) {
            System.out.println(stack[i]);
        }
    }

    //返回运算符的优先级 使用数字表示 数字越大 表明优先级越高
    public int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        }
        if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;//目前表达式只允许纯在+，-，*，/
        }
    }

    //判断是否是一个运算符
    public boolean isOperator(int value) {
        return value == '+' || value == '-' || value == '*' || value == '/';
    }

    //计算方法
    public int calculate(int num1, int num2, int operator) {
        int result = 0;//运算的结果
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        return result;
    }


}