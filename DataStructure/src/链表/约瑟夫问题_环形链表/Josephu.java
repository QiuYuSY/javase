package 链表.约瑟夫问题_环形链表;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

        circleSingleLinkedList.addBoy(5);

        circleSingleLinkedList.countBoy(3,3,5);

        circleSingleLinkedList.list();
    }

}

class CircleSingleLinkedList{
    private BoyNote first = new BoyNote(-1);

    //建立环形链表
    public void addBoy(int nums){
        if (nums < 1){
            System.out.println("nums值不正确");
            return;
        }
        BoyNote cur = null;
        first.setNo(1);
        cur = first;
        cur.setNext(first);
        for (int i = 2; i <= nums; i++) {
            BoyNote boyNote = new BoyNote(i);
            cur.setNext(boyNote);
            boyNote.setNext(first);
            cur = cur.getNext();
        }
    }

    //遍历环形链表
    public void list(){
        if (first.getNext() == null){//注意此处不能判断first为不为空，first一直都是有的
            System.out.println("没有任何小孩");
            return;
        }
        BoyNote temp = first;
        int sums = 0;
        while (temp.getNext() != first){
            System.out.println(temp);
            temp = temp.getNext();
            sums++;
        }
        System.out.println(temp);
        System.out.println("一共有"+(sums+1)+"个小孩");
    }

    /**
     *
     * @param startNo 从第几个小孩开始数数
     * @param countNum  表示数几下
     * @param nums  多少个小孩在圈中
     */
    //计算出小孩出圈的顺序
    public void countBoy(int startNo, int countNum, int nums){
        if (first.getNext() == null || startNo < 1 || startNo > nums){
            System.out.println("参数输入有误");
            return;
        }
        BoyNote cur = first;
        for (int i = 1; i < startNo; i++) {
            cur = cur.getNext();
        }
        BoyNote temp;
        while (cur.getNext() != cur){
            for (int i = 0; i < countNum - 2; i++) {
                cur = cur.getNext();
            }
            temp = cur.getNext();
            System.out.print(temp+"---->");
            cur.setNext(temp.getNext());
            cur = cur.getNext();
        }
        first = cur;//把开始first指向的那个节点回收
        System.out.println("最够留在圈内的小孩的"+first);
    }
}

class BoyNote{
    private int no;
    private BoyNote next;

    public BoyNote(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyNote getNext() {
        return next;
    }

    public void setNext(BoyNote next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "编号为 "+no;
    }
}
