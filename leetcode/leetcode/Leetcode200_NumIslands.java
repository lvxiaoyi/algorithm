package leetcode;

/**
 * @Author: lvxiaoyi
 * @Description: 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * @DateTime: 2023/12/14 22:06
 */

public class Leetcode200_NumIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(new Leetcode200_NumIslands().numIslands(grid));

    }

    /**
     * @Author: lvxiaoyi
     * @Description: 深度优先便利（一次深度优先遍历完成代表一个岛屿）
     * 对每一个节点进行深度遍历，知道遇到0或者边界在深度遍历完成说明是一个岛屿
     * 定义一个数组标记是否访问过，这样对一个岛屿的就不会重复计数
     * @DateTime: 2023/12/14 22:42
     */

    public int numIslands(char[][] grid) {
        int num = 0;
        // 行 row 列 col
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs1(grid, r, c);
                    num++;
                }

            }
        }
        return num;
    }

    private void dfs1(char[][] grid, int r, int c) {
        // 如果传入的坐标出边界了或者坐标为0或者坐标为2（代表访问过了）直接返回

        // 出边界了
        if (!(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)) {
            return;
        }
        if (grid[r][c] != '1') {
            return;
        }
        //继续遍历
        grid[r][c] = '2';
        dfs1(grid, r - 1, c);
        dfs1(grid, r + 1, c);
        dfs1(grid, r, c - 1);
        dfs1(grid, r, c + 1);
    }


    public int numIslands1(char[][] grid) {

        return 0;
    }

    public int numIslands2(char[][] grid) {

        return 0;
    }


}
