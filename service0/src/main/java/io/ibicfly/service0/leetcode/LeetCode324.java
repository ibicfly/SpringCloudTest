package io.ibicfly.service0.leetcode;

import java.util.Arrays;

public class LeetCode324 {
    /**
     * 摆动排序 nums[0]<nums[1]><nums[2]<nums[3]><nums[4]> 现在这个太恶心了。。
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        //将数组，排序，取中位数
        if (nums.length <= 1)
            return;
        Arrays.sort(nums);
        int len = nums.length;
        int k = 1;
//        int high=(len%2==0)?len-1:len-2,mid=nums[len/2];//根据奇偶的不同
        int mid = len % 2 == 0 ? (nums[len / 2] + nums[len / 2 + 1]) / 2 : nums[len - 1] / 2;
        //还是得根据奇偶数的不同
        if (len % 2 == 0) {
            for (int i = 0; i < len; i++) {

            }
        } else {
            for (int i = 0; i < len; i++) {

            }
        }

        int[] res = new int[len];
        nums = res;
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 1, 1, 6, 4};
        new LeetCode324().wiggleSort(input);
        for (int temp : input)
            System.out.print(temp);
    }
}
