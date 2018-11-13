package io.ibicfly.service0.leetcode;

import java.util.Stack;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/15 9:21
 * @Description: 作用描述
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class LeetCode20 {
    static final char[] CHARS = {'(', '{', '[', ']', '}', ')'};

    public boolean isValid(String s) {
        boolean res = true;
        char[] chars = s.toCharArray();
        if (chars.length % 2 == 1)
            return false;
        int i = 0;
        Stack<Character> stack = new Stack();
        try {
            while (i < chars.length) {
                char temp = chars[i];
                int index = findIndex(temp);
                if (index < CHARS.length / 2) {
                    stack.push(temp);
                } else {
                    char popNode = stack.pop();
                    int indexSum = findIndex(popNode) + findIndex(chars[i]);
                    if (CHARS.length - 1 != indexSum) {
                        res = false;
                        break;
                    }
                }
                i++;
            }
            if (!stack.isEmpty())
                res = false;
        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public boolean isValid2(String s) {
//      使用了数组的第一个位置作为临时缓存位
        char[] chs = s.toCharArray();
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    chs[cur++] = c;
                    break;

                case ')':
                    if (cur == 0) return false;
                    char c1 = chs[--cur];
                    if (c1 != '(') return false;
                    break;
                case ']':
                    if (cur == 0) return false;
                    char c2 = chs[--cur];
                    if (c2 != '[') return false;
                    break;
                case '}':
                    if (cur == 0) return false;
                    char c3 = chs[--cur];
                    if (c3 != '{') return false;
                    break;
            }
        }
        if (cur != 0) {
            return false;
        }
        return true;
    }

    public int findIndex(char input) {
        int res = -1;
        for (int i = 0; i < CHARS.length; i++) {
            if (CHARS[i] == input)
                res = i;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        String s1 = "((";
        System.out.println(new LeetCode20().isValid2(s));
    }
}
