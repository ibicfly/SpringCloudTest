package io.ibicfly.service0.leetcode;

import java.util.Arrays;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/9 16:58
 * @Description: 作用描述
 * 给定一个正整数 n，生成一个包含 1 到 n的平方 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class LeetCode59 {
    //    这不是dp问题
    public int[][] generateMatrix(int n) {
//        int[][] result = new int[n][n];
//        int[][] indexArr = new int[n][n];
//        int i = 0;
//        int j = 0;
//        int temp = 1;
//        while (indexArr[i][j] == 0 && i < n && j < n) {
//            res[i][j] = temp++;
//            indexArr[i][j] = 1;
//            if (j + 1 != n && indexArr[i][j + 1] == 0) {
//                j++;
//            } else if (i + 1 != n && indexArr[i + 1][j] == 0) {
//                i++;
//            } else if (j - 1 != -1 && indexArr[i][j - 1] == 0) {
//                j--;
//            } else if (i - 1 != -1 && indexArr[i - 1][j] == 0) {
//                i--;
//            } else {
//                break;
//            }
//    }
        int[][] result = new int[n][n];
        int[][] indexArr = new int[n][n];
        int square = n * n;
        int num = 1;
        int x = 0;
        int y = 0;
        while (num <= square) {
            while (y < n && result[x][y] == 0) {
                result[x][y++] = num++;
            }
            y--;
            x++;
            while (x < n && result[x][y] == 0) {
                result[x++][y] = num++;
            }
            x--;
            y--;
            while (y >= 0 && result[x][y] == 0) {
                result[x][y--] = num++;
            }
            x--;
            y++;
            while (x >= 0 && result[x][y] == 0) {
                result[x--][y] = num++;
            }
            x++;
            y++;
        }
        return result;
    }

    public int[][] generateMatrix2(int n) {
        int[][] result = new int[n][n];

        int top = 0;
        int right = 0;
        int bottom = 0;
        int left = 0;
        int index = 1;
        int i = 0;
        while (true) {
            // top
            for (i = left; i < n - right; i++) {
                result[top][i] = index++;
            }
            top++;
            if (top + bottom == n) {
                break;
            }
            // right
            for (i = top; i < n - bottom; i++) {
                result[i][n - 1 - right] = index++;
            }
            right++;
            if (left + right == n) {
                break;
            }
            // bottom
            for (i = n - 1 - right; i >= left; i--) {
                result[n - 1 - bottom][i] = index++;
            }
            bottom++;
            if (top + bottom == n) {
                break;
            }
            // left
            for (i = n - 1 - bottom; i >= top; i--) {
                result[i][left] = index++;
            }
            left++;
            if (left + right == n) {
                break;
            }
        }
        return result;
    }

    public int[][] generateMatrix3(int n) {
        int[][] result = new int[n][n];
        int temp = 1;
        int sequare = n * n;
        int i = 0;
        int j = 0;
        while (temp <= sequare) {
            while (j < n && result[i][j] == 0)
                result[i][j++] = temp++;
            j--;
            i++;
            while (i < n && result[i][j] == 0)
                result[i++][j] = temp++;
            i--;
            j--;
            while (j > -1 && result[i][j] == 0)
                result[i][j--] = temp++;
            i--;
            j++;
            while (i > -1 && result[i][j] == 0)
                result[i--][j] = temp++;
            i++;
            j++;
        }
        return result;
    }
//    按圈打印
    public int[][] generateMatrixStandard(int n) {
        int height = n;
        int width = n;
        int[][] arr = new int[n][n];
        int up = 0, down = height - 1, left = 0, right = width - 1;
        int value = 1;

        while (up <= down || left <= right) {
//          一次循环填充一圈
            value = fill(arr, value, up, down, left, right);
            up++;
            left++;
            down--;
            right--;
        }
        return arr;
    }
    private int fill(int arr[][], int value, int up, int down, int left, int right) {
        for (int i = left; i <= right; i++) {
            arr[up][i] = value++;
        }
        for (int i = up + 1; i <= down; i++) {
            arr[i][right] = value++;
        }
        for (int i = right - 1; i >= left; i--) {
            arr[down][i] = value++;
        }
        for (int i = down - 1; i > up; i--) {
            arr[i][left] = value++;
        }
        return value;
    }

    public static void main(String[] args) {
        for (int[] temp : new LeetCode59().generateMatrixStandard(4)) {
            System.out.println(Arrays.toString(temp));
        }
    }
}
