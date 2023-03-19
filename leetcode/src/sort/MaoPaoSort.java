package src.sort;

import java.util.Arrays;


/*
 * @Description:
 * 大的值放后面
 * @Author: zixin.lv
 * @Date: 2023/3/19 20:47
 */


public class MaoPaoSort {
    public static void main(String[] args) {
        int arr[] = {8, 5, 3, 2, -1, 4, -9};
        Solution solution = new Solution();
        solution.maoPao(arr);
    }

    static class Solution {
        public void maoPao(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                boolean isBreak = false;
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        isBreak = true;
                    }
                }
                if (!isBreak) {
                    break;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}