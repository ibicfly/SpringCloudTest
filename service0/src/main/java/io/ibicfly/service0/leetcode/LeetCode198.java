package io.ibicfly.service0.leetcode;

import java.util.Stack;

/**
 * 采用动态跟踪及回溯进行解题
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class LeetCode198 {

    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
        System.out.println(robFaster(nums));
    }

    /**
     * 蠢办法，将所有进行递归，然后相加
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int max = 0, preMax = 0;
        for (int cur : nums) {
            int temp = max;
            max = Math.max(max, preMax + cur);
            preMax = temp;
        }
        return max;
    }
    public static int robFaster(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int n=nums.length;
        if(n==1)
            return nums[0];
        if(n==2)
            return Math.max(nums[1],nums[0]);
        int f_n=0;
        int f_n_1=Math.max(nums[1],nums[0]);
        int f_n_2=nums[0];
        int i=2;
        while(i<n){
            f_n=Math.max(f_n_1,f_n_2+nums[i]);
            f_n_2=f_n_1;
            f_n_1=f_n;
            i++;
        }
        return f_n;
    }

}
