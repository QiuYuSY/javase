package 栈.用数组模拟栈;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);

        String key;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show：表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：表示添加数据到栈");
            System.out.println("pop：表示弹栈");
            System.out.println("请输入你的选择: ");
            key = scanner.next();

            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.print("请输入一个数：");
                    stack.push(scanner.nextInt());
                    break;
                case "pop":
                    try{
                        System.out.println("出栈的数据为"+stack.pop());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }



    }
}

class ArrayStack{
    private int maxSize;
    private int top = -1;
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    //压栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        stack[++top] = value;
    }

    //弹栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈已空,无法出栈");
        }
        return stack[top--];
    }

    //遍历栈
    public void list(){
        if (isEmpty()){
            System.out.println("栈为空");
            return;
        }
        int temp = top;
        while (temp != -1){
            System.out.println("stack["+temp+"]="+stack[temp]);
            temp--;
        }
    }

}

