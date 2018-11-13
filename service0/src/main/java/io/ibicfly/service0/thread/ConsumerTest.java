package io.ibicfly.service0.thread;

import io.ibicfly.service0.util.TimeUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/26 16:39
 * @Description: 作用描述
 */
public class ConsumerTest {
//    利用队列和线程实现了生产者和消费者模式Demo wait和notify方法，都需要在持有对应对象锁的时候才能使用，因为他会放弃对象锁，让线程进入等待队列，直到被唤醒进入阻塞队列重新竞争锁
    static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue(100);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Constumer constumer = new Constumer();
        executorService.submit(constumer);
        for (int i = 0; i < 10; i++) {
            Producter producter = new Producter(i);
            executorService.submit(producter);
        }
        Producter exitInstruction = new Producter("ConsumerExit");
        executorService.submit(exitInstruction);
        executorService.shutdown();
    }

    static class Constumer implements Runnable {
        public Constumer() {
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (!queue.isEmpty()) {
                        String message = queue.poll();
                        System.out.println("message :" + message + "   ---Constomer at" + TimeUtil.getNowHHMMSS());
                        if (message.equals("ConsumerExit")) {
                            System.out.println("ConsumerExit");
                            return;
                        }
                    }
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Producter implements Runnable {
        private String message;

        public Producter() {
        }

        public Producter(String message) {
            this.message = message;
        }

        public Producter(int a) {
            this.message = a + "";
        }

        @Override
        public void run() {
            synchronized (queue) {
                queue.offer(message);
                queue.notifyAll();
            }
        }
    }

}
