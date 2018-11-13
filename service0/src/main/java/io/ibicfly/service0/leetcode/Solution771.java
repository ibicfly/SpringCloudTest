package io.ibicfly.service0.leetcode;

public class Solution771 {
    /**
     * J是需要查找的类型
     * S是查找的字符串
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        if (J == null || J.equals("") || S == null || S.equals(""))
            return res;
        for (char j : J.toCharArray()) {
            for (char s : S.toCharArray()) {
                if (j == s)
                    res++;
            }
        }
        return res;
    }
}
