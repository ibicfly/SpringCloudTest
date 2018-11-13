package io.ibicfly.service0.basic;

import java.util.Random;

/**
 * @Author :cyh
 * @CreateDate: 2018/9/27 9:19
 * @Description: 作用描述
 */
public class FinalData {
    private static Random random = new Random(47);
    private String id;

    private final int i4 = random.nextInt(20);

    public String toString() {
        return id + ": " + i4;
    }

    public static void main(String[] args) {
        FinalData finalData = new FinalData();
        finalData.test();
        System.out.println(finalData.i4);
        FinalData finalData2 = new FinalData2();
        finalData2.test();
        FinalData3 finalData3 = new FinalData3();
        System.out.println(++finalData3.a);
    }

    private final void test() {
        System.out.println("final method test");
    }
}

class FinalData2 extends FinalData {
    public final void test() {
        System.out.println("final method test public override");
    }
}

final class FinalData3 {
    public static int a = 0;
}

class Value {
    int i;

    public Value(int i) {
        this.i = i;
    }
}

class FinalReferenceExample {
    final int[] intArray; // final是引用类型
    static FinalReferenceExample obj;

    public FinalReferenceExample() { // 构造函数
        intArray = new int[1]; // 1
        intArray[0] = 1; // 2
    }

    public static void writerOne() { // 写线程A执行
        obj = new FinalReferenceExample(); // 3
    }

    public static void writerTwo() { // 写线程B执行
        obj.intArray[0] = 2; // 4
    }

    public static void reader() { // 读线程C执行
        if (obj != null) { // 5
            int temp1 = obj.intArray[0]; // 6
        }
    }
}