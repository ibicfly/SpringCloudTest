package io.ibicfly.service0.lock;

import javax.sound.midi.Soundbank;
import java.util.concurrent.*;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/31 13:36
 * @Description: 作用描述
 */
public class CyclicBarrierTest {
    private static volatile CyclicBarrier cyclicBarrier;
    private static volatile Semaphore semaphore;

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(5);
        semaphore = new Semaphore(1);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 10; i++) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//          其实已经做到了每一组一发，但是由于可能是cpu缓存或者输出流的缓存问题，才会导致输出出现错行的情况，在线程sleep之后，就能正确显示结果
            for (int j = 0; j < 5; j++) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("Thread " + Thread.currentThread().getName() + " 在等待");
                            cyclicBarrier.await(1, TimeUnit.SECONDS);
                            System.out.println("Thread " + Thread.currentThread().getName() + " 整整齐齐");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            System.out.println("Thread " + Thread.currentThread().getName() + " 打破栅栏");
                        } catch (TimeoutException e) {
                            System.out.println("Thread " + Thread.currentThread().getName() + " 等待超时退出");
                        }
                    }
                });
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }
        executorService.shutdown();
    }
}
