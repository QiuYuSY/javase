package 数组.数组模拟队列;

import java.util.Scanner;

public class ArrayQueueTest {
    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    try{
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    } finally {
                        break;
                    }

                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
//                        e.printStackTrace();
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~");
    }

}


class ArrayQueue{
    private int[] arr;
    private int maxSize;
    private int front;
    private int rear;

    //构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    public boolean isFull(){
        if (rear == maxSize-1){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if (front == rear) {
            return true;
        }
        return false;
    }

    //加入队列
    public void addQueue(int addValue){
        //如果队列满了，异常
        if (isFull()){
            throw new RuntimeException("无法存入数据，队列已满");
        }
        //如果队列没满，加入
        rear++;
        arr[rear] = addValue;
    }

    //获取队列数据，出队列
    public int getQueue(){
        // 如果队列为空，异常
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        //如果队列不为空，取出
        front++;
        return arr[front];
    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

}
