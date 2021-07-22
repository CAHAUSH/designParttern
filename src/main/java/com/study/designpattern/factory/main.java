package com.study.designpattern.factory;

public class main {
    public static void main(String[] args) {
        //1、任意定制交通工具，通过继承Moveable接口
        Moveable m = new Plane();
        m.go();

        //2、任意定制生产过程
        Moveable m1 = new CarFactory().create();

        //3、任意定制产品族 ，抽象工厂

    }
}
