package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: lvxiaoyi
 * @Description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * @DateTime: 2023/12/22 20:55
 */


public class Leetcode46_Permute {
    public static void main(String[] args) {

        int nums[] = {1, 2, 3};
        System.out.println(new Leetcode46_Permute().permute(nums));
    }

    /**
     * @Author: lvxiaoyi
     * @Description: 现在正常思路，如果手写123的全排列怎么处理
     * 1. 取第一个，然后2和3交换
     * 2. 第一个和第二个交换，然后2和3交换
     * 3. 第一个和第三个交换，然后2和3交换
     * 4. 然后依次类推，
     * @DateTime: 2023/12/22 20:55
     */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> outPutTemp = new LinkedList<>();
        for (Integer num : nums) {
            outPutTemp.add(num);
        }
        dfs(0, result, outPutTemp);
        return result;

    }

    private void dfs(int index, List<List<Integer>> result, List<Integer> outPutTemp) {
        if (index == outPutTemp.size()) {
            result.add(new LinkedList<>(outPutTemp));
        }
        for (int i = index; i < outPutTemp.size(); i++) {
            Collections.swap(outPutTemp, index, i);
            dfs(index + 1, result, outPutTemp);
            Collections.swap(outPutTemp, i, index);
        }

    }

}
