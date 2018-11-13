package io.ibicfly.service0.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class LeetCode9 {
    public static boolean isPalindrome(int x) {
        boolean res = true;
        String a = x + "";
        if (x < 0)
            return res = false;
        else if (x < 10)
            return res = true;
        char[] arr = a.toCharArray();
        for (int i = 0; i <= arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                res = false;
                break;
            }
        }
        return res;
    }
    public static boolean isPalindromeFastest(int x) {
        int origin=x;
        boolean res=true;
        if(x<0)
            return res=false;
        else if (x<10)
            return res;
        int a=10;
        long reverse = 0;
        while (x>0)
        {
            int temp=x%10;
            reverse*=10;
            reverse+=temp;
            x/=10;
        }
        return reverse==origin;
    }


        public static void main(String[] args) {
        System.out.println(isPalindromeFastest(121));
    }
}
