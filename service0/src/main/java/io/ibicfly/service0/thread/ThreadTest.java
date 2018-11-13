package io.ibicfly.service0.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/23 9:05
 * @Description: 作用描述
 */
public class ThreadTest {
    static class TwoThread {
        //        static Integer i=new Integer(1);
        static boolean flag = true;
        static AtomicInteger i = new AtomicInteger(1);
        final static Semaphore SEMAPHORE = new Semaphore(1);
        final static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(2);
        final static CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(3);

        public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
//            ExecutorService executorService = new ThreadPoolExecutor(2, 2,
//                    0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), Executors.defaultThreadFactory());
            long start = System.currentTimeMillis();
            Thread thread = new Thread(new One());
            Thread thread1 = new Thread(new Two());
            thread.start();
            thread1.start();
            COUNT_DOWN_LATCH.await();
            System.out.println(System.currentTimeMillis() - start + "ms");
        }

        static class One implements Runnable {
            private Thread thread;

            public Thread getThread() {
                return thread;
            }

            public void setThread(Thread thread) {
                this.thread = thread;
            }

            @Override
            public void run() {
                while (i.get() < 100) {
                    if (flag) {
                        System.out.println("B" + i.getAndIncrement());
                        flag = false;
                    }
                }
                COUNT_DOWN_LATCH.countDown();
            }
        }

        static class Two implements Runnable {
            private Thread thread;

            public Thread getThread() {
                return thread;
            }

            public void setThread(Thread thread) {
                this.thread = thread;
            }

            @Override
            public void run() {
                while (i.get() <= 100) {
                    if (!flag) {
                        System.out.println("A" + i.getAndIncrement());
                        flag = true;
                    }
                }
                COUNT_DOWN_LATCH.countDown();
            }
        }
    }

    static class JoinTest {
        public static void main(String[] args) {
            for (int i = 0; i < 10; i++) {
                int  temp=i;
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("线程"+temp+"结束");
                    }
                });
                thread.setName(String.valueOf(i));
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("All Fin");
        }
    }

    public static void main(String[] args) {

    }
}

class RecordSample implements Runnable {
    int a = 0;
    boolean flag = false;
    public final static int CPUNUM;

    static {
        CPUNUM = Runtime.getRuntime().availableProcessors();
    }

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = a * a;
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        writer();
        reader();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(CPUNUM - 1);
//        executorService.submit()
        for (int i = 0; i < 1000; i++) {
            RecordSample recordSample = new RecordSample();
            executorService.submit(recordSample);
        }
        executorService.shutdown();
    }

}

class Deprecated {
    public static void main(String[] args) throws Exception {

        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        SleepUtils.second(3);
    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                System.out.println(Thread.currentThread().getName() + " Run at " +
                        format.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }
}
