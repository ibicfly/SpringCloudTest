package io.ibicfly.service0.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/29 13:13
 * @Description: 作用描述
 */
public class ThreadLocalTest {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        ThreadLocalTest.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + ThreadLocalTest.end() + " mills");
    }
}

class Test implements Runnable{
    private static ThreadLocal threadLocal = new ThreadLocal();
    private int a;
    public Test(int i) {
        this.a=i;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++)
        {
//            System.out.println(threadLocal.get());
            Test test=new Test(i);
            Thread thread=new Thread(test);
            thread.start();
        }
    }

    @Override
    public void run() {
        threadLocal.set(a);
        System.out.println(Thread.currentThread().getName()+" ---"+threadLocal.get());
    }
//    static class ResourceClass {
//
//        public final static ThreadLocal<String> RESOURCE_1 =
//                new ThreadLocal<String>();
//
//        public final static ThreadLocal<String> RESOURCE_2 =
//                new ThreadLocal<String>();
//
//    }

//    static class A {
//
//        public void setOne(String value) {
//            ResourceClass.RESOURCE_1.set(value);
//        }
//
//        public void setTwo(String value) {
//            ResourceClass.RESOURCE_2.set(value);
//        }
//    }

//    static class B {
//        public void display() {
//            System.out.println(ResourceClass.RESOURCE_1.get()
//                    + ":" + ResourceClass.RESOURCE_2.get());
//        }
//    }

//    public static void main(String []args) {
//        final A a = new A();
////        final B b = new B();
//        for(int i = 0 ; i < 15 ; i ++) {
//            final String resouce1 = "线程-" + i;
//            final String resouce2 = " value = (" + i + ")";
//            new Thread() {
//                public void run() {
//                    try {
//                        a.setOne(resouce1);
//                        a.setTwo(resouce2);
//                        System.out.println(ResourceClass.RESOURCE_1.get()
//                                + ":" + ResourceClass.RESOURCE_2.get());
//                    }finally {
//                        ResourceClass.RESOURCE_1.remove();
//                        ResourceClass.RESOURCE_2.remove();
//                    }
//                }
//            }.start();
//        }
//    }


//    public static void main(String[] args) {
//        for(int i=0;i<100;i++) {
//            Test test = new Test(i);
//
//        }
//    }
}
class Test2{
    static int a=0;
    static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        LockSupport.park();
//        for(int i=0;i<5;i++) {
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while (true) {
//                        threadLocal.set(a++);
//                        System.out.println("Thread " + Thread.currentThread().getName() + "  print " + threadLocal.get());
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            });
//            thread.setName(Integer.toString(i));
//            thread.start();
//        }
    }
}