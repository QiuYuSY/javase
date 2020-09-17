package 递归.八皇后问题;

public class Queue8 {

    int max = 8;
    int[] array =new int[max];
    static int num = 0;
    static int nunJudge = 0;
    public static void main(String[] args) {


        Queue8 queue8 = new Queue8();

        queue8.add(0);

        System.out.println(num);
        System.out.println(nunJudge);


    }

    //放置第n个皇后
    public void add(int n){
        if (n == max){//这是第九个了
            print();
            num++;
            return;
        }
        //加入并判断是否冲突
        for (int i = 0; i < max; i++) {
            array[n] = i;
            nunJudge++;
            if (judge(n)){//不冲突
                //接着放n+1个皇后
                add(n+1);
            }
            //冲突，放下一列
        }

    }
    //放第n个皇后时，检测一下前面n-1个皇后是否和n冲突
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] -array[i])){
                //同列或在同一斜线（纵的差相等）
                return false;
            }
        }
        return true;
    }
    private void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
