package com.study.designpattern.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 事件处理模型
 * 观察者 + 责任链 可以实现复杂的事件处理
 * */
public class Main {
    public static void main(String[] args) {
        Child child=new Child();
        child.addObserver(new Father());
        child.addObserver(new Mother());
        child.cry();
    }
}

class Child{
    private List<Observer> observers = new ArrayList<>();

    void cry(){
        long time = new Date().getTime();
        String location = "bloor";
        System.out.println("I am cring wawawa...");
        WakeupEvent event = new WakeupEvent(time,location,this);
        for (Observer o:observers){
            o.handleEvent(event);
        }
    }

    void addObserver(Observer obs){
        observers.add(obs);
    }
}

interface Event<T>{
    abstract T getSource();
}

class WakeupEvent implements Event<Child>{
    private long time;
    private String location;
    private Child source;
    WakeupEvent(long time, String location, Child source){
        this.time = time;
        this.location = location;
        this.source = source;
    }


    @Override
    public Child getSource() {
        return this.source;
    }
}

interface Observer{
    void handleEvent(WakeupEvent event);
}

class Father implements Observer{

    @Override
    public void handleEvent(WakeupEvent event) {
        System.out.println("father handler");
    }
}

class Mother implements Observer{

    @Override
    public void handleEvent(WakeupEvent event) {
        System.out.println("mom handler");
    }
}
