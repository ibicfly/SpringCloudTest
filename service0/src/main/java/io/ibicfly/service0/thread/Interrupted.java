package io.ibicfly.service0.thread;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/25 16:36
 * @Description: 作用描述
 */
public class Interrupted {
    public static void main(String[] args) throws Exception {
// sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
// busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
// 休眠5秒，让sleepThread和busyThread充分运行
        SleepUtils.second(5000);
        sleepThread.interrupt();
        busyThread.interrupt();
// 防止sleepThread和busyThread立刻退出SleepUtils.second(2);
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        SleepUtils.second(2000);
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());

    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
            }
        }
    }
}
