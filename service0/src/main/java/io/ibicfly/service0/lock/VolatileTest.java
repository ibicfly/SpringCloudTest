package io.ibicfly.service0.lock;

import io.swagger.models.auth.In;
import org.omg.SendingContext.RunTime;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author :cyh
 * @CreateDate: 2018/9/26 17:16
 * @Description: 作用描述
 */
public class VolatileTest {
    private final static int n;

    static {
        n = Runtime.getRuntime().availableProcessors();
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            TestThread testThread = new TestThread();
            Thread thread=new Thread(testThread);
            if(i%3==0)
                thread.setName("add");
            else
                thread.setName(i+"");
            thread.start();
        }
    }
}

class TestThread implements Runnable {
    volatile static int a=0;

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("add")) {
            a++;//单线程写
        } else {
            System.out.println("Thread"+Thread.currentThread().getName()+"---"+a);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}