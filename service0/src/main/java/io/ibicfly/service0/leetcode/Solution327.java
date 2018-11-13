package io.ibicfly.service0.leetcode;

public class Solution327 {
    public static void main(String[] args) {
        int[] a = {2, 5, 3, 4, 7, 1, 9, 0, 10};
        new Solution327().sort(a, 0, a.length - 1);
        for (int temp : a) {
            if (temp != a[a.length - 1])
                System.out.print(temp + " ");
            else
                System.out.print(temp);
        }
//        new Solution327().recursionBinarySearch(a, 0, a.length - 1, 0);
        new Solution327().binarySearch(a, 7);
    }

    //    public int countRangeSum(int[] nums, int lower, int upper) {
//
//
//        for(int i=0;i<nums.length-1;i++)
//        {
//
//        }
//    }
    public void sort(int[] input1, int start, int end) {
        int half = (start + end) / 2;
        if (start < end) {
            sort(input1, start, half);
            sort(input1, half + 1, end);
            merge(input1, start, end, half);
        }
    }

    public void merge(int[] input1, int start, int end, int mid) {
        //比起index要多1
        int[] res = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (input1[i] < input1[j])
                res[k++] = input1[i++];
            else
                res[k++] = input1[j++];
        }
        while (i <= mid) {
            res[k++] = input1[i++];
        }
        while (j <= end) {
            res[k++] = input1[j++];
        }
        for (int x = 0; x < res.length; x++) {
            input1[start + x] = res[x];
        }
    }

    public void recursionBinarySearch(int[] input, int start, int end, int key) {
        if (start < end) {
            int mid = (start + end) >>> 1;
            if (input[mid] > key) {
                recursionBinarySearch(input, start, mid, key);
            } else if (input[mid] < key) {
                recursionBinarySearch(input, mid + 1, end, key);
            } else {
                System.out.println("查找到" + key + "位于第" + (mid + 1) + "个");
            }
        }
    }

    public void binarySearch(int[] input, int key) {
        int start = 0;
        int end = input.length - 1;
        int mid = (start + end) >>> 1;
        while (start < end) {
            if (key < input[mid]) {
                end = mid - 1;
                mid = (start + end) >>> 1;
            } else if (key > input[mid]) {
                start = mid + 1;
                mid = (start + end) >>> 1;
            } else {
                System.out.println("key" + key + "find at index" + mid);
                return;
            }
        }
    }
}
