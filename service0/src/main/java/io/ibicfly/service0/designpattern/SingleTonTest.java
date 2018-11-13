package io.ibicfly.service0.designpattern;

public class SingleTonTest {
    private final static String b;
    static {
        b="b";
    }
    private final String a;

    SingleTonTest(String a)
    {
        this.a=a;
    }
    private final String c="c";
    public void test() {
        Test test=new Test();
        System.out.println(a);
    }

    public static void main(String[] args) {
        System.out.println("1");
        SingleTonTest singleTonTest = new SingleTonTest("a");
        System.out.println("2");
//        for (int i = 0; i < 1000000; i++) {
//            Test2 test2 = new Test2();
//            Test test = new Test();
//            Thread thread = new Thread(test2);
//            thread.setName(i + "");
//            thread.start();
//        }
//        SingleTonTest singleTonTest = new SingleTonTest();
//        System.out.println(SingleTon.getInstance());
    }

}

class Test implements Runnable {
    private SingleTon single;

    @Override
    public void run() {
        single = SingleTon.getInstance();
        System.out.println("thread" + Thread.currentThread().getName() + single);
    }
}

/**
 * 采用双重锁定在1.5之前可能还会出现指令重排序的bug
 */
class SingleTon {
    private volatile static SingleTon instance = null;

    public static SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }
}

/**
 * 这里使用了静态内部类来实现，是因为静态内部类只有在第一次使用这个类的时候才会进行加载
 */
class SingleTonStatic {

    private static class SingleTonStaticBuilder {
        private static final SingleTonStatic singleTonStatic = new SingleTonStatic();
    }

    public static SingleTonStatic getInstance() {
        return SingleTonStaticBuilder.singleTonStatic;
    }

}

class Test2 implements Runnable {
    private SingleTonStatic single;

    @Override
    public void run() {
        single = SingleTonStatic.getInstance();
        System.out.println("thread" + Thread.currentThread().getName() + single);
    }
}
