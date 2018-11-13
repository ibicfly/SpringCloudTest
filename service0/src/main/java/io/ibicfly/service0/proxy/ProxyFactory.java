package io.ibicfly.service0.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author :cyh
 * @CreateDate: 2018/9/26 15:00
 * @Description: 作用描述
 * Cglib子类代理工厂
 * 对UserDao在内存中动态构建一个子类对象
 */
public class ProxyFactory implements MethodInterceptor {


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before");
        //执行目标对象的方法
        Object proxyObj= proxy.invokeSuper(obj,args);
        System.out.println("After");
        return proxyObj;
    }

}
