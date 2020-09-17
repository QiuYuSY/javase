package 排序.基数;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214,0};
        int[] arr = new int[40000000];//2秒
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        int[] temp = new int[arr.length];

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = simpleDateFormat.format(date1);
        System.out.println(time1);

        radixSort(arr);

        Date date2 = new Date();
        String time2 = simpleDateFormat.format(date2);
        System.out.println(time2);
    }

    //基数排序方法
    public static void radixSort(int[] arr) {
        int max = arr[0];

        //得到最大值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //获取最大值长度
        int maxLength = (max + "").length();//这种比下面的那种更巧妙
//        while (Math.abs(max) / 10 > 0) {
//            max /= 10;
//            weishuForMax++;
//        }

        int[][] bucket = new int[10][arr.length];
        int[] index = new int[10];//记录放了几个进桶
        int no = 0;//原数组第几个数据
        int count = 0;//该轮位数上的数是什么

        for (int time = 0, n = 1; time < maxLength; time++, n *= 10) {

            for (int i = 0; i < arr.length; i++) {
                count = arr[i] / n % 10;
                bucket[count][index[count]] = arr[i];
                index[count]++;
            }
            no = 0;
            //把桶的数据弄回原数组
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < index[i]; j++) {
                    arr[no++] = bucket[i][j];
                }
                index[i] = 0;//索引重新指向0
            }

//            System.out.println(Arrays.toString(arr));

        }

//打印桶内信息
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < index[i]; j++) {
//                System.out.print("第"+i+"个桶"+bucket[i][j]+"  ");
//            }
//            System.out.println();
//        }
    }
}


