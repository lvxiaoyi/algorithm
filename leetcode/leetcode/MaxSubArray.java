package leetcode;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubArray = new MaxSubArray();
        int i = maxSubArray.maxSubArray(nums);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        /**
         * 题目只要求最大的值，不需要整个序列，如果前面的累和大于当前值，去取前面的累和，如果小于当前值，前面的累和复制为当前值
         *
         *
         */
        int pre = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i],nums[i]);
            max = Math.max(pre,max);
        }
        return max;
    }
}
