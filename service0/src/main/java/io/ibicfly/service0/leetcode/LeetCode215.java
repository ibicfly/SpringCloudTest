package io.ibicfly.service0.leetcode;

import java.util.Arrays;

/**
 * @Author :cyh
 * @CreateDate: 2018/11/2 15:19
 * @Description: 作用描述
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int res=0;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(--k==0)
            {
                res=nums[i];
                break;
            }
            while (i>0&&nums[i]==nums[i-1])
            {
                i--;
            }
        }
        return res;
    }
    public int findKthLargestQuick(int[] nums, int k) {
        if(nums.length == 1)
        {
            return nums[0];
        }
        int val = qsort(nums, 0, nums.length-1);
        int left = 0;
        int right = nums.length-1;
        k -= 1;//第k大，说明有k-1个元素比他大
        if(val == k) {
            return nums[val];
        }
        while(left < right){
            if(val >= k){
                right = val;
                val = qsort(nums, left, right);
            }
            else{
                left = val+1;
                val = qsort(nums, left, right);
            }
        }
        return nums[k];
    }

    int qsort(int[] nums,int left,int right){
        int i = left;
        int j = right;
        int center = nums[(i+j) / 2];
        while(i <= j){
            while(nums[i] > center) {
                i++;
            }
            while(nums[j] < center) {
                j--;
            }
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++; j--;
            }
        }
        if(j < left) {
            return left;//防止j越界，陷入无限循环
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums={1,1};
        int k=2;
        System.out.println(new LeetCode215().findKthLargest(nums,k));;
    }
}
