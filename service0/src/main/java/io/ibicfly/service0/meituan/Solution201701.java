package io.ibicfly.service0.meituan;

import java.util.Scanner;

/**
 * 大富翁游戏，玩家根据骰子的点数决定走的步数，即骰子点数为1时可以走一步，点数为2时可以走两步，点数为n时可以走n步。求玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时，总共有多少种投骰子的方法。
 * 输入描述:
 * 输入包括一个整数n,(1 ≤ n ≤ 6)
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数,表示投骰子的方法
 * <p>
 * 输入例子1:
 * 6
 * <p>
 * 输出例子1:
 * 32
 */
public class Solution201701 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int res=1;
        while(n>1)
        {
            res<<=1;
            n--;
        }
        System.out.println(res);
    }

}
