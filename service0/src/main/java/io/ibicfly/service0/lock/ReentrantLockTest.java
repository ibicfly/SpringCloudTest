package io.ibicfly.service0.lock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private final static ReentrantLock lock = new ReentrantLock();
//    private static final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) {
//        ExecutorService executor=Executors.newFixedThreadPool(10);
//        AtomicInteger ctl=new AtomicInteger();
//        ctl.set(10);
//        while(ctl.intValue()>0){
//            TestTask testTask = new TestTask(ctl);
//            testTask.setLock(lock);
//            executor.submit(testTask);
//        }
//        System.out.println("shutDown Pool");
//        executor.shutdown();
        ReentrantLock lock = new ReentrantLock();
        System.out.println("主线程获得锁");
        try {
            lock.lock();
            for(int i=0;i<10;i++)
            {
                final  int temp=i;
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("子线程"+temp+"获得锁");
                            lock.lock();
                            Thread.sleep(100);
                            System.out.println("子线程"+temp+"释放锁");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            lock.unlock();
                        }
                    }
                });
                thread.start();
            }
        }finally {
            lock.unlock();
        }

        System.out.println("主线程释放锁");
//        AbstractQueuedSynchronizer
    }
}

class TestTask implements Runnable {
//    private int num;
    private AtomicInteger atomNum;
    private ReentrantLock lock;

    public TestTask() {
    }
//    public TestTask(int num) {
//        this.num = num;
//    }
    public TestTask(AtomicInteger num) {
        this.atomNum = num;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }
//    public int sumCut1() {
//        return num--;
//    }

    @Override
    public void run() {

        if(atomNum.get()>0){
            System.out.print(Thread.currentThread().getName()+"   正在执行task  ");
            try {
                lock.lock();
                System.out.print("计算后"+atomNum);
                System.out.print("休眠"+(atomNum.get()*3)/10);
                Thread.sleep(0);
                atomNum.decrementAndGet();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("  task 执行完毕");
                lock.unlock();
            }
        }
    }
}
