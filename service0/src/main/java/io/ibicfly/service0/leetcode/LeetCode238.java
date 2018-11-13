package io.ibicfly.service0.leetcode;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/30 17:44
 * @Description: 作用描述
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int tempSum = 1;
        int zeroNum = 0;
        for (int tempNum : nums) {
            if (tempNum != 0) {
                tempSum *= tempNum;
            } else {
                zeroNum++;
            }
        }
        int[] res = new int[nums.length];
        if (zeroNum > 1)
            return res;
        for (int i = 0; i < res.length; i++) {
            if (zeroNum == 1) {
                if (nums[i] == 0)
                    res[i] = tempSum;
            } else {
                res[i] = tempSum / nums[i];
            }
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        res[res.length - 1] = 1;
//        将最后一个元素设置为1   从倒数第二个元素开始进行计算，
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = res[i + 1] * nums[i + 1];
        }
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] *= left;
            left *= nums[i];
        }
        return res;
    }

    //  本能地会去用除法解决这个问题，但实际上，顺着逻辑去走可以很好的解决问题
    public int[] productExceptSelf3(int[] nums) {
        int[] res = new int[nums.length];
        res[res.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = nums[i + 1] * res[i + 1];
        }
        System.out.println("test");
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] *= temp ;
            temp *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode238().productExceptSelf3(new int[]{1, 2, 3, 4})));
    }
}
