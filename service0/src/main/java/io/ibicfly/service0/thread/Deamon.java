package io.ibicfly.service0.thread;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/25 15:53
 * @Description: 作用描述
 */
public class Deamon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(11);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("DaemonThread start run.");
                SleepUtils.second(10);
                System.out.println("DaemonThread end run.");
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}

class SleepUtils {
    public static void second(long seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
