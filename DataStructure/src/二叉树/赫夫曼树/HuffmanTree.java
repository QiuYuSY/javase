package 二叉树.赫夫曼树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};

        Node node = creatHuffmanTree(arr);

        preOrder(node);

    }

    //编写一个前序遍历的方法
    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("该赫夫曼树为空");
        }
    }

    //创建赫夫曼树
    public static Node creatHuffmanTree(int[] arr) {
        //1.遍历arr数组
        //2.将arr每个元素构成一个Node
        //3.将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int value: arr){
            nodes.add(new Node(value));
        }


        while (nodes.size() > 1) {
            //排序，从小到大
            Collections.sort(nodes);

            //取出根节点权值最小的两颗二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //创建一个新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //删掉原来的两个
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //加入新的Node
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

//创建节点
//为了让Node 对象持续排序Collections集合排序
//要让Node实现Comparable接口
class Node implements Comparable<Node>{
    int value;//节点权值
    Node left;
    Node right;

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    @Override
    public int compareTo(Node o) {
        //表示从小到大排序
        return this.value - o.value;
    }
}
