package 二叉树.平衡二叉树;
/*
为了解决二叉排序树出现一边的高度特别大的情况
甚至可能出现链表的情况
 */

public class AVLTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8};
//        int[] arr = {10,12,8,9,7,6};
        int[] arr = {10,11,7,6,8,9};


        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        System.out.println(avlTree.getRoot());

        System.out.println(avlTree.getRoot().height());
        System.out.println("左子树高度"+avlTree.getRoot().leftHeight());
        System.out.println("右子树高度"+avlTree.getRoot().rightHeight());

        avlTree.infixOrder();

    }
}

//创建AVLTree
class AVLTree {
    private Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
    }

    //中序遍历
    public void infixOrder() {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        root.infixOrder();
    }

    //查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 返回的以node为根节点的二叉排序树的最小节点的值
     * 删除以node为根节点的二叉排序树的最小节点
     *
     * @param node 传入的节点（当做二叉排序树的根节点）
     * @return 返回以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子节点，就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        del(target.value);
        return target.value;
    }

    //删除节点
    public void del(int value) {
        if (root == null) {
            return;
        } else {
            //找到要删的节点
            Node targetNode = search(value);
            //如果没找到要删的节点
            if (targetNode == null) {
                return;
            }
            //找到了目标节点
            //如果当前二叉树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //去找到目标节点的父节点
            Node parent = searchParent(value);
            //如果要删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                //删除有两个子树的节点
                //找到目标节点的右子树中最小的，把值覆盖目标节点，也可以使左子树的最大值
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else {
                //剩下的是删除一个子树的节点，注意删除的顺序
                //如果目标节点只有左子节点
                if (targetNode.left != null) {
                    //如果父节点为空，说明使根节点，直接root指向子节点就好了
                    if (parent == null) {
                        root = targetNode.left;
                        return;
                    }
                    if (parent.left.value == value) {
                        parent.left = targetNode.left;
                    } else if (parent.right.value == value) {
                        parent.right = targetNode.left;
                    }
                } else {//目标节点只有有右子节点
                    //如果父节点为空，说明使根节点，直接root指向子节点就好了
                    if (parent == null) {
                        root = targetNode.right;
                        return;
                    }
                    if (parent.left.value == value) {
                        parent.left = targetNode.right;
                    } else if (parent.right.value == value) {
                        parent.right = targetNode.right;
                    }
                }
            }


        }
    }

    public Node getRoot() {
        return root;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //返回以该节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左旋转的方法
    private void leftRotate(){
        //创建新节点,以当前根节点的值
        Node newNode = new Node(value);
        //把新的节点的左子树设置为当前节点的左子树
        newNode.left = this.left;
        //把新节点的右子树设置为当前节点的右子树的左子树
        newNode.right = this.right.left;
        //把当前节点的值替换为右子节点的值
        this.value = this.right.value;
        //把当前节点的右子树设置成当前节点的右子树的右子树
        this.right = this.right.right;
        //把当前节点的左子树设置为新节点
        this.left = newNode;
    }

    //右旋转
    public void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
    }


    /**
     * 查找要删除的节点
     *
     * @param value 希望删除的节点的值
     * @return 如果找到返回该节点否则null
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除节点的父节点
     *
     * @param value 要找到节点的值
     * @return 返回的是要删除节点的父节点，没有就返回null
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.left != null && value < this.value) {
                return this.left.searchParent(value);
            } else if (this.right != null && value >= this.value) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    //递归的形式添加节点
    public void add(Node newNode) {
        if (newNode == null) {
            return;
        }

        //判断传入的节点的值和当前子树的根节点的值的大小
        if (newNode.value < this.value) {
            //如果当前节点的左子节点不为空，继续往左比较
            if (this.left != null) {
                this.left.add(newNode);
            } else {//为空就挂在下面
                this.left = newNode;
            }
        } else {//传入的节点的值大于等于当前子树的根节点的值的大小
            if (this.right != null) {
                this.right.add(newNode);
            } else {
                this.right = newNode;
            }
        }

        //当添加完一个节点后，右子树的高度减去左子树的高度的值大于1，左旋转
        if (rightHeight() - leftHeight() > 1){
            //如果当前节点的右节点的左子树高度大于右节点的右子树高度!!!
            if (right != null || this.right.leftHeight() > this.right.rightHeight()){
                this.right.rightRotate();
            }
            leftRotate();

            return;//必须要！！！
        }
        //当添加完一个节点后，左子树的高度减去右子树的高度的值大于1，右旋转
        if (leftHeight() - rightHeight() > 1){
            //如果当前节点的左子节点的右子树高度大于左子节点的左子树高度!!!
            if (left != null || left.rightHeight() > left.leftHeight()){
                left.leftRotate();
            }
            rightRotate();
        }
    }

    //中序遍历二叉树
    public void infixOrder() {
        if (left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}