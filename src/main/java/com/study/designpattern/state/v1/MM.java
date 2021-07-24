package com.study.designpattern.state.v1;
/**
 *
 * 根据不同的状态，每个方法会执行不同的逻辑
 * 但是，当需要不定期扩展状态时，每一个方法都需要进行相应的逻辑扩展
 *
 * */
public class MM {
    private enum MMSTATE{Happy,SAD}
    MMSTATE mmstate;
    void smile(){
        //switch case
    }

    void cry(){
        //switch case
    }

    void say(){
        //switch case
    }
}
