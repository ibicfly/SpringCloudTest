package io.ibicfly.service0.leetcode;

import java.text.SimpleDateFormat;
import java.util.*;

public class LeetCode70 {
    private  int a=0;
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    /**
     *
      * @param n
     * @return
        2 1+1
            2

     */

    public static int climbStairs(int n) {
        int a=1;
        int b=1;
        int sum=0;
        if(n==1||n==0)
            return 1;
        while(n-1>0)
        {
            sum=a+b;
            a=b;
            b=sum;
            n--;
        }
        return sum;
    }
}
