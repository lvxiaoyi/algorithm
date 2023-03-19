package src.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {8, 5, 3, 2, -1, 4, -9};
        Solution solution = new Solution();
        solution.select(arr);
    }

    private static class Solution {
        public void select(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < arr.length ; j++) {
                    if (arr[min] > arr[j]) {
                        min = j;
                    }
                }
                if (min != i){
                    int temp = arr[i];
                    arr[i] = arr[min];
                    arr[min] = temp;
                }

            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
