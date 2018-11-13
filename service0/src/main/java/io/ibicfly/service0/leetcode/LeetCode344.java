package io.ibicfly.service0.leetcode;

public class LeetCode344 {
    public static String reverseString(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] arrs = s.toCharArray();
        for (int i = 0; i < arrs.length / 2; i++) {
            char temp = arrs[i];
            arrs[i] = arrs[arrs.length - i - 1];
            arrs[arrs.length - i - 1] = temp;
        }
        for (char temp : arrs)
            stringBuffer.append(temp);
        return stringBuffer.toString();
    }

    public static String reverse(String s) {
        boolean hasSurrogates = false;
        int count = s.length();
        char[] value = s.toCharArray();
        int n = count - 1;
        for (int j = (n - 1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = value[j];
            char ck = value[k];
            value[j] = ck;
            value[k] = cj;
            if (Character.isSurrogate(cj) ||
                    Character.isSurrogate(ck)) {
                hasSurrogates = true;
            }
        }
        return s;
    }

    private static void reverseAllValidSurrogatePairs(String s) {
        int count = s.length();
        char[] value = s.toCharArray();
        for (int i = 0; i < count - 1; i++) {
            char c2 = value[i];
            if (Character.isLowSurrogate(c2)) {
                char c1 = value[i + 1];
                if (Character.isHighSurrogate(c1)) {
                    value[i++] = c1;
                    value[i] = c2;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
        reverseAllValidSurrogatePairs("hello");
    }
}
