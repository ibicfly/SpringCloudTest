package io.ibicfly.service0.offer2018;

import java.util.*;

public class WangYi2018 {
    public static void main(String[] args)
    {
//        HashMap hashMap=new HashMap();
        Scanner scanner=new Scanner(System.in);
        long N = scanner.nextLong();//工作数
        long M = scanner.nextLong();//人数
        HashMap<Long,Long> hashMap = new HashMap();
        TreeSet<Long> set=new TreeSet<>();
        long i=0;
        while(i<N)
        {
            long Di=scanner.nextLong();//难度
            long Pi=scanner.nextLong();//报酬
            set.add(Di);
            hashMap.put(Di,Pi);
            i+=1;
        }
        i=0;
        System.out.println();
        while(i<M)
        {
            long Ai = scanner.nextLong();
            Iterator iterator=set.iterator();
            long min=0;
            while(iterator.hasNext())
            {
                long temp= (long) iterator.next();
                if (Ai >= temp)
                    min=temp;
                else
                    break;
            }
            System.out.println(hashMap.get(min) + " ");
        }

    }
}
