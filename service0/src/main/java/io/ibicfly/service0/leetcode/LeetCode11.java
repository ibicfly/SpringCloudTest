package io.ibicfly.service0.leetcode;

/**
 * @Author :cyh
 * @CreateDate: 2018/11/8 16:52
 * @Description: 作用描述
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class LeetCode11 {
    public int maxArea(int[] height) {
//        用最直接的做法去做就是O(n^2)储存所有的蓄水量
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i; j < height.length; j++) {
                int heightTemp = height[i] > height[j] ? height[j] : height[i];
                int width = (j - i);
                int sum = width * heightTemp;
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
//        用最直接的做法去做就是O(n^2)储存所有的蓄水量
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while (left != right) {
            int tempArea = (height[left] > height[right] ? height[right] : height[left] )* (right - left);
            if (area < tempArea) {
                area = tempArea;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return area;
    }

    public static void main(String[] args) {
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new LeetCode11().maxArea2(input));
    }
}
