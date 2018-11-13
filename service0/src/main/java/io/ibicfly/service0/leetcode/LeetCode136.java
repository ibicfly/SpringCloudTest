package io.ibicfly.service0.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class LeetCode136 {
    public static int singleNumberFastest(int[] nums) {
        int result=0;
        for(int i:nums){
            result=result^i;
        }
        return result;
    }
    public static int singleNumber(int[] nums) {
        int res=0;
        HashMap<Integer,Integer> map=new HashMap(nums.length);
        for (int a:nums)
            map.put(a,map.get(a)!=null?map.get(a)+1:1);
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
            if(entry.getValue()==1)
                res= entry.getKey();
        return res;
    }

    public static void main(String[] args) {
        int[] a={2,1,2};
        int[] b={4,1,2,1,2};
        System.out.println(9^8);
        System.out.println(singleNumberFastest(b));
    }
}
