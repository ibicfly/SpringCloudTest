package io.ibicfly.service0.lock;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/22 14:04
 * @Description: 作用描述
 * 两个锁互相
 */
public class DealLockTest {
    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        System.out.println(Thread.currentThread().getName()+"hold lock A");
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }synchronized (B) {
                        System.out.println(Thread.currentThread().getName()+"hold lock B");
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    System.out.println(Thread.currentThread().getName()+"hold lock B");
                    synchronized (A) {
                        System.out.println(Thread.currentThread().getName()+"hold lock A");
                        System.out.println("2");
                    }
                }
            }
        });
        t1.setName(1+"");
        t1.start();
        t2.setName(2+"");
        t2.start();
    }
    private static String A = "A";
    private static String B = "B";
    public static void main(String[] args) {
        new DealLockTest().deadLock();
    }
}
