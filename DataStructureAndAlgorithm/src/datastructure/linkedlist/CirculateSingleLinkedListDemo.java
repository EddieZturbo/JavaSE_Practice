package datastructure.linkedlist;

/** 环形链表 单向
 @author EddieZhang
 @create 2022-09-16 9:59
 */
public class CirculateSingleLinkedListDemo {
    public static void main(String[] args) {
        CirculateSingleLinkedList circulateSingleLinkedList = new CirculateSingleLinkedList();
        circulateSingleLinkedList.addBoyNode(5);
        circulateSingleLinkedList.showList();
        System.out.println("-----------------------------------约瑟夫问题（默认从firstNode节点开始）-----------------------------------------------");
        circulateSingleLinkedList.outCircle(1);

        System.out.println("-----------------------------------约瑟夫问题（Ultimately）-----------------------------------------------");
        circulateSingleLinkedList.outCircleUltimately(1,5,2);

    }
}

//创建环形链表 单向的
class CirculateSingleLinkedList {
    //创建一个First节点 当前还没有编号
    private BoyNode firstNode = null;

    //添加一个节点 构建成环形链表
    public void addBoyNode(int numNode) {//numNode为要加入多少个节点的数量
        //校验numNode
        if (numNode < 1) {
            System.out.println("numNode的值不正确");
            return;
        }
        //进行循环添加
        //由于firstNode要保留 因此利用一个临时节点
        BoyNode temp = null;
        for (int i = 1; i <= numNode; i++) {
            BoyNode boyNode = new BoyNode(i);//创建对应数量的节点
            //创建环形链表的第一个节点
            if (i == 1) {
                firstNode = boyNode;
                firstNode.setNext(firstNode);//第一个节点也要构成”环状“
                temp = firstNode;//temp指向第一个节点
            } else {
                temp.setNext(boyNode);
                boyNode.setNext(firstNode);//每一个新添加的节点 即最后的节点的next都要指向头节点 形成循环
                temp = boyNode;//从第二个开始 temp指向每一个已经新添加进链表的节点
            }
        }
    }

    //遍历循环链表
    public void showList() {
        if (firstNode == null) {//表明链表为空
            System.out.println("链表是空的哦~");
            return;
        }
        //循环遍历每一个节点
        //由于firstNode要保留 此处使用一个临时遍历
        BoyNode temp = firstNode;
        while (true) {

            if (temp.getNext() == firstNode) {//表示已经遍历到最后一个节点
                System.out.println(temp);
                break;
            }
            //有两个及以上的节点
            System.out.println(temp);
            //temp后移
            temp = temp.getNext();
        }
    }

    //约瑟夫问题 根据用户输入的num数 计算出节点出圈的顺序（默认从firstNode开始）
    public void outCircle(int num) {
        if (num < 1) {
            System.out.println("输入的数字有误~~");
            return;
        }
        if (num == 1) {//如果数字为1 就相当于遍历环形链表
            showList();
            return;
        }
        //当输入的数字>=2时 循环按照规律进行出圈
        //定义一个临时变量 为要出圈节点的前一个节点 初始为链表的最后一个节点
        BoyNode temp = new BoyNode(-1);
        temp.setNext(firstNode);//初始为链表的最后一个节点
        while (true) {
            if (firstNode.getNext() == firstNode) {//只剩下最后一个节点
                System.out.println(firstNode);
                break;
            }
            for (int i = 1; i <= num - 1; i++) {
                firstNode = firstNode.getNext();//firstNode向后移动num位
                temp = temp.getNext();//temp向后移动num位
            }
            System.out.println(firstNode);//输出出圈节点
            //进行出圈操作 此时 first节点为要出圈的节点 temp节点为要出圈的前一个节点
            firstNode = firstNode.getNext();//让firstNode为出圈节点的下一个节点
            temp.setNext(firstNode);//temp节点的下一个继续为firstNode
            //经过以上操作 待出圈的节点没有指向 等待gc回收 即为出圈
        }
    }

    //约瑟夫问题 根据用户输入的num数 计算出节点出圈的顺序（完整版本）
    /*
     * @Description
     * @Author EddieZhang
     * @Date 2022/9/16 11:15
     * @Param [startNode 从第几个节点开始, sumNode 一共有多少个节点, num 每次报数的值]
     * @Return void
     * @Since version-1.0
     */
    public void outCircleUltimately(int startNode, int sumNode, int num) {
        //进行参数的值校验
        if (startNode < 0 || startNode > sumNode || startNode < 1 || num < 1) {
            System.out.println("输入的数值有误~~");
            return;
        }
        if (firstNode == null) {
            System.out.println("链表是空的哦~~");
        }
        //定义一个零时变量 为开始节点的前一个节点//先将临时变量置为first节点再找到环形链表的最后一个节点
        BoyNode temp = firstNode;
        while (true) {
            if (temp.getNext() == firstNode) {//此时temp为链表最后一个节点
                break;
            }
            //temp后移
            temp = temp.getNext();
        }
        //根据形参列表的startNode 从第几个节点开始 将firstNode与temp节点同步向后移动 startNode - 1 位
        for (int i = 1; i <= startNode - 1; i++) {
            //firstNode与temp节点同步向后移动 startNode - 1 位
            firstNode = firstNode.getNext();
            temp = temp.getNext();
        }
        if (num == 1) {//如果数字为1 就相当于遍历环形链表
            showList();
            return;
        }
        //当输入的数字>=2时 循环按照规律进行出圈
        while (true) {
            if (firstNode.getNext() == firstNode) {//只剩下最后一个节点
                System.out.println(firstNode);
                break;
            }
            for (int i = 1; i <= num - 1; i++) {
                firstNode = firstNode.getNext();//firstNode向后移动num位
                temp = temp.getNext();//temp向后移动num位
            }
            System.out.println(firstNode);//输出出圈节点
            //进行出圈操作 此时 first节点为要出圈的节点 temp节点为要出圈的前一个节点
            firstNode = firstNode.getNext();//让firstNode为出圈节点的下一个节点
            temp.setNext(firstNode);//temp节点的下一个继续为firstNode
            //经过以上操作 待出圈的节点没有指向 等待gc回收 即为出圈
        }


    }

}


//创建节点类
class BoyNode {
    private int no;//标号
    private BoyNode next;//指向next 默认为null

    public BoyNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "BoyNode{" +
                "no=" + no +
                '}';
    }
}
