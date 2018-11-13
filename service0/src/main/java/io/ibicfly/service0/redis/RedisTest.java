package io.ibicfly.service0.redis;

import org.springframework.boot.autoconfigure.cache.CacheProperties;
import redis.clients.jedis.Jedis;


public class RedisTest {
private static final String LOCK_SUCCESS = "OK";
private static final String SET_IF_NOT_EXIST = "NX";
private static final String SET_WITH_EXPIRE_TIME = "PX";
    public static void main(String[] args)
    {
        Jedis jedis=new Jedis("localhost");
        System.out.println("成功");
        System.out.printf("ping"+jedis.ping());
    }
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {

        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}
