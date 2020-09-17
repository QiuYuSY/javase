package 栈.栈实现计算器.逆波兰_后缀计算器;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        /*将中缀表达式转为后缀表达式*/

        //把中缀每个元素先放到List集合里面
        String expression = "1+((2+3)*4)-5";

        List<String> list = toInfixExpressionList(expression);

        List<String> suffixList = parseSuffixExpressionList(list);

        System.out.println(calculate(suffixList));



//        String suffixExpression = "3 4 + 5 * 6 -]";
//
//        List<String> list = getListString(suffixExpression);
//        System.out.println(calculate(list));
    }

    //把一个逆波兰表达式的数据和运算符依次给放入ArrayList中
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list= new ArrayList<>();
        for (String ele: split ){
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> ls){
        Stack<String> stack = new Stack<>();
        for (String item: ls){
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                int num2= Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                if ("+".equals(item)){
                    result = num1 + num2;
                }else if ("-".equals(item)){
                    result = num1 - num2;
                }else if ("*".equals(item)){
                    result = num1 * num2;
                }else if ("/".equals(item)){
                    result = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    //把中缀表达式放进List集合
    public static List<String> toInfixExpressionList(String s){
        List<String> list = new ArrayList<>();
        int index = 0;
        String str ; //字符串拼接
        char c;
        do {
            //不是数字的话
            if ((c=s.charAt(index)) < 48 || (c=s.charAt(index)) > 57){
                list.add(String.valueOf(c));
                index++;
            }else {//是数字的话
                str = "";
                while (index < s.length() && (c = s.charAt(index) )>= 48 && (c = s.charAt(index)) <=57){
                    str += c;
                    index++;
                }
                list.add(str);
            }

        }while (index < s.length());
        return list;
    }

    //中缀表达式List转为后缀表达式List
    public static List<String> parseSuffixExpressionList(List<String> list){
        Stack<String> s1 = new Stack<>();
//        Stack<String> s2 = new Stack<>();//用可以用ArrayList替代，因为没有弹栈过，最后还要逆序输出
        ArrayList<String> s2 = new ArrayList<>();
        for (String item :list) {
            //是一个数就加入s2
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                //如果是左括号，压入s1
                s1.push(item);
            }else if (item.equals(")")){
                //如果是右括号，把s1的弹出，压到s2，直到遇到左括号
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//去掉左括号
            }else {
                //如果item级别小于等于s1栈顶，将s1栈顶放入s2，再比较
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >=
                        Operation.getValue(item) ){
                    s2.add(s1.pop());
                }
                //空栈，级别大，栈顶为（
                s1.push(item);
            }

        }
        //把s1剩下的压入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }

        return s2;
    }
}
//用来返回运算符级别
class Operation{
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
            case "-":
                result = 1;
                break;
            case "*":
            case "/":
                result = 2;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}
