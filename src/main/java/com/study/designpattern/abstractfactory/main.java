package com.study.designpattern.abstractfactory;

import com.study.designpattern.factory.CarFactory;
import com.study.designpattern.factory.Moveable;
import com.study.designpattern.factory.Plane;

public class main {
    public static void main(String[] args) {
        /**
        * 工厂分类：
         * 1简单工厂；
         * 2静态工厂（单例）；
         * 3 工厂方法（factory method,每种产品一个工厂），Factory ->{CarFactory，PlaneFactory，BroomFactory}。单个产品维度上扩展性高
         * 4 抽象工厂 。 在产品一族进行方便扩展。
        * */

        //1、场景：现在世界的人 开着一个car,吃着面包，使用ak47
        Car car = new Car();
        car.go();
        Bread bread = new Bread();
        bread.printName();
        AK47 ak47=new AK47();
        ak47.shoot();

        //2、使用继承抽象工厂的具体工厂来实现产品族。扩展/修改时，只需要修改new ModernFactory()即可
        AbstractFactory abstractFactory = new ModernFactory();
        abstractFactory.createFood().printName();
        abstractFactory.createVehicle().go();
        abstractFactory.createWeapon().shoot();

        //3、//语法上可以用interface 代替 abstract，但是从语义上来说abstact更合适；
        //名词用abstract、形容词用interface

        //4、更好的工厂解决方案 SPRING IOC 的 Bean工厂
    }
}
