package io.ibicfly.service0.lock;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author :cyh
 * @CreateDate: 2018/11/7 9:09
 * @Description: 作用描述
 */
public class ReadWriteLockTest {
    final static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    final static Lock readLock=readWriteLock.readLock();
    final static Lock writeLock=readWriteLock.writeLock();

    static int a=0;
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(5,10,
                0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),Executors.defaultThreadFactory());

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    writeLock.lock();
                    System.out.println("写变量a"+a++);;
                    writeLock.unlock();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        for(int i=0;i<10;i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        readLock.lock();
                        System.out.println("读变量a" + a);
                        readLock.unlock();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
