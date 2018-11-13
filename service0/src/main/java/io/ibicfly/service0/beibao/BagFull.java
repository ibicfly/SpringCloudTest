package io.ibicfly.service0.beibao;

import java.io.DataOutputStream;

/**
 * 完全背包
 * 有n种物品，每个物品有各自的价值
 * 在其中挑选重量为W的物品，要求价值最大
 */
public class BagFull {
    static int[] w = {3, 4, 2};
    static int[] v = {4, 5, 3};
    public static void main(String[] args) {
        int W = 7;
        System.out.println(recDynamic(3,W));
    }
    public static int recDynamic(int n,int W)
    {
//        动态规划的01背包
        int[][] dp=new int[n+1][W+1];
        for(int i=1;i<=n;i++)
        {
//            从0开始迭代背包的大小进行选择
            for(int j=1;j<=W;j++)
            {
                for(int k=0;k<=j/w[i-1];k++)
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-k*w[i-1]]+k*v[i-1]);
                }
            }
        }
        for(int[] dpTemp:dp)
        {
            for(int temp:dpTemp)
                System.out.print(temp+" ");
            System.out.println();
        }
        return dp[n][W];
    }
}
