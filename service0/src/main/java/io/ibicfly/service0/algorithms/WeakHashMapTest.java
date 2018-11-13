package io.ibicfly.service0.algorithms;


import java.util.WeakHashMap;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/12 15:43
 * @Description: 作用描述
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
//        WeakHashMapTest weakHashMapTest = new WeakHashMapTest();
//        System.out.println("a");
//        WeakHashMap weakHashMap = new WeakHashMap();
//        for (int i = 0; i < 10; i++) {
//            weakHashMap.put(Integer.toString(i), i);
//        }
//        System.gc();
//        for (int i = 0; i < 10; i++) {
//            weakHashMap.put(Integer.toString(i), i);
//        }
        int size = 3;
        Key[] keys = new Key[size];
        Value[] vals=new Value[size];
        WeakHashMap weakHashMap = new WeakHashMap();
        for(int i=0;i<size;i++) {
            Key key=new Key(Integer.toString(i));
            System.out.println("创建key"+key);
            Value value=new Value(Integer.toString(i));
            System.out.println("创建val"+value);
            if(i%3==0) {
                keys[i] = key;
                vals[i]=value;
            }
            weakHashMap.put(key,value);
        }
        System.gc();
    }
}

class Element {
    private String ident;

    public Element(String id) {
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    public int hashCode() {
        return ident.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Element && ((Element) obj).ident.equals(ident);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize" + getClass().getSimpleName() + ident);
    }
}

class Key extends Element {
    public Key(String id) {
        super(id);
    }
}

class Value extends Element {
    public Value(String id) {
        super(id);
    }
}