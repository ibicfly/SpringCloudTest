package io.ibicfly.service0.basic;

import java.util.Random;

/**
 * @Author :cyh
 * @CreateDate: 2018/9/28 14:13
 * @Description: 作用描述
 */
public class RandomTest {
    private final static Random RANDOM=new Random(47);
    final  int a=RANDOM.nextInt(10);
    public static void main(String[] args) {
        for(int i=0;i<10;i++)
            System.out.println(new RandomTest().a);
    }
}
