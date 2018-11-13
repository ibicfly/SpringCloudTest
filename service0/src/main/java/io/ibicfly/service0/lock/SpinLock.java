package io.ibicfly.service0.lock;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁，采用了
 */
public class SpinLock {
    private final static int CPU_NUM;

    static {
        CPU_NUM = Runtime.getRuntime().availableProcessors();
    }

    private AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock() {
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null, current)) {
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLock spinLock = new SpinLock();
        Object synLock=new Object();

        Test test1 = new Test(spinLock);
        Thread thread1 = new Thread(test1);
        thread1.setName("1");
        Test test2 = new Test(spinLock,thread1);
        Thread thread2 = new Thread(test2);
        thread2.setName("2");
        thread1.start();
        thread2.start();
//        for (int i = 0; i < CPU_NUM + 1; i++) {
//            Test test = new Test(synLock);
//            Thread thread = new Thread(test);
//            thread.setName(i + "");
//            thread.start();
//        }
    }
}

class Test implements Runnable {
    private Object synLock;
    private SpinLock spinLock;
    private Thread lastThread;
    private static int a = 1;

    public Test() {

    }

    public Test(SpinLock lock) {
        this(lock,null);
    }

    public Test(SpinLock lock,Thread lastThread) {
        spinLock = lock;
        this.lastThread=lastThread;
    }

    public Test(Object synLock) {
        this.synLock = synLock;
    }

    public SpinLock getSpinLock() {
        return spinLock;
    }

    public void setSpinLock(SpinLock spinLock) {
        this.spinLock = spinLock;
    }

    private void spinLock() throws InterruptedException {
        lastThread.join();
        int thread = Integer.parseInt(Thread.currentThread().getName());
        int time = 0;
        if(spinLock==null)
            return;
        if (thread % 2 == 0)
            time = 10;
        if (thread % 2 == 1)
            time = 20;
        spinLock.lock();
        System.out.println("Thread  " + thread + " Start Sleep " + time);
        Thread.sleep(time);
        System.out.println("Thread  " + thread + " End Sleep " + time);
        System.out.println("test");
        spinLock.unlock();
    }

    private void synchronizedLock() throws InterruptedException {
        int thread = Integer.parseInt(Thread.currentThread().getName());
        int time = 0;
        if(synLock==null)
            return;
        while (true) {
                if ( thread% 2 == 0)
                    time = 100;
                if (thread % 2 == 1)
                    time = 200;
            synchronized (synLock) {
                System.out.println("Thread  " + thread + " 开始 Sleep " + time);
                Thread.sleep(time);
                System.out.println("Thread  " + thread + " End Sleep " + time);
            }
        }
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("线程"+threadName+"进入run方法");
//            spinLock();
            synchronizedLock();
            System.out.println("线程"+threadName+"退出run方法");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
