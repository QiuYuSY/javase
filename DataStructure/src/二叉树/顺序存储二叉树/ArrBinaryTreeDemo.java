package 二叉树.顺序存储二叉树;
/*
把一个数组用前序二叉树遍历
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
//        arrBinaryTree.preOrder();
        arrBinaryTree.infixOrder(0);
    }
}

//编写一个ArrayBinaryTree，实现顺序存储二叉树遍历
class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //让代码更干净一点,重载
    public  void preOrder(){
        this.preOrder(0);
    }

    //编写方法完成顺序存储二叉树的前序遍历
    public void preOrder(int index){//index是数组的下标
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        System.out.println(arr[index]);
        //直接递归有可能越界
        if ((index * 2 + 1)< arr.length){
            preOrder(index * 2 + 1);
        }
        if ((index * 2 + 2) < arr.length){
            preOrder(index * 2 +2);
        }
    }

    //编写方法完成顺序存储二叉树的中序遍历
    public void infixOrder(int index){//index是数组的下标
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }

        //直接递归有可能越界
        if ((index * 2 + 1)< arr.length){
            infixOrder(index * 2 + 1);
        }
        System.out.println(arr[index]);
        if ((index * 2 + 2) < arr.length){
            infixOrder(index * 2 +2);
        }
    }

    //后序一样的做法
}

