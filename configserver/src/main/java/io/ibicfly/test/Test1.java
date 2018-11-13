package io.ibicfly.test;

public class Test1 {
    public static void main(String[] args)
    {
        ClassLoader loader=Integer.class.getClassLoader();//bootstrap加载器进行加载
        while(loader!=null)
        {
            System.out.println(loader);
            loader=loader.getParent();
        }
//        System.out.println(loader);
    }
}

