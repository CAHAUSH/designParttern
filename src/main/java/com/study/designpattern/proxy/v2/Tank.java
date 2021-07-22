package com.study.designpattern.proxy.v2;

import java.util.Random;

public class Tank implements Moveable {
    @Override
    public void move() {
        long starttime= System.currentTimeMillis();
        System.out.println("tank start moving....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endtime= System.currentTimeMillis();
        System.out.println("坦克运行了"+(endtime-starttime)+"秒");
    }

    public static void main(String[] args) {
        System.out.println(new MoveableTimeProxy(new Tank()).moveTime());
    }
}

class MoveableTimeProxy{
    private Moveable moveable;
    public MoveableTimeProxy(Moveable movObj) {
        this.moveable=movObj;
    }
    public long moveTime(){
        long starttime= System.currentTimeMillis();
        this.moveable.move();
        long endtime= System.currentTimeMillis();
        return endtime-starttime;
    }
}

interface Moveable{
    void move();
}
