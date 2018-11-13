package io.ibicfly.service0.annotation;

import org.apache.commons.lang.StringUtils;

public class AnnotationTest {

    @MyMessage(num = 10, desc = "参数a")
    private static int a;

    @MyMessage(name = "测试名字", desc = "测试方法test")
    public void test(String name) {
        if(StringUtils.isEmpty(name))
            System.out.println("test");
        else
            System.out.println("test 被注入"+name);
    }

}

