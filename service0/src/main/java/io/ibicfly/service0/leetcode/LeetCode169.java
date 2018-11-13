package io.ibicfly.service0.leetcode;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 分冶法 通过将问题分为多个部分，分而治之，一般这几个部分都有一定的关联性
 */
public class LeetCode169 {

    public int majorityElement(int[] nums) {
        int result=find(nums,0,nums.length-1);
        return result;
    }
    public int find(int[] nums,int start,int end)
    {
        if(start==end)
            return nums[start];
        int mid=(start+end)/2;
        int left=find(nums,start,mid);
        int right=find(nums,mid+1,end);
        if(left==right)
            return left;
        int countLeft = 0;
        int countRight = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == left)
                countLeft++;
            else if (nums[i] == right)
                countRight++;
        }
        return  countLeft>=countRight?left:right;
    }
    public static int majorityElementMap(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        int[] nums={2,2,1,1,1,2,2};
        System.out.println(majorityElementMap(nums));
    }
}
