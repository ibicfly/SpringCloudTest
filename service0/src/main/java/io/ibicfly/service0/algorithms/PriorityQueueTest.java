package io.ibicfly.service0.algorithms;

import io.swagger.models.auth.In;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/11 16:59
 * @Description: 作用描述
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        Class intClass= int.class;
        Class IntegerClass= Integer.class;

        System.out.println(intClass==IntegerClass);
        PriorityQueue priorityQueue = new PriorityQueue();
        for(int i=0;i<10;i++)
        {
            Node node=new Node();
            priorityQueue.add(node);
            System.out.print(node+" ");
        }
        System.out.println();
        while (!priorityQueue.isEmpty())
            System.out.print(priorityQueue.poll()+" ");
    }
}

class Node implements Comparable<Node>{
    private static final Random RANDOM = new Random();
    private int a;
    public Node() {
        a=RANDOM.nextInt(100);
    }

    @Override
    public int compareTo(Node o) {
        int res=0;
        if(a>o.a)
            res=1;
        else if (a==o.a)
            res=0;
        else
            res=-1;
        return res;
    }

    @Override
    public String toString() {
        return a+"";
    }
}
