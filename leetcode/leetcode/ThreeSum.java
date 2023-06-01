package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, -1, -1};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(nums);
        System.out.println(lists);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 1. 对数组进行排序 -4,-1,-1,0, 1, 2
         * 2. 从第i位开始，相当于遍历求任意两个数相加等于-num[i]
         * 3. 定义left和right
         *          如果nums[left]+nums[right]+nums[i]>0,说明最大位的数太大，需要right--
         *          如果nums[left]+nums[right]+nums[i]<0,说明最小位的数太小，需要left++
         *          如果nums[left]+nums[right]+nums[i]=0,加入result结果集
         *  4. 去重
         *      1. 对nums[i]去重，排序后的nums[i] = nums[i-1]，continue
         *      2. 对nums[left]和nums[right]去重，如果nums[left] = nums[left-1],left++  ....
         *
         */
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return result;
        }


        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left-1]){
                    left++;
                    continue;
                }

                if (right < nums.length - 1 && nums[right] == nums[right+1]){
                    right--;
                    continue;
                }

                if (nums[left] + nums[right] + nums[i] == 0) {
                    LinkedList<Integer> temp = new LinkedList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                }

                if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

}
