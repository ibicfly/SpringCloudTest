package io.ibicfly.service1.offer2018Second.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] input ={1,2,7,3,5,10,3};
        System.out.println(Arrays.toString(input));
        bubbleSort(input);
        System.out.println(Arrays.toString(input));
    }
    public static void bubbleSort(int[] input)
    {
        for(int i=0;i<input.length-1;i++)
        {
            for(int j=i;j<input.length;j++)
            {
                if(input[i]>input[j])
                {
                    int temp=input[i];
                    input[i]=input[j];
                    input[j]=temp;
                }
            }
        }
    }
}
