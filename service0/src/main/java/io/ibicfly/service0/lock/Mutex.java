package io.ibicfly.service0.lock;

import io.swagger.models.auth.In;

import java.io.BufferedInputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Lock
 * 实现一个独占锁
 * 它在同一时刻只允许一个线程占有锁
 */
public class Mutex implements Lock {
    private static class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = -4387327721959839431L;

        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        public boolean tryAcquire(int acquires) {
            // Otherwise unused
            assert acquires == 1;
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int releases) {
            assert releases == 1; // Otherwise unused
            if (getState() == 0)
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    public static void main(String[] args) {
//        Mutex mutex = new Mutex();
//        for (int i = 0; i < 1000; i++) {
//            int temp = i;
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    mutex.lock();
//                    System.out.println(temp);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    mutex.unlock();
//                }
//            });
//            thread.start();
//        }
        Mutex2 mutex2 = new Mutex2();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    mutex2.lock();
                    System.out.println(temp);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mutex2.unlock();
                }
            });
            thread.setName(Integer.toString(temp));
            thread.start();
        }
    }

}

//  这是一个互斥锁
class Mutex2 implements Lock {
    // 静态内部类，自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        // 该线程是否正在独占资源。只有用到condition才需要去实现它。当状态为0的时候获取锁
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        //tryAcquire(int)：独占方式。尝试获取资源，成功则返回true，失败则返回false。释放锁，将状态设置为0
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        //        tryRelease(int)：独占方式。尝试释放资源，成功则返回true，失败则返回false。
        protected boolean tryRelease(int releases) {
            if (getState() == 0) throw new
                    IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }// 返回一个Condition，每个condition都包含了一个condition队列

        Condition newCondition() {
            return new ConditionObject();
        }
    }// 仅需要将操作代理到Sync上即可

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }
    @Override
    public void unlock() {
        sync.release(1);
    }
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }
    @Override
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }
}
