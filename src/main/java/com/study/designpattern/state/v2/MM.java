package com.study.designpattern.state.v2;
/**
 * state模式适用于方法固定，状态动态扩展的情况。
 * 假如，方法不固定，不适合使用state设计模式
 * */
public class MM {
    String name;
    MMSTATE mmstate;
    public void smile(){
        mmstate.smile();
    }
    public void cry(){
        mmstate.cry();
    }
    public void say(){
        mmstate.say();
    }
}
