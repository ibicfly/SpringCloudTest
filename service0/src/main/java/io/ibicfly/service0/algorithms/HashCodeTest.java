package io.ibicfly.service0.algorithms;

/**
 * @Author :cyh
 * @CreateDate: 2018/11/8 8:58
 * @Description: 作用描述
 */
public class HashCodeTest {

    static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash
    public static void main(String[] args) {
        int n=10;
        String[] strings=new String[n];
        for (int i=0;i<n;i++)
        {
            String a=Integer.toString(i);
            strings[i]=a;
            System.out.println(a.hashCode());
        }
    }
    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }
}

