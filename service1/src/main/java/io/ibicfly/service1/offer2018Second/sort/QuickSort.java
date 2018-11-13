package io.ibicfly.service1.offer2018Second.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] input = {1, 9, 7, 3, 5, 2, 10};
//        int[] input = {1, 2, 7, 3, 5, 2, 3};
        System.out.println(Arrays.toString(input));
        quickSort2(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    public static void quickSort(int[] input, int start, int end) {
        if (start < end) {
            int index = partition(input, start, end);
            quickSort(input, start, index - 1);
            quickSort(input, index + 1, end);
        }
    }
//  这种写法相对繁琐？
    public static void quickSortStandard(int[] input, int left, int right) {
        int i, j;
        int pivot = partitionStandardFirst(input, left, right);//确定基准值
        if (left < right) {
            i = left + 1;//以第一个数left作为基准数，从left+1开始作比较
            j = right;

            while (i < j) {
                if (input[i] > pivot)//如果比较的数比基准数大
                {
                    swap(input,i, j);//把该比较数放到数组尾部，并让j--，比较过的数就不再比较了
                    j--;
                } else {
                    i++;//如果比较的数比基准数小，则让i++，让下一个比较数进行比较
                }
            }

            //跳出while循环后，i==j
            //此时数组被分成两个部分，a[left+1]-a[i-1]都是小于a[left],a[i+1]-a[right]都是大于a[left]
            //将a[i]与a[left]比较，确定a[i]的位置在哪
            //再对两个分割好的部分进行排序，以此类推，直到i==j不满足条件
            if (input[i] >= input[left]) {
                i--;
            }

            swap(input,i,left);

            quickSortStandard(input, left, i);
            quickSortStandard(input, j, right);
        }
    }

    public static int partitionStandardFirst(int[] input, int left, int right) {
        return input[left];
    }
    public static int partitionStandardMiddle(int[] input, int left, int right) {
        int mid=(left+right)/2;
        if(input[mid]<input[left])
        {
            swap(input,left,mid);
        }
//        if(input[left])
        return 0;
    }

    public static void swap(int[] input, int left, int right) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }

    //快速排序采用迭代写法
    public static int partition(int[] input, int start, int end) {
        int base = input[start];
        while (start < end) {
            while (start < end && input[end] >= base)
                end--;
            if (start < end)
                input[start++] = input[end];
            while (start < end && input[start] <= base)
                start++;
            if (start < end)
                input[end--] = input[start];
        }
        input[start] = base;
        return start;
    }

    public static void quickSort2(int[] input, int left, int right) {
        if (left < right) {
            int middle = partitionMiddle(input, left, right);
//        int middle=partitionFirst(input,left,right);
            quickSort2(input, left, middle - 1);
            quickSort2(input, middle + 1, right);
        }
    }

    public static int partitionMiddle(int[] array, int lo, int hi) {
        int mid = (hi + lo) / 2;
        if (array[mid] > array[hi]) {
            swap(array,mid,hi);
        }
        if (array[lo] > array[mid]) {
            swap(array,mid,lo);
        }
        if (array[lo] > array[hi]) {
            swap(array,hi,lo);
        }
//      将最小的那一个放到lo位置
        int key = array[lo];
        while (lo < hi) {
            while (lo < hi && array[hi] >= key) {
                hi--;
            }
            array[lo] = array[hi];
            while (lo < hi && array[lo] <= key) {
                lo++;
            }
            array[hi] = array[lo];
        }
        array[lo] = key;
        return lo;
    }


    public static int partitionFirst(int[] input, int left, int right) {
        int base = input[left];
        while (left < right) {
            while (left < right && input[right] >= base) {
                right--;
            }
            if (left < right) {
                input[left++] = input[right];
            }
            while (left < right && input[left] <= base) {
                left++;
            }
            if (left < right) {
                input[right--] = input[left];
            }
            input[left] = base;
        }
        return left;
    }
}
