package datastructure.tree.bst;

/**
 @author EddieZhang
 @create 2022-10-10 17:16
 */

/**
 * 二叉查询树
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private BSTNode<T> mRoot;//根节点

    /**
     * 节点 树的内部类
     * @param <T>
     */
    public class BSTNode<T extends Comparable<T>> {
        T key;//关键字（键值）用来对二叉查找树的节点进行排序
        BSTNode<T> left;//左孩子
        BSTNode<T> right;//右孩子
        BSTNode<T> parent;//父节点

        public BSTNode(T key, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }



    /*
        前序遍历
        根节点
        左孩子
        右孩子
     */
    public void preOrder(BSTNode<T> tree) {
        if (tree != null) {
            System.out.println(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }
    public void preOrder() {
        preOrder(mRoot);
    }


    /*
        中序遍历
        左孩子
        根节点
        右孩子
     */
    public void inOrder(BSTNode<T> tree){
        if(tree != null){
            inOrder(tree.left);
            System.out.println(tree.key + " ");
            inOrder(tree.right);
        }
    }
    public void inOder(){
        inOrder(mRoot);
    }



    /*
        后序遍历
        左孩子
        右孩子
        根节点
     */
    public void postOrder(BSTNode<T> tree){
        if(tree != null){
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.key + " ");
        }
    }
    public void postOrder(){
        postOrder(mRoot);
    }


    /**
     * BST的插入节点方法
     * @param key 节点的值
     */
    public void insert(T key) {
        BSTNode<T> z=new BSTNode<T>(key,null,null,null);//根据节点的值key初始化一个节点

        // 如果新建结点失败，则返回。
        if (z != null)
            insert(this, z);//传入一个BST 以及待插入节点z
    }

    /**
     *
     * @param bst BST
     * @param z 待插入节点
     */
    private void insert(BinarySearchTree<T> bst, BSTNode<T> z) {
        int cmp;//用于比较大小的值
        BSTNode<T> y = null;//待插入节点z的父节点（没找到z的准确位置前 初始为null）
        BSTNode<T> x = bst.mRoot;//树的顶根节点

        // 查找z的插入位置
        while (x != null) {//判断树的顶根节点是否为null
            //若不为null则顺着根节点向下寻找要插入的位置
            y = x;//y始终为待插入节点的父节点
            cmp = z.key.compareTo(x.key);
            if (cmp < 0)//待插入的z节点<x根节点 则z作为x的左子节点继续循环下顺直至到叶子节点(遇到子节点为null的节点)
                x = x.left;
            else
                x = x.right;//待插入的z节点>=x根节点 则z作为x的右子节点继续循环下顺直至到叶子节点(遇到子节点为null的节点)
        }

        //遇到子节点为null的节点 可以将待插入节点z作为此节点的子节点
        z.parent = y;//y始终为待插入节点的父节点
        if (y==null)//若y为null 表明树的顶根节点是为null 表明是棵空树
            bst.mRoot = z;//直接将待插入节点z作为该BST的根节点
        else {//判断待插入节点应当作为其父节点y的左节点还是右节点
            cmp = z.key.compareTo(y.key);
            if (cmp < 0)//作为左节点插入
                y.left = z;
            else
                y.right = z;//作为右节点插入
        }
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
//        binarySearchTree.insert(2);
//        binarySearchTree.insert(4);
//        binarySearchTree.insert(13);
//        binarySearchTree.insert(9);

        //中序遍历
        binarySearchTree.inOrder(binarySearchTree.mRoot);

    }
}



