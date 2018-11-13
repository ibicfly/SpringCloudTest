package io.ibicfly.service0.leetcode;

/**
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，以下数列为等差数列:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 *
 * 1, 1, 2, 5, 7
 *
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 *
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 *
 * 元素 A[P], A[P + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 *
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 * 示例:
 *
 * A = [1, 2, 3, 4]
 *
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 */
public class LeetCode413 {
    public static int numberOfArithmeticSlices(int[] A) {
        int res=0;
        int add=0;

        for(int i=0;i<A.length-2;i++)
        {
            if((A[i+1]-A[i])==(A[i+2]-A[i+1]))
            {
                res+=++add;
            }else
                add=0;
        }
        System.out.println(res);
        return res;
    }
    public static int numberOfArithmeticSlices1ms(int[] A) {
        int len = A.length;
        if(len < 3) return 0;

        int res = 0, add = 0;
        for(int i = 2; i < len; i++) {
            if(A[i]-A[i-1] == A[i-1]-A[i-2]) {
                add++;
                res += add;
            } else {
                add = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a={1,2,3,4,8,9,10};
        System.out.println(numberOfArithmeticSlices(a));
    }
}
