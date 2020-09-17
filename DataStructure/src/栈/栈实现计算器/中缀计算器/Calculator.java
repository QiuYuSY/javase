package 栈.栈实现计算器.中缀计算器;

public class Calculator {
    public static void main(String[] args) {
//        String expression = "3-2*1+1=";//有大问题！！
        String expression = "6000+2*15=";
        ArrayStack numStack = new ArrayStack(100);
        ArrayStack operStack = new ArrayStack(100);

        int index = 0, num1 = 0, num2 = 0, oper = 0, result = 0;
        char ch = ' ';
        String  keepNum = "";

        while (true){
            ch = expression.substring(index,index+1).charAt(0);
            //是数字，压栈到数组栈
            if (!numStack.isOper(ch)){
//                numStack.push(ch-48);//单个数字的情况
                keepNum += ch;

                if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                    //我的输入后面有=，所以这里不会数组下标越界，没有等于的话要在前面再判断一次是否到最后了
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }
            }else {//是字符
                //是等号
                if (ch == '='){
                    while (!operStack.isEmpty()){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper =  operStack.pop();
                        result = numStack.cal(num1,num2,oper);
                        numStack.push(result);
                    }
                    break;
                }
                //空栈直接压栈
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {//不是空栈
                    //优先级比栈顶的高,压栈
                    if (operStack.priority(ch) >
                            operStack.priority(operStack.peek())) {
                        operStack.push(ch);
                    } else {//优先级比栈顶的低或一样,拿出两个计算
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper =  operStack.pop();
                        result = numStack.cal(num1,num2,oper);
                        numStack.push(result);
                        operStack.push(ch);
                    }
                }
            }
            index++;
        }
        numStack.list();
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

    //返回栈顶
    public int peek(){
        return stack[top];
    }

    //返回运算符优先级
    public int priority(int data){
        if (data == '*' || data == '/'){
            return 1;
        }else if (data == '+' || data == '-'){
            return 0;
        }
        return -1;//假设目前只有加减乘除
    }

    //判断是不是运算符
    public boolean isOper(int data){
        return data == '+' || data == '-' || data == '*' || data == '/'|| data== '=';
    }

    //计算方法
    public int cal(int num1, int num2, int oper){
        int result;
        switch (oper){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;//注意这里是后出栈的减去先出栈的
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;//注意这里是后出栈的除先出栈的
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + oper);
        }
        return result;
    }

    public int getTop() {
        return top;
    }
}



