package io.ibicfly.service0.basic;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/9 9:43
 * @Description: 作用描述
 * 异常测试类
 */
public class ExceptionTest {
    public static void f() throws Exception {
        System.out.println("Origin Exception at f()");
        throw new Exception("throw from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Exception at g()");
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("Main Exception ");
            e.printStackTrace();
        }
    }
}
