package 查找.斐波那契;

import java.util.Arrays;

public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr= {1,3,8,15,19,25,36,38,48,56,68,79,88,99,105,112,118,200};


        System.out.println(fibSearch(arr,3));

    }

    //非递归的获得一个斐波那契数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    //编写斐波那契查找算法
    public static int fibSearch(int[] arr, int key){
        int left = 0;
        int right = arr.length-1;
        int k = 0;//表示斐波那契数组的下标
        int mid = 0;
        int f[] = fib();

        //获得斐波那契数列数值的下标
        while (f[k] < right + 1){
            k++;
        }

        //得到的k指向的数值可能比数值长度大，把数组长度补上
        int[] temp = Arrays.copyOf(arr,f[k]);
        //多出来的地方补上数组的最后一位数
        for (int i = right +1; i < temp.length; i++) {
            temp[i] = arr[right];
        }

        while (left <= right){
            System.out.println("被调用");
            mid = left + f[k-1] -1;//后一个减一是因为要的是数组下标，而f里的是长度
            if (arr[mid] > key){
                right = mid -1 ;
                k--;//长度变成了分割成的两块里头较大的那一块
            }else if (arr[mid] < key){
                left = mid+1;
                k-=2;//长度变为了分割成的两块里头教小的那一块
            }else if (arr[mid] == key){
                //有可能找到的是前面生成的那些数
                if (mid > left){
                    return left;
                }else {
                    return mid;
                }
            }

        }
        return -1;
    }
}
