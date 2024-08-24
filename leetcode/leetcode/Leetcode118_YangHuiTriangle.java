package leetcode;


/*
 * @Description:
 * @Author: zixin.lv
 * @Date: 2023/3/19 22:24
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leetcode118_YangHuiTriangle {
    public static void main(String[] args) {
        int num = 5;
        try {
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Solution solution = new Solution();
        List<List<Integer>> generate = solution.generate(num);
        System.out.println(generate);
    }

    private static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (i == 0) {
                        row.add(1);
                        break;
                    }
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        List<Integer> oldRow = result.get(i - 1);
                        row.add(oldRow.get(j - 1) + oldRow.get(j));
                    }
                }
                result.add(row);
            }
            return result;
        }
    }

}
