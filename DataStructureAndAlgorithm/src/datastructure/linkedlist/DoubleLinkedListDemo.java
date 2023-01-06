package datastructure.linkedlist;

/**
 @author EddieZhang
 @create 2022-09-15 19:54
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //创建几个DoubleLinkedHeroNode节点
        DoubleLinkedHeroNode node1 = new DoubleLinkedHeroNode(1, "Eddie", "张锦豪");
        DoubleLinkedHeroNode node2 = new DoubleLinkedHeroNode(2, "Irving", "欧文");
        DoubleLinkedHeroNode node3 = new DoubleLinkedHeroNode(3, "James", "詹姆斯");
        DoubleLinkedHeroNode node4 = new DoubleLinkedHeroNode(4, "Curry", "库里");
        DoubleLinkedHeroNode node5 = new DoubleLinkedHeroNode(5, "Durant", "杜兰特");
        DoubleLinkedHeroNode node6 = new DoubleLinkedHeroNode(6, "Jordan", "乔丹");
        //创建双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //向链表中添加节点
        doubleLinkedList.addNode(node1);
        doubleLinkedList.addNode(node2);
        doubleLinkedList.addNode(node3);
        doubleLinkedList.addNode(node4);

        System.out.println("----------------------------------遍历链表--------------------------------------------");
        //遍历链表
        doubleLinkedList.showDoubleLinkedList();

        System.out.println("----------------------------------update节点--------------------------------------------");
        //update节点
        DoubleLinkedHeroNode node = new DoubleLinkedHeroNode(1, "EddieZhang", "张锦豪");
        doubleLinkedList.updateDoubleLinkedNode(node5);
        doubleLinkedList.showDoubleLinkedList();

        System.out.println("----------------------------------delete节点--------------------------------------------");
        //delete节点
        doubleLinkedList.deleteDoubleLinkedNode("Curry");
        doubleLinkedList.showDoubleLinkedList();

        System.out.println("----------------------------------按照no的顺序添加或插入节点--------------------------------------------");
        //按照no的顺序添加或插入节点
        DoubleLinkedList doubleLinkedList1 = new DoubleLinkedList();
        doubleLinkedList1.addNodeByNo(node1);
        doubleLinkedList1.addNodeByNo(node3);
        doubleLinkedList1.addNodeByNo(node6);
        doubleLinkedList1.addNodeByNo(node5);
        doubleLinkedList1.addNodeByNo(node2);
        doubleLinkedList1.addNodeByNo(node4);
        doubleLinkedList1.addNodeByNo(node4);
        doubleLinkedList1.showDoubleLinkedList();
    }
}

//创建一个双向链表类
class DoubleLinkedList {
    //定义一个头节点
    DoubleLinkedHeroNode headNode = new DoubleLinkedHeroNode();

    //返回头结点
    public DoubleLinkedHeroNode getHeadNode() {
        return headNode;
    }

    //向双向链表的最后添加节点
    public void addNode(DoubleLinkedHeroNode node) {
        //要使用到head节点 由于head节点要保留 因此使用一个临时节点
        DoubleLinkedHeroNode temp = headNode;
        //通过temp进行链表的遍历 找到最后一个节点
        while (true) {//一直寻找到最后的节点 将新的节点置为最后节点的next
            if (temp.next == null) {//说明temp以及到链表的最后了
                break;
            }
            //如果没有到最后
            temp = temp.next;//往后移动
        }
        //此时temp 已经在最后一个节点处 可以进行添加 将新的节点置为最后节点的next 新节点的prev指向原链表中的最后一个节点
        temp.next = node;
        node.prev = temp;
    }

    //向双向链表中添加节点 （按照编号的大小顺序进行添加）
    public void addNodeByNo(DoubleLinkedHeroNode node) {
        //要使用到head节点 由于head节点要保留 因此使用一个临时节点
        DoubleLinkedHeroNode temp = headNode;
        Boolean flag = false;
        while(true){
            if(temp.next == null){//判断是不是最后一个 如果是 则直接退出循环进行插入操作
                temp.next = node;
                node.prev = temp;
                break;
            }
            //有节点
            //将与链表中的所有节点进行no的比较 并进行有序的添加
            if(node.no < temp.next.no){//按照顺序需要插入在前面
                node.next = temp.next;
                temp.prev = node;
                temp.next = node;
                node.prev = temp;
                break;
            }
            if (node.no == temp.next.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.printf("节点\t %S\t已经存在 无法进行添加操作\n",node.name);
        }
    }

    //遍历双向链表
    public void showDoubleLinkedList() {
        //判断链表是否为空
        if (headNode.next == null) {//链表的头节点的next为null表明是一个空链表
            System.out.println("链表是空的哦！！");
        }
        //链表不为空时 while循环遍历链表 由于要保留头节点 所以这里定义一个临时变量用来遍历链表上的每一个节点
        DoubleLinkedHeroNode temp = headNode;
        while (temp.next != null) {
            System.out.println(temp.next);
            //temp后移
            temp = temp.next;
        }
    }

    //修改 update节点
    public void updateDoubleLinkedNode(DoubleLinkedHeroNode newNode) {
        if (headNode.next == null) {//表明链表为空
            return;
        }
        //由于头节点要保留 因此这里定义一个临时变量用来遍历所有节点
        DoubleLinkedHeroNode temp = headNode;
        boolean flag = false;//用来判断while循环有没有找到可替换节点
        //遍历链表 查看是否有可替换的节点 根据节点的no进行判断
        while (true) {
            if (temp.next == null) {//直至遍历结束未找到
                break;
            }
            if (temp.next.no == newNode.no) {//表明找到了可替换的节点 根据节点的no进行判断
                flag = true;//找到了将flag置为true
                break;//找到了就结束循环
            }
            //temp后移
            temp = temp.next;
        }
        if (flag) {//至此 flag为true时 表明找到了就是这个节点 进行update操作
            temp.next.name = newNode.name;
            temp.next.nickName = newNode.nickName;
        } else {
            System.out.println("无可替换的节点~~");
        }
    }

    //从双向链表中删除指定节点 根据name
    public void deleteDoubleLinkedNode(String name) {
        if (headNode.next == null) {//判断链表是否为空
            System.out.println("连表是空的哦~~");
            return;
        }
        //遍历链表 寻找是否有指定要删除的节点 根据name判断
        //由于头节点要保留 因此这里定义一个临时变量 用来遍历链表
        DoubleLinkedHeroNode temp = headNode.next;
        //定义一个flag用来标记是否找到要删除的节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (name.equals(temp.name)) {//表明找到了指定要删除的节点
                flag = true;//找到了 将flag标识置为true
                break;//同时退出while循环
            }
            //temp后移
            temp = temp.next;
        }
        if (flag) {
            temp.prev.next = temp.next;//如果要删除的节点是最后一个位置上的 只执行此行即可
            if (temp.next != null) {//要删除的节点非最后一个位置上的
                temp.next.prev = temp.prev;
            }
        } else {
            System.out.println("未找到指定要删除的节点哦~~");
        }

    }
}

//创建节点类
class DoubleLinkedHeroNode {
    //数据
    int no;//标号
    String name;//名称
    String nickName;//别称
    //next
    DoubleLinkedHeroNode next;//next节点

    //previous
    DoubleLinkedHeroNode prev;//previous节点


    public DoubleLinkedHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public DoubleLinkedHeroNode() {
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
