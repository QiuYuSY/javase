import java.util.Random;


public class 生成五个不重复随机数 {
    public static void main(String[] args) {

        Random r = new Random();
        int[] i = new int[5];
        i[0] = r.nextInt(5);

        for (int j = 1; j < i.length; j++) {//为数组每个空间分配数字

            while(true){
                int index = r.nextInt(5);
                boolean b = false;
                for (int k = 0; k < j; k++) {
                    //如果生成的不等于当前数组的数字，比较下一位
                    if (index != i[k]) {

                    } else if (index == i[k]) { //如果等于，重新生成随机数
                        index = r.nextInt(5);
                        System.out.println(index+"isnot");
                        b = true;
                        break;
                    }
                }
                if (b==false){
                    i[j] = index;
                    break;
                }
            }
        }
        for (int j = 0; j < i.length; j++) {
            System.out.println(i[j]);
        }
    }
}
