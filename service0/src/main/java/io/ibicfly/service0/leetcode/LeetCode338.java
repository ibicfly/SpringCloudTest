package io.ibicfly.service0.leetcode;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 *        0 1 2 3 4 5 6
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 这是一个找规律的过程，要找到这一个是由什么转变过来的，找到公式，就能
 */
public class LeetCode338 {
    public static int[] countBitsSimple(int num) {
        int[] nums=new int[num+1];
        for(int i=0;i<=num;i++)
        {
            int k=1;
            int temp=0;
            while(k<=i)
            {
                if((k&i)==k)
                    temp++;
                k<<=1;
            }
            nums[i]=temp;
        }
        return  nums;
    }
    public static int[] countBits(int num) {
        int[] nums = new int[num+1];
        nums[0] = 0;
        for(int i = 1; i <= num; ++i){
            nums[i] = nums[i >> 1] + (i&1); // 按位与&的优先级小于+, 所以要加括号!!
        }
        return nums;
    }
    public static void main(String[] args) {
        for(int temp:countBits(15))
        {
            System.out.print (temp+" ");
        }
    }
}
