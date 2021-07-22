package com.study.designpattern.proxy.v3;

import java.util.Random;

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
        //运行时间代理
        new MoveableTimeProxy(new Tank()).move();
        //运行日志代理
        new MoveableLogProxy(new Tank()).move();
    }
}

class MoveableTimeProxy implements Moveable{
    private Moveable moveable;
    public MoveableTimeProxy(Moveable movObj) {
        this.moveable=movObj;
    }
    /*public long moveTime(){
        long starttime= System.currentTimeMillis();
        this.moveable.move();
        long endtime= System.currentTimeMillis();
        return endtime-starttime;
    }*/

    @Override
    public void move() {
        long starttime= System.currentTimeMillis();
        moveable.move();
        long endtime= System.currentTimeMillis();
        System.out.println("坦克运行了"+(endtime-starttime)+"秒");
    }
}

class MoveableLogProxy implements Moveable{
    private Moveable moveable;
    public MoveableLogProxy(Moveable movObj) {
        this.moveable=movObj;
    }
    /*public long moveTime(){
        long starttime= System.currentTimeMillis();
        this.moveable.move();
        long endtime= System.currentTimeMillis();
        return endtime-starttime;
    }*/

    @Override
    public void move() {
        System.out.println("坦克准备出发了");
        moveable.move();
        System.out.println("坦克停下来了");
    }
}

interface Moveable{
    void move();
}
