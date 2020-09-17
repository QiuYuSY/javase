class 用数组模拟栈 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(6);
            stack.push(7);
            stack.push(8);
            stack.push(9);
            stack.push(10);
            stack.push(11);
            stack.push(12);


        } catch (MyStackOperationException e) {
            String s = e.getMessage();
            System.out.println(s);
        }
        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (MyStackOperationException e) {
            String s = e.getMessage();
            System.out.println(s);
        }

    }
}

class MyStack{
    private Object[] elements = new Object[10];
    private int index = -1;
    //Constructor
    public MyStack(Object[] elements) {
        this.elements = elements;
    }

    public MyStack() {

    }
    //getter and setter
    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public void push(Object obj) throws MyStackOperationException {
        if (index >= 9){
            //System.out.println("栈已满压栈失败");
            //return;
            //用异常来写此处代码
            throw new MyStackOperationException("栈已满,压栈失败");
        }
        index++;
        elements[index] = obj;
        System.out.println("压栈"+obj+"成功，栈帧指向--->"+index);
    }
    public void pop() throws MyStackOperationException {
        //如果index等于-1 栈空
        if (index < 0){
            //System.out.println("栈已空弹栈失败");
            //return;
            //用异常来写此处代码
            throw new MyStackOperationException("栈已空,弹栈失败");
        }
        System.out.println("弹栈"+elements[index]+"成功，栈帧指向--->"+index);
        elements[index] = null;
        index--;


    }
}
class MyStackOperationException extends Exception{
    public MyStackOperationException() {
    }

    public MyStackOperationException(String message) {
        super(message);
    }
}

