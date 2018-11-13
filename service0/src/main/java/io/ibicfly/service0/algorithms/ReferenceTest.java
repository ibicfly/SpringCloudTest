package io.ibicfly.service0.algorithms;

import java.lang.ref.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/12 11:21
 * @Description: 作用描述
 * 强软弱虚
 */
public class ReferenceTest {
    public static void main(String[] args) {
//        SoftReference softReference = new SoftReference();
//        WeakReference weakReference = new WeakReference();
//        PhantomReference phantomReference = new PhantomReference();
        Integer obj = new Integer(5);
        SoftReference sf = new SoftReference(obj);
        WeakReference<Object> wf = new WeakReference<Object>(obj);
        PhantomReference pf = new PhantomReference(obj, null);
        System.out.println("软引用" + sf.get());
        System.out.println("弱引用" + wf.get());
        System.out.println("虚引用" + pf.get());
        obj = null;
        System.out.println("软引用" + sf.get());
        System.out.println("弱引用" + wf.get());
        System.out.println("虚引用" + pf.get());
        Runtime.getRuntime().gc();
        System.out.println("GC 1次");
        System.out.println("软引用" + sf.get());
        System.out.println("弱引用" + wf.get());
        System.out.println("虚引用" + pf.get());
        Runtime.getRuntime().gc();
        System.out.println("GC 2次");
        System.out.println("软引用" + sf.get());
        System.out.println("弱引用" + wf.get());
        System.out.println("虚引用" + pf.get());
        Runtime.getRuntime().gc();
        System.out.println("GC 3次");
        System.out.println("软引用" + sf.get());
        System.out.println("弱引用" + wf.get());
        System.out.println("虚引用" + pf.get());


        Object a = new Object();
        referenceTest(a);
        softReferenceTest(a);
        weakReferenceTest(a);
        phantomReferenceTest(a);
    }

    //    强引用
    public static void referenceTest(Object o) {
        Object a = o;
    }

    //    软引用
    public static void softReferenceTest(Object o) {
        Object a = new Object();
        SoftReference reference = new SoftReference(o);
        o = reference.get();
    }

    //  弱引用
    public static void weakReferenceTest(Object o) {
        WeakReference reference = new WeakReference(o);
        o = reference.get();
    }

    //  虚引用
    public static void phantomReferenceTest(Object o) {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference reference = new PhantomReference(o, referenceQueue);
        o = reference.get();
    }

    public static void test() {

    }
}


class VeryBig {
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;

    public VeryBig(String id) {
        ident = id;
    }

    public String toString() {
        return ident;
    }

    @Override
    protected void finalize() {
        System.out.println("finalizing " + ident);
    }
}
 class References {
    private static ReferenceQueue<VeryBig> rq =
            new ReferenceQueue<VeryBig>();

    public static void checkQueue() {
        Reference<? extends VeryBig> inq = rq.poll();
        if (inq != null)
            System.out.println("In queue:" + inq.get());
    }

    public static void main(String[] args) {
        int size = 3;
        LinkedList<SoftReference<VeryBig>> sa =
                new LinkedList<SoftReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            sa.add(new SoftReference<VeryBig>(
                    new VeryBig("Soft" + i), rq));
            System.out.println("Just created:" + sa.getLast());
            checkQueue();
        }
        LinkedList<WeakReference<VeryBig>> wa =
                new LinkedList<WeakReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            wa.add(new WeakReference<VeryBig>(
                    new VeryBig("Weak" + i), rq));
            System.out.println("Just created:" + wa.getLast());
            checkQueue();
        }
//        SoftReference<VeryBig> s =
//                new SoftReference<VeryBig>(new VeryBig("Soft"));
//        WeakReference<VeryBig> w =
//                new WeakReference<VeryBig>(new VeryBig("Weak"));
        System.gc();
        checkQueue();
        LinkedList<PhantomReference<VeryBig>> pa =
                new LinkedList<PhantomReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            pa.add(new PhantomReference<VeryBig>(
                    new VeryBig("Phantom" + i), rq));
            System.out.println("Just created:" + pa.getLast());
            checkQueue();
        }
    }
}

