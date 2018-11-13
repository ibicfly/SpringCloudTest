package io.ibicfly.service0.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})//指定注解可以作用的范围，方法，属性，类...
@Retention(RetentionPolicy.RUNTIME)//指定了注解保留时间的长短
@Inherited//父类的注解是否在子类生效
@Documented//指明拥有这个注解的元素可以被javadoc此类的工具文档化
public @interface MyMessage {
    String name() default "";
    int num() default 0;
    String desc();
}
