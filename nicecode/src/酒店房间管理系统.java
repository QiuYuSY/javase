import java.util.Objects;
import java.util.Scanner;

public class 酒店房间管理系统{//断电的话所有数据消失，后期可存入数据库
    public static void main(String[] args) {
        //首先输出一个欢迎列表
        System.out.println("欢迎使用酒店管理系统，请认真阅读以下使用说明");
        System.out.println("请输入对应功能的编号：【1】查看房间列表  【2】订房  【3】退房  【0】退出系统");

        //实现数字调用方法功能
        Scanner s= new Scanner(System.in);
        Uesr u = new Uesr();
        while (true) {
            System.out.println("请输入功能编号:");
            int i = s.nextInt();
            if (i == 1) {
                u.check();
            } else if (i == 2) {
                System.out.println("请输入房间号码：");
                int no = s.nextInt();
                u.yuding(no);
            } else if (i == 3) {
                System.out.println("请输入房间号码：");
                int no = s.nextInt();
                u.tuifang(no);
            } else if (i == 0) {
                break;
            } else {
                System.out.println("输入功能标号有误，请重新输入");
            }
        }


    }
}
class Uesr{
    private Room[][] rooms = new Room[3][10];

    public Uesr() {
        for (int i =0; i < rooms.length; i++){
            for (int j = 0; j < rooms[i].length; j++){
                if (i == 0)  rooms[i][j] = new Room((i+1)*100+j+1,"单人间" ,false);
                else if (i == 1)  rooms[i][j] = new Room((i+1)*100+j+1,"标准间" ,false);
                else if (i == 2)  rooms[i][j] = new Room((i+1)*100+j+1,"总统套房" ,false);
            }
        }
    }

    //getter and setter
    public Room[][] getRooms() {
        return rooms;
    }

    public void setRooms(Room[][] rooms) {
        this.rooms = rooms;
    }
    //预定房间
    public void yuding(int roomNo){
        int x = roomNo/100 -1;
        int y = roomNo%100 -1;
        if (rooms[x][y].isIsfree() == true){
            System.out.println(rooms[x][y].getNo()+"房间已被人预定，请换房");
            return;
        }
        rooms[x][y].setIsfree(true);
        System.out.println(rooms[x][y].getNo()+"房间预定成功");
    }
    //退房
    public void tuifang(int roomNo){
        int x = roomNo/100 -1;
        int y = roomNo%100 -1;
        if (rooms[x][y].isIsfree() == false){
            System.out.println(rooms[x][y].getNo()+"房间并未被预定，无法退房");
            return;
        }
        rooms[x][y].setIsfree(false);
        System.out.println(rooms[x][y].getNo()+"房间退房成功");
    }
    //打印出所有房间状态
    public void check(){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length ; j++) {
                System.out.print(rooms[i][j].toString());
            }
            System.out.println();
        }
    }

}
class Room{
    private int no;
    private String leixing;
    private boolean isfree;

    public Room() {
    }

    public Room(int no, String leixing, boolean isfree) {
        this.no = no;
        this.leixing = leixing;
        this.isfree = isfree;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }

    public boolean isIsfree() {
        return isfree;
    }

    public void setIsfree(boolean isfree) {
        this.isfree = isfree;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof Room))return false;
        if (this == obj)return true;
        Room room = (Room)obj;
        if(this.no == room.getNo())return true;
        return false;
    }


    @Override
    public String toString() {
        return "["+no+","+leixing+","+(isfree?"占用]":"空闲]");
    }
}