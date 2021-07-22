package com.study.designpattern.proxy.v7;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * cglib 动态代理，比jdk动态代理要简单很多，不需要实现接口
 *
 * 缺陷：cglib无法代理 final修饰的类
 *
 * 底层用的是asm
 *
 * 可实现AOP
 * */

public class Tank{
    public void move() {
        System.out.println("tank start moving....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //设置enchancer的父类为被代理类
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        /**会覆盖之前设置的代理拦截器*/
        enhancer.setCallback(new TestMethodInterceptor());
       /**
        * 代理链多需要配置 Filter
        * enhancer.setCallbackFilter();
        enhancer.setCallbacks(new Callback[] {new TimeMethodInterceptor(),new TestMethodInterceptor()});*/
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}

class TimeMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("o 为动态生成的代理类"+o.getClass().getName());
        System.out.println("动态代理类o 为tank类的子类"+o.getClass().getSuperclass().getName());
        System.out.println("before method starting");
        Object result = null;
        result = methodProxy.invokeSuper(o,objects);
        System.out.println("after method executing");
        return result;
    }
}

class TestMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before test");
        Object result = null;
        result = methodProxy.invokeSuper(o,objects);
        System.out.println("after test");
        return result;
    }
}
