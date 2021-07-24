package com.study.designpattern.templateMethod;
/**
 * 模板方法
 * */
public class Main {
    public static void main(String[] args) {
        F f = new son();
        f.m();
    }
}

abstract class F{
    public void m(){
        a();
        b();
    }

    abstract void a();
    abstract void b();

}

class son extends F{

    @Override
    void a() {
        System.out.println("a11");
    }

    @Override
    void b() {
        System.out.println("b22");
    }
}
