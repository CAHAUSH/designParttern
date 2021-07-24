package com.study.designpattern.state.FSM;

public class RunningState extends ThreadState_ {
    Thread_ thread;

    public RunningState(Thread_ thread) {
        this.thread = thread;
    }

    @Override
    void move(Action action) {

    }

    @Override
    void run() {

    }
}
