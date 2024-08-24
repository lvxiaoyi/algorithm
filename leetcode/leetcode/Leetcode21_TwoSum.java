package leetcode;

import java.util.Arrays;

public class Leetcode21_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        Leetcode21_TwoSum twoSum = new Leetcode21_TwoSum();
        int[] ints = twoSum.twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {

        /**
         *
         * 1. 对数组进行排序
         * 2. 使用双指针，如果 left + right == target，加入
         * 3. 去重，如果当前元素和上一个元素相等，跳过
         *
         *
         */
        int[] result = new int[2];
        if (nums.length < 2) {
            return result;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left > 0 && nums[left] == nums[left - 1]) {
                left++;
            }
            while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                right--;
            }
            if (nums[left] + nums[right] == target) {
                result[0] = left;
                result[1] = right;
                return result;
            }else {
                left++;
            }

        }

        return result;
    }
}
