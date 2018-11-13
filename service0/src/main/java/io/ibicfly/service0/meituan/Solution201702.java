package io.ibicfly.service0.meituan;

import java.util.Scanner;

/**
 * 给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。
 */
public class Solution201702 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] moneys={1,5,10,20,50,100};
        int [][] dp=new int[moneys.length][n];
        int count=0;
        int sum=0;

    }


}
