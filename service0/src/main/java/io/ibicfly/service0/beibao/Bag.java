package io.ibicfly.service0.beibao;

import java.util.Arrays;
import java.util.Scanner;

public class Bag {
    static int n, m, re, count[], val[], dp[];
    //01背包
    static void f_01(int cost, int val) {
        for (int i = m; i >= cost; i--)
            dp[i] = Math.max(dp[i], dp[i - cost] + val);
    }

    //完全背包
    static void f_full(int cost, int val) {
        for (int i = cost; i <= m; i++)
            dp[i] = Math.max(dp[i], dp[i - cost] + val);
    }

    //多重背包 多重背包
    static void f_mul(int cost, int val, int count) {
        if (count * cost >= m) {
            f_full(cost, val);
        } else {
            int k = 1;
            while (k < count) {
                count -= k;
                f_01(k * cost, k * val);
                k *= 2;
            }
            f_01(count * cost, count * val);
        }
    }
    public static void main(String[] args) {
        int n;
        int m;
        Scanner sc = new Scanner(System.in);
        for (;;) {
            n = sc.nextInt();
            m = sc.nextInt();
            if (m + n == 0)
                return;
            re = 0;
            dp = new int[m + 1];
            //除dp[0]初始化为0外，其他初始化为-∞
            Arrays.fill(dp, 1, dp.length, Integer.MIN_VALUE);
            val = new int[n + 1];
            count = new int[n + 1];
            for (int i = 1; i <= n; i++)
                val[i] = sc.nextInt();
            for (int i = 1; i <= n; i++)
                count[i] = sc.nextInt();
            for (int i = 1; i <= n; i++)
                f_mul(val[i], val[i], count[i]);
            for (int i = 1; i <= m; i++)
                if (dp[i] == i)
                    re++;
            System.out.println(re);
        }
    }
}
