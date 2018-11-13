package io.ibicfly.service0.jvm;

/**
 * @Author :cyh
 * @CreateDate: 2018/9/20 9:56
 * @Description: 作用描述
 */
public class DealLoopTest {
    {
        System.out.println("实例块");
    }

    static {
        System.out.println("DealLoopTest...");
    }

    static class DeadLoopClass {
        static {
            if (true) {
                System.out.println(Thread.currentThread()
                        + "init DeadLoopClass");
//                while (true) {
//                    System.out.println(Thread.currentThread()
//                            + "initing");
//                    // 模拟耗时很长的操作
//                }
            }
        }
    }

    public static void main(String[] args) {
//        Runnable script = new Runnable() {   // 匿名内部类
//            public void run() {
//                System.out.println(Thread.currentThread() + " start");
//                DeadLoopClass dlc = new DeadLoopClass();
//                System.out.println(Thread.currentThread() + " run over");
//            }
//        };
//
//        Thread thread1 = new Thread(script);
//        Thread thread2 = new Thread(script);
//        thread1.start();
//        thread2.start();
        Bar bar = new Bar();
        System.out.println(bar.getValue());
    }
}

class Foo {
    int i = 1;

    Foo() {
        System.out.println(i);
        int x = getValue();
        System.out.println(x);
    }

    {
        i = 2;
    }

    protected int getValue() {
        return i;
    }
}

//子类
class Bar extends Foo {
    int j = 1;

    Bar() {
        j = 2;
    }

    {
        j = 3;
    }

    @Override
    protected int getValue() {
        return j;
    }
}
