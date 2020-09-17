package 排序.归并;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MergerSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        int[] arr = new int[40000000];//5秒
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        int[] temp = new int[arr.length];

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = simpleDateFormat.format(date1);
        System.out.println(time1);



        mergeSort(arr,0,arr.length-1,temp);

        Date date2 = new Date();
        String time2 = simpleDateFormat.format(date2);
        System.out.println(time2);

//        System.out.println(Arrays.toString(arr));
    }
    //分+合并
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }

    //合并

    /**
     * @param arr   排序的原始数组
     * @param left  左边有序数组的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;//temp用的索引

        //左右两边的数据填充到temp
        //直到左右两边有一边处理完毕
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //把剩下的都填充过去

        //左边满了
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        //右边满了
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }


        //把temp填回原数组
        //不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}


