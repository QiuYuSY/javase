package 链表.双向链表;


public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero4);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);

//        doubleLinkedList.del(3);

//        doubleLinkedList.update(new HeroNode(4,"修改","修改"));

        doubleLinkedList.list();


    }
}
class DoubleLinkedList {
    private HeroNode head = new HeroNode(0, null, null);

    public HeroNode getHead() {
        return head;
    }

    //遍历双向链表
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加节点到最后
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.prev = temp;
    }

    //按照编号大小顺序添加
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        while (temp.next != null){
            if (temp.next.no > heroNode.no){
                heroNode.next = temp.next;
                heroNode.prev = temp;
                temp.next.prev = heroNode;
                temp.next = heroNode;
                return;
            }else if (temp.next.no == heroNode.no){
                System.out.println("已有该编号的节点");
                return;
            }
            temp = temp.next;
        }
//        this.add(heroNode);//感觉效率不高，还是算了
        temp.next = heroNode;
        heroNode.prev = temp;
    }

    //修改节点内容
    public void update(HeroNode newNeroNode){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (temp != null){
            if (temp.no == newNeroNode.no){
                flag = true;
                temp.name = newNeroNode.name;
                temp.nickName = newNeroNode.nickName;
                return;
            }
            temp = temp.next;
        }
        if (flag == false){
            System.out.printf("没找到编号为%d的节点\n",newNeroNode.no);
        }
    }

    //删除节点
    public void del(int no){
        if (head.next == null){
            System.out.println("链表已空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (temp != null){
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == false){
            System.out.println("未找到该节点");
        }else {
            temp.prev.next = temp.next;
            if (temp.next != null) temp.next.prev = temp.prev;//最后一个要特殊处理！！不然空指针异常
        }
    }

}
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    public HeroNode prev;

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
