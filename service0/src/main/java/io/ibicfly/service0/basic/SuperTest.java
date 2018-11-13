package io.ibicfly.service0.basic;

/**
 * @Author :cyh
 * @CreateDate: 2018/9/27 10:58
 * @Description: 作用描述
 */
public class SuperTest {
    public static void main(String[] args) {
        Super sup = new Sub();
        System.out.println("sup.field" + sup.field + "sup.getField" + sup.getField());
        Sub sub = new Sub();
        System.out.println("sup.field" + sub.field + "sup.getField" + sub.getField() + "sup.getSuperField" + sub.getSuperField());
        sup.staticMethod();
        sub.staticMethod();
    }
}

class Super {
    public int field = 0;

    public int getField() {
        return field;
    }
    public static void staticMethod(){
        System.out.println("Super staticMethod");
    }
}

class Sub extends Super {
    public int field = 1;

    public int getField() {
        return field;
    }
    public static void staticMethod(){
        System.out.println("Sub staticMethod");
    }

    public int getSuperField() {
        return super.field;
    }
}