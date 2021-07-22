package com.study.designpattern.decorator;
/**
 * 装饰器：用于在不改变现有类结构的情况下，增加装饰信息
 * */
public class main {
    public static void main(String[] args) {
        Shape s = new Circle();
        s.draw();

        RedShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        //redCircle.draw();
        YellowShapeDecorator yellowCircle = new YellowShapeDecorator(redCircle);
        yellowCircle.draw();

        YellowShapeDecorator yellowRect = new YellowShapeDecorator(new Rectangle());
        yellowRect.draw();
    }
}
