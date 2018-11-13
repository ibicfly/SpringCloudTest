package io.ibicfly.service0.designpattern;

/**
 * @Author :cyh
 * @CreateDate: 2018/9/21 14:20
 * @Description: 生产者消费者模型
 * 一般采用阻塞队列的形式实现
 * test
 */
public class ProducerCousumerTest {
    public static void main(String[] args) {
        String[] a={"test"};
        Test3.main(a);
    }
}

class Test3 {
    public static void main(String[] args) {
        System.out.println("Test3 main");
    }
}
