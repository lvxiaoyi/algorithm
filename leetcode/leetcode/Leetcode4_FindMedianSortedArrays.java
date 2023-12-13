package leetcode;

public class Leetcode4_FindMedianSortedArrays {
    public static void main(String[] args) {
        Leetcode4_FindMedianSortedArrays leetcode = new Leetcode4_FindMedianSortedArrays();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(leetcode.findMedianSortedArrays(nums1, nums2));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        if (size % 2 == 0) {
            return (findMedianSortedArrays_1(nums1, nums2, size / 2) + findMedianSortedArrays_1(nums1, nums2, size / 2 + 1)) / 2.0;
        } else {
            return findMedianSortedArrays_1(nums1, nums2, size / 2 + 1);
        }
    }


    public double findMedianSortedArrays_1(int[] nums1, int[] nums2, int k) {
        // 寻找两个数组中第k大的元素
        int index1 = 0;
        int index2 = 0;

        while (true){
            if (index1 == nums1.length){
                return nums2[index2 + k -1];
            }
            if (index2 == nums2.length){
                return nums1[index1 + k -1];
            }
            if (k == 1){
                return Math.min(nums1[index1],nums2[index2]);
            }

            int half = k/2;

            int num1 = Math.min(index1 + half,nums1.length) - 1;
            int num2 = Math.min(index2 + half,nums2.length) - 1;

            int value1 = nums1[num1];
            int value2 = nums2[num2];
            if (value1<=value2){
                k = k- (num1 - index1 + 1);
                index1 = num1 + 1;
            }else {
                k = k -  (num2 - index2 + 1);
                index2 = num2 + 1;
            }

        }

    }
}
