public class 消费者和生产者模式打印奇偶数 {
    public static void main(String[] args) {
        Num n = new Num(0);
        jishu t1 = new jishu(n);
        oushu t2 = new oushu(n);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

class Num{
    private int i;

    public Num() {
    }

    public Num(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class jishu extends Thread{
    private Num num;

    public jishu(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (true){
            synchronized (num){
                if (num.getI()%2 == 1){
                    System.out.println(Thread.currentThread().getName()+"----->"+num.getI());

                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num.setI(num.getI()+1);
                num.notifyAll();
            }
        }

    }
}

class oushu extends Thread{
    private Num num;

    public oushu(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        while(true){
            synchronized (num){
                if (num.getI()%2 == 0){
                    System.out.println(Thread.currentThread().getName()+"----->"+num.getI());

                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num.setI(num.getI()+1);
                num.notifyAll();
            }
        }

    }
}