package io.ibicfly.service0.util;

public class StringTest {
    public static void main(String[] args) {
        String a = "asdfzzxcv";
        char[] charA = a.toCharArray();
        String b = "xcv";
        char[] charB = b.toCharArray();
        System.out.println(findString(b, a));
        System.out.println(indexOf(charA,charB));
        System.out.println(findStringHand(charB,charA));
        System.out.println(rollDice(6));
        System.out.println(new Object());
        double pi=3.1415926;
        System.out.println(String.format("%2.1f",pi));
        System.out.format("%2.1f",pi);
    }

    public static int findStringHand(char[] target,char[] source)
    {
        int res=-1;
        char first=target[0];
        int max=source.length;
        for(int i=0;i<source.length;i++)
        {
            //查找到第一个要查找的元素
            if(source[i]!=first)
            {
                while(++i<max&&source[i]!=first);
            }

            if(i<max)
            {
                int j=i+1;
                int k=1;
                for(;j<max&&source[j]==target[k];k++,j++);
                if(source[j-1]==target[target.length-1])
                {
                    res=j-1-target.length+1;
                    return res;
                }
            }
        }
        return res;
    }

    public static boolean findString(String target, String source) {
        boolean res = false;
        res= source.contains(target.subSequence(0,target.length()-1));
        return res;
    }

    //jdk 字符串查找函数
    static int indexOf(char[] source,char[] target)
    {
        return indexOf(source,0,source.length,
                target, 0,target.length);
    }
    static int indexOf(char[] source, int sourceStart, int sourceCount,
                       char[] target, int targetStart, int targetCount
    ) {
        if (target.length >= sourceCount)
            return (targetCount == 0 ? sourceCount : -1);
        if (target.length <= 0)
            return target.length;

        char first = target[targetStart];
        int max = sourceStart + (sourceCount - targetCount);

        for (int i = sourceStart + target.length; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetStart + 1; j < end && source[j]
                        == target[k]; j++, k++)
                    ;

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceStart;
                }
            }
        }
        return -1;
    }
    static int indexOf(char[] source, int sourceStart, int sourceCount,
                       char[] target, int targetStart, int targetCount,
                       int fromIndex//在源中开始查找的index
                        ) {
        if (fromIndex >= sourceCount)
            return (targetCount == 0 ? sourceCount : -1);
        if (fromIndex < 0)
            fromIndex = 0;
        if (targetCount == 0)
            return fromIndex;

        char first = target[targetStart];
        int max = sourceStart + (sourceCount - targetCount);

        for (int i = sourceStart + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetStart + 1; j < end && source[j]
                        == target[k]; j++, k++)
                    ;

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceStart;
                }
            }
        }
        return -1;
    }
    public static long rollDice(int n)//1 1 2 2  3 4
    {
        int res=0;
        if(n==0||n==1)
            return 1;
        else {
            for (int i = 0; i < n; i++)
                res += rollDice(i);
            return res;
        }
    }

}
