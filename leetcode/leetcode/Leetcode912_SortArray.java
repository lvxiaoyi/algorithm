package leetcode;

import java.util.Arrays;
import java.util.Random;

public class Leetcode912_SortArray {
    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        Leetcode912_SortArray sortArray = new Leetcode912_SortArray();
        int[] ints = sortArray.sortArray(nums);
        System.out.println(Arrays.toString(ints));

    }

    public int[] sortArray(int[] nums) {
        /**
         *
         * 快排：定义一个基准值，比基准值小的放左边，比基准值大的放右边
         *
         *
         */
        return sort(nums, 0, nums.length - 1);
    }

    private int[] sort(int[] nums, int low, int high) {
        if (low >= high) {
            return nums;
        }
        int left = low;
        int right = high;

        int randomIndex = new Random().nextInt(right - left + 1) + left;
        int temp = nums[left];
        nums[left] = nums[randomIndex];
        nums[randomIndex] = temp;

        int tempValue = nums[left];
        while (left < right) {
            while (right > left && nums[right] >= tempValue) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= tempValue) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = tempValue;
        sort(nums, low, left - 1);
        sort(nums, left + 1, high);
        return nums;
    }
}
