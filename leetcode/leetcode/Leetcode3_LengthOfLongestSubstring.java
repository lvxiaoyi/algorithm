package leetcode;


/* 
 * @Description:
 *


给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 *
 * @Author: zixin.lv
 * @Date: 2023/3/19 20:29
 */

import java.util.HashMap;

public class Leetcode3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        Leetcode3_LengthOfLongestSubstring mode = new Leetcode3_LengthOfLongestSubstring();
        String s = "abcabcbb";
        System.out.println(mode.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        int max = 0;
        HashMap<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (cache.containsKey(charAt)) {
                left = Math.max(left, cache.get(charAt) + 1);
            }
            max = Math.max(max, i - left + 1);
            cache.put(charAt, i);
        }
        return max;
    }

}
