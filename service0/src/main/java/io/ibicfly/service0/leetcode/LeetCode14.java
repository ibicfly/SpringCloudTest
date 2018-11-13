package io.ibicfly.service0.leetcode;

import io.swagger.models.auth.In;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/9 16:31
 * @Description: 作用描述
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LeetCode14 {
    //    如果是前缀，可以采用贪心的形式进行查找
    public String longestCommonPrefix(String[] strs) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean diff = true;
        try {
            for (int i = 0; i < strs[0].length() && diff; i++) {
                char a = strs[0].charAt(i);
                for (String temp : strs) {
                    if (a != temp.charAt(i)) {
                        diff = false;
                        break;
                    }
                }
                if (diff)
                    stringBuffer.append(a);
            }

        } catch (IndexOutOfBoundsException e) {
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String[] a = {"flower", "flow", "flight"};
        String[] b = {"dog", "racecar", "car"};
        System.out.println(new LeetCode14().longestCommonPrefix(b));
    }
}
