package io.ibicfly.service0.leetcode;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/19 9:09
 * @Description: 作用描述
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 */
public class LeetCode231 {
    public boolean isPowerOfTwo(int n) {
        boolean res=false;
        if(n<=0)
            return res;
        int temp=n>>1;
        while(temp>0)
        {
            if((temp&n)!=0)
            {
                return res;
            }
            temp>>=1;
        }
        res=true;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode231().isPowerOfTwo(3));;
    }
}
