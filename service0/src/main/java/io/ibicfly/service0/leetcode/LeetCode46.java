package io.ibicfly.service0.leetcode;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/10 15:51
 * @Description: 作用描述
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 */
public class LeetCode46 {

//    采用循环的方式,提取第一个元素作为一个队,然后将第二个元素向其每个间隙间插入,插入的次数等于当前已经插入的个数+1,然后返回这个队列,再插入下一个元素
    public List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        result.add(list);
//      还要插多少个元素
        for (int i = 1; i < size; i++) {
            List<List<Integer>> tempResult = new ArrayList<>();
//          插多少个空
            for (int j = 0; j <= i; j++) {
                for (List<Integer> tempList : result) {
                    List<Integer> temp = new ArrayList<>(tempList);
                    temp.add(j, nums[i]);
                    tempResult.add(temp);
                }
            }
            result = tempResult;
        }
        return result;
    }

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        // Init
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(nums[0]);
        result.add(l0);

        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> temp_result = new ArrayList<List<Integer>>();       // temp result

            // Add new item to current lists
            for (int j = 0; j <= i; j++) {
                for (List<Integer> l : result) {
                    List<Integer> temp_list = new ArrayList<Integer>(l);
                    temp_list.add(j, nums[i]);
                    temp_result.add(temp_list);
                }
            }
            result = temp_result;
        }

        return result;
    }

    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int j) {
//      把所有元素都添加完成后的情况
        if (j == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums)
                list.add(num);
            res.add(list);
        }
        for (int i = j; i < nums.length; i++) {
            System.out.println("i"+i+"j"+j);
            swap(nums, i, j);
            dfs(res, nums, j + 1);
            swap(nums, i, j);
        }
    }
//  递归方法还是用的回溯算法
    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 0)
            return res;
        dfs(res, nums, 0);
        return res;
    }



















    public void dfs2(List<List<Integer>> res,int[] nums,int j){
        if(j==nums.length)
        {
//            Enter the recurse
            List<Integer> temp =new ArrayList<>();
            for(int tempNum:nums)
                temp.add(tempNum);
            res.add(temp);
        }
        for(int i=j;i<nums.length;i++)
        {
            swap2(nums,i,j);
            dfs2(res,nums,j+1);
            swap2(nums,i,j);
        }
    }
    public void swap2(int[] nums,int i,int j)
    {
        if(nums.length==0)
            return;
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    public List<List<Integer>> permute4(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length==0)
            return res;
        dfs2(res,nums,0);
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> res = new LeetCode46().permute4(a);
        for (List<Integer> temp : res) {
            System.out.println(temp);
        }
    }
}
