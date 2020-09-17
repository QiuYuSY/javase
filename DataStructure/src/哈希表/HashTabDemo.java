package 哈希表;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(5);
        hashTab.add(new Emp(1,"one"));
        hashTab.add(new Emp(6,"six"));

        hashTab.list();

        hashTab.findEmpById(7);
        hashTab.findEmpById(123);

    }
}

//创建HashTab 管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size){
        //初始化链表数列
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        //别忘了把链表对象建立起来！！！
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp newEmp){
        //根据员工ID得到员工该加到哪条链表
        int empLinkedListNO = hashFun(newEmp.id);//是哪条链表
        empLinkedListArray[empLinkedListNO].add(newEmp);
    }

    //遍历所有链表，遍历哈希表
    public void list(){
        for (int i = 0; i < empLinkedListArray.length; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //根据输入Id，查找雇员
    public void findEmpById(int id){
        int empLinkedListNO = hashFun(id);//是哪条链表
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if (emp == null){
            System.out.println("在哈希表中没找到该雇员");
        }else {
            System.out.printf("在第%d条链表中找到 雇员id = %d\n",empLinkedListNO,id);
        }
    }

    //编写一个散列函数，使用简单的取模法
    public int hashFun(int id){
        return id % size;
    }
}

//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

//表示链表
class EmpLinkedList{
    private Emp head;

    //添加雇员
    //注意这个链表的头指针是要放数据的
    public void add(Emp newEmp){
        if (head == null){
            head = newEmp;
            return;
        }
        Emp temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newEmp;
    }

    //遍历链表
    public void list(int no){
        if (head == null){
            System.out.println("第"+no+"条链表为空");
            return;
        }
        System.out.print("第"+no+"条链表信息为");
        Emp temp = head;
        while (temp != null){
            System.out.print("=>"+temp);
            temp = temp.next;
        }
        System.out.println();
    }

    //根据id查找雇员
    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp temp = head;
        while (temp != null){
            if (temp.id == id){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
