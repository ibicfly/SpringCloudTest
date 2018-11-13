package io.ibicfly.service0;

public class JavaSOF {
    private int length = 1;

    public void stackLeak() {
        length++;
        stackLeak();
    }
//stackoverflow
    public static void main(String[] args) {
        JavaSOF javaSOF = new JavaSOF();
        //栈的深度达到了16635
        //如果缩小Xss
//        2g堆深度能开27410左右
        try {
            javaSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("栈的深度" + javaSOF.length);
        }
    }
}
