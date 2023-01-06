package datastructure.queue;

/**
 @author EddieZhang
 @create 2022-09-12 10:49
 */

import java.util.Scanner;

/**
 * 数组模拟队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试环形数组队列");
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(5);//队列有效空间为4
        //从控制台接收
        Scanner scanner = new Scanner(System.in);
        char key = ' ';//从控制台接收用户输入
        //创建一个menu
        boolean flag = true;
        while(flag){
            System.out.println("s(show):    显示队列");
            System.out.println("e(exit):    退出");
            System.out.println("a(add):    添加数据");
            System.out.println("g(get):    取出数据");
            System.out.println("h(head):    获得第一个数据");
            System.out.print("请输入选项:");
            key = scanner.next().charAt(0);//接收一个字符  Scanner源码中,我们可知输入String类型实际是调用了next()方法,而输入字符实际上还是输入字符串,然后取字符串的第一个字符.即str.charAt(0)
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    flag = false;
                    break;
                case 'a':
                    System.out.print("请输入一个数值:");
                    int anInt = scanner.nextInt();
                    arrayQueue.addQueue(anInt);
                    break;
                case 'g':
                    try {
                        int i = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i1 = arrayQueue.getFront();
                        System.out.printf("头数据是%d\n",i1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
            }


        }

    }
}

/*
 * @Description 环形数组模拟队列 编写一个类
 * @Author EddieZhang
 * @Date 2022/9/12 10:51
 * @Since version-1.0
 */
class ArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front;//队列头 指向队列的第一个元素 初始值为0
    private int rear;//队列尾 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定 默认值为0
    private int[] array;//数组 用来储存队列数据 模拟队列

    public ArrayQueue(int maxSize) {//构造器创造数组对象 传入数组的最大容量 maxSize
        this.maxSize = maxSize;
        array = new int[this.maxSize];
    }

    public boolean isFull() {//判断环形数组是否已经满
        if ((rear + 1) % maxSize == front) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isEmpty(){//判断环形数组知否为空
        if(front == rear){
            return true;
        }else{
            return false;
        }
    }
    public void addQueue(int num){
        if(isFull()){//判断是否已满 未满可以添加数据
            System.out.println("队列已满，无法继续添加了哦~~");
            return;
        }
        //可以进行添加
        array[rear] = num;
        //将rear后移一个索引位置
        rear = (rear + 1) % maxSize;//考虑取模（保证在maxSize内循环）
    }
    public int getQueue(){
        if(isEmpty()){//判断是否队列是否为空
            throw new RuntimeException("队列为空 无法取出数据~~");
        }
        //将数据保存到临时变量中 将front后移一个索引位置 返回数据
        int temp = array[front];
        front = (front + 1)%maxSize;//考虑取模（保证在maxSize内循环）
        return temp;
    }
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        //遍历 从front开始遍历 考虑遍历多少个（遍历有效值个）
        for (int i = front; i < front + numQueue(); i++) {
            System.out.printf("array[%d]=%d\n",i % maxSize,array[i % maxSize]);
        }

    }
    /*
     * @Description 求队列中有多少个有效值
     * @Author EddieZhang
     * @Date 2022/9/12 15:19
     * @Param []
     * @Return int
     * @Since version-1.0
     */
    public int numQueue(){
        return (rear - front + maxSize)%maxSize;
    }
    public int getFront(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return array[front];

    }


}