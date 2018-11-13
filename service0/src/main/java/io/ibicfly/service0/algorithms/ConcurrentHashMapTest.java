package io.ibicfly.service0.algorithms;

import io.swagger.models.auth.In;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/12 11:01
 * @Description: 作用描述
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap();
        for (int i = 0; i < 10; i++)
            concurrentHashMap.put(Integer.toString(i), Integer.toString(i));
        HashMap<String, String> hashMap = new HashMap();
        for (int i = 0; i < 10; i++)
            hashMap.put(Integer.toString(i), Integer.toString(i));
        testFailFast(concurrentHashMap);
        testFailFast(hashMap);
//        testFailFast2();
    }

    public static void testFailFast(Map map) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        map.put("11", "new");
        try {
//            Map.Entry entry = iterator.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        while (iterator.hasNext()) {
//            Map.Entry<String, String> entry = iterator.next();
//            if (Integer.parseInt(entry.getKey()) < 50)
//                System.out.println("key " + entry.getKey() + " val " + entry.getValue());
//            else {
//                System.out.println("key " + entry.getKey() + " val " + entry.getValue() + "new ");
//                entry.setValue(entry.getValue() + "new");
//            }
//        }
//        System.out.println("next");
//        Set<Map.Entry> entries = map.entrySet();
//        for (Map.Entry entry : entries) {
//            System.out.println("key " + entry.getKey() + " val " + entry.getValue());
//        }
    }

    public static void testFailFast2() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i + "", i + "");
        }
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (i == 3) {
                map.remove(3 + "");
            }
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            i++;
        }

    }
}
