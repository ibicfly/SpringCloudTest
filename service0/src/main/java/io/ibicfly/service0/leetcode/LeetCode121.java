package io.ibicfly.service0.leetcode;

public class LeetCode121 {
    public static void main(String[] args) {
        int[] nums={7,1,5,3,6,4};

        System.out.println(maxProfit(nums));
    }
    public static int maxProfit(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++)
            {
                if(max<(prices[j]-prices[i]))
                    max=prices[j]-prices[i];
            }
        }
        return max;
    }
//    将查找最小值和查找与最小值的最大差同时进行
    public int maxProfit1ms(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }

        int min = prices[0];
        int result = 0;

        for(int i=0;i<prices.length;i++) {
            if(prices[i] < min ){
                min =prices[i];
            }else if(prices[i] - min > result){
                result = prices[i] - min ;
            }
        }
        return result;
    }
}
