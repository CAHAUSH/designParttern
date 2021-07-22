package com.study.designpattern.decorator;

public class YellowShapeDecorator extends ShapeDecorator{
    public YellowShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setBorder(decoratedShape);
    }

    private void setBorder(Shape decoratedShape){
        System.out.println("border color: yellow");
    }
}
