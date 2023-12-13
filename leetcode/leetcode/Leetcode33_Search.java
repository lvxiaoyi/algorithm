package leetcode;

/**
 * @Author: lvxiaoyi
 * @Description: 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * @DateTime: 2023/12/13 22:07
 */

public class Leetcode33_Search {
    public static void main(String[] args) {
        int[] nums = {3,1};
        Leetcode33_Search leetcode_33_search = new Leetcode33_Search();
        int search = leetcode_33_search.search(nums, 1);
        System.out.println(search);
    }

    /**
     * @Author: lvxiaoyi
     * @Description: 二分法
     * mid = (left + right) / 2
     * mid左右和右边必定有一个是完全升序的的，另一个可能是升序说明刚好mid在中间或者是大小大的部分升序，在对这部分继续mid二分
     * @DateTime: 2023/12/13 22:16
     */

    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        } else if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            // 如果left < mid 说明left到mid是升序的
            if (nums[left] <= nums[mid]){
               if (nums[left] <= target && target < nums[mid]){
                   // 值在前半段
                   right = mid - 1;
               }else {
                   // 值在后半段
                   left = mid + 1;
               }
            }else{
                // left到mid中间有旋转值，mid后面的额值为完全升序，所以可以判断target在mid的前面还是后面
                if (nums[mid] < target && target <= nums[right]){
                    //值在后面
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }

            }
        }



        return -1;
    }

}
