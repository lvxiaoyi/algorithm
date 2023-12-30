package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: lvxiaoyi
 * @Description: 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * @DateTime: 2023/12/25 21:34
 */

public class Leetcode322_CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 11;
        System.out.println(new Leetcode322_CoinChange().coinChange(coins, amount));
    }

    /**
     * @Author: lvxiaoyi
     * @Description: 动态规划
     * 动态规划的核心就是根据递归逆推出公式
     * f0 = -1
     * f1 = 1
     * fn = min(f(n-coin)) + 1 , coin属于coins
     * <p>
     * 中间我们可以使用一个数组保存过去的结果
     * @DateTime: 2023/12/25 21:36
     */

    public int coinChange(int[] coins, int amount) {
        int size = coins.length;
        if (size == 0 ) {
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];

    }


}
