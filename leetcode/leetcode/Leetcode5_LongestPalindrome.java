package leetcode;

public class Leetcode5_LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        Leetcode5_LongestPalindrome longestPalindrome = new Leetcode5_LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        /**
         *
         * 动态规划，如果当前字符串是回文子串，那么去掉两头的字符后的字符串也一定是一个回文字符串
         *
         * 所以要判断字符是不是回文字符串，只需要判断两头的字符串是不是回文字符串且内部的字符串是不是回文字符串
         *
         * 所以需要判断所有子串的是不是回文字符串，找出所有子串是否回文的状态,
         * 加入字符的位置为num[i][j],去掉两头字符的位置为[i--][j++]
         *
         * 1. 两个字符的判断方法，这两个字符是否相等
         * 2. 大于两个字符，两头是否相等且内部子串是否相等
         *
         */

        int n = s.length();
        boolean[][] array = new boolean[n][n];
        int begin = 0;
        int end = 0;
        int max = -1;
        for (int i = 0; i < n; i++) {
            array[i][i] = true;
        }
        for (int j = n - 1; j >= 0; j--) {
            for (int i = j; i < n; i++) {
                if (i - j == 1 && s.charAt(i) == s.charAt(j)) {
                    array[i][j] = true;
                } else if (i - j > 1) {
                    array[i][j] = s.charAt(i) == s.charAt(j) && array[i - 1][j + 1];
                }
                if (i - j > max && array[i][j]) {
                    max = i - j;
                    begin = j;
                    end = i;
                }

            }
        }


        return s.substring(begin, end + 1);
    }


}
