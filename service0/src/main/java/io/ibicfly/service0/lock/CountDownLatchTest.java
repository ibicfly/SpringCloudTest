package io.ibicfly.service0.lock;

import javax.sound.midi.Soundbank;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/31 11:27
 * @Description: 作用描述
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch;

    public static void main(String[] args) {
        countDownLatch = new CountDownLatch(4);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("4个线程创建完毕");
            }
        });
        for (int i = 0; i < 520; i++) {
            final int temp = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    if (countDownLatch.getCount() > 0) {
                        try {
                            Thread.sleep(temp * 1000);
                            System.out.println("Thread " + temp + "sleep" + temp * 100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        countDownLatch.countDown();
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
