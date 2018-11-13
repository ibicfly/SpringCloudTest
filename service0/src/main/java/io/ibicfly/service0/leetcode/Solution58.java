package io.ibicfly.service0.leetcode;

import java.util.Scanner;
import java.util.Arrays;

public class Solution58{
//采用了递归的方式，进行
    //其实是将fibnacii数列变换成了一次增加多个值，然后将最后一个取值取出来
    public static long count(int n) {
        if (n <= 0) return 0;
        int[] coins = new int[]{1, 5, 10, 20, 50, 100};
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];//类似斐波那契 后者的种类数基于前者
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            long res = count(n);
//            System.out.println(res);
//        }
//        System.out.println(count(11));
        System.out.println(maxSubString("abca","asdfbcadsf"));
    }

    public static int maxSubString(String a,String b)
    {
        int[][] signs=new int[a.length()][b.length()];//建立打标数组
        int max=0;
        for(int i=0;i<a.length();i++)
        {
            for(int j=0;j<b.length();j++)
            {
                if(a.charAt(i)==b.charAt(j))
                {
                    if(i==0||j==0)
                        signs[i][j]=1;
                    else
                        signs[i][j]=signs[i-1][j-1]+1;
                }
                if(max<signs[i][j])
                    max=signs[i][j];
            }
        }

        return max;
    }
}
