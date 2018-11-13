package io.ibicfly.service0.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyMessageProcessor {
    public static void main(String[] args) {

        try {
            //加载annotationTest.class类
            Class clazz = MyMessageProcessor.class.getClassLoader().loadClass("io.ibicfly.service0.annotation.AnnotationTest");
            Object o=clazz.newInstance();
            //获取属性
            Field[] fields = clazz.getDeclaredFields();
            //遍历属性
            for (Field field : fields) {
//                取得注解
                MyMessage myMessage = field.getAnnotation(MyMessage.class);
                if(myMessage!=null)
                    System.out.println("name:" + myMessage.name() + "  num:" + myMessage.num() + "  desc:" + myMessage.desc());
            }
            //获取类中的方法
            Method[] methods = clazz.getMethods();
            //遍历方法
            for (Method method : methods) {
                //判断方法是否带有MyMessage注解
                if (method.isAnnotationPresent(MyMessage.class)) {
                    // 获取所有注解 method.getDeclaredAnnotations();
                    // 获取MyMessage注解
                    MyMessage myMessage = method.getAnnotation(MyMessage.class);
                    System.out.println("注解name:" + myMessage.name() + "  num:" + myMessage.num() + "  desc:" + myMessage.desc());
                    method.invoke(o,myMessage.name());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
