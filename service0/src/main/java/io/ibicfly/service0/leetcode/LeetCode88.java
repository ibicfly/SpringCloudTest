package io.ibicfly.service0.leetcode;

import java.util.Arrays;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/30 16:08
 * @Description: 作用描述
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 */
public class LeetCode88 {
    //        1.merge排序 2.轮训比较大小插入3，合并后排序
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int sum = n + m;
        for (int temp = m; temp < sum; temp++) {
            nums1[temp] = nums2[j++];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        if(n==0)
            return;
        int sum=n+m;
        while (i<sum&&j<n)
        {
            while (i<m&&j<n) {
                if (nums1[i] > nums2[j]) {
                    for(int k=sum-1;k>i;k--)
                    {
                        nums1[k]=nums1[k-1];
                    }
                    nums1[i]=nums2[j];
                    m++;
                    j++;
                } else {
                    i++;
                }
            }
            while (j<n)
                nums1[i++]=nums2[j++];
        }

    }
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int temp = 0;
        int sum = n + m;

        int[] res = new int[sum];
        while (temp < sum) {
            if(i==m)
            {
                if(j==n)
                {
                    return;
                }else
                {
                    res[temp++] = nums2[j++];
                }
            }else {
                if(j==n)
                {
                    res[temp++] = nums1[i++];
                }else
                {
                    if (nums1[i] < nums2[j]) {
                        res[temp++] = nums1[i++];
                    } else {
                        res[temp++] = nums2[j++];
                    }
                }
            }
        }
        i=0;
        for(int tempNum:res)
        {
            nums1[i++]=tempNum;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
//        [2,0]
//        1
//                [1]
//        1
//        [-1,0,0,3,3,3,0,0,0]
//        6
//                [1,2,2]
//        3
        new LeetCode88().merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
