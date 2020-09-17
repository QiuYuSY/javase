package 排序.冒泡;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {1,5,8,-4,6};

        //看看具体时间
        int[] arr = new int[80000];//10秒
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = simpleDateFormat.format(date1);
        System.out.println(time1);

        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = false;//用于判断是否已经排好序,这是冒泡优化
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
//            for (int k = 0; k < arr.length; k++) {
//                System.out.print(arr[k]+"  ");
//            }
//            System.out.println();
        }


        Date date2 = new Date();
        String time2 = simpleDateFormat.format(date2);
        System.out.println(time2);


    }
}
