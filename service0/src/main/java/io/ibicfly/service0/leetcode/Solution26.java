package io.ibicfly.service0.leetcode;

import java.util.Stack;

public class Solution26 {
    public static void main(String[] args) {
        int[] nums = {};
        new Solution26().removeDuplicates(nums);
    }

    public int removeDuplicates(int[] nums) {
        Stack<Integer> stack = new Stack();
        if (nums == null || nums.length == 0)
            return 0;
        int index = 1;
        if (nums.length == 1)
            return 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                //找到了不一样的元素
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
