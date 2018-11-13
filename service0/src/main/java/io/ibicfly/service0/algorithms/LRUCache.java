package io.ibicfly.service0.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache {
    private  static final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    LinkedHashMap<Object,Object> map;
    static {
        MAX_CACHE_SIZE=100;
    }
    public LRUCache(int cacheSize) {
//        MAX_CACHE_SIZE = cacheSize;
        //根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容，
        int capacity = (int) Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTOR) + 1;
        map = new LinkedHashMap<Object,Object>(capacity, DEFAULT_LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public synchronized void put(Object key, Object value) {
        map.put(key, value);
    }

    public synchronized Object get(Object key) {
        return map.get(key);
    }

    public synchronized void remove(Object key) {
        map.remove(key);
    }

    public synchronized Set<Map.Entry<Object,Object>> getAll() {
        return map.entrySet();
    }

    public synchronized int size() {
        return map.size();
    }

    public synchronized void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(10);
//        LRUDelegation lruDelegation=new LRUDelegation(10);
        System.out.println();
        System.out.println("===========================LRU LinkedHashMap(delegation)实现===========================");
        LRUDelegation<Integer, String> lru = new LRUDelegation(5);
        lru.put(1, "11");
        lru.put(2, "11");
        lru.put(3, "11");
        lru.put(4, "11");
        lru.put(5, "11");
        System.out.println(lru.toString());
        lru.put(6, "66");
        lru.get(2);
        lru.put(7, "77");
        lru.get(4);
        System.out.println(lru.toString());
        System.out.println();

    }
}
 class LRUDelegation<K, V> {

    private final int MAX_SIZE;
    LinkedHashMap<K, V> map;

     public synchronized void put(K k, V v) {
         map.put(k,v);
     }

     public synchronized Object get(K key) {
         return map.get(key);
     }

     public synchronized void remove(K key) {
         map.remove(key);
     }

     public synchronized Set<Map.Entry<K, V>> getAll() {
         return map.entrySet();
     }

     public synchronized int size() {
         return map.size();
     }

     public synchronized void clear() {
         map.clear();
     }

    public LRUDelegation(int cacheSize) {
        MAX_SIZE = cacheSize;
        int capacity = (int) Math.ceil(MAX_SIZE / 0.75) + 1;
        map = new LinkedHashMap(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_SIZE;
            }
        };
    }
     @Override
     public String toString() {
         StringBuilder sb = new StringBuilder();
         for (Map.Entry entry : map.entrySet()) {
             sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
         }
         return sb.toString();
     }
}
