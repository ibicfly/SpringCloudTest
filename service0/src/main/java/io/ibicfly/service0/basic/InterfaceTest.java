package io.ibicfly.service0.basic;

/**
 * @Author :cyh
 * @CreateDate: 2018/9/27 16:46
 * @Description: 作用描述
 */
public class InterfaceTest {
    private static String a = "a";

    public static void main(String[] args) {
//        InstrumentClass instrumentClass = new Wind();
//        InstrumentClass instrumentClass2 = new Wind();
//        instrumentClass2.a = "test2";
//        System.out.println(instrumentClass.a);
//        System.out.println(instrumentClass2.a);
//        System.out.println(Instrument.a);
    }
}

abstract class InstrumentClass {
    String a = new String("test");

    public void what() {
        System.out.println("what");
    }
}

interface Instrument {
    int a = 10;
}

class Wind extends InstrumentClass implements Instrument {
}

interface Monster {
    void say();
    void eat(Object o);
}

interface DangerousMonster extends Monster {
    void eat(Object live);
}
class Gesila implements DangerousMonster{

    @Override
    public void say() {

    }
    @Override
    public void eat(Object live) {

    }
}