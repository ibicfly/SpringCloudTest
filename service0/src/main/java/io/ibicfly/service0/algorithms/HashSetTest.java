package io.ibicfly.service0.algorithms;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
        TreeSet set1 = new TreeSet();
        for (int i = 0; i < 10; i++) {
            set1.add(i);
        }
        TreeMap treeMap = new TreeMap();
        for (int i = 0; i < 10; i++) {
            treeMap.put(i,i);
        }
        Object[] arr = set.toArray();
        for (Object temp : arr) {
            System.out.println(temp);
        }
    }
}
