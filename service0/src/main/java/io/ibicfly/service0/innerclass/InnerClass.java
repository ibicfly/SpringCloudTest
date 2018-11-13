package io.ibicfly.service0.innerclass;

import io.swagger.models.auth.In;
import sun.applet.AppletClassLoader;

public class InnerClass {
/**
 * 局部内部类
 */
    public void innerClassMethod() {
        String name2 = "innerClassMethod";
         class InnerClassMethod {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String print() {
                return name2;
            }
        }
        InnerClassMethod innerClassMethod = new InnerClassMethod();
        System.out.println(innerClassMethod.print());
    }
}

/**
 * 成员内部类
 */
class OuterMember {
    private int name = 1;
    private int age = 99;

    public class Inner {

        private final int a = 1;
        String name = "Jayden";

        public void show() {
            System.out.println(OuterMember.this.name);
            System.out.println(name);
            System.out.println(age);
        }
    }

    public Inner getInnerClass() {
        return new Inner();
    }

    public static void main(String[] args) {
        OuterMember o = new OuterMember();
        Inner in = o.new Inner();
        in.show();
    }
}

/**
 * 匿名内部类
 */
class OuterAnonymous {
    private int name = 1;
    private int age = 99;

    public void method1(Inner inner) {
        System.out.println(inner.say1());
    }

    public void method2(Inner2 inner) {
        System.out.println(inner.say2());
    }

    public static void main(String[] args) {
        OuterAnonymous o = new OuterAnonymous();
        o.method1(new Inner() {
            @Override
            public String say1() {
                return "say";
            }
        });
        o.method2(new Inner2() {
            @Override
            public String say2() {
                return "say2";
            }
        });
    }
}
abstract class Inner2 {
    public abstract String say2();
}

interface Inner {
    public String say1();
}

/**
 * 静态内部类
 */
class OuterStatic {
    private int name = 1;
    private int age = 99;
    static  class Inner{
        static  String name2="1";
        String name="Jayden";
        public void show(String name )
        {
//            System.out.println(OuterStatic.this.name);
            System.out.println(name);
//            System.out.println(age);
        }
    }
    public Inner getInnerClass() {
        return new Inner();
    }

    public static void main(String[] args) {
        OuterStatic o = new OuterStatic();
        Inner in = o.getInnerClass();
        String a="1";
        in.show(a);
        in.show("2");
    }
}

