package io.ibicfly.service0.leetcode;

import io.swagger.models.auth.In;

import java.util.*;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/10 13:25
 * @Description: 作用描述
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 回溯算法 递归+循环
 */
public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            System.out.println("删除" + i + "个元素");
            int num = i;
            while (num > 0) {

            }
        }
        return null;
    }
//  递归+循环 回溯算法实现
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res, temp, nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int j) {
        res.add(new ArrayList<Integer>(temp));
        for (int i = j; i < nums.length; i++) {
            temp.add(nums[i]);  //① 加入 nums[i]
            dfs(res, temp, nums, i + 1);  //② 递归
            temp.remove(temp.size() - 1);  //③ 移除 nums[i]
        }
    }
//  非递归实现
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int num : nums) {  // ①从数组中取出每个元素
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(res.get(i));//②逐一取出中间结果集
                temp.add(num);  // ③将 num 放入中间结果集
                res.add(temp);  // ④加入到结果集中
            }
        }
        return res;
    }
//  实现递归
    public List<List<Integer>> subsets4(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<>();
        dfs2(res,temp,nums,0);
        return res;
    }
    public void dfs2(List res,List temp,int[] nums,int index)
    {
        res.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++)
        {
            temp.add(nums[i]);
            dfs2(res,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> res = new ArrayList();
        res = new LeetCode78().subsets4(a);
        for (List<Integer> tempList : res)
            System.out.print(tempList);
    }
}
