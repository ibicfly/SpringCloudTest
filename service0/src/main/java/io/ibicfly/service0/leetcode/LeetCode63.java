package io.ibicfly.service0.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * {
 * {0,0,0},
 * {0,1,0},
 * {0,0,0}
 * }
 * {
 *     {1, 1, 1},
 *     {1, 0, 0},
 *     {1, 0, 0}
 * }
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class LeetCode63 {
    public static int uniquePathsWithObstacles(int[][]  obstacleGrid)
    {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] nums=new int[m][n];
        if(m==0||n==0)
            return 0;
        if(m==1||n==1)
            for(int[] tempArr:obstacleGrid)
                for(int temp:tempArr)
                    if(temp==1)
                        return 0;
        if(obstacleGrid[0][0]==1)
            return 0;
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1)
                break;
            else
                nums[i][0]=1;
        }
        for(int j=0;j<n;j++){
            if(obstacleGrid[0][j]==1)
                break;
            else
                nums[0][j]=1;
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j]==1)
                    nums[i][j]=0;
                else
                    nums[i][j]=nums[i-1][j]+nums[i][j-1];
            }
        }
        return nums[m-1][n-1];
    }

    public static void main(String []  args)
    {
//        int[][] nums = {
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        };
//        int[][] nums={{1}};
        int[][] nums = {{0,0},{1,1},{0,0}};

        System.out.println(uniquePathsWithObstacles(nums));
    }
}
