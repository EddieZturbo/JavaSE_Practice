package datastructure.stack;

/**
 @author EddieZhang
 @create 2022-09-17 22:55
 */

import org.junit.Test;

import java.util.Scanner;

/**
 * 栈 后进先出
 */
public class StackDome {
    @Test
    public void testArrayStack() {
        ArrayStack arrayStack = new ArrayStack(4);//表示一个栈
        String option = "";//用来接收控制台输入的选项
        boolean flag = true;//控制菜单是否退出
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("show:  表示显示栈");
            System.out.println("exit:  退出程序");
            System.out.println("push:  添加数据到栈");
            System.out.println("pop :  从栈中取出栈");
            System.out.print("请输出您的选择:");
            option = scanner.next();
            switch (option) {
                case "show":
                    try {
                        arrayStack.showStack();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    System.out.print("请输入一个数值");
                    int anInt = scanner.nextInt();
                    arrayStack.pushStack(anInt);
                    break;
                case "pop":
                    try {
                        int value = arrayStack.popStack();
                        System.out.println(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

    public static void main(String[] args) {

        SingleLinkedStack singleLinkedStack = new SingleLinkedStack();

        String option = "";//用来接收控制台输入的选项
        boolean flag = true;//控制菜单是否退出
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("show:  表示显示栈");
            System.out.println("exit:  退出程序");
            System.out.println("push:  添加数据到栈");
            System.out.println("pop :  从栈中取出栈");
            System.out.print("请输出您的选择:");
            option = scanner.next();
            switch (option) {
                case "show":
                    try {
                        singleLinkedStack.showStack();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        ;
                    }
                    break;
                case "push":
                    System.out.print("请输入一个数值");
                    int anInt = scanner.nextInt();
                    Node node = new Node(anInt);
                    singleLinkedStack.pushStack(node);
                    break;
                case "pop":
                    try {
                        singleLinkedStack.popStack();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

//数组模拟栈
class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈 数据放在数组中
    private int top = -1;//top表示栈顶 初始化为-1


    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];//初始化模拟栈的数组
    }

    public ArrayStack() {
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
}

//单链表模拟栈
class SingleLinkedStack {

    private Node firstNode;

    public SingleLinkedStack() {//空参构造器中初始化链表的头节点 数据为空
        firstNode = new Node();
    }

    //判断链表是否无有效节点
    public boolean isEmpty() {
        if (firstNode.getNext() == null) {
            return true;
        } else {
            return false;
        }
    }

    //模拟栈的push方法
    public void pushStack(Node node) {
        //由于要保留头节点 这里使用临时遍历 用于遍历链表节点
        Node temp = firstNode;
        //判断链表是否为空
        if (isEmpty()) {
            firstNode.setNext(node);
            return;
        }
        //如果链表中已经有数据了
        //循环遍历到链表的节点 直至最后一个节点 将新节点接至最后
        while (true) {
            if (temp.getNext() == null) {//此时的temp为原链表中的最后一个节点 将新节点接至temp后
                temp.setNext(node);
                break;
            }
            //将temp节点后移
            temp = temp.getNext();
        }
    }

    //模拟栈的pop方法
    public void popStack() {
        //由于头节点要保留 这里使用临时遍历 用于遍历链表节点
        Node temp = firstNode;
        //判断链表是否为空
        if (firstNode.getNext() == null) {
            throw new RuntimeException("栈是空的哦~~");
        }
        //链表有数据是 要模拟栈的先进后出特性 因此 要将链表的最后一个节点弹出
        while (true) {
            if (temp.getNext().getNext() == null) {//判断temp是否属于原本链表中的倒数第二个节点 将temp的next指向null(即将原本链表中的最后节点移除)
                System.out.println("弹出栈的是 :" + temp.getNext().toString());
                temp.setNext(null);
                break;
            }
            //temp后移
            temp = temp.getNext();
        }
    }


    //模拟栈的show方法
    public void showStack() {
        //判断是否为空栈
        if (isEmpty()) {
            throw new RuntimeException("栈是空的");
        }
        //链表模拟循环遍历栈的数据
        //由于头节点要保留 这里使用临时遍历 用于遍历链表节点
        Node temp = firstNode;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            System.out.println(temp.getNext());
            //后移temp
            temp = temp.getNext();
        }

    }


    @Override
    public String toString() {
        return "SingleLinkedStack{" +
                "firstNode=" + firstNode +
                '}';
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }
}

//链表的节点类
class Node {
    private int item;
    private Node next;//指向next

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int item) {
        this.item = item;
    }

    public Node() {
    }
}
