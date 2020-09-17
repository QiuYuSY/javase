

import java.util.Arrays;
import java.util.Random;


 class Test {
    public static void main(String[] args) {

        Random r = new Random();
        int[] i = new int[5];
        for (int j = 0; j < i.length; j++) {
            i[j] = -1;
        }
        int j = 0;

        while (j < i.length) {
            int index = r.nextInt(5);
            if (!contains(i, index)) {
                i[j] = index;
                j++;
            }
        }
        for (int k = 0; k < i.length; k++) {
            System.out.println(i[k]);
        }
    }

    /**
     *
     * @param ints 数组
     * @param i 查找的元素
     * @return 大于等于0，找到 小于0没找到
     */
    public static boolean contains(int[] ints, int i) {
        //Arrays.sort(ints);
        //return Arrays.binarySearch(ints, i);
        // 有问题，每次都会进行排序，前一次赋给第一个的值有可能到后面的位置去
        //但是提供了一种思想,从main方法中提取一部分到别的方法里

        //使用遍历的方法
        for (int j = 0; j < ints.length; j++) {
            if (ints[j] == i) {
                return true;
            }
        }
        return false;
    }
}

