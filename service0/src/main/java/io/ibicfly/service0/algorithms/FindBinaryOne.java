package io.ibicfly.service0.algorithms;

public class FindBinaryOne {
    public static void main(String[] args) {
        int a = 0;
        int count = 0;
        System.out.println(a << 1);
        for (int i = 1; i <= Integer.MAX_VALUE && i > 0; i <<= 1) {
            if ((i & a) == i) {
                count++;
            }
            System.out.println(i);
        }
        System.out.println(count);
    }
}
