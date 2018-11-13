package io.ibicfly.service0.leetcode;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class LeetCode547 {
    //采用深度搜索，在搜索到第一个元素之后，搜索他的朋友圈
    public int findCircleNum(int[][] M) {
        int res = 0;
        boolean[] marked = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            for (int j = i; j < M.length; j++) {
                if (!marked[i]) {
                    mark(M, marked, j);
                    res++;
                }
            }
        }
        if (res <= 0)
            res = 1;
        return res;
    }

    public void mark(int[][] M, boolean[] marked, int j) {
        marked[j] = true;
        for (int i = 0; i < M.length; i++) {
            if (!marked[i] && M[j][i] == 1) {
                mark(M, marked, i);
                marked[i] = true;
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = {{1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1}};
        System.out.println(new LeetCode547().findCircleNum(input));
        Integer obj = new Integer(5);
        SoftReference sf = new SoftReference(obj);
        WeakReference<Object> wf = new WeakReference<Object>(obj);
        PhantomReference pf = new PhantomReference(obj, null);
        System.out.println("软引用" + sf.get());
        System.out.println("弱引用" + wf.get());
        System.out.println("虚引用" + pf.get());
        obj = null;
        for (int i = 0; i < 1000000000; i++) {
            Integer temp2 = new Integer(i);
        }
        System.out.println("软引用" + sf.get());
        System.out.println("弱引用" + wf.get());
        System.out.println("虚引用" + pf.get());
        int[][] input2 = {{1, 2}, {3, 4}};
        new LeetCode547().matrixReshape(input2, 1, 4);
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || (nums.length * nums[0].length) != (r * c))
            return nums;
        int rindex = 0;
        int cindex = 0;
        for (int[] tempArr : nums) {
            for (int temp : tempArr) {
                if (c == cindex) {
                    cindex = 0;
                    rindex++;
                }
                res[rindex][cindex] = temp;
                cindex++;
            }
        }
        return res;
    }
}