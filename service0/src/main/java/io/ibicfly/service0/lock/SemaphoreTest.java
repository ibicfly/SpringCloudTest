package io.ibicfly.service0.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/31 13:25
 * @Description: 作用描述
 */
public class SemaphoreTest {
    private static Semaphore semaphore;

    public static void main(String[] args) {
        semaphore=new Semaphore(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (semaphore.availablePermits()==0)
                {
                    System.out.println("并发充满\n");
                }
            }
        });

        for(int i=1;i<=100;i++)
        {
            final  int temp=i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        Thread.sleep(1000);
                        System.out.println("Thread"+temp);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
