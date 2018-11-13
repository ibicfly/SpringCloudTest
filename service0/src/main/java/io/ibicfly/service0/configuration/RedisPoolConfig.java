package io.ibicfly.service0.configuration;

import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPoolConfig {
    @Bean
    public static JedisPool getPool() {
        return RedisPoolBuilder.build();
    }

    private RedisPoolConfig() {
    }

    private static class RedisPoolBuilder {
        private static JedisPoolConfig poolConfig = new JedisPoolConfig();
        final static String password = "1+1=2";
        private static JedisPool pool = new JedisPool(poolConfig, "localhost", 6379, 100, password);

        public static JedisPool build() {
            return pool;
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        JedisPool[] pools = new JedisPool[n];
        for (int i = 0; i < n; i++) {
            TestThread testThread = new TestThread(i);
            Thread thread = new Thread(testThread);
            thread.start();
            pools[i] = testThread.getPool();
        }
        for (JedisPool temp : pools)
            System.out.println(temp);
    }
}

class TestThread implements Runnable {
    private JedisPool pool;
    private int num;

    public int getNum() {
        return num;
    }

    public JedisPool getPool() {
        return pool;
    }

    public TestThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        pool = RedisPoolConfig.getPool();
    }
}