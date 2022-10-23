package sort;

import java.util.Arrays;

public class MaoPaoSort {
    public static void main(String[] args) {
        int arr[] = {8, 5, 3, 2, -1, 4, -9};
        Solution solution = new Solution();
        solution.maoPao(arr);
    }

    private static class Solution {
        public void maoPao(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            System.out.printf(Arrays.toString(arr));
        }
    }
}