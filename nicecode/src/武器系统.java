
public class 武器系统{//可将此系统的move和attack改成接口，减小耦合度
    public static void main(String[] args) {
        Army a = new Army(4);
        Weapon w1 = new Gun("手枪",true, false);
        Weapon w2 = new Gun("步枪",true, false);
        Weapon w3 = new Gun("狙击枪",true, false);
        Weapon w4 = new Car("卡车",false,true);
        Weapon w5 = new Car("卡车",false,true);
        try {
            a.addWeapon(w1);
            a.addWeapon(w2);
            a.addWeapon(w3);
            a.addWeapon(w4);
            a.addWeapon(w5);
        } catch (AddWeaponException e) {
            e.printStackTrace();
        }

        a.attack();
        a.move();
    }
}
class Army{
    //存储所有武器
    private Weapon[] w;
    //Constructor
    public Army() {
    }

    public Army(int max){ //max -->武器数量最大值
        w = new Weapon[max];
    }

    //getter and setter
    public Weapon[] getW() {
        return w;
    }

    public void setW(Weapon[] w) {
        this.w = w;
    }
    //把武器填入数组的方法
    public void addWeapon(Weapon wa) throws AddWeaponException {
        for (int i = 0; i <w.length ; i++) {
            if (null == w[i] ){
                w[i] = wa;
                return;
            }
        }
        throw new AddWeaponException("武器已达到上限！");
    }
    public void attack(){
        for (int i = 0; i < w.length; i++) {
            if (w[i] == null){
                return;
            }
            if (true == w[i].isAttack()) {
                System.out.println(w[i].getName() + "正在攻击");
            }
        }
    }

    public void move(){
        for (int i = 0; i < w.length; i++) {
            if (w[i] == null){
                return;
            }
            if (true == w[i].isMove()) {
                System.out.println(w[i].getName() + "正在移动");
            }
        }
    }

}
class Weapon{
    private String name;
    private boolean attack;
    private boolean move;

    public Weapon() {
    }

    public Weapon(String name, boolean attack, boolean move) {
        this.name = name;
        this.attack = attack;
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAttack() {
        return attack;
    }

    public void setAttack(boolean attack) {
        this.attack = attack;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }
}
class Gun extends Weapon{

    public Gun() {
    }

    public Gun(String name, boolean attack, boolean move) {
        super(name, attack, move);
    }

}
class Car extends Weapon{
    public Car() {
    }

    public Car(String name, boolean attack, boolean move) {
        super(name, attack, move);
    }
}
class AddWeaponException extends Exception{
    public AddWeaponException() {
    }

    public AddWeaponException(String message) {
        super(message);
    }
}