package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author: lvxiaoyi
 * @Description:
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 *
 * @DateTime: 2023/12/18 22:38
 */


public class Leetcode20_IsValid {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(new Leetcode20_IsValid().isValid(s));

    }

    public boolean isValid(String s) {
        int length = s.length();
        if ((length % 2) != 0){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }


}
