package 查找.插值查找;

public class InsertValueSearch {
    public static void main(String[] args) {
//        int[] arr = new int[100];
//        for (int i = 0; i < 100; i++) {
//            arr[i] = i+1;
//        }
        int[] arr= {1,3,8,15,19,25,36,38,48,56,68,79,88,99,105,112,118,200};

        int i = insertValueSearch(arr,0,arr.length-1,1);
        System.out.println(i);
//        System.out.println(Arrays.toString(arr));
    }

    public static int insertValueSearch(int[] arr,int left, int right, int findVal){

        System.out.println("被调用");

        if (left > right || findVal < arr[0] || findVal > arr[arr.length-1]){
            //为什么要比二分法多了两个比较？
            //因为如果findVal如果非常大或者非常小在下面的程序中会导致mid很大或很小，就有可能就越界
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if (arr[mid] < findVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (arr[mid] > findVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
