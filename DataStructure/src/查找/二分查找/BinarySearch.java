package 查找.二分查找;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        int[] arr= {1,3,8,15,19,25,36,38,48,56,68,79,88,99,105,112,118,200};

//        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 5);
        int i = binarySearch(arr, 0, arr.length - 1, 3);
        System.out.println(i);
//        System.out.println(list);

    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        System.out.println("被调用");
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;

        if (arr[mid] < findVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (arr[mid] > findVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }

    //找出每一个数字的下标
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;

        if (arr[mid] < findVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (arr[mid] > findVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            List<Integer> resIndexList = new ArrayList<>();

            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == findVal) {
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == findVal) {
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }

    }
}
