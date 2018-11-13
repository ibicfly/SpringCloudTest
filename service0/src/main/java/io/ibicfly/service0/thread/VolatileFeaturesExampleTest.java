package io.ibicfly.service0.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/23 13:48
 * @Description: 作用描述
 */
public class VolatileFeaturesExampleTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        VolatileFeaturesExample volatileFeaturesExample = new VolatileFeaturesExample();
        for (int i = 0; i < 1000000; i++) {
            final Integer integer=new Integer(i);
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    synchronized(volatileFeaturesExample) {
                        volatileFeaturesExample.set(integer);
                        System.out.println(volatileFeaturesExample.get());
                    }
                }
            };
            executorService.submit(runnable);
//            Thread thread=new Thread(runnable);
//            thread.setName(i+"");
//            thread.start();
        }
        executorService.shutdown();
    }
}
//这两个类的getAndIncrement方法都是普通方法，线程不安全的
class VolatileFeaturesExample {
    volatile long vl = 0L; // 使用volatile声明64位的long型变量
//    long vl = 0L;

    public void set(long l) {
        vl = l; // 单个volatile变量的写
    }

    public void getAndIncrement() {
        vl++; // 复合（多个）volatile变量的读/写
    }

    public long get() {
        return vl; // 单个volatile变量的读
    }

}

class VolatileFeaturesExample2 {
    long vl = 0L; // 64位的long型普通变量

    public synchronized void set(long l) { // 对单个的普通变量的写用同一个锁同步
        vl = l;
    }

    public void getAndIncrement() { // 普通方法调用
        long temp = get(); // 调用已同步的读方法
        temp += 1L; // 普通写操作
        set(temp); // 调用已同步的写方法
    }

    public synchronized long get() { // 对单个的普通变量的读用同一个锁同步
        return vl;
    }

}

