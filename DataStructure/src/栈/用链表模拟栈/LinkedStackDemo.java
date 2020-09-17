package 栈.用链表模拟栈;

public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();

        linkedStack.push(new Node(1));
        linkedStack.push(new Node(2));
        linkedStack.push(new Node(3));
        linkedStack.push(new Node(4));
        linkedStack.pop();

        linkedStack.list();
    }
}

class LinkedStack{
    Node head = new Node(-1);

    //判断栈是否为空
    public boolean isEmpty(){
        return head.next == null;
    }

    //加节点的时候倒着加
    public void push(Node newNode){
        if (isEmpty()){
            head.next = newNode;
            return;
        }
        newNode.next = head.next;
        head.next = newNode;
    }

    //出栈
    public Node pop(){
        if (isEmpty()){
            throw new RuntimeException("栈已空。无法出栈");
        }
        Node temp = head.next;
        head.next = head.next.next;
        return temp;
    }

    //遍历
    public void list(){
        if (isEmpty()){
            System.out.println("栈为空");
            return;
        }
        Node temp = head.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }

    }

}
class Node{
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
