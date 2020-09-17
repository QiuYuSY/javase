package 排序.插入.直接插入;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {5, 1, 3, 2, 4};
        //看看具体时间
        int[] arr = new int[200000];//3秒
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = simpleDateFormat.format(date1);
        System.out.println(time1);

        insertSort(arr);

        Date date2 = new Date();
        String time2 = simpleDateFormat.format(date2);
        System.out.println(time2);

    }

    //插入排序
    public static void insertSort(int[] arr) {
        int insertVal;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //没越界并且当前比左边那个小，左边右移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //插入，如果比排好序的所有都大的话就不用插了
            if (insertIndex + 1 != i){
                arr[insertIndex + 1] = insertVal;
            }

//            for (int k = 0; k < arr.length; k++) {
//                System.out.print(arr[k] + "  ");
//            }
//            System.out.println();

        }
    }
}
