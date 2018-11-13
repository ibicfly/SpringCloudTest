package io.ibicfly.service0.leetcode;

import java.util.Stack;

public class LeetCode868 {
    public static void main(String[] args) {
        System.out.println(binaryGap(8));
    }
    public static  int binaryGap(int N) {
        int i=1;
        int index=0;
        int max=0;
        Stack<Integer> stack=new Stack();
        while(i<=N)
        {
            if((i&N)==i)
            {
                stack.push(index);
            }
            index++;
            i=i<<1;
        }
        int last=stack.pop();
        while(!stack.isEmpty()){
            int temp;
            if((temp=last-stack.peek())>max)
                max=temp;
            last=stack.pop();
        }
        return max;
    }
    public int binaryGap13ms(int N) {
        int tail =-1, dis = 0;
        for(int i=0; i<32; ++i){
            if(((N >> i) & 1) > 0){
                if(tail >= 0)
                    dis = Math.max(dis, i-tail);
                tail = i;
            }
        }
        return dis;
    }
}
