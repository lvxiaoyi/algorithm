package leetcode;

/**
 * @Author: lvxiaoyi
 * @Description: 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * <p>
 * 答案需要取模 1e9+7(1000000007) ，如计算初始结果为：1000000008，请返回 1。
 * @DateTime: 2023/12/23 23:05
 */

public class Leetcode126_Fib {
    public static void main(String[] args) {
        System.out.println(new Leetcode126_Fib().fib(4));
    }

    /**
     * @Author: lvxiaoyi
     * @Description:
     * 正常的动态规划的解法
     * @DateTime: 2023/12/23 23:22
     */

    public int fib(int n) {
        if (n == 1) {
            return 1;
        }
        int pre = 0;
        int cur = 1;

        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (pre + cur)% 1000000007;
            pre = cur;
            cur = result;
        }
        return result;
    }


    /**
     * @Author: lvxiaoyi
     * @Description:
     *
     * 针对这道题，我们还可以利用矩阵相乘的解法
     * 为什么会出现这个？
     * 0112358
     * 假设一个
     * 二维矩阵abcd，乘上一个10向量等于11向量
     * 二维矩阵abcd，乘上一个11向量等于21向量
     * 二维矩阵abcd，乘上一个21向量等于32向量
     * ...
     * 最后我们能解出这个矩阵abcd，abc均为1，d为0的这样的一个二维矩阵，验证后发现对所有的f(n)都适用于这个矩阵
     * 所以
     * f(n)等于这个这个矩阵的n-1次幂呈上这个01向量
     *
     * @DateTime: 2023/12/23 23:22
     */

    public int fib2(int n) {
        //矩阵快速幂
        if (n < 2) {
            return n;
        }
        //定义乘积底数
        int[][] base = {{1, 1}, {1, 0}};
        //定义幂次
        int power = n - 1;
        int[][] ans = calc(base, power);
        //按照公式，返回的是两行一列矩阵的第一个数
        return ans[0][0];
    }

    //定义函数,求底数为 base 幂次为 power 的结果
    public int[][] calc(int[][] base, int power) {
        //定义变量，存储计算结果，此次定义为单位阵
        int[][] res = {{1, 0}, {0, 1}};

        //可以一直对幂次进行整除
        while (power > 0) {
            //1.若为奇数，需多乘一次 base
            //2.若power除到1，乘积后得到res
            //此处使用位运算在于效率高
            if ((power & 1) == 1) {
                res = mul(res, base);
            }
            //不管幂次是奇还是偶，整除的结果是一样的如 5/2 和 4/2
            //此处使用位运算在于效率高
            power = power >> 1;
            base = mul(base, base);
        }
        return res;
    }

    //定义函数,求二维矩阵：两矩阵 a, b 的乘积
    public int[][] mul(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                //矩阵乘积对应关系，自己举例演算一遍便可找到规律
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

}
