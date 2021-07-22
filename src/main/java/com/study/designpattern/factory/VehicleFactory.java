package com.study.designpattern.factory;
/*
* 简单工厂， 可扩展性差， 加一个火车的时候，要加方法和逻辑
* */
public class VehicleFactory {
    public Car createCar(){
        //1、日志
        //2、创建
        return new Car();
    }

    public Plane createPlane(){
        //1、日志
        //2、创建
        return new Plane();
    }

    public Broom createBroom(){
        //1、日志
        //2、创建
        return new Broom();
    }
}
