package 链表.单链表.基础;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(5, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(7, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(2, "宋江2", "及时雨2");
        HeroNode hero6 = new HeroNode(4, "卢俊义2", "玉麒麟2");
        HeroNode hero7 = new HeroNode(6, "吴用2", "智多星2");
        HeroNode hero8 = new HeroNode(8, "林冲2", "豹子头2");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();

        //加入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList2.addByOrder(hero5);
        singleLinkedList2.addByOrder(hero6);
        singleLinkedList2.addByOrder(hero8);
        singleLinkedList2.addByOrder(hero7);

        singleLinkedList.update(4,"被修改");

//        singleLinkedList.del(1);

//        System.out.println(getLength(singleLinkedList.head));

//        try {
//            System.out.println(findLastIndexNode(1,singleLinkedList.head));
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

//        reversePrint(singleLinkedList.head);

        mergeLinkedList(singleLinkedList,singleLinkedList2.head);

        singleLinkedList.list();
//        singleLinkedList2.list();

//        reverseList(singleLinkedList.head);
//        singleLinkedList.list();
    }

    //统计链表内节点的个数
    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 1;
        HeroNode cur = head.next;
        while (true){
            if (cur.next == null){
                break;
            }
            length++;
            cur = cur.next;
        }
        return length;
    }

    //查找倒数第k个节点【新浪面试题】
    public static HeroNode findLastIndexNode(int lastIndex, HeroNode head){
        int length = getLength(head);
        if (lastIndex > length || lastIndex < 1){
            throw new RuntimeException("超出范围");
        }
        int index = length - lastIndex + 1;//正数第几个
        HeroNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //单链表的反转【腾讯面试题】
    public static void reverseList(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }
        HeroNode temp = head.next;
        HeroNode temp2 = null;
        HeroNode next = null;
        HeroNode reverseNode = new HeroNode(0,null,null);
        /*while (true){//自己想法
            if (temp.next == null){
                temp.next = reverseNode.next;
                reverseNode.next = temp;
                head.next = reverseNode.next;
                break;
            }
            temp2 = temp;
            temp = temp.next;
            temp2.next = reverseNode.next;
            reverseNode.next = temp2;
        }*/
        //老师给的方法
        while (temp != null){
            next = temp.next;
            temp.next = reverseNode.next;
            reverseNode.next = temp;
            temp = next;
        }
        head.next = reverseNode.next;
        return;
    }

    //逆序打印单链表【百度面试题】
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        HeroNode temp = head.next;
        Stack<HeroNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    //合并两个有序链表
    public static void mergeLinkedList(SingleLinkedList singleLinkedList, HeroNode head){
        if (head.next == null) {
            return;
        }
        HeroNode temp = head.next;
        HeroNode next = null;
        while (true) {
            if (temp.next == null) {
                singleLinkedList.addByOrder(temp);
                return;
            }
            next = temp.next;
            singleLinkedList.addByOrder(temp);
            temp = next;
        }
    }
}

class SingleLinkedList{
    HeroNode head = new HeroNode(0,null,null);
    //添加人物
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    //顺序添加人物
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no){
                break;
            }
            temp = temp.next;
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }
    //改变指定节点信息
    public void update(int no, String newName){
        if (head.next == null){
            System.out.println("链表为空");
        }
        HeroNode temp = head.next;
        while (true){
            if (temp.next == null){
                if (temp.no == no){
                    temp.name = newName;
                }else {
                    System.out.println("没找到");
                }
                break;
            }
            if (temp.no == no){
                temp.name = newName;
                break;
            }
            temp = temp.next;
        }
    }
    //删除指定节点
    public void del(int no){
        if (head.next == null){
            System.out.println("链表为空");
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null){
                System.out.println("未找到指定数据");
                break;
            }
            //判断下一个是否一样,一样删除
            if (temp.next.no == no){
                temp.next = temp.next.next;
                break;
            }
            //不一样，下一个
            temp = temp.next;
        }
    }
    //打印全部链表
    public void list(){
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
