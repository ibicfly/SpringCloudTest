package io.ibicfly.service0.algorithms;

import java.util.HashMap;
import java.util.*;

public class HashMapTest implements Runnable {
    final static HashMap<String, String> map2 = new HashMap<String, String>(2);

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
//              创建10000个线程 不断在map里面进行添加
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map2.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Map<CountedString,Integer> map=new HashMap<>();
//        CountedString[] cs=new CountedString[5];
//        for(int i=0;i<cs.length;i++)
//        {
//            cs[i]=new CountedString("hello");
//            map.put(cs[i],i);
//        }
//        System.out.println(map);
//        for(CountedString temp:cs)
//        {
//            System.out.println("查找"+temp);
//            System.out.println(map.get(temp));
//        }
//        int a = 10;
//        System.out.println(a | 2);//这个操作相当于除2
//        int newCap = 16;
//        int ft = 12;
//
//        //开10个线程
//        for (int j = 0; j < 4; j++) {
//            HashMapTest test = new HashMapTest();
//            Thread thread = new Thread(test);
//            thread.setName(j + "");
//            thread.start();
//        }

//        a条件满足，然后进入&&的后一个条件，然后进入三目运算符，最后返回
//        HashMap hashMap = new HashMap(1,2);
//        hashMap.put("key","value");
//        MinStack stack=new MinStack();
//        stack.push(512);
//        stack.push(-1024);
//        stack.push(-1024);
//        stack.push(512);
//        stack.pop();
    }

    private static int a = 100000000;
    static HashMap<Object, Object> map = new HashMap<Object, Object>();
    private Object key;
    private Object value;
    final int c;

    public HashMapTest() {
        this.c = 1;
    }

    public boolean judgeCircle(String moves) {
        //O(n)
        int R = 0, L = 0, U = 0, D = 0;
        for (char temp : moves.toCharArray()) {
            switch (temp) {
                case 'U':
                    U++;
                    break;
                case 'L':
                    L++;
                    break;
                case 'D':
                    D++;
                    break;
                case 'R':
                    R++;
                    break;
            }
        }
        if (R == L && U == D)
            return true;
        return false;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void add(Object key, Object value) {
        System.out.println("线程" + Thread.currentThread().getName() + "添加 key " + key + "value" + value);
        map.put(key, value);
    }

    @Override
    public void run() {
        long start = System.nanoTime();
        while (a > 0) {
            synchronized (map) {
                if (a > 0) {
                    add(a, a);
                    a = a - 1;
                    HashMap<Object, Object> map1 = HashMapTest.map;
                    Set<Map.Entry<Object, Object>> set = map1.entrySet();
                    for (Map.Entry<Object, Object> entry : set) {
                        System.out.println("线程" + Thread.currentThread().getName() + "尝试迭代 key:" + entry.getKey() +
                                " value:" + entry.getValue());
                    }
                }
            }
        }
        System.out.println("线程" + Thread.currentThread().getName()
                + " 耗时" + (System.nanoTime() - start) / 1000000L + "ms");
    }
}

class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        stack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek()))
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

class CountedString {
    private static List<String> list = new ArrayList<>();
    private String s;
    private int id = 0;

    public CountedString(String str) {
        s = str;
        list.add(str);
        for (String temp : list) {
            if (temp.equals(str))
                id++;
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "String " + s + " id " + id + " hashCode " + hashCode();
    }
}