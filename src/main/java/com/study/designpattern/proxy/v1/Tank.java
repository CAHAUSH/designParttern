package com.study.designpattern.proxy.v1;

import java.util.Random;

public class Tank implements Moveable{
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
        new Tank().move();
    }
}

interface Moveable{
    void move();
}
