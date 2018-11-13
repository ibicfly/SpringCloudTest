package io.ibicfly.service0.basic;

import java.util.Random;

/**
 * @Author :cyh
 * @CreateDate: 2018/11/13 11:28
 * @Description: 作用描述
 */
public class Random01 {
    int p;
    boolean zero = true;

    //    i为0，或
    public int random01P(int i) {
        Random random=new Random();
        int res =random.nextInt();
        res=res%2==0?0:1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Random01().random01P(1));
        System.out.println(new Random01().random01P(0));
        System.out.println(new Random01().random01P(0));
        System.out.println(new Random01().random01P(0));
        System.out.println(new Random01().random01P(0));
    }
}
