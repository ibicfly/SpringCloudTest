package io.ibicfly.service0.leetcode;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class LeetCode557 {
    public String reverseWords(String s) {
        String[] sArr = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        for (String temp : sArr)
            buffer.append(new StringBuffer(temp).reverse().toString() + " ");
        return buffer.subSequence(0, buffer.length() - 2).toString();
    }
}
