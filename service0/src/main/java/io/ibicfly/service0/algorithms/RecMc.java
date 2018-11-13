package io.ibicfly.service0.algorithms;

import java.util.*;

/**
 * 动态规划
 *
 * @author Jessica
 */
public class RecMc {
    public static void main(String[] args) {
//        if((-1+1+0)==0)
//            System.out.println("adf");
//        System.out.println(new RecMc().findminNow(new int[]{1, 2, 5, 6}, 13));
//        for (int temp : new RecMc().findSum(new int[]{1, 4, 5, 7, 23}, 24))
//            System.out.println(temp);
//
//        for (List<Integer> temp : new RecMc().threeSum(new int[]{1, 0, -1, 2, -1, -4})) {
//            for (Integer tempInt : temp) {
//                System.out.print(tempInt + " ");
//            }
//        }
//        System.out.println(new RecMc().reverse(1534236469));
//        int count = 0;
//        System.out.println(new RecMc().change(5, new int[]{1, 2, 5}));
//        System.out.println(new RecMc().coinChange(new int[]{1, 2, 5},11));
        System.out.println(new RecMc().combinationSum4(new int[]{1, 2, 3}, 4));
    }

    public int findminNow(int[] coinList, int change) {
        int minCoins = change;
        for (int temp : coinList)
            if (temp == change)
                return 1;
        //然后找到最小的那个元素，将之加入
        for (int temp : coinList) {
            if (temp <= change) {
                int numCoins = 1 + findminNow(coinList, change - temp);
                if (numCoins < minCoins)
                    minCoins = numCoins;
            }
        }
        return minCoins;
    }

    public int[] findSum(int[] input, int target) {
        HashMap<Integer, Integer> map = new HashMap(input.length);
        for (int i = 0; i < input.length; i++) {
            int cha = target - input[i];
            if (map.containsKey(cha) && cha != input[i]) {
                return new int[]{map.get(cha), i};
            } else
                map.put(input[i], i);
        }
        throw new IllegalArgumentException("找不到");
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums.length <= 2)
            return list;
        HashMap map = new HashMap();
        //最普通的实现就是通过三重循环进行查找(但是没法做到对同样元素不同位置进行去重)
        //现在采用对数组进行排序，然后通过头尾指针，
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            else
                twoSum(nums, i + 1, -nums[i], list);
        }
        return list;
    }

    //
    public void twoSum(int[] nums, int i, int target, List<List<Integer>> list) {
        int b = i - 1;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[b]);
                temp.add(nums[i]);
                temp.add(nums[j]);
                list.add(temp);
                //处理重复的情况
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) i++;//去掉重复的元素
                while (i < j && nums[j + 1] == nums[j]) j--;//去掉重复的元素
            } else {
                if (nums[i] + nums[j] < target)
                    i++;
                else
                    j--;
            }
        }
    }

    public int reverse(int x) {
        int resInt = 0;
        char[] chars = (x + "").toCharArray();
        char index = '-';
        if (x < 0)
            chars = (x + "").substring(1).toCharArray();
        else
            index = 0;
        for (int i = 0; i < chars.length / 2 && x >= 0; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        String res = new String(chars);
        try {
            resInt = Integer.parseInt(index + res);
        } catch (Exception e) {
        }
        return resInt;
    }

    /**
     * @param amount
     * @param coins
     * @param res
     * @deprecated 采用动态规划进行解题
     */
    public int change(int amount, int[] coins) {
        int size = coins.length;
        int[] dp = new int[amount + 1];
        // 0 1 2 3 4 5
        // 1 0 0 0 0 0
        dp[0] = 1;
        //下表index 从0 到amount代表着对应背包剩余容量
        for (int temp : coins) {
            //相当于迭代整个可能的硬币列表，然后对应去跟背包大小进行比较，如果小于就放入
            for (int j = temp; j <= amount; j++) {
                dp[j] += dp[j - temp];
            }
        }
        return dp[dp.length - 1];
    }

    /**
     * LeetCode 322 这个是知道最少能用多少个硬币就能实现，而不是，总共有多少种情况
     * 先实现后优化
     */
    public int coinChange(int[] coins, int amount) {
        //重复背包
        // 0  1  2  3  4  5
        // 0 11 11 11 11 11
        if (coins == null || coins.length <= 0 || amount < 0)
            return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        //根据每个剩余的amount可以放置多少个元素，然后取最少的进行放置
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j])
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);//相当于由上一步往下一步跳coins[j]步
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];
//                    dp[i+nums[j]]+=dp[i];
            }
        }
        return dp[target];
    }
}
