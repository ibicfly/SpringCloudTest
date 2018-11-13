package io.ibicfly.service0.leetcode;

/**
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 *
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 *
 * 输入: "LOVELY"
 * 输出: "lovely"
 * 水题
 */
public class LeetCode709 {
    public static String toLowerCase(String str) {
        char[] chars=str.toCharArray();
        StringBuffer stringBuffer=new StringBuffer();
        for (char temp:chars)
        {
            if(temp>='A'&&temp<='Z')
                temp+=32;
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        char a='a';
        char A='A';
        System.out.println(toLowerCase(A+""));
    }
}
