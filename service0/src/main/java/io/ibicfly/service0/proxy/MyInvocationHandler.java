package io.ibicfly.service0.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

        // 真实业务对象
        private Object target;

        public MyInvocationHandler(Object target){
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 增强逻辑
            System.out.println("PROXY : " + proxy.getClass().getName());

            // 反射调用，目标方法
            Object result = method.invoke(target, args);

            // 增强逻辑
            System.out.println(method.getName() + " : " + result);

            return result;
        }

}


