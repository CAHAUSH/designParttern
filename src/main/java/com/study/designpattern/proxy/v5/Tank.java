package com.study.designpattern.proxy.v5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * ？？需求：让logProxy可以重用，不仅可以代理movebale的实现类，还可以代理任何其他可以代理的类型Object
 * 分离代理行为与被代理对象
 *
 * 解决方案：使用jdk动态代理，不再存在手写的代理类
 *
 * jdk使用反射生成代理，必须实现接口
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
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method: "+method.getName()+" start...");
                        Object o = method.invoke(tank,args);
                        System.out.println("method: "+method.getName()+" stopped...");
                        return o;
                    }
                }
                );
        m.move();
    }
}

interface Moveable{
    void move();
}
