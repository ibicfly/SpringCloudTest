package io.ibicfly.service0.leetcode;

import java.util.Arrays;

/**
 * 我们把符合下列属性的数组 A 称作山脉：
 *
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 * 示例 1：
 *
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：[0,2,1,0]
 * 输出：1
 *
 *
 * 提示：
 *
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 * 想着用递归做，其实就是把问题复杂化了，但是递归也有递归的必要性
 */
public class LeetCode852 {
//    public static int peakIndexInMountainArray(int[] A) {
//        if(A==null||A.length<3)
//            return 0;
//        return find(A,0,A.length-1);
//    }
    public static int peakIndexInMountainArray(int[] A) {
        int i =(A.length-1)/2;
        if(A[i] > A[i-1] && A[i] > A[i+1])
            return i ;
        if(A[i] > A[i-1])
            return i + peakIndexInMountainArray(Arrays.copyOfRange(A,i,A.length));
         else
            return peakIndexInMountainArray(Arrays.copyOfRange(A,0,i+1));
    }
    public  static int find(int[] A,int start,int end)
    {
        if(start==end)
            return A[start];
        int mid=(start+end)/2;
        int left=find(A,start,mid);
        int right=find(A,mid+1,end);
        if(left==right)
            return left;
        int countLeft = 0;
        int countRight = 0;
        for (int i = start; i <= end; i++) {

        }
        return  countLeft>=countRight?left:right;
    }

    public static void main(String[] args) {
        int[] A={0,2,1,0};
        System.out.println(peakIndexInMountainArray(A));
    }
}
