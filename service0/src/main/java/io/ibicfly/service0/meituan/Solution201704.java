package io.ibicfly.service0.meituan;

import java.util.Scanner;

public class Solution201704 {
    public static int LCS(String a,String b){
        int la=a.length();
        int lb=b.length();
        int max=0;
        int[][]dp=new int[1+la][1+lb];
        for(int i=1;i<=la;i++){
            for(int j=1;j<=lb;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=0;
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(LCS(a,b));
    }
}
