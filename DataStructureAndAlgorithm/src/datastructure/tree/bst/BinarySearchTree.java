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
}



