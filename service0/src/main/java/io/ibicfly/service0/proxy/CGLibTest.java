package io.ibicfly.service0.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author :cyh
 * @CreateDate: 2018/9/26 14:35
 * @Description 测试类
 */
public class CGLibTest {
//    public void test() {
//        //目标对象
//        CGLibService target = new CGLibService();
//        //代理对象
//        CGLibService proxy = (CGLibService) new ProxyFactory(target).getProxyInstance();
//        //执行代理对象的方法
//        proxy.test();
//    }


    public static void main(String[] args) {
        CGLibService cgLibService=new CGLibService();
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(CGLibService.class);
        enhancer.setCallback(new ProxyFactory());
        CGLibService proxy= (CGLibService) enhancer.create();
        proxy.test2();
    }
}
