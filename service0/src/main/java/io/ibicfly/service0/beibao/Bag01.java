package io.ibicfly.service0.beibao;

/**
 * n=4
 * 重量w,价值v
 * (w,v)=(2,3),(1,2),(3,4),(2,2)
 * W=5
 * 01背包，背包内的物品只能有两个状态，放入或者不放，而不存在多次放入的情况
 * 只存在两种状态的情况才能使用这种公式进行套用
 * 采用递归的形式进行放置
 */
public class Bag01 {
    static int[] w = {2, 1, 3, 4};
    static int[] v = {3, 2, 4, 2};
    public static void main(String[] args) {
        int W = 5;
        System.out.println(Rec(w.length - 1, W));
        System.out.println(recDynamic(4,W));
        System.out.println(recDynamicBetter(4,W));
    }

    public static int Rec(int i, int j) {
        int res;
        if (i == -1) {
            // 终止条件， 无物品可选 Rec(0, j) = 0
            // 0个物品可以选择，放入容量为j的背包， 得到的最大价值只能为0
            res = 0;
        } else if (j < w[i]) {
            // 背包剩余容量不足以放下第i个物品
            res = Rec(i - 1, j);
        } else {
            // 抉择，第i个物品选或者不选，都试一下，取较大值
            res = Math.max(Rec( i - 1, j),
                    (Rec(i - 1, j - w[i]) + v[i]));
        }
        return res;
    }

    /**
     *
     * @param n
     * 代表物品的个数
     * @param W
     * 代表背包的大小
     * @return
     */
    public static int recDynamic(int n,int W)
    {
//        动态规划的01背包
        int[][] dp=new int[n+1][W+1];
        for(int i=1;i<=n;i++)
        {
//            从0开始迭代背包的大小进行选择
            for(int j=1;j<=W;j++)
            {
                if(w[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i-1]]+v[i-1]);
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

    /**
     * 优化01背包问题空间复杂度，因为只是用到了上一行的数据，所以只要构造两行就足够
     * @param n
     * @param W
     * @return
     */
    public static int recDynamicBetter(int n,int W)
    {
//        动态规划的01背包
        int[] dp=new int[W+1];
        for(int i=1;i<=n;i++)
        {
//            从0开始迭代背包的大小进行选择
//            根据算法可知，因为现在是取了前面某列的值，原来取得是上一行某列的值，
// 现在的上一行不存在，所以，我们在取第4列的数据的时候会取到本行前面的列赋的值
            for(int j=W;j>=0;j--)
            {
                if(w[i-1]>j)
                    dp[j]=dp[j];
                else {
                    dp[j] = Math.max(dp[j], dp[j - w[i-1]] + v[i-1]);
                }
            }
        }

        for(int temp:dp)
            System.out.print(temp+" ");
        return dp[W];
    }
}
