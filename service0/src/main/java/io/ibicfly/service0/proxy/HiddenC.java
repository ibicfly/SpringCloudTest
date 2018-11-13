package io.ibicfly.service0.proxy;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/9 16:16
 * @Description: 作用描述
 */
public class HiddenC {
    public static  A makeA(){
        return new C();
    }
}
final class C implements A{

    @Override
    public void f() {
        System.out.println("public C.f()");
    }
    void u(){
        System.out.println("default C.u()");
    }
    protected void v(){
        System.out.println("protected C.v()");
    }
    private void w(){
        System.out.println("private C.w()");
    }
}

