package io.ibicfly.service0.proxy;

import net.sf.cglib.beans.BeanCopier;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test() {

    }

    public Test(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        jdk动态代理
        HelloService helloService = new HelloServiceImpl();
        // 生成代理类的class对象 只是使用跟接口同一个
        Class<?> clazz = Proxy.getProxyClass(helloService.getClass().getClassLoader(), helloService.getClass().getInterfaces());
//      创建InvocationHandler
        InvocationHandler myInvocationHandler = new MyInvocationHandler(helloService);
//      获取MyInvocationHandler类的构造器对象 这是一个加强类，在执行原来方法的周围织入代码
        Constructor constructor = null;
        try {
            constructor = clazz.getConstructor(new Class[]{InvocationHandler.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
//      反射创建代理对象
        HelloService proxy = null;
        try {
            proxy = (HelloService) constructor.newInstance(myInvocationHandler);//将真实对象注入
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        这两行代码等价于上面的代码
//        Proxy.newProxyInstance()
        proxy = (HelloService) Proxy.newProxyInstance(helloService.getClass().getClassLoader(),
                helloService.getClass().getInterfaces(), new MyInvocationHandler(helloService));

        proxy.hello("cyh");
        proxy.hi("hi");


        System.out.println("新Proxy");
        HelloService test2 = new HelloServiceImpl();
        InvocationHandler invocationHandler=new MyInvocationHandler(test2);
        HelloService proxy2=(HelloService)Proxy.newProxyInstance(test2.getClass().getClassLoader(),test2.getClass().getInterfaces(),invocationHandler);
        proxy2.hi("i am test2");
        proxy2.hello("i am test2 ");






        System.out.println("新Proxy2");
        HelloService test3=new HelloServiceImpl();
        InvocationHandler invocationHandler1 = new MyInvocationHandler(test3);
        Class testClazz=Proxy.getProxyClass(test3.getClass().getClassLoader(),test3.getClass().getInterfaces());
        Constructor constructor1=testClazz.getConstructor(InvocationHandler.class);
        HelloService proxy3= (HelloService) constructor1.newInstance(invocationHandler1);
        proxy3.hi("i am test3");
        proxy3.hello("i am test3");
    }
    public static void beanCopier()
    {
//        复制bean的所有属性
        Test test1 = new Test("name1");
        Test test2 = new Test();

        System.out.println(test1.name);
        System.out.println(test2.name);

        BeanCopier beanCopier = BeanCopier.create(Test.class, Test.class, false);
        beanCopier.copy(test1,test2,null);

        System.out.println(test1.name);
        System.out.println(test2.name);
    }
    public int[] removeDuplicates(int[] array) {
        int index = 0;
        Map<Integer, Boolean> maps = new LinkedHashMap<Integer, Boolean>();
        for(int num : array) {
            if(maps.get(num)!=null) {
                array[index] = num;
                index++;
                maps.put(num, true);
            }
        }

        return array;
    }
}
