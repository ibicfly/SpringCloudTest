package io.ibicfly.service0.proxy;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello "+name;
    }

    @Override
    public String hi(String msg) {
        return "hi "+msg;
    }
}
