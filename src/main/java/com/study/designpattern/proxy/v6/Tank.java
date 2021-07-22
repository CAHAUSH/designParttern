package com.study.designpattern.proxy.v6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * ？？需求：让logProxy可以重用，不仅可以代理movebale的实现类，还可以代理任何其他可以代理的类型Object
 * 分离代理行为与被代理对象
 *
 * 解决方案：使用jdk动态代理，不再存在手写的代理类
 * */

public class Tank implements Moveable {
    @Override
    public void move() {
        System.out.println("tank start moving....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
        Moveable m = (Moveable) Proxy.newProxyInstance(
                tank.getClass().getClassLoader(),
                new Class[]{Moveable.class},
                new TimeProxy(tank)
                );
        m.move();
    }
}

class TimeProxy implements InvocationHandler {
    private Moveable m;
    public TimeProxy(Moveable m) {
        this.m=m;
    }

    public void before(){
        System.out.println("method: start...");
    }

    public void after(){
        System.out.println("method:stopped...");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(this.m,args);
        after();
        return o;
    }
}

interface Moveable{
    void move();
}
