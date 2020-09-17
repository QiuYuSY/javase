package 二叉树.堆排序;

public class HeapSort {
    public static void main(String[] args) {
        //升序排序，大顶堆
        int[] arr = {4, 6, 8, 5, 9};
//        int[] arr = new int[40000000];//11秒
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 800000);
//        }

//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time1 = simpleDateFormat.format(date1);
//        System.out.println(time1);

        heapSort(arr);

//        Date date2 = new Date();
//        String time2 = simpleDateFormat.format(date2);
//        System.out.println(time2);
    }

    //编写一个堆排序
    public static void heapSort(int[] arr) {
        int temp = 0;
        //变成大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        //排序：最大的放后面，然后再变成大顶堆，大的再放后面....
        for (int i = arr.length - 1; i > 0 ; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,i);
        }
    }

    /**
     * 将以i对应的非叶子节点的树调整成一个大顶堆
     * 例子： {4,6,8,5,9} --> i = 1  --->{4,9,8,5,6} --> i = 0 --->{9,6,8,5,4}
     *
     * @param arr    待调整数组
     * @param i      非叶子节点再数组中的索引
     * @param length 表示对多少个元素继续调整
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];

        //k = i * 2 + 1, k是i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;//指向右节点
            }
            if (arr[k] > temp) {//如果子节点大于父节点，较大的值给夫节点
                arr[i] = arr[k];
                i = k;//i指向k继续循环
            } else {//直接退出是因为排序是从左往右，从下往上的，不用担心下面还有更大的
                break;
            }
        }
        //把原父节点放在调整后的位置
        arr[i] = temp;
//        System.out.println(Arrays.toString(arr));
    }
}
