package 排序.选择;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {1,34,119,101,5,78,-5};

//看看具体时间
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = simpleDateFormat.format(date1);
        System.out.println(time1);

        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (i != minIndex){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            //这种方法比较麻烦，不如直接看最大下标是否为当前最后一个(这里用的是先找最大)
//            if (arr[arr.length - 1 -i] < max){
//                arr[maxIndex] = arr[arr.length-1-i];
//                arr[arr.length-1-i] = max;
//            }

//            for (int j = 0; j < arr.length; j++) {
//                System.out.print(arr[j]+"  ");
//            }
//            System.out.println();
        }

        Date date2 = new Date();
        String time2 = simpleDateFormat.format(date2);
        System.out.println(time2);
    }
}
