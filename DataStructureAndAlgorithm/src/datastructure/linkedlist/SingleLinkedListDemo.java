package datastructure.linkedlist;

/**
 @author EddieZhang
 @create 2022-09-12 17:10
 */

import java.util.Stack;

import static datastructure.linkedlist.SingleLinkedList.numNode;

/**
 * 单向链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建几个HeroNode
        HeroNode node1 = new HeroNode(1, "Eddie", "张锦豪");
        HeroNode node2 = new HeroNode(2, "Irving", "欧文");
        HeroNode node3 = new HeroNode(3, "James", "詹姆斯");
        HeroNode node4 = new HeroNode(4, "Curry", "库里");
        HeroNode node5 = new HeroNode(1, "EddieZhang", "锦豪");
        HeroNode node6 = new HeroNode(3, "King James", "詹皇");
        HeroNode node7 = new HeroNode(6, "Durant", "杜小帅");
        HeroNode node8 = new HeroNode(7, "Harden", "火箭登");
        HeroNode node9 = new HeroNode(8, "Jordan", "篮球之神");

        //创建单向链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add2(node1);
        singleLinkedList.add2(node4);
        singleLinkedList.add2(node3);
        singleLinkedList.add2(node2);
        singleLinkedList.showList();
        System.out.println("-------------------------------------------------------");
        singleLinkedList.replaceNode(node5);
        singleLinkedList.showList();
        System.out.println("-------------------------------------------------------");
        singleLinkedList.modifyNode(node6);
        singleLinkedList.showList();
        System.out.println("-------------------------------------------------------");
        singleLinkedList.selectNode(1);
        System.out.println("-------------------------------------------------------");
        singleLinkedList.deleteNode(4);
        singleLinkedList.showList();
        System.out.println("-------------------------------------------------------");
        int numNode = numNode(singleLinkedList.getHead());
        System.out.printf("链表中的有效节点有\t%d\t个\n", numNode);
        System.out.println("-------------------------------------------------------");
        HeroNode searchNode = singleLinkedList.searchNode(2);
        if (searchNode != null) {
            System.out.printf("倒数第\t%d\t个节点为\n" + searchNode, 2);
        }
        System.out.println();
        System.out.println("-------------------------------------------------------");
        singleLinkedList.reverseNode();
        singleLinkedList.showList();
        System.out.println("-------------------------------------------------------");
        singleLinkedList.reversePrint();
        System.out.println("-------------------------------------------------------");
        singleLinkedList.reverseNode();
        singleLinkedList.add2(node8);

        singleLinkedList.showList();

        System.out.println("------------------------------------------------------------");
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.add2(node7);
        singleLinkedList1.add2(node4);
        singleLinkedList1.add2(node9);


        singleLinkedList1.showList();


        System.out.println("------------------------------------------------------------");
        SingleLinkedList concatList = SingleLinkedList.concatList(singleLinkedList, singleLinkedList1);
        concatList.showList();

    }
}

/*
 * @Description 单向链表设计(管理节点) 有一个head节点 保留
 * @Author EddieZhang
 * @Date 2022/9/12 17:15
 * @Since version-1.0
 */
class SingleLinkedList {
    //有个head节点
    private HeroNode head = new HeroNode(0, null, null);

    public HeroNode getHead() {
        return head;
    }

    //添加节点--通过temp进行链表的遍历 找到最后一个节点
    public void addNode(HeroNode node) {
        //要使用到head节点 由于head节点要保留 因此使用一个零时节点
        HeroNode temp = head;
        //通过temp进行链表的遍历 找到最后一个节点
        while (true) {//一直寻找到最后的节点 将新的节点置为最后节点的next
            if (temp.next == null) {//说明temp以及到链表的最后了
                break;
            }
            //如果没有到最后
            temp = temp.next;//往后移动
        }
        //此时temp 已经在最后一个节点处 可以进行添加 将新的节点置为最后节点的next
        temp.next = node;
    }

    /*
     * @Description 按照指定的要求进行添加
     * @Author EddieZhang
     * @Date 2022/9/12 20:04
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void add2(HeroNode node) {
        //要使用到head节点 由于head节点要保留 因此使用一个零时节点
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {//判断temp是不是最后一个
                break;
            }
            //查到有别的节点
            if (temp.next.no > node.no) {
                break;
            }
            if (temp.next.no == node.no) {//是否已经存在此节点
                flag = true;
                break;
            }
            temp = temp.next;//向后移动
        }
        if (flag) {
            System.out.printf("待插入的标号%d已经存在，无法进行添加\n", node.no);
        } else {//进行添加操作
            node.next = temp.next;
            temp.next = node;
        }
    }

    /*
     * @Description replace节点 根据no
     * @Author EddieZhang
     * @Date 2022/9/12 20:27
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void replaceNode(HeroNode node) {
        //要使用到head节点 由于head节点要保留 因此使用一个零时节点
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //查到有节点
            if (temp.next.no == node.no) {//no是否能够匹配
                flag = true;
                break;
            }
            temp = temp.next;//向后移动
        }
        if (flag) {
            if (temp.next.next == null) {
                temp.next = node;
            } else {
                node.next = temp.next.next;
                temp.next = node;
            }
        } else {
            System.out.printf("未查询到\t%d\t所对应的数据\n", node.no);
        }


    }

    /*
     * @Description 修改节点
     * @Author EddieZhang
     * @Date 2022/9/12 21:04
     * @Param [node]
     * @Return void
     * @Since version-1.0
     */
    public void modifyNode(HeroNode node) {
        //要使用到head节点 由于head节点要保留 因此使用一个零时节点
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //查到有节点
            if (temp.next.no == node.no) {//no是否能够匹配
                flag = true;
                break;
            }
            temp = temp.next;//向后移动
        }
        if (flag) {
            temp.next.name = node.name;
            temp.next.nickName = node.nickName;
        } else {
            System.out.printf("未查询到\t%d\t所对应的数据\n", node.no);
        }
    }

    /*
     * @Description 删除节点 根据name
     * @Author EddieZhang
     * @Date 2022/9/12 21:08
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void deleteNode(int no) {
        //要使用到head节点 由于head节点要保留 因此使用一个零时节点
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //查到有节点
            if (temp.next.no == no) {//no是否能够匹配
                flag = true;
                break;
            }
            temp = temp.next;//向后移动
        }
        if (flag) {
            if (temp.next.next == null) {//判断是不是位于最后一个位置的节点
                temp.next = null;
            } else {
                temp.next = temp.next.next;
            }
        } else {
            System.out.printf("未查询到\t%d\t所对应的数据\n", no);
        }
    }

    /*
     * @Description 查找节点 根据name
     * @Author EddieZhang
     * @Date 2022/9/12 21:17
     * @Param [node]
     * @Return void
     * @Since version-1.0
     */
    public void selectNode(int no) {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }
        //不为空时候 由于head节点要保留 因此需要使用一个零时节点来遍历链表
        HeroNode temp = head.next;
        while (true) {
            if (temp.no == no) {//判断是否匹配
                System.out.println(temp);
                break;
            }
            //将temp后移
            temp = temp.next;
        }
    }

    /*
     * @Description 查找倒数第n个节点
     * @Author EddieZhang
     * @Date 2022/9/12 21:44
     * @Param []
     * @Return datastructure.linkedlist.HeroNode
     * @Since version-1.0
     */
    public HeroNode searchNode(int n) {
        if (head.next == null) {
            System.out.println("列表为空");
            return null;
        }
        HeroNode temp = head;
        int num = 0;//代表第几个有效元素
        while (true) {
            if (temp.next != null) {
                num++;
                temp = temp.next;//向后移动
            } else {
                break;
            }
        }
        //此时的num表示的是最后一个元素的位置
        HeroNode temp1 = head;
        if (n < 0 || n > num) {
            System.out.println("查不到此索引位置");
            return null;
        } else {
            //倒数第n个元素的位置为(num - (n -1))
            for (int i = 1; i <= (num - (n - 1)); i++) {
                temp1 = temp1.next;
            }

        }
        return temp1;
    }

    /*
     * @Description 节点反转
     * @Author EddieZhang
     * @Date 2022/9/13 8:29
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void reverseNode() {
        if (head.next == null || head.next.next == null) {//判断是否没有节点或者只有一个节点 则不需要反转
            System.out.println("无需反转");
        }
        HeroNode temp = head;
        HeroNode reverseHead = new HeroNode(0,null,null);
        HeroNode temp1 = reverseHead;
        while(head.next != null){
            while (temp.next.next != null){
                temp = temp.next;
            }
            //此时temp为最后一个
            temp1.next = temp.next;
            temp1 = temp1.next;
            temp.next = null;
            temp = head;
        }
        head.next = reverseHead.next;

    }

    /*
     * @Description 从尾到头 反向打印输出链表 （借助于栈【先进后出】）
     * @Author EddieZhang
     * @Date 2022/9/13 11:02
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    public void reversePrint(){
        if (head.next == null){
            System.out.println("链表为空");
        }
        //创建以一个Stack结构
        Stack<HeroNode> heroNodeStack = new Stack<>();
        //遍历链表 将链表中的每一个节点压入Stack中
        HeroNode temp = head.next;
        while(temp != null){
            heroNodeStack.push(temp);
            temp = temp.next;//向后移动
        }
        while(heroNodeStack.size() > 0){
            System.out.println(heroNodeStack.pop());
        }



    }
    /*
     * @Description 将两个链表进行连接 连接后依然按照顺序排列
     * @Author EddieZhang
     * @Date 2022/9/13 11:31
     * @Param [list1, list2]
     * @Return void
     * @Since version-1.0
     */
    public static SingleLinkedList concatList(SingleLinkedList list1,SingleLinkedList list2){
        //创建一个新的链表 接收两个链表的拼接（有序）
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        if(list1.head.next == null && list2.head.next == null){
            System.out.println("链表为空");
        } else if (list1.head.next == null) {
            singleLinkedList = list2;
        } else if (list2.head.next == null) {
            singleLinkedList = list1;
        }
        //如果都不为空 以其中一个list1为前段 将list2的每个节点按序加入到list1链表中
        singleLinkedList = list1;
            //遍历list2的每一个节点 并add2到list1中
        //list2要保留 创建一个零时变量
        HeroNode temp = list2.head.next;
        HeroNode tempNode = null;
        while(temp != null){
            tempNode = temp;
            list2.head.next = tempNode.next;
            tempNode.next = null;
            singleLinkedList.add2(tempNode);
            temp = list2.head.next;//向后移动
        }
        return singleLinkedList;
    }

    /*
     * @Description 求有效节点的个数
     * @Author EddieZhang
     * @Date 2022/9/12 20:53
     * @Param []链表的头节点
     * @Return int
     * @Since version-1.0
     */
    public static int numNode(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        HeroNode temp = head;
        int num = 0;
        while (temp.next != null) {
            num++;
            temp = temp.next;//向后移动
        }
        return num;
    }

    //显示链表--通过temp进行链表的遍历
    public void showList() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }
        //不为空时候 由于head节点要保留 因此需要使用一个零时节点来遍历链表
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {//判断是否到链表的最后
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}

/*
 * @Description 节点设计 节点需要有数据 以及next（指向下个节点）
 * @Author EddieZhang
 * @Date 2022/9/12 17:12
 * @Since version-1.0
 */
class HeroNode {
    //数据
    int no;//标号
    String name;//名称
    String nickName;//别称
    //next
    HeroNode next;//next节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode() {
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

