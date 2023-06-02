package leetcode;

public class Leetcode215_FindKthLargest {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        Leetcode215_FindKthLargest leetcode215FindKthLargest = new Leetcode215_FindKthLargest();
        int kthLargest = leetcode215FindKthLargest.findKthLargest(arr, 2);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        /**
         *
         * 快排的变种，我们只需要找到第k大的数，不需要对数组全部排序
         * 快排，是选择一个基准值，比基准值大的放右边，如果右边的数据已经大于k的数量的了，我们就可以直接把左边的舍弃掉，
         * 如果恰好右边的数量就是k，说明我们的这个基准值就是我们要找打数
         *
         * 第k大的值的下标：nums.length - k
         */
       return quitSort(nums,0,nums.length-1,k)[nums.length - k];
    }

    private int[] quitSort(int[] arr, int low, int high, int k) {
        if (low >= high){
            return arr;
        }
        int left = low;
        int right = high;
        int tempReferenceValue = arr[left];
        while (left < right){
            while (left < right && arr[right] >= tempReferenceValue){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tempReferenceValue){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tempReferenceValue;
        while (left == arr.length - k){
            return arr;
        }
        if (arr.length - k < left){
            quitSort(arr,low,left-1,k);
        }
        quitSort(arr,left+1,high,k);
        return arr;
    }

}
