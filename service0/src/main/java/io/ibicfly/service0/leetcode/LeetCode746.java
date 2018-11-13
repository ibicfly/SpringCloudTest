package io.ibicfly.service0.leetcode;

/**
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * <p>
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1:
 * <p>
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 * 示例 2:
 * <p>
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 * <p>
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 * <p>
 * 根据两个大小，比较添加 不可行
 * 什么情况下会是最小之和呢？ 每次走1或2步
 */
public class LeetCode746 {
    public static void main(String[] args) {
        int[] nums1 = {0, 0, 1, 1};
        int[] nums2 = {1, 2, 1, 1};
        int[] nums = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairsSpecial(nums2));
    }

    public static int minCostClimbingStairsFail(int[] cost) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        while (i < cost.length) {
            sum += cost[i];
            if (i == cost.length - 1 || i == cost.length - 2)
                break;
            if (cost[i + 1] == cost[i + 2] || cost[i] + cost[i + 2] <= cost[i + 1]) {
                i += 2;
            } else {
                i++;
            }
        }
        return sum;
    }

    /**
     * 一般的背包问题都会采用这种做法，相当于走路捡石头，然后这一步能走，就将这一步的石头放进包内
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length + 1;
        int[] dp = new int[length];
        for (int i = 2; i < length; i++) {
            int a=dp[i - 2] + cost[i - 2];
            int b=dp[i - 1] + cost[i - 1];
            dp[i] = Math.min(a,b);
        }
        return dp[length - 1];
    }
    public static int minCostClimbingStairsSpecial(int[] cost) {
        int length = cost.length + 1;
        int dp0 = 0;
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 2; i < length; i++) {
            dp2 = Math.min(dp0 + cost[i - 2] , dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp2;
    }
}
