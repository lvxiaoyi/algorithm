package leetcode;

import java.util.Arrays;

/**
 * @Author: lvxiaoyi
 * @Description: 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * @DateTime: 2023/12/19 21:56
 */

public class Leetcode88_Merge {
    public static void main(String[] args) {

        int[] nums1 = {1};
        int[] nums2 = {};

        new Leetcode88_Merge().merge(nums1, 1, nums2, 0);

        System.out.println(Arrays.toString(nums1));

    }

    /**
     * @Author: lvxiaoyi
     * @Description: 申请一个m+n的空间sort
     * 两个都是非递减数列，可以使用双指针，如果left<=right,把left赋值到sort中，否则把right赋值到sort中
     * @DateTime: 2023/12/19 21:59
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m + n];
        int cur = 0;
        int left = 0;
        int right = 0;

        while (left < m || right < n) {
            if (left == m){
                sort[cur] = nums2[right++];
            }else if (right == n){
                sort[cur] = nums1[left++];
            }else if (nums1[left] <= nums2[right]){
                sort[cur] = nums1[left++];
            }else {
                sort[cur] = nums2[right++];
            }
            cur++;
        }
        for (int i = 0; i < m+n; i++) {
            nums1[i] = sort[i];
        }
    }

}
