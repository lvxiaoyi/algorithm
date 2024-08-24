package src.sort;

import java.util.Arrays;

public class QuiteSort {
    public static void main(String[] args) {
        int[] arr = {8, 5, 3, 2, -1, 4, -9};

        int[] sort = sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] sort(int[] arr, int low, int high) {
        /**
         * 选择一个基准值，比基准值小的放左边，比基准值大的放右边
         *      双指针，如果右边的值小于基准值，把这个值覆盖到原来基准值为止
         *      如果左边的值大于基准值，把这个值覆盖到原来right的位置
         * 从内层循环迭代，最后从左到右一定是依次递增的
         *
         *
         *
         */
        if (low >= high) {
            return arr;
        }

        int left = low;
        int right = high;
        int tempReferenceValue = arr[left];

        while (left < right) {
            // 左边一直遍历，直到找到一个小于基准值的，覆盖temp
            while (left < right && arr[right] >= tempReferenceValue) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tempReferenceValue) {
                left++;
            }
            arr[right] = arr[left];
        }
        // 把基准值放到对应已经排好序的位置上
        arr[left] = tempReferenceValue;
        sort(arr, low, left - 1);
        sort(arr, left + 1, high);
        return arr;
    }

}
